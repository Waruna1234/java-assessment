package com.example.Assessment.Controller;

import com.example.Assessment.Service.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @Test
    void testValidName_Returns200() throws Exception {
        when(helloService.generateMessage("alice"))
                .thenReturn("Hello Alice");

        mockMvc.perform(get("/hello-world?name=alice"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Alice"));
    }

    @Test
    void testInvalidName_Returns400() throws Exception {
        when(helloService.generateMessage("waruna"))
                .thenReturn(null);

        mockMvc.perform(get("/hello-world?name=waruna"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Invalid Input"));
    }

    @Test
    void testMissingName_Returns400() throws Exception {
        mockMvc.perform(get("/hello-world")).andExpect(status().isBadRequest());
    }
}
