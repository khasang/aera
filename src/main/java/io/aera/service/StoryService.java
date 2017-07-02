package io.aera.service;

import io.aera.entity.Story;

import java.util.List;

/**
 * Used for story functionality.
 */
public interface StoryService {
    /**
     * Create story at database
     *
     * @param story - story for creation
     * @return story
     */
    Story createStory(Story story);

    /**
     * get story from database by id
     *
     * @param storyId - unique id for story(PK)
     * @return Story
     */
    Story getStoryById(long storyId);

    /**
     *
     * @return list of Stories
     */
    List<Story> getStoryList();

    /**
     *
     * @param story - updated story for DB
     * @return - updated story
     */
    Story updateStory(Story story);
}//interface
