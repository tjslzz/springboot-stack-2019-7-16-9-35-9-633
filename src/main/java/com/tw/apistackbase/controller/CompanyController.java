package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        List<Company> result = new ArrayList<>();
        List<Company> companies = Company.getListForCompanyTest();
        for(int i =0; i < companies.size();i++){
            if(i >= start && i <= end){
                result.add(companies.get(i));
            }
        }
        return result;
    }

    @PostMapping
    public String putCompany(@RequestBody Company company){
        List<Company> companies = Company.getListForCompanyTest();
        Integer size = companies.size();
        companies.add(company);
        return companies.size() - size == 1 ? "ok":"no";
    }
}
