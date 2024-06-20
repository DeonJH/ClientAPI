package com.clientApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lombok.Data;

public class lombokTest {

    @Test
    public void givenAnnotatedUser_thenHasGettersAndSetters() {
        User user = new User();
        user.setFirstName("TestFirstName");
        assertEquals(user.getFirstName(), "TestFirstName");
    }

    @Data
    class User {
        private String firstName;
    }
}
