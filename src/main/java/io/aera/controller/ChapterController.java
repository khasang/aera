package io.aera.controller;

import io.aera.entity.Chapter;
import io.aera.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/chapter")
@Controller
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

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
}
