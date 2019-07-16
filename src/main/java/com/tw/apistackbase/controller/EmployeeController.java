package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return Employee.getEmployeesForCompanyTest();
    }

    @GetMapping(path = "/employees/{index}")
    public Employee getEmployees(@PathVariable Integer index) {
        return Employee.getEmployeesForCompanyTest().get(index);
    }

    @GetMapping(path = "/employees{page}{pageSize}")
    public List<Employee> getEmployeesByPage(@RequestParam Integer page, @RequestParam Integer pageSize) {
        Integer end = page * pageSize - 1;
        Integer start = (page-1)*pageSize;
        List<Employee> employees = Employee.getEmployeesForCompanyTest();
        return employees.stream().filter(employee -> employees.indexOf(employee) >= start && employees.indexOf(employee) <= end).collect(Collectors.toList());
    }

    @GetMapping("/employees{gender}")
    public List<Employee> getEmployeesByGender(@RequestParam("gender") String gender) {
        List<Employee> employees = Employee.getEmployeesForCompanyTest();
        return employees.stream().filter(employee -> employee.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
    }

    @PostMapping("/employees")
    public String postEmployee(@RequestBody Employee employee){
        List<Employee> employees = Employee.getEmployeesForCompanyTest();
        Integer size = employees.size();
        employees.add(employee);
        return employees.size() - size == 1 ? "ok":"no";
    }

    @PutMapping(path = "/employees/{index}")
    public String putEmployee(@PathVariable Integer index,@RequestBody Employee employee){
        List<Employee> employees = Employee.getEmployeesForCompanyTest();
        String olc_name = employees.get(index).getName();
        employees.remove(index);employees.add(employee);
        return employees.get(index).getName().equalsIgnoreCase(olc_name) ? "ok":"no";
    }

    @DeleteMapping(path = "/employees/{index}")
    public String deleteEmployee(@PathVariable Integer index){
        List<Employee> employees = Employee.getEmployeesForCompanyTest();
        employees.remove(index);
        return "ok";
    }
}
