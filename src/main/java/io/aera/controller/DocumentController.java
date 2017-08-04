package io.aera.controller;

import com.google.common.base.Preconditions;
import io.aera.entity.Document;
import io.aera.entity.Story;
import io.aera.service.DocumentService;
import io.aera.service.StoryService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Controller
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @Autowired
    private StoryService storyService;

    @RequestMapping(value = "/doUpload-{storyId}", method = RequestMethod.POST)
    public String handleFileUpload(@PathVariable long storyId, @RequestParam CommonsMultipartFile fileToUpload){
        Story story = storyService.getStoryById(storyId);
        if(story!=null && fileToUpload!=null){
            story.setBackgroundImage(getDocumentInfo(fileToUpload));
            story.setDateModified(LocalDateTime.now());
            storyService.updateStory(story);
        }
        return "redirect:/story/edit-story-".concat(Long.toString(storyId));
    }

    @RequestMapping(value = "/show-document-{storyId}-{documentId}", method = RequestMethod.GET)
    public String getDocumentContent(@PathVariable String documentId, @PathVariable long storyId, HttpServletResponse response) throws IOException {
        Document document = documentService.getDocumentById(documentId);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(document.getContent());
        response.getOutputStream().close();
        return "redirect:/story/edit-story-"+storyId;
    }

    @RequestMapping(value = "/remove-document-{storyId}-{documentId}", method = RequestMethod.GET)
    public String removeDocument(@PathVariable long storyId, @PathVariable String documentId){
        Story story = storyService.getStoryById(storyId);
        Preconditions.checkNotNull(story).setBackgroundImage(null);
        storyService.updateStory(story);
        documentService.removeDocumentById(documentId);
        return "redirect:/story/edit-story-"+storyId;
    }

    private Document getDocumentInfo(CommonsMultipartFile file){
        Document document = new Document();
        document.setName(file.getOriginalFilename());
        document.setDescription("null description");
        document.setExtension(FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase());
        document.setType(file.getContentType());
        document.setContent(file.getBytes());
        return document;
    }
}
