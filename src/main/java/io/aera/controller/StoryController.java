package io.aera.controller;

import io.aera.entity.Story;
import io.aera.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/story")
@Controller
public class StoryController {
    @Autowired
    private StoryService storyService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Story addStory(@RequestBody Story story) {
        return storyService.createStory(story);
    }

    @RequestMapping(value = "/get/story/name/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Story story(@PathVariable(value = "id") String id) {
        return storyService.getStoryById(Long.parseLong(id));
    }
}//class
