package io.aera.service.impl;

import io.aera.dao.StoryDao;
import io.aera.entity.Story;
import io.aera.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        story.setDateModified(LocalDateTime.now());
        return storyDao.updateEntity(story);
    }

    /*@Override
    public void changeImage(Long storyId, Image image) {
        Story story = storyDao.getById(storyId);
        if(story==null){
            throw new StoryNotFoundException(String.format("Story with id $s was not found", storyId));
        }
        story.setBackgroundImage(image);
        storyDao.updateEntity(story);
    }

    @Override
    public void removeImage(Long storyId) {
        Story story = storyDao.getById(storyId);
        if(story==null){
            throw new StoryNotFoundException(String.format("Story with id $s was not found", storyId));
        }
        story.setBackgroundImage(null);
        storyDao.updateEntity(story);
    }*/
}
