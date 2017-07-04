package io.aera.controller;

import io.aera.config.TestConfig;
import io.aera.entity.Story;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class StoryControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/story";
    private final String GET_ALL_STORIES = "/all";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void getAllStoriesTest(){
        assertEquals(getAllStories().size(), checkStoriesOnDB());
    }

    @Test
    public void checkListOfStories(){
        getAllStories().stream().forEach(story -> assertNotNull(story.getId()));
    }

    private int checkStoriesOnDB(){
        return jdbcTemplate.queryForObject("SELECT count(*) FROM stories", Integer.class);
    }

    private List<Story> getAllStories() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Story>> storyResponse = restTemplate.exchange(
                ROOT + GET_ALL_STORIES,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Story>>() {
                });
        return storyResponse.getBody();
    }
}
