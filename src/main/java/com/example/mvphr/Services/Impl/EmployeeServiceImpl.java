package com.example.mvphr.Services.Impl;

import com.example.mvphr.Entities.Employee;
import com.example.mvphr.Repos.EmployeeRepository;
import com.example.mvphr.Services.IEmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeeRepository repo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public void setInfo(Employee e,
                        String surname, String name,
                        String secname, String tg,
                        String role, String start) {

    e.setSurname(surname);
    e.setName(name);
    e.setSecname(secname);
    e.setTg(surname);
    e.setSurname(surname);
    }
}
