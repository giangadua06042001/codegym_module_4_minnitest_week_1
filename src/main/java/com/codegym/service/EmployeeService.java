package com.codegym.service;

import com.codegym.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService implements IEmployee {
    public static  final Map<Integer,Employee> employeeList;
    static {
        employeeList=new HashMap<>();
        employeeList.put(1,new Employee(1,"Nguyen Van Tuan",29,"tuan@gmail.com",90000,"Ha Noi"));
        employeeList.put(2,new Employee(2,"Nguyen Van Toan",28,"toan@gmail.com",80000,"Ha Noi"));
        employeeList.put(3,new Employee(3,"Nguyen Van Tu",27,"tu@gmail.com",70000,"Ha Noi"));
        employeeList.put(4,new Employee(4,"Nguyen Van Thi",26,"thi@gmail.com",60000,"Ha Noi"));
        employeeList.put(5,new Employee(5,"Nguyen Van Thang",25,"thang@gmail.com",50000,"Ha Noi"));
    }
    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeList.values());
    }

    @Override
    public void saveEmployee(Employee employee) {
       employeeList.put(employee.getId(),employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeList.get(id);
    }

    @Override
    public void removeEmployeeById(int id) {

    }

    @Override
    public void updateEmployeeById(int id, Employee employee) {

    }
}
