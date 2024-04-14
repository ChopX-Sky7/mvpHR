package com.example.mvphr.Controllers;

import com.example.mvphr.Entities.Candidate;
import com.example.mvphr.Services.Impl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/candList")
public class CandidateList {
    private final CandidateServiceImpl service;


    @Autowired
    public CandidateList(CandidateServiceImpl service) {
        this.service = service;
    }

    @ModelAttribute
    private List<Candidate> getList(){return service.getALl();}

    @GetMapping
    public String showList(Model model){
        model.addAttribute("list", getList());
        return "candList";}

}
