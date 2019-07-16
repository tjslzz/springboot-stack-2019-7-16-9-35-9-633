package com.tw.apistackbase.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

import com.tw.apistackbase.model.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_company_list_when_call_get_companies() throws Exception {
        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[{companyName:alibaba}]"));
    }

    @Test
    public void should_return_true_company_when_call_get_companies_given_1() throws Exception {
        mockMvc.perform(get("/companies/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{companyName:tengxun}"));
    }

    @Test
    public void should_return_true_employee_list_when_call_get_companies_employees_given_1() throws Exception {
        mockMvc.perform(get("/companies/1/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[{\"id\":1,\"name\":\"jerry\",\"age\":22,\"gender\":\"male\",\"salary\":10000},{\"id\":2,\"name\":\"laura\",\"age\":22,\"gender\":\"female\",\"salary\":10000}]"));
    }

    @Test
    public void should_return_true_company_list_when_call_get_companies_given_pages() throws Exception {
        mockMvc.perform(get("/companies?page=1&pageSize=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[{\"companyName\":\"alibaba\",\"employees\":[{\"id\":1,\"name\":\"jerry\",\"age\":22,\"gender\":\"male\",\"salary\":10000},{\"id\":2,\"name\":\"laura\",\"age\":22,\"gender\":\"female\",\"salary\":10000}],\"employeesNumber\":0},{\"companyName\":\"tengxun\",\"employees\":[{\"id\":1,\"name\":\"jerry\",\"age\":22,\"gender\":\"male\",\"salary\":10000},{\"id\":2,\"name\":\"laura\",\"age\":22,\"gender\":\"female\",\"salary\":10000}],\"employeesNumber\":0}]"));
    }

    @Test
    public void should_return_ok_when_call_post_companies_given_company() throws Exception {
        mockMvc.perform(post("/companies").contentType("application/json;charset=UTF-8").content("{\"companyName\":\"alibaba\",\"employees\":[{\"id\":1,\"name\":\"jerry\",\"age\":22,\"gender\":\"male\",\"salary\":10000},{\"id\":2,\"name\":\"laura\",\"age\":22,\"gender\":\"female\",\"salary\":10000}],\"employeesNumber\":0}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(containsString("ok")));
    }
}