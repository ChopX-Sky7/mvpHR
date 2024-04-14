package com.example.mvphr.Services.Impl;

import com.example.mvphr.Entities.Candidate;
import com.example.mvphr.Repos.CandidateRepository;
import com.example.mvphr.Services.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements ICandidateService {

    private final CandidateRepository repo;

    @Autowired
    public CandidateServiceImpl(CandidateRepository repo) {
        this.repo = repo;
    }

    @Override
    public void setInfo(Candidate c,
    String surname, String name,
    String secname, String dob,
    String email, String hhUrl,
    String gitUrl, String porfolioLink){

     c.setSurname(surname);
     c.setName(name);
     c.setSecname(secname);
     c.setDob(dob);
     c.setEmail(email);
     c.setHhUrl(hhUrl);
     c.setGitUrl(gitUrl);
     c.setPortfolioLink(porfolioLink);
    }

    @Override
    public void save(Candidate c) {
        repo.save(c);
    }

    @Override
    public List<Candidate> getALl(){
        return repo.findAll();
    }

    @Override
    public Candidate getById(Long id) {
        return repo.getById(id);
    }


}
