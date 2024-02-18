package exercise.controllers;

import io.javalin.http.Handler;
import java.util.List;
import java.util.Map;

import io.javalin.validation.ValidationException;
import io.javalin.validation.Validator;
import io.javalin.validation.ValidationError;
import io.javalin.validation.JavalinValidation;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;
import io.javalin.http.Context;

import exercise.domain.User;
import exercise.domain.query.QUser;

public final class UserController {

    private static void removeFlashMessage(Context ctx) {
        ctx.sessionAttribute("flash", null);
    }

    public static Handler listUsers = ctx -> {

        List<User> users = new QUser()
            .orderBy()
                .id.asc()
            .findList();

        ctx.attribute("users", users);
        ctx.render("users/index.html");
        removeFlashMessage(ctx);
    };

    public static Handler showUser = ctx -> {
        long id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);

        User user = new QUser()
            .id.equalTo(id)
            .findOne();

        ctx.attribute("user", user);
        ctx.render("users/show.html");
    };

    public static Handler newUser = ctx -> {

        ctx.attribute("errors", Map.of());
        ctx.attribute("user", Map.of());
        ctx.render("users/new.html");
    };

    public static Handler createUser = ctx -> {
        // BEGIN
        try {
            var passwordConfirmation = ctx.formParam("passwordConfirmation");
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> value.length() > 3, "Минимальная длина пароля 4 символа")
                    .get();
            var firstName = ctx.formParamAsClass("firstName", String.class)
                    .check(value -> !value.isEmpty(), "Имя не должно быть пустым")
                    .get();
            var lastName = ctx.formParamAsClass("lastName", String.class)
                    .check(value -> !value.isEmpty(), "Фамилия не должна быть пустой")
                    .get();
            var email = ctx.formParamAsClass("email", String.class)
                    .check(x -> EmailValidator.getInstance().isValid(x), "Эл. почта имеет неправильный формат")
                    .get();
            var user = new User(firstName, lastName, email, password);
            user.save();
            ctx.redirect("/users");
        } catch (ValidationException e) {
            Map<String, List<ValidationError<Object>>> errors = e.getErrors();
            var firstName = ctx.formParam("firstName");
            var lastName = ctx.formParam("lastName");
            var password = ctx.formParam("password");
            var email = ctx.formParam("email");
            User user = new User(firstName, lastName, email, password);
            ctx.status(422);
            ctx.attribute("user", user);
            ctx.attribute("errors", errors);
            ctx.render("users/new.html");
        }
        // END
    };
}
