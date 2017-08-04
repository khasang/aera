package io.aera.controller;

import com.google.common.base.Preconditions;
import io.aera.entity.Chapter;
import io.aera.entity.Story;
import io.aera.service.ChapterService;
import io.aera.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/chapter")
@Controller
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @Autowired
    private StoryService storyService;

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

    @RequestMapping(value = "/remove/{storyId}-{chapterId}")
    public String removeChapterFromStory(@PathVariable long storyId, @PathVariable long chapterId){
        Story story = Preconditions.checkNotNull(storyService.getStoryById(storyId));
        Chapter del_chapter = Preconditions.checkNotNull(chapterService.getChapterById(chapterId));
        story.getChapters().remove(del_chapter);
        storyService.updateStory(story);
        return "redirect:/story/edit-story-"+storyId;
    }

    @RequestMapping(value = "edit-chapter-{chapterId}", method = RequestMethod.GET)
    public String editChapter(@PathVariable long chapterId, ModelMap modelMap){
        Chapter chapter = Preconditions.checkNotNull(chapterService.getChapterById(chapterId));
        modelMap.addAttribute("chapter", chapter);
        modelMap.addAttribute("edit", true);
        return "chapter-page-edit";
    }

    @RequestMapping(value = "edit-chapter-{chapterId}", method = RequestMethod.POST)
    public String updateChapter(@Valid Chapter chapter, BindingResult result, @PathVariable long chapterId){
        if(result.hasErrors()){
            return "chapter-page";
        }
        Preconditions.checkNotNull(chapter);
        Chapter chapter_upd = chapterService.getChapterById(chapter.getId());
        chapter_upd.setName(chapter.getName());
        chapter_upd.setGoldPrice(chapter.getGoldPrice());
        chapter_upd.setDateModified(LocalDateTime.now());
        chapterService.updateChapter(chapter_upd);
        return "redirect:/chapter/"+chapter.getId();
    }

    /*@RequestMapping(value = "/edit-story-{storyId}", method = RequestMethod.GET)
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
    }*/


}
