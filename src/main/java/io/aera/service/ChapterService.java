package io.aera.service;

import io.aera.entity.Chapter;

import java.util.List;

/**
 * Used for chapter functionality
 */
public interface ChapterService {
    /**
     * Create chapter at database
     * @param chapter - chapter for creation
     * @return story
     */
    Chapter createChapter(Chapter chapter);

    /**
     * Crete chapter and wire with found story
     * @param chapter - chapter for creation
     * @param storyID - story ID
     * @return chapter
     */
    Chapter createChapter(Chapter chapter, long storyID);

    /**
     * Get chapter from database by ID
     * @param chapterID - unique chapter ID
     * @return Chapter entity
     */
    Chapter getChapterById(long chapterID);

    /**
     * Delete chapter from database by ID.
     * @param chapterID - unique chapter ID
     */
    void deleteStory(long chapterID);

    /**
     * Get all chapter entities from database
     * @return list of chapters
     */
    List<Chapter> getAllChapters();

    /**
     * Update existing chapter     *
     * @param chapter
     * @return updated chapter
     */
    Chapter updateChapter(Chapter chapter);
}