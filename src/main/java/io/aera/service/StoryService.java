package io.aera.service;

import io.aera.entity.Story;

/**
 * Used for story functionality
 */
public interface StoryService {

    /**
     * Create story at database
     * @param story - story for creation
     * @return story
     */
    Story createStory(Story story);

    /**
     * Get story from database by ID.
     * @param storyID - unique story ID
     * @return Story entity
     */
    Story getStoryById(long storyID);

    /**
     * Delete story from database by ID.
     * @param storyID - unique story ID
     */
    void deleteStory(Long storyID);
}
