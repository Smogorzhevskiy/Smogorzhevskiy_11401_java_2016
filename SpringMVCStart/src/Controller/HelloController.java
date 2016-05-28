package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by User on 09.03.16.
 */
@Controller
@RequestMapping("/hi")
public class HelloController {
    @RequestMapping (method = RequestMethod.GET)
    public String hiPage (ModelMap model, @RequestParam(required = false) String name){
        model.put("time",new java.util.Date());
        return  "hi";
    }
}