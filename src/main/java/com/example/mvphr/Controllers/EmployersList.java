package com.example.mvphr.Controllers;

import com.example.mvphr.Entities.Employee;
import com.example.mvphr.Repos.EmployeeRepository;
import com.example.mvphr.Services.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/empllist")
public class EmployersList {

    private final EmployeeServiceImpl service;
    private final EmployeeRepository repo;

    @Autowired
    public EmployersList(EmployeeServiceImpl service, EmployeeRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @ModelAttribute(name = "list")
    public List<Employee> getList(){return repo.findAll();}

    @GetMapping
    public String EmplList(Model model){
        model.addAttribute("list", getList());
        return "EmplList";}
}
