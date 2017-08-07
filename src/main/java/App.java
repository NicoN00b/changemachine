import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/your_change", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");

            String input = request.queryParams("amount");
            Float inputAsFloat = Float.parseFloat(input);

            ChangeMachine newChangeMachine = new ChangeMachine();
            String output = newChangeMachine.makeChange(inputAsFloat);

            model.put("name", name);
            model.put("amount", output);
            return new ModelAndView(model, "your_change.hbs");
git
        }, new HandlebarsTemplateEngine());

    }
}


