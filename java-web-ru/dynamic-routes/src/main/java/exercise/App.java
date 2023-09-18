package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var id = ctx.pathParam("id");
            boolean f = false;

            var company = findById(COMPANIES, id) // Ищем пользователя в базе по id
                    .orElseThrow(() -> new NotFoundResponse("Company not found"));
            ctx.json(company);
        });
        return app;
    }



    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    private static Optional<Object> findById(List<Map<String, String>> companies, String id) {
        for (Map<String, String> company: companies) {
            if (company.get("id").equals(id)) {
                return Optional.of(company);
            }
        }
        return Optional.empty();
    }


}
