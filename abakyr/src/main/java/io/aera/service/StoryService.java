package io.aera.service;

import io.aera.entity.Story;

/**
 * The main purpose is to work with a functionality of the stories
 */
public interface StoryService {
    /**
     * Creates story in the database
     *
     * @param story
     * @return story
     */
    Story createStory(Story story);

    /**
     * Gets Story by Id
     *
     * @param storyId - unique id for Stories
     * @return entity
     */
    Story getStoryById(long storyId);

    /**
     * Updates Story in the database
     *
     * @param story
     * @return story
     */
    Story updateStory(Story story);

    /**
     * Deletes story by id
     *
     * @param story
     */
    void deleteStory(Story story);
}
