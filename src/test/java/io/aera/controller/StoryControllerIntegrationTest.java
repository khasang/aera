package io.aera.controller;

import io.aera.config.TestConfig;
import io.aera.entity.Chapter;
import io.aera.entity.Story;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class StoryControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/story";
    private final String ADD = "/add";
    private final String GET_ALL_STORIES = "/all";
    private final String GET_BY_ID = "/getById";
    private final String DELETE = "/delete";
    private final String UPDATE = "/update";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void addStoryTest(){
        Story story = createStory();
        Story receivedStory = getStory(story);

        assertNotNull(receivedStory);
        assertEquals(receivedStory.getName(), story.getName());
        assertEquals(receivedStory.getChapters().size(), story.getChapters().size());

        int chaptersCounter = story.getChapters().size();
        sortingChaptersList(receivedStory.getChapters());
        sortingChaptersList(story.getChapters());

        for(int i=0; i<chaptersCounter; i++){
            assertEquals(receivedStory.getChapters().get(i).getName(),
                    story.getChapters().get(i).getName());
            assertEquals(receivedStory.getChapters().get(i).getGoldPrices().intValue(),
                    story.getChapters().get(i).getGoldPrices().intValue());
        }
    }

    @Test
    public void deleteStoryTest(){
        Story story = createStory();
        ResponseEntity<String> deleteStoryResponse = deleteStory(story);
        assertEquals("OK", deleteStoryResponse.getStatusCode().getReasonPhrase());

        Story deletedStory = getStory(story);
        assertNull(deletedStory);
    }

    @Test
    public void updateStoryTest(){
        Story story = createStory();
        Story updatedStory = updateStory(story);
        Story getUpdatedStory = getStory(story);

        assertNotNull(updatedStory);
        assertEquals(story.getId(), updatedStory.getId());
        assertNotEquals(story.getDateCreated(), updatedStory.getDateCreated());

        assertNotNull(getUpdatedStory);
        assertEquals(updatedStory.getDateCreated(), getUpdatedStory.getDateCreated());
        assertEquals(updatedStory.getDescription(), getUpdatedStory.getDescription());
    }

    @Test
    public void getAllStoriesTest(){
        assertEquals(getAllStories().size(), checkStoriesOnDB());
    }

    @Test
    public void checkListOfStories(){
        getAllStories().stream().forEach(story -> assertNotNull(story.getId()));
    }

    private Story getStory(Story story){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Story> storyResponseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Story.class,
                story.getId()
        );
        return storyResponseEntity.getBody();
    }

    private ResponseEntity<String> deleteStory(Story story){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                story.getId()
        );
        return responseEntity;
    }

    private Story updateStory(Story story){
        story.setDescription("updated description");
        story.setDateCreated(new Date());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Story> storyHttpEntity = new HttpEntity<>(story, headers);
        return postStoryChanges(storyHttpEntity);
    }

    private Story postStoryChanges(HttpEntity<Story> httpEntity) {
        RestTemplate restTemplate = new RestTemplate();
        Story updatedStory = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Story.class
        ).getBody();
        return updatedStory;
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


    private Story createStory(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Story> httpEntity = new HttpEntity<>(prefillStory(), headers);
        return addStory(httpEntity);
    }

    private Story addStory(HttpEntity<Story> storyHttpEntity){
        RestTemplate restTemplate = new RestTemplate();
        Story addedStory = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                storyHttpEntity,
                Story.class
        ).getBody();
        return addedStory;
    }

    private Story prefillStory(){
        Story story = new Story();
        story.setName(RandomStringUtils.randomAlphabetic(15).toUpperCase());
        story.setDescription(createRandomDescription());
        story.setDateCreated(new Date());

        Chapter chapter1 = new Chapter();
        chapter1.setName(RandomStringUtils.randomAlphabetic(15).toUpperCase());
        chapter1.setGoldPrices(new BigDecimal(BigInteger.valueOf(new Random().nextInt(100))));

        Chapter chapter2 = new Chapter();
        chapter2.setName(RandomStringUtils.randomAlphabetic(10).toUpperCase());
        chapter2.setGoldPrices(new BigDecimal(BigInteger.valueOf(new Random().nextInt(100))));

        story.setChapters(new ArrayList<>(Arrays.asList(chapter1,chapter2)));

        return story;
    }

    private String createRandomDescription(){
        StringBuilder sBuilder = new StringBuilder();
        for(int i=0;i<5;i++){
            sBuilder.append(RandomStringUtils.randomAlphabetic(7).toLowerCase() + " ");
        }
        return sBuilder.toString();
    }

    private void sortingChaptersList(List<Chapter> chapters){
        Collections.sort(chapters, new Comparator<Chapter>() {
            @Override
            public int compare(Chapter o1, Chapter o2) {
                return (int)(o1.getId() - o2.getId());
            }
        });
    }
}
