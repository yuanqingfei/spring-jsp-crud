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
public class VideoServiceTest {

//    @Autowired
//    CourseService courseService;

    @Autowired
    VideoService videoService;

    Video video;

//    Course course;

    String id;

    String videoId;

    @Before
    public void setUp(){
//        course = new Course();
//        course.setName("testName");
//        course.setStartDate(new Date());
//        course.setPrice(10.23);
//        course.setSellable(true);

        video = new Video();
        video.setName("testVideoName");
        video.setLength(12.5);
        video.setPath("c:/xxx");
        video.setSize(12321L);
    }

    @After
    public void shutDown(){
        if(id != null){
            videoService.delete(id);
        }
//        if(orderId != null){
//            videoService.delete(orderId);
//        }
    }

    @Test
    public void testCrud(){
        Assert.assertNotNull(videoService);
        video = videoService.insert(video);

        id = video.getId();
        Assert.assertNotNull(id);
        System.out.println("id: " + id);

        List<Video> videos = videoService.getAll();
        Assert.assertTrue(videos.size() > 0);

        video.setDescription("description");
        videoService.update(video);
        video = videoService.get(id);
        Assert.assertTrue("description".equals(video.getDescription()));
    }
//
//    @Test
//    public void testVideoCourses(){
//        Assert.assertNotNull(courseService);
//        course = courseService.insert(course);
//
//        id = course.getId();
//        Assert.assertNotNull(id);
//        System.out.println("id: " + id);
//
//        orderId = courseService.insertVideo(id, video);
//        Assert.assertNotNull(orderId);
//        System.out.println("orderId: " + orderId);
//        List<Video> videoList = courseService.getVideos(id);
//        Assert.assertTrue(videoList.size() > 0);
//        Assert.assertTrue(videoList.get(0).getId().equals(orderId));
//
//        courseService.deleteVideo(id, orderId);
//    }
}
