package com.codWithProject.employee.services;

import com.codWithProject.employee.entity.Employee;
import com.codWithProject.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    List<Employee> findAll(){
        return employeeRepository.findAll();
    }



    public Employee postEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
