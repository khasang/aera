package io.aera.controller;

import io.aera.entity.Story;
import io.aera.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/story")
public class StoryController {
    @Autowired
    private StoryService storyService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Story> getStoryList() {
        return storyService.getStoryList();
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Story addStory(@RequestBody Story story) {
        return storyService.createStory(story);
    }

    @RequestMapping(value = "/get/story/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Story getStory(@PathVariable(value = "id") String id) {
        return storyService.getStoryById(Long.parseLong(id));
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Story updateStory(@PathVariable(value = "id") String id, @RequestBody Story story) {
        story.setId(Long.parseLong(id));
        return storyService.updateStory(story);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    @ResponseBody
    public void deleteStory(@PathVariable(value = "id") String id) {
        storyService.deleteStoryById(Long.parseLong(id));
    }
}
