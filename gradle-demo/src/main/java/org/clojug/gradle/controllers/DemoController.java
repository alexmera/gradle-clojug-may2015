package org.clojug.gradle.controllers;

import org.apache.commons.lang3.StringUtils;
import org.clojug.gradle.services.Expressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador MVC
 */
@Controller
@RequestMapping("/")
public class DemoController {

    @Autowired
    private Expressions expr;

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("helloMessage", "¡HOLA CLOJUG!");
        return "home";
    }

    @RequestMapping(value = "/expression", method = RequestMethod.GET)
    public String expression(Model model,
                             @RequestParam(required = false) String lastSpel,
                             @RequestParam(required = false) String result,
                             @RequestParam(required = false) String error) {
        // Se adicionan los atributos flash
        model.addAttribute("lastSpel", lastSpel);
        model.addAttribute("result", result);
        model.addAttribute("error", error);
        return "expression";
    }

    @RequestMapping(value = "/expression", method = RequestMethod.POST)
    public String postExpression(@RequestParam String spel, RedirectAttributes redirectAttributes) {
        if (StringUtils.isNotEmpty(spel)) {
            redirectAttributes.addAttribute("lastSpel", spel);
            try {
                redirectAttributes.addAttribute("result", expr.evaluate(spel));
            } catch (Exception e) {
                redirectAttributes.addAttribute("error", e.getMessage());
            }
        }
        return "redirect:expression";
    }
}
