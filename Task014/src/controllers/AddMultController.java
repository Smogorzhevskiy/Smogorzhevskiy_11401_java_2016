package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.AddMultService;

@RestController
public class AddMultController {
    @Autowired
    @Qualifier("addMultServiceImpl")
    AddMultService service;

    @RequestMapping(value = "/add/{num-id-0}/{num-id-1}", method = RequestMethod.GET)
    public Integer getAddResult(@PathVariable("num-id-0") Integer num0, @PathVariable("num-id-1") Integer num1, Model model) {
        Integer temp = service.add(num0, num1);
        model.addAttribute("result", temp);
        return temp;
    }

    @RequestMapping(value = "/mult/{num-id-0}/{num-id-1}", method = RequestMethod.GET)
    public Integer getMultResult(@PathVariable("num-id-0") Integer num0, @PathVariable("num-id-1") Integer num1, Model model) {
        Integer temp = service.mult(num0, num1);
        model.addAttribute("result", temp);
        return temp;
    }

}
