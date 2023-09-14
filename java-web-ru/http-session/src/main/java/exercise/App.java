package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var page = ctx.queryParam("page");
            var per = ctx.queryParam("per");
            int start = 0;
            int end = 5;
            if (page != null && per != null) {
                start = (Integer.parseInt(page) - 1) * Integer.parseInt(per);
                end = start + Integer.parseInt(per);
            }
            ctx.json(USERS.subList(start, end));
                });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
