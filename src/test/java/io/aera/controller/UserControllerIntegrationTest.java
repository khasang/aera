package io.aera.controller;

import io.aera.config.AppConfig;
import io.aera.config.application.WebConfig;
import io.aera.entity.History;
import io.aera.entity.Roles;
import io.aera.entity.User;
import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class})
@WebAppConfiguration
@Transactional
//@Ignore
public class UserControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/user";
    private final String REGISTER = "/register";
    private final String UPDATE = "/update";
    private final String FINDUSER = "/findById";

    @Autowired
    SessionFactory sessionFactory;

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

        List<History> historyItems = findHistory(user.getLogin(), "Registering new User!");
        assertNotNull(result);
        assertEquals(user.getLogin(), result.getLogin());
        assertTrue(historyItems.size() > 0);
    }

    private List findHistory(String login, String descr) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(History.class);
        Root<History> root = criteria.from(History.class);
        criteria.select(root).where(builder.equal(root.get("userLogin"), login), builder.like(root.get("description"), descr));
        return sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
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
