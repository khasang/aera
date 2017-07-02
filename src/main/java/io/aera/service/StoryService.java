package io.aera.service;

import io.aera.entity.Story;

import java.util.List;

/**
 * Used for story functionality
 */
public interface StoryService {
    /**
     * Create Story at database
     *
     * @param story - story for creation
     * @return story
     */
    Story createStory(Story story);

    /**
     * Get Story from database by id
     *
     * @param storyId - unique id for story (PK)
     * @return Story
     */
    Story getStoryById(long storyId);

    /**
     * Update Story in database
     *
     * @param story - story for update
     * @return Story updated
     */
    Story updateStory(Story story);

    /**
     * Delete Story from database by id
     *
     * @param storyId - unique id for story (PK)
     * @return
     */
    void deleteStoryById(long storyId);

    /**
     * Get all story entities from database
     *
     * @return list of stories
     */
    List<Story> getListStories();

}
