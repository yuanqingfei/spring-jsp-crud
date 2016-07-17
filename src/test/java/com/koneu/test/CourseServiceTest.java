package com.koneu.test;

import com.koneu.WebApplication;
import com.koneu.course.Course;
import com.koneu.course.CourseService;
import com.koneu.video.Video;
import com.koneu.video.VideoService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by aaron on 16-7-17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(WebApplication.class)
public class CourseServiceTest {

    @Autowired
    CourseService courseService;

    @Autowired
    VideoService videoService;

    Video video;

    Course course;

    String id;

    String orderId;

    @Before
    public void setUp(){
        course = new Course();
        course.setName("testName");
        course.setStartDate(new Date());
        course.setPrice(10.23);
        course.setSellable(true);

        video = new Video();
        video.setName("testVideoName");
        video.setLength(12.5);
        video.setPath("c:/xxx");
        video.setSize(12321L);
    }

    @After
    public void shutDown(){
        if(id != null){
            courseService.delete(id);
        }
        if(orderId != null){
            videoService.delete(orderId);
        }
    }

    @Test
    public void testCrud(){
        Assert.assertNotNull(courseService);
        course = courseService.insert(course);

        id = course.getId();
        Assert.assertNotNull(id);
        System.out.println("id: " + id);

        List<Course> courses = courseService.getAll();
        Assert.assertTrue(courses.size() > 0);
        id = courses.get(0).getId();

        course.setDescription("description");
        courseService.update(course);
        course = courseService.get(id);
        System.out.println(course.getStartDate() + " " + course.getEndDate() + "  " + course.getName());
        Assert.assertNotNull(course.getStartDate());
        Assert.assertTrue("description".equals(course.getDescription()));
    }

    @Test
    public void testVideoCourses(){
        Assert.assertNotNull(courseService);
        course = courseService.insert(course);

        id = course.getId();
        Assert.assertNotNull(id);
        System.out.println("id: " + id);

        orderId = courseService.insertVideo(id, video);
        Assert.assertNotNull(orderId);
        List<Video> videoList = courseService.getVideos(id);
        Assert.assertTrue(videoList.size() > 0);
        Assert.assertTrue(videoList.get(0).getId().equals(orderId));

        courseService.deleteVideo(id, orderId);
    }

    @Test
    public void testStopSell(){
        Assert.assertNotNull(courseService);
        course = courseService.insert(course);

        id = course.getId();
        Assert.assertNotNull(id);
        System.out.println("id: " + id);

        courseService.stopSell(id);

        course = courseService.get(id);
        Assert.assertFalse(course.getSellable());
    }



}
