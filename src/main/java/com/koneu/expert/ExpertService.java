package com.koneu.expert;

import com.koneu.course.Course;
import com.koneu.course.CourseExpertMapper;
import com.koneu.course.CourseMapper;
import com.koneu.course.CourseVideoMapper;
import com.koneu.video.Video;
import com.koneu.video.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aaron on 16-7-2.
 */
@Component
public class ExpertService {

    @Autowired
    private ExpertMapper expertMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private CourseExpertMapper courseExpertMapper;

    @Autowired
    private CourseVideoMapper courseVideoMapper;

    public List<Expert> getAll(){
        return expertMapper.getAll();
    }

    public Expert get(String id){
        return expertMapper.get(Long.valueOf(id));
    }

    public Expert update(Expert expert){
        String id = expert.getId();
        Assert.notNull(id);
        expertMapper.update(Long.valueOf(id), expert);
        return expert;
    }

    public void delete(String id){
        expertMapper.delete(Long.valueOf(id));
    }

    public Expert insert(Expert expert){
        expertMapper.insert(expert);
        return expert;
    }

    public String insertCourse(String id, Course course){
        courseMapper.insert(course);
        String courseId = course.getId();
        Assert.notNull(courseId);
        courseExpertMapper.insert(Long.valueOf(courseId), Long.valueOf(id));
        return courseId;
    }

    public void deleteCourse(String id, String courseId){
        courseExpertMapper.delete(Long.valueOf(courseId), Long.valueOf(id));
    }

    public List<Course> getCourses(String id){
        Assert.notNull(id);
        List<Course> courses = new ArrayList<>();
        List<Long> courseIds = courseExpertMapper.getCourseIds(Long.valueOf(id));
        for(Long courseId : courseIds){
            courses.add(courseMapper.get(courseId));
        }
        return courses;
    }

    public List<Video> getVideos(String id){
        Assert.notNull(id);
        List<Video> videos = new ArrayList<>();
        List<Long> courseIds = courseExpertMapper.getCourseIds(Long.valueOf(id));
        Set<Long> videoIds = new HashSet<>();
        for(Long courseId : courseIds){
            List<Long> innerVideoIds = courseVideoMapper.getVideoIds(courseId);
            videoIds.addAll(innerVideoIds);
        }
        for(Long videoId : videoIds){
            videos.add(videoMapper.get(videoId));
        }
        return videos;
    }

}
