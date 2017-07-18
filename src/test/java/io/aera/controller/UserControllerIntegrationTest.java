package io.aera.controller;

import io.aera.entity.Roles;
import io.aera.entity.User;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Transactional
public class UserControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/user";
    private final String REGISTER = "/register";
    private final String UPDATE = "/update";
    private final String FINDUSER = "/findById";

    @Test
    public void createTestUser(){
        User user = createUser();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> responseEntity = restTemplate.exchange(
                ROOT + FINDUSER + "/{id}",
                HttpMethod.GET,
                null,
                User.class,
                user.getId());

        User result = responseEntity.getBody();
        assertNotNull(result);
        assertEquals(user.getLogin(), result.getLogin());
    }

    @Test
    public void updateUser(){
        User oldUser = createUser();
        User user = updateUser(oldUser);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);

        RestTemplate restTemplate = new RestTemplate();

        User result = restTemplate.exchange(
                ROOT + UPDATE + "/" + user.getId(),
                HttpMethod.PUT,
                httpEntity,
                User.class).getBody();

        assertNotNull(result);
        assertEquals("Kat", result.getFirstname());
    }

    private User createUser(){
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
        assertEquals("swordy", result.getLogin());
        return result;
    }

    private User updateUser(User oldUser) {
        oldUser.setId(oldUser.getId());
        oldUser.setLogin("testUpdate");
        oldUser.setFirstname("Kat");
        oldUser.setLastname("Kat");
        oldUser.setPassword(new BCryptPasswordEncoder().encode("testUpdate"));
        oldUser.setEmail("sword@yandex.ru");
        oldUser.setRoleId(Roles.ROLE_USER);
        return oldUser;
    }

    private User prefillUser() {
        User user = new User();
        user.setLogin("swordy");
        user.setFirstname("swordy");
        user.setLastname("swordy");
        user.setPassword(new BCryptPasswordEncoder().encode("swordy"));
        user.setEmail("swordy@mail.com");
        user.setRoleId(Roles.ROLE_USER);
        return user;
    }
}
