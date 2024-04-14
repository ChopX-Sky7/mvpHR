package com.example.mvphr.Services;

import com.example.mvphr.Entities.Candidate;

import java.util.List;

public interface ICandidateService {

    void setInfo(Candidate c,
                 String surname, String name,
                 String secname, String dob,
                 String email, String hhUrl,
                 String gitUrl, String porfolioLink);

    void save(Candidate c);
    List<Candidate> getALl();

    Candidate getById(Long id);
}
