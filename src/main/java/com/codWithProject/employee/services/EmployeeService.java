package com.codWithProject.employee.services;

import com.codWithProject.employee.entity.Employee;
import com.codWithProject.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id).orElseThrow(null);
    }


    public Employee postEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> deleteEmployee(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        employeeOptional.ifPresent(employeeDb -> {
            employeeRepository.delete(employeeDb);
        });
        return employeeOptional;
    }

    public Optional<Employee> updateEmployee(Long id, Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if(employeeOptional.isPresent()){
            Employee employeetDb = employeeOptional.orElseThrow();
            employeetDb.setName(employee.getName());
            employeetDb.setEmail(employee.getEmail());
            employeetDb.setPhone(employee.getPhone());
            employeetDb.setDepartment(employee.getDepartment());

            return Optional.of(employeeRepository.save(employeetDb));
        }
        return employeeOptional;
    }



}

