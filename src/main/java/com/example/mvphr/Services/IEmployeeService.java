package com.example.mvphr.Services;

import com.example.mvphr.Entities.Employee;

public interface IEmployeeService {

    void setInfo(Employee e,
                 String surname,
                 String name,
                 String secname,
                 String tg,
                 String role,
                 String start);
}
