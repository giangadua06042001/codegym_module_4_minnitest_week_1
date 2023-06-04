package com.codegym.controller;

import com.codegym.model.Employee;
import com.codegym.service.EmployeeService;
import com.codegym.service.IEmployee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("test")
public class EmployeeController {
    private final IEmployee listEmployee=new EmployeeService();
    @GetMapping("")
    public String index (Model model){
        List<Employee>employeeList=listEmployee.findAll();
        model.addAttribute("employee",employeeList);
        return "/list";
    }
    @GetMapping("create")
    public String creatFrom(Model model){
        model.addAttribute("employee",new Employee());
        return "/create";
    }
    @PostMapping("/save")
    public String creatEmployee(Employee employee){
        employee.setId((int) (Math.random() * 10000));
        listEmployee.saveEmployee(employee);
        return "redirect:/employee";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id,Model model){
        model.addAttribute("employee",listEmployee.findEmployeeById(id));
    return "/edit";
    }
    @PostMapping("/update")
    public String update(Employee employee){
        listEmployee.updateEmployeeById(employee.getId(),employee);
        return "redirect:/employee";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id,Model model){
        model.addAttribute("employee",listEmployee.findEmployeeById(id));

        return "/delete";
    }
    @PostMapping("delete")
    public String delete(Employee employee){
        listEmployee.removeEmployeeById(employee.getId());
        return "redirect:/employee";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("employ",listEmployee.findEmployeeById(id));
        return "/view";

    }
}
