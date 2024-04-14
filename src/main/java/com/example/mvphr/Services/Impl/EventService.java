package com.example.mvphr.Services.Impl;

import com.example.mvphr.Entities.EventEntity;
import com.example.mvphr.Repos.EventRepository;
import com.example.mvphr.Services.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
// инкапсуляция бд леера
@Service
public class EventService implements IEventService {

    private final EventRepository repo;

    @Autowired
    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    @Override
    public EventEntity getById(Long id) {
        return repo.getById(id);
    }

    @Override
    public List<EventEntity> getAll() {
        return repo.findAll();
    }



    @Override
    public void setInfo(EventEntity e, String d, String desc, Long candId) {
        e.setEvdate(d);
        e.setEvdesc(desc);
        e.setCandId(candId);
    }

    @Override
    public void save(EventEntity e) {
        repo.save(e);
    }
}
