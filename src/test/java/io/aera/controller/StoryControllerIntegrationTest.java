package io.aera.controller;

import io.aera.entity.Chapter;
import io.aera.entity.Story;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StoryControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/story";
    private final String ADD = "/add";
    private final String GET_ID = "/get/story/";

    @Test
    public void addStory() {
        Story story = createStory();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Story> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Story.class,
                story.getId()
        );

        Story rezultStory = responseEntity.getBody();

        Assert.assertNotNull(rezultStory);
        Assert.assertEquals(story.getName(), rezultStory.getName());
    }

    private Story createStory() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        
        Story story = prefillStory();
        HttpEntity<Story> httpEntity = new HttpEntity<>(story, httpHeaders);

        RestTemplate restTemplate = new RestTemplate();

        Story rezult = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Story.class
        ).getBody();

        Assert.assertNotNull(rezult);
        Assert.assertNotNull(rezult.getId());
        Assert.assertEquals("knife", rezult.getName());

        return rezult;
    }

    private Story prefillStory() {
        Story story = new Story();
        story.setName("knife");

        Chapter chapter1 = new Chapter();
        chapter1.setName("create");
        chapter1.setGoldPrice(BigDecimal.valueOf(10));

        Chapter chapter2 = new Chapter();
        chapter2.setName("sharpen");
        chapter2.setGoldPrice(BigDecimal.valueOf(3));

        List<Chapter> chapterList = new ArrayList<>();
        chapterList.add(chapter1);
        chapterList.add(chapter2);
        story.setStoryChapter(chapterList);

        return story;
    }
}
