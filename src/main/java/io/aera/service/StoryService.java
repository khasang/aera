package io.aera.service;

import io.aera.entity.Story;

import java.util.List;

/**
 * Used for story functionality
 */
public interface StoryService {
    /**
     * Create story at database
     * @param story - story for creation
     * @return created story
     */
    Story createStory(Story story);

    /**
     * Return story from database by primary key id
     * @param storyId - primary key
     * @return Story
     */
    Story getStoryById(long storyId);

    /**
     * Update story at database
     * @param story
     * @return story
     */
    Story updateStory(Story story);

    /**
     * Delete story by id
     * @param id - story id to delete
     */
    void deleteStoryById(long id);

    /**
     * Get list of stories
     * @return list of stories
     */
    List<Story> getStoryList();
}
