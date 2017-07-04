package io.aera.controller;

import io.aera.entity.Chapter;
import io.aera.entity.Story;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class StoryControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/story";
    private final String ADD = "/add";
    private final String GET_ID = "/get/story";
    private final String ALL = "/all";
    private final String DELETE = "/delete";

    @Test
    public void getAllStories(){
        RestTemplate restTemplate = new RestTemplate();
        createStory();
        createStory();

        ResponseEntity<List<Story>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Story>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<Story> list = responseEntity.getBody();
        assertNotNull(list);
    }

    @Test
    public void deleteStory(){
        Story story = createStory();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                story.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        ResponseEntity<Story> checkStory = restTemplate.exchange(
                ROOT + GET_ID + "/{id}",
                HttpMethod.GET,
                null,
                Story.class,
                story.getId()
        );

        assertNull(checkStory.getBody());

    }

    @Test
    public void addStory() {
        Story story = createStory();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Story> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "/{id}",
                HttpMethod.GET,
                null,
                Story.class,
                story.getId()
        );

        Story resultStory = responseEntity.getBody();
        assertNotNull(resultStory);
        assertEquals(story.getName(), resultStory.getName());
    }

    private Story createStory() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Story story = prefillStory();

        HttpEntity<Story> httpEntity = new HttpEntity<>(story, headers);

        RestTemplate restTemplate = new RestTemplate();

        Story result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Story.class).getBody();

        assertNotNull(result);
        assertEquals("Sword", result.getName());
        assertNotNull(result.getId());

        return result;
    }

    private Story prefillStory() {
        Story story = new Story();
        story.setName("Sword");

        Chapter chapter1 =  new Chapter();
        chapter1.setName("create");
        chapter1.setGoldPrice(new BigDecimal(BigInteger.valueOf(10)));

        Chapter chapter2 =  new Chapter();
        chapter1.setName("sharpening");
        chapter1.setGoldPrice(new BigDecimal(BigInteger.valueOf(3)));

        List<Chapter> chapterList = new ArrayList<>();
        chapterList.add(chapter1);
        chapterList.add(chapter2);
        story.setStoryChapters(chapterList);

        return story;
    }

}
