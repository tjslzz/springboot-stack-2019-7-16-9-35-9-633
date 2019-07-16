package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("companies")
public class CompanyController {

    @GetMapping
    public List<Company> getCompanies() {
        return Company.getListForCompanyTest();
    }

    @GetMapping(path = "/{index}")
    public Company getCompany(@PathVariable Integer index) {
        return Company.getListForCompanyTest().get(index);
    }

    @GetMapping(path = "/{index}/employees")
    public List<Employee> getEmployeesByCompany(@PathVariable Integer index) {
        return Company.getListForCompanyTest().get(index).getEmployees();
    }

    @GetMapping(path = "{page}{pageSize}")
    public List<Company> getCompaniesByPage(@RequestParam Integer page,@RequestParam Integer pageSize) {
        Integer end = page * pageSize - 1;
        Integer start = (page-1)*pageSize;
        List<Company> companies = Company.getListForCompanyTest();
        return companies.stream().filter(company -> companies.indexOf(company) >= start && companies.indexOf(company) <= end).collect(Collectors.toList());
    }

    @PostMapping
    public String postCompany(@RequestBody Company company){
        List<Company> companies = Company.getListForCompanyTest();
        Integer size = companies.size();
        companies.add(company);
        return companies.size() - size == 1 ? "ok":"no";
    }

    @PutMapping(path = "/{index}")
    public String putCompany(@PathVariable Integer index,@RequestBody Company company){
        List<Company> companies = Company.getListForCompanyTest();
        String olc_name = companies.get(index).getCompanyName();
        companies.remove(index);companies.add(company);
        return companies.get(index).getCompanyName().equalsIgnoreCase(olc_name) ? "ok":"no";
    }

    @DeleteMapping(path = "/{index}")
    public String deleteCompany(@PathVariable Integer index){
        List<Company> companies = Company.getListForCompanyTest();
        companies.remove(index);
        return "ok";
    }
}
