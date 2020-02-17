import models.Animal;
import models.Ranger;
import models.Sighting;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import sql2o.Sql2oAnimal;
import sql2o.Sql2oRanger;
import sql2o.Sql2oSighting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {


    public static void main(String[] args) {
        Map<String, Object> model = new HashMap<>();
        staticFileLocation("/public");

        HandlebarsTemplateEngine handlebarsTemplateEngine = new HandlebarsTemplateEngine();

        String connection = "jdbc:h2:~/wildlife_track.db;INIT=RUNSCRIPT from 'classpath:database/wildlifetrack.sql'";
        Sql2o sql2o = new Sql2o(connection, "postgres", "admin");
        Sql2oAnimal sql2oAnimal = new Sql2oAnimal(sql2o);
        Sql2oRanger sql2oRanger = new Sql2oRanger(sql2o);
        Sql2oSighting sql2oSighting = new Sql2oSighting(sql2o);

        get("/", (request, response) -> {
            return new ModelAndView(model, "index.hbs");

        }, handlebarsTemplateEngine);


        get("/rangers", (request, response) -> {
            return new ModelAndView(model, "add-ranger.hbs");
        }, handlebarsTemplateEngine);


        get("/animals", (request, response) -> {
            return new ModelAndView(model, "add-animal.hbs");
        }, handlebarsTemplateEngine);


        get("/sightings", (request, response) -> {
            return new ModelAndView(model, "add-sighting.hbs");
        }, handlebarsTemplateEngine);


        post("/rangers", (request, response) -> {
            int ranger_id = Integer.parseInt(request.queryParams("ranger_id"));
            String ranger_name = request.queryParams("ranger_name");
            System.out.println(ranger_id);
            System.out.println(request.queryParams("ranger_id"));
            sql2oRanger.add(ranger_id, ranger_name);
            response.redirect("/rangers");
            return null;
        }, handlebarsTemplateEngine);

        post("/animals", (request, response) -> {
            int animal_id = Integer.parseInt(request.queryParams("animal_id"));
            String animal_name = request.queryParams("animal_name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String endangered = request.queryParams("endangered");
            System.out.println(animal_id);
            System.out.println(request.queryParams("animal_id"));
            sql2oAnimal.add(animal_id, animal_name, health, age, endangered);
            response.redirect("/animals");
            return null;
        }, handlebarsTemplateEngine);


        post("/sightings", (request, response) -> {
            int sighting_id = Integer.parseInt(request.queryParams("sighting_id"));
            String location = request.queryParams("location");
            int animal_id = Integer.parseInt(request.queryParams("animal_id"));
            int ranger_id = Integer.parseInt(request.queryParams("ranger_id"));
            System.out.println(sighting_id);
            System.out.println(request.queryParams("sighting_id"));
            sql2oSighting.add(sighting_id, location, animal_id, ranger_id);
            response.redirect("/sightings");
            return null;
        }, handlebarsTemplateEngine);

    }
}
