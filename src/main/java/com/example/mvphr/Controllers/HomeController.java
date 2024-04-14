package com.example.mvphr.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//стартовая страница
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home() {
        return "promo";
    }

}
