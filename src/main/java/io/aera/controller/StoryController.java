package io.aera.controller;

import io.aera.entity.Story;
import io.aera.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/story")
@Controller
public class StoryController {
    @Autowired
    private StoryService storyService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Story addStory(@RequestBody Story story){
        return storyService.createStory(story);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Story getStoryById(@PathVariable(value = "id") String id ){
        return storyService.getStoryById(Long.parseLong(id));
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getStory(@PathVariable(value = "id") String id){
        Story story = storyService.getStoryById(Long.parseLong(id));
        return new ModelAndView("story-page", "story", story);
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Story> getAllStories(){
        return storyService.getAllStories();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteStory(@PathVariable(value = "id") String id){
        storyService.deleteStory(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Story updateStory(@RequestBody Story story){
        return storyService.updateStory(story);
    }

}
