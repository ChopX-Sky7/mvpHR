package com.example.mvphr.Controllers;

import com.example.mvphr.Entities.Candidate;
import com.example.mvphr.Services.Impl.CandidateServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.example.mvphr.SysHelper.Helper.parse;

@Controller
@Slf4j
@RequestMapping("/response")
public class CandidateController {


    private static final String UPLOAD_DIR = "src/main/resources/static/portfolio/";
    private final CandidateServiceImpl service;


    @Autowired
    public CandidateController(CandidateServiceImpl service) {
        this.service = service;

    }

    @ModelAttribute
    public Candidate candidate(){return new Candidate();}

    @GetMapping
    public String showForm(Model model){
        model.addAttribute("candidate", candidate());
        return "CandidateForm";}

    @PostMapping
    public String processing(@RequestParam("file")MultipartFile file,
                         @ModelAttribute("candidate") Candidate c){

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
       try {
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
           service.setInfo(c, c.getSurname(), c.getName(), c.getSecname(),
                   String.valueOf(c.getDob()), c.getEmail(), c.getHhUrl(),c.getGitUrl(), String.valueOf(path));
           c.timeOfCreate();
           c.setResumeLink(parse(c.getHhUrl()));
           service.save(c);
           log.info("Created candidate: {}", c);
       } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/";
    }

}
