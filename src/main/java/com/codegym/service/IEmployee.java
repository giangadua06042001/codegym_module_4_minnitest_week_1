package com.codegym.service;

import com.codegym.model.Employee;

import java.util.List;

public interface IEmployee {
    public List<Employee> findAll();
    public void saveEmployee(Employee employee);
    public Employee findEmployeeById(int id);
    public void removeEmployeeById(int id);
    public void updateEmployeeById(int id,Employee employee);
}
