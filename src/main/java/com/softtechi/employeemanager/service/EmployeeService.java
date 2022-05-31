package com.softtechi.employeemanager.service;

import java.util.List;
import java.util.UUID;

import com.softtechi.employeemanager.dao.EmployeeRepository;
import com.softtechi.employeemanager.exception.UserNotFoundException;
import com.softtechi.employeemanager.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /*
    * set the employeeid because its not user input ist auto managed by data base
    */
    //add new employee
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    //get all employee 
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    //get employee by id
    public Employee findEmployeeById (Long id){
        return employeeRepository.findEmployeeById(id)
        .orElseThrow(() -> new UserNotFoundException("User by id "+ id + "was not found"));
    }

    //update employee by id
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //delete employee by id
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteEmployeeById(id);
    }

}
