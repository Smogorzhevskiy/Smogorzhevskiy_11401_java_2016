package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.TextAnalyzeService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TextAnalyzeController {
    @Autowired
    @Qualifier("textAnalyzeServiceImpl")
    TextAnalyzeService service;

    @RequestMapping(value = "/process", method = RequestMethod.GET)
    public String getProcess() {
        return "process-page";
    }

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public String analyze(@RequestParam("text") String text, @RequestParam("analyze_param") String param, HttpServletRequest request) {
        request.getSession().setAttribute("result", service.analyze(text, param));
        return "redirect:result";
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String getResult(HttpServletRequest request, Model model) {
        String result = (String) request.getSession().getAttribute("result");
        model.addAttribute("result", result);
        return "result";
    }

}
