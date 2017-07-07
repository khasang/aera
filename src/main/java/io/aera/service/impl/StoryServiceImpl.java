/*
package io.aera.service.impl;

import io.aera.dao.StoryDao;
import io.aera.entity.Story;
import io.aera.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("userService")
public class StoryServiceImpl implements StoryService {
    @Autowired
    private StoryDao storyDao;

    @Override
    public Story createStory(Story story) {
        return storyDao.create(story);
    }

    @Override
    public List<Story> getStoryList() {
        return storyDao.getList();
    }

    @Override
    public Story getStoryById(long storyId) {
        return storyDao.getById(storyId);
    }
}
*/
