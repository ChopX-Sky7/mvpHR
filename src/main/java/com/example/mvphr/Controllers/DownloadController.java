package com.example.mvphr.Controllers;

import com.example.mvphr.Entities.Candidate;
import com.example.mvphr.Services.Impl.CandidateServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;

@RestController
@Slf4j
@RequestMapping("/download")
public class DownloadController {

   private final CandidateServiceImpl service;

   @Autowired
    public DownloadController(CandidateServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/portfolio/{id}")
    public ResponseEntity<Object> portfolio(@PathVariable Long id){
    Candidate c = service.getById(id);
    String fio = c.getSurname() + " " +c.getName()+ " "+ c.getSecname();
    File file = new File(c.getPortfolioLink());
    InputStreamResource resource = null;
    try {
        resource = new InputStreamResource(new FileInputStream(c.getPortfolioLink()));
    }catch (Exception e){
        log.info("Catched: {}", e.getMessage());
    }
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/zip; charset=UTF-8");
    headers.add("Content-Disposition",
            String.format("attachment; filename="+fio+".zip"));
    ResponseEntity<Object> response = ResponseEntity.ok().headers(headers)
            .contentLength(file.length())
            .contentType(MediaType.parseMediaType("application/zip")).body(resource);
    return response;
}

    @GetMapping("/resume/{id}")
    public ResponseEntity<Object> resume(@PathVariable Long id){
        Candidate c = service.getById(id);
        String fio = c.getSurname() + " " +c.getName()+ " "+ c.getSecname();
        File file = new File(c.getResumeLink());
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(c.getPortfolioLink()));
        }catch (Exception e){
            log.info("Catched: {}", e.getMessage());
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/pdf; charset=UTF-8");
        headers.add("Content-Disposition",
                String.format("attachment; filename="+fio+".pdf"));
        ResponseEntity<Object> response = ResponseEntity.ok().headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf")).body(resource);
        return response;
    }
}
