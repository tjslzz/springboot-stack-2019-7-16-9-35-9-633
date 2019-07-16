package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String companyName;

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

    public static List<Company> getListForCompanyTest(){
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("alibaba"));
        companies.add(new Company("tengxun"));
        return companies;
    }

}
