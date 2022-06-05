package springMVC.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class firstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value="name", required = false)String name,
                            @RequestParam(value="surname",required = false) String surname,
                            Model model) {
        model.addAttribute("message", name +" "+ surname);
//        System.out.println(name +" "+ surname);
        return "first/hello";
    }
    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model){
        double result;

        switch(action) {
            case "multi":
                result = a*b;
                break;
            case "divis":
                result =  a/(double)b;
                break;
            case "subs":
                result = a -b;
                break;
            case "add":
                result = a+b;
                break;
            default:
                result = 0.0;
        }
        model.addAttribute("result", result);
        return"first/calculator";
    }
}
