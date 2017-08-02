package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

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
public class DemoApplicationTests {

    @Autowired
    private MockMvc mvc;
    
    @Test
    public void testDefault() throws Exception {
        mvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(xpath("//form[@id='default']/input[@name='_csrf']").doesNotExist());
    }

    @Test
    public void testThAction() throws Exception {
        mvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(xpath("//form[@id='th:action']/input[@name='_csrf']").doesNotExist());
    }

    @Test
    public void testMethodThAction() throws Exception {
        mvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(xpath("//form[@id='method+th:action']/input[@name='_csrf']").doesNotExist());
    }

}
