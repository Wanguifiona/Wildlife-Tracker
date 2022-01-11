import models.Animal;
import models.Endangered;
import models.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import java.util.HashMap;
import java.util.List;
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
            model.put("sighting", Sighting.all());
            model.put("animal", Endangered.all());
            return new ModelAndView(model, "animal-sighting.hbs");
        }, new HandlebarsTemplateEngine());

        post("/animal-sighting", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();
            String animal = request.queryParams("animal");
            String danger = request.queryParams("danger");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");


//            Endangered endangeredAnimal = new Endangered(animal, danger, health, age, location, ranger);
//            endangeredAnimal.save();
//            Sighting sighting = new Sighting(endangeredAnimal.getId(), location, ranger);
//            sighting.save();
//
//            model.put("endangeredAnimal", endangeredAnimal);
//            model.put("sighting", sighting);
                return new ModelAndView(model, "animal-sighting.hbs");
            }, new HandlebarsTemplateEngine());

        }
}
