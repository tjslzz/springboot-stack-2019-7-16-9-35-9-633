package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String companyName;
    private List<Employee> employees = new ArrayList<>();
    private Integer employeesNumber = employees.size();

    public Company() { }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public static List<Company> getListForCompanyTest(){
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("alibaba"));
        companies.add(new Company("tengxun"));
        return companies;
    }

}
