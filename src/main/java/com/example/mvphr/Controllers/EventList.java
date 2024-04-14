package com.example.mvphr.Controllers;


import com.example.mvphr.Entities.EventEntity;
import com.example.mvphr.Services.Impl.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
// вывод списка мероприятий
@Controller
@RequestMapping("/eventlist")
public class EventList {

    private final EventService service;

    @Autowired
    public EventList(EventService service) {
        this.service = service;
    }

    @ModelAttribute
    private List<EventEntity> getEvents(){return service.getAll();}


    @GetMapping
    public String showList(Model model){
        model.addAttribute("list", getEvents());
        return "EventList";
    }

}
