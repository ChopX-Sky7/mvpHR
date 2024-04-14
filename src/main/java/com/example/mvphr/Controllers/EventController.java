package com.example.mvphr.Controllers;


import com.example.mvphr.Entities.Candidate;
import com.example.mvphr.Entities.EventEntity;
import com.example.mvphr.Services.Impl.CandidateServiceImpl;
import com.example.mvphr.Services.Impl.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.example.mvphr.SysHelper.Helper.*;
//добавление и обработка мероприятий
@Controller
@Slf4j
@RequestMapping("/events")
public class EventController {

    private final EventService service;
    private final CandidateServiceImpl Cservice;

    @Autowired
    public EventController(EventService service, CandidateServiceImpl cservice) {
        this.service = service;
        Cservice = cservice;
    }
    @ModelAttribute
    private EventEntity getNewEvent(){return new EventEntity();}


    @GetMapping("/add")
    public String showForm(Model model){
        model.addAttribute("event", getNewEvent());
        return "addEvent";
    }

    @PostMapping("/add")
    public String addEvent(@ModelAttribute EventEntity e){
        service.setInfo(e, e.getEvdate(), e.getEvdesc(), e.getCandId());
        Candidate c = Cservice.getById(e.getCandId());
        e.setCandName(c.getName() + " " + c.getSecname());
        setMailerLink(c.getEmail());
        setMailerContent(e.getCandName(), e.getEvdate());
        post();
        service.save(e);
        log.info("Event add: {}" , e);
        return "EventList";
    }
}
