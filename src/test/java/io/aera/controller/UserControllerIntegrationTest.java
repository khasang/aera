package io.aera.controller;

import io.aera.entity.User;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/user";
    private final String REGISTER = "/register";

    @Test
    public void createUser(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        User user = prefillUser();

        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);

        RestTemplate restTemplate = new RestTemplate();

        User result = restTemplate.exchange(
                ROOT + REGISTER,
                HttpMethod.PUT,
                httpEntity,
                User.class).getBody();

        assertNotNull(result);
        assertEquals("sword", result.getLogin());
        assertNotNull(result.getId());
    }

    private User prefillUser() {
        User user = new User();
        user.setLogin("sword");
        user.setFirstname("Ivan");
        user.setLastname("Ivanov");
        user.setPassword("sword");
        user.setEmail("ivan125@yandex.ru");
        user.setRoleId(1);
        return user;
    }
}
