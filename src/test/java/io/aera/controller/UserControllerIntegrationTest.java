package io.aera.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.aera.config.AppConfig;
import io.aera.config.SecurityConfig;
import io.aera.config.application.WebConfig;
import io.aera.entity.History;
import io.aera.entity.Roles;
import io.aera.entity.User;
import io.aera.service.UserService;
import org.apache.commons.codec.binary.Base64;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class, SecurityConfig.class})
@WebAppConfiguration
@Transactional
public class UserControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/user";
    private final String REGISTER = "/register";
    private final String UPDATE = "/update";
    private final String FINDUSER = "/findById";
    private final String LOGIN = "/login";
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    WebApplicationContext context;

    @Autowired
    SessionFactory sessionFactory;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    @Test
    public void testCreateUser(){
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
    public void testLoginUser(){
        User oldUser = prefillUser();

        HttpHeaders httpHeaders = createHeaders(oldUser.getLogin(), oldUser.getPassword());
        HttpEntity<String> userHttpEntity = new HttpEntity<>(httpHeaders);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + LOGIN,
                HttpMethod.GET,
                userHttpEntity,
                String.class);

        String answer = responseEntity.getStatusCode().toString();

        assertNotNull(answer);
        assertEquals("200", answer);
    }

    @Test
    @WithUserDetails("sword")
    public void testUpdateUser() throws Exception {
        User oldUser = prefillUser();
        User user = updateUser(oldUser);

        mockMvc.perform(put(ROOT + UPDATE)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(asJsonString(user)))
                        .andExpect(status().isOk());

        User updatedUser = this.userService.findByLogin(user.getLogin());
        assertEquals(updatedUser.getFirstname(), "Kat");
    }

    private HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes());
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
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
        assertEquals("sword", result.getLogin());
        return result;
    }

    private User updateUser(User oldUser) {
        oldUser.setId(oldUser.getId());
        oldUser.setLogin("sword");
        oldUser.setFirstname("Kat");
        oldUser.setLastname("Kat");
        oldUser.setPassword(new BCryptPasswordEncoder().encode("sword"));
        oldUser.setEmail("Kat@yandex.ru");
        oldUser.setRoleId(Roles.ROLE_USER);
        return oldUser;
    }

    private User prefillUser() {
        User user = new User();
        user.setLogin("sword");
        user.setFirstname("sword");
        user.setLastname("sword");
        user.setPassword(new BCryptPasswordEncoder().encode("sword"));
        user.setEmail("sword@mail.com");
        user.setRoleId(Roles.ROLE_USER);
        return user;
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
