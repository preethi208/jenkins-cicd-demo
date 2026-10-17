package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void shouldReturnExpectedMessage() {
        assertEquals(
            "Hello from my first DevOps project!",
            App.getMessage()
        );
    }
}
