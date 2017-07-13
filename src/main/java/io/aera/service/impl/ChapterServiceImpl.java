package io.aera.service.impl;

import io.aera.dao.ChapterDao;
import io.aera.dao.StoryDao;
import io.aera.dao.impl.EntityNotFoundRuntimeException;
import io.aera.entity.Chapter;
import io.aera.entity.Story;
import io.aera.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    ChapterDao chapterDao;

    @Autowired
    StoryDao storyDao;

    @Override
    public Chapter createChapter(Chapter chapter) {
        return chapterDao.create(chapter);
    }

    @Override
    public Chapter createChapter(Chapter chapter, long storyID) {
        Story foundStory = storyDao.getById(storyID);
        if(foundStory==null){
            throw new EntityNotFoundRuntimeException(
                    Story.class.getName(), Long.toString(storyID));
        }
        return chapterDao.create(chapter);
    }

    @Override
    public Chapter getChapterById(long chapterID) {
        return chapterDao.getById(chapterID);
    }

    @Override
    public void deleteChapter(long chapterID) {
        chapterDao.deleteById(chapterID);
    }

    @Override
    public List<Chapter> getAllChapters() {
        return chapterDao.getAllEnities();
    }

    @Override
    public Chapter updateChapter(Chapter chapter) {
        chapter.setDateModified(LocalDateTime.now());
        return chapterDao.updateEntity(chapter);
    }
}
