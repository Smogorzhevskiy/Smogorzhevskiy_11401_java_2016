package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.DateService;

import java.util.Date;

@RestController
public class DateController {
    @Autowired
    @Qualifier("dateServiceImpl")
    DateService service;

    @RequestMapping(value = "/date", method = RequestMethod.GET)
    public Date getDate(Model model) {
        Date temp = service.getDate();
        model.addAttribute("date", temp);
        return temp;
    }
}
