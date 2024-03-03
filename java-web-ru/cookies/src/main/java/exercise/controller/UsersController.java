package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;
import java.util.Collections;
import java.util.Objects;

import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        if (Objects.equals(ctx.cookie("token"), user.getToken())) {
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        } else ctx.redirect(NamedRoutes.buildUserPath());
    }

    public static void create(Context ctx) throws Exception {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var token = Security.generateToken();
        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        ctx.cookie("token", token);
//        var id = user.getId();
        ctx.redirect(NamedRoutes.userPath(user.getId()));
//        ctx.render("/users/build.jte");
    }

    // END
}
