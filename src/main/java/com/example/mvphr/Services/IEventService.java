package com.example.mvphr.Services;

import com.example.mvphr.Entities.EventEntity;

import java.util.Date;
import java.util.List;

public interface IEventService {

    EventEntity getById(Long id);
    List<EventEntity> getAll();

    void setInfo(EventEntity e,
                 String d,
                 String desc,
                 Long candId);

    void save(EventEntity e);
}
