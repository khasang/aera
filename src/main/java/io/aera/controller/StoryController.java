package io.aera.controller;

import com.google.common.base.Preconditions;
import io.aera.entity.Story;
import io.aera.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/story")
@Controller
public class StoryController {
    @Autowired
    private StoryService storyService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.CREATED)
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
    public String getStory(@PathVariable(value = "id") String id, ModelMap modelMap){

        Story story = Preconditions.checkNotNull(storyService.getStoryById(Long.parseLong(id)));
        modelMap.addAttribute("story", story);
        return "story-page";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Story> getAllStories(){
        return storyService.getAllStories();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteStory(@PathVariable(value = "id") String id){
        storyService.deleteStory(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Story updateStory(@RequestBody Story story){
        Preconditions.checkNotNull(story);
        return storyService.updateStory(story);
    }

    @RequestMapping(value = "/edit-story-{storyId}", method = RequestMethod.GET)
    public String editStory(@PathVariable long storyId, ModelMap modelMap){
        Story story = storyService.getStoryById(storyId);
        modelMap.addAttribute("story", story);
        modelMap.addAttribute("edit", true);
        return "story-page-edit";
    }

    @RequestMapping(value = "/edit-story-{storyId}", method = RequestMethod.POST)
    public String updateStory(@Valid Story story, BindingResult result, @PathVariable long storyId){
        if (result.hasErrors()){
            return "story-page";
        }
        Preconditions.checkNotNull(story);
        Story story_upd = storyService.getStoryById(story.getId());
        story_upd.setName(story.getName());
        story_upd.setDescription(story.getDescription());
        story_upd.setDateModified(LocalDateTime.now());
        storyService.updateStory(story_upd);
        return "redirect:/story/"+story.getId();
    }
}
