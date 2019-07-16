package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private Integer salary;

    public Employee() {
    }

    public Employee(Integer id, String name, Integer age, String gender, Integer salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public static List<Employee> getEmployeesForCompanyTest(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"jerry",22,"male",10000));
        list.add(new Employee(2,"laura",22,"female",10000));
        return list;
    }
}
