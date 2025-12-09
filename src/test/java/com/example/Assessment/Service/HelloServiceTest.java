package com.example.Assessment.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

    private final HelloService helloService = new HelloService();

    @Test
    void testValidName_FirstHalfAlphabet() {
        String result = helloService.generateMessage("alice");
        assertEquals("Hello Alice", result);
    }

    @Test
    void testValidName_CapitalLetter() {
        String result = helloService.generateMessage("Bandara");
        assertEquals("Hello Bandara", result);
    }

    @Test
    void testInvalidName_SecondHalfAlphabet() {
        String result = helloService.generateMessage("waruna");
        assertNull(result);
    }

    @Test
    void testNameNull_ReturnsNull() {
        String result = helloService.generateMessage(null);
        assertNull(result);
    }

    @Test
    void testNameEmpty_ReturnsNull() {
        String result = helloService.generateMessage("");
        assertNull(result);
    }

    @Test
    void testNameWithSpaces_ReturnsNull() {
        String result = helloService.generateMessage("   ");
        assertNull(result);
    }
}
