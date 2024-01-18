package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var users = new UsersPage(USERS);
            ctx.render("users/index.jte", Collections.singletonMap("users", users));
        });

        app.get("/users/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var user = new UserPage(findById(USERS, id)
                    .orElseThrow(() -> new NotFoundResponse("User not found")));
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });
        // END

        return app;
    }

    private static Optional<User> findById(List<User> users, String id) {
        for (var user : users) {
            if (user.getId() == Long.parseLong(id)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
