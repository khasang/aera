package io.aera.controller;

import io.aera.entity.Chapter;
import io.aera.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/chapter")
@Controller
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getStory(@PathVariable(value = "id") String id){
        Story story = storyService.getStoryById(Long.parseLong(id));
        return new ModelAndView("story-page", "story", story);
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getChapter(@PathVariable(value = "id") String id){
        Chapter chapter = chapterService.getChapterById(Long.parseLong(id));
        return new ModelAndView("chapter-page", "chapter", chapter);
    }


    @RequestMapping(value = "/add/{storyID}",
            method = RequestMethod.PUT,
            produces = "application/json;charset-utf-8")
    @ResponseBody
    public Chapter addChapter(
            @RequestBody Chapter chapter,
            @PathVariable(value = "storyID") String storyID){
        return chapterService.createChapter(chapter, Long.parseLong(storyID));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Chapter> getAllChapters(){
        return chapterService.getAllChapters();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset-utf-8")
    @ResponseBody
    public Chapter updateChapter(@RequestBody Chapter chapter){
        return chapterService.updateChapter(chapter);
    }

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Chapter getChapterById(@PathVariable(value = "id") String id){
        return chapterService.getChapterById(Long.parseLong(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteChapter(@PathVariable(value = "id") String id){
        chapterService.deleteChapter(Long.parseLong(id));
    }


}
