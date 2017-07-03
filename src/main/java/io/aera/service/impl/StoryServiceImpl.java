package io.aera.service.impl;

import io.aera.dao.StoryDao;
import io.aera.entity.Story;
import io.aera.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("storyService")
public class StoryServiceImpl implements StoryService {
    @Autowired
    StoryDao storyDao;

    @Override
    public Story createStory(Story story) {
        return storyDao.create(story);
    }

    @Override
    public Story getStoryById(long storyID) {
        return storyDao.getById(storyID);
    }

    @Override
    public void deleteStory(Long storyID) {
        storyDao.deleteById(storyID);
    }

    @Override
    public List<Story> getAllStories() {
        return storyDao.getAllEnities();
    }

    @Override
    public Story updateStory(Story story) {
        return storyDao.updateEntity(story);
    }
}
