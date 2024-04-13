package com.example.mvphr.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(columnDefinition = "text")
    private String name;
    private String surname;
    private String secname;
    private String startOfWork;
    @Column(columnDefinition = "text")
    private String role;
    private String tg;
    private String paperId;
}
