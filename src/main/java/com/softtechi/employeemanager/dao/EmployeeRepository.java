package com.softtechi.employeemanager.dao;

import java.util.Optional;

import com.softtechi.employeemanager.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

    Optional<Employee> findEmployeeById(Long id);

    void deleteEmployeeById(Long id);
    
}
