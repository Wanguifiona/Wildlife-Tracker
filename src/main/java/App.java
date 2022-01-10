import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animals-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animals-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/animal-sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "animal-sighting.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animal-sighting", (request, response) -> { //URL to make new post on POST route
                Map<String, Object> model = new HashMap<>();
                String animalName = request.queryParams("animal");
                String rangerName = request.queryParams("ranger");
                String location = request.queryParams("location");
                String health = request.queryParams("health");
                String age = request.queryParams("age");
                String type = request.queryParams("type");
                return new ModelAndView(model, "animal-sighting.hbs");
            }, new HandlebarsTemplateEngine());

        }
}
