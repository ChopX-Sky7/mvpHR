package com.example.mvphr.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
// класс кандидата
@Entity
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String surname;
    private String secname;
    private String dob;
    private String email;

    private String hhUrl;
    private String gitUrl;
    private String portfolioLink;
    private String resumeLink;


    private String time;

    public void timeOfCreate(){this.time = new SimpleDateFormat("yyyy-MM-dd H:mm").format(new Date());}

}
