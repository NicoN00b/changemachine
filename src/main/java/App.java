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
            Float amount = Float.parseFloat(request.queryParams("amount"));


            ChangeMachine newChangeMachine = new ChangeMachine();
            newChangeMachine.makeChange(amount);

            model.put("name", name);
            model.put("amount", amount);

            return new ModelAndView(model, "your_change.hbs");
        }, new HandlebarsTemplateEngine());

    }
}


