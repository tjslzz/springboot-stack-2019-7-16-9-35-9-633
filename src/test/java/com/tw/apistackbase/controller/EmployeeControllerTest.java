package com.tw.apistackbase.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.containsString;

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
public class EmployeeControllerTest {
 
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_company_list_when_call_get_employees() throws Exception {
        mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[{\"id\":1,\"name\":\"jerry\",\"age\":22,\"gender\":\"male\",\"salary\":10000},{\"id\":2,\"name\":\"laura\",\"age\":22,\"gender\":\"female\",\"salary\":10000}]"));
    }

    @Test
    public void should_return_true_company_when_call_get_employees_given_1() throws Exception {
        mockMvc.perform(get("/employees/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("{\"id\":2,\"name\":\"laura\",\"age\":22,\"gender\":\"female\",\"salary\":10000}"));
    }

    @Test
    public void should_return_true_employee_list_when_call_get_employees_employees_given_1() throws Exception {
        mockMvc.perform(get("/employees?gender=male"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[{\"id\":1,\"name\":\"jerry\",\"age\":22,\"gender\":\"male\",\"salary\":10000},{\"id\":2,\"name\":\"laura\",\"age\":22,\"gender\":\"female\",\"salary\":10000}]"));
    }

    @Test
    public void should_return_true_company_list_when_call_get_employees_given_pages() throws Exception {
        mockMvc.perform(get("/employees?page=1&pageSize=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json("[{\"id\":1,\"name\":\"jerry\",\"age\":22,\"gender\":\"male\",\"salary\":10000},{\"id\":2,\"name\":\"laura\",\"age\":22,\"gender\":\"female\",\"salary\":10000}]"));
    }

    @Test
    public void should_return_ok_when_call_post_employees_given_company() throws Exception {
        mockMvc.perform(post("/employees").contentType("application/json;charset=UTF-8").content("{\"id\":1,\"name\":\"jerry\",\"age\":22,\"gender\":\"male\",\"salary\":10000},{\"id\":2,\"name\":\"laura\",\"age\":22,\"gender\":\"female\",\"salary\":10000}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(containsString("ok")));
    }

    @Test
    public void should_return_ok_when_call_put_employees_given_new_company() throws Exception {
        mockMvc.perform(put("/employees/1").contentType("application/json;charset=UTF-8").content("{\"id\":1,\"name\":\"jerry\",\"age\":22,\"gender\":\"male\",\"salary\":10000},{\"id\":2,\"name\":\"laura\",\"age\":22,\"gender\":\"female\",\"salary\":10000}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(containsString("ok")));
    }

    @Test
    public void should_return_ok_when_call_delete_employees_given_1() throws Exception {
        mockMvc.perform(delete("/employees/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(containsString("ok")));
    }
}