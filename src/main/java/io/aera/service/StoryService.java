package io.aera.service;

import io.aera.entity.Story;

/**
 * Used for story functionality.
 */
public interface StoryService {
    /**
     *
     * Create story at database
     * @param story - for creation
     * @return story
     */
    Story createStory(Story story);

    /**
     * get story from database by id
     * @param storyId - unique id for story(PK)
     * @return Story
     */
    Story getStoryById(long storyId);
}
