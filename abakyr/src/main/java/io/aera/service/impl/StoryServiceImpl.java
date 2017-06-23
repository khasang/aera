package io.aera.service.impl;

import io.aera.dao.StoryDao;
import io.aera.entity.Story;
import io.aera.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("storyService")
public class StoryServiceImpl implements StoryService{
    @Autowired
    private StoryDao storyDao;

    @Override
    public Story createStory(Story story) {
        return (Story) storyDao.create(story);
    }

    @Override
    public Story getStoryById(long storyId) {
        return (Story) storyDao.getById(storyId);
    }

    @Override
    public Story updateStory(Story story) {
        return (Story) storyDao.updateStory(story);
    }

    @Override
    public void deleteStory(Story story) {
        storyDao.deleteStory(story);
    }
}
