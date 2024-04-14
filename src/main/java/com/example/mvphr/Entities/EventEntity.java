package com.example.mvphr.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
//класс мероприятия
@Entity
@Data
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String evdate;
    private String evdesc;
    @Transient
    private Long candId;
    private String name;
    @Transient
    private String candName;

}


