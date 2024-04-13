package com.example.mvphr.Repos;


import com.example.mvphr.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    List<Employee> getAllByRole(String s);
    List<Employee> getAllByStartOfWork(String s);
    List<Employee> getByPaperId(String S);
}
