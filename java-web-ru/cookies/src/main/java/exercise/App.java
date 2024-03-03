package exercise;

import exercise.model.User;
import exercise.repository.UserRepository;
import exercise.util.Security;
import io.javalin.Javalin;
import exercise.controller.UsersController;
import exercise.util.NamedRoutes;

import java.util.Collections;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.post(NamedRoutes.usersPath(), UsersController::create);
        app.get(NamedRoutes.buildUserPath(), UsersController::build);
//        app.get(NamedRoutes.buildUserPath(), UsersController::buildNew);
        // END
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
