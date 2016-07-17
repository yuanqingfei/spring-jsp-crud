package com.koneu.test;

import com.koneu.WebApplication;
import com.koneu.course.Course;
import com.koneu.course.CourseExpertMapper;
import com.koneu.course.CourseService;
import com.koneu.expert.Expert;
import com.koneu.expert.ExpertService;
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
public class ExpertServiceTest {

    @Autowired
    ExpertService expertService;

    @Autowired
    CourseService courseService;

    Expert expert;

    Course course;

    String id;

    String courseId;

    @Before
    public void setUp(){
        expert = new Expert();
        expert.setName("testName");
        expert.setGender("testGender");
        expert.setTitle("testTitle");

        course = new Course();
        course.setName("testName");
        course.setStartDate(new Date());
        course.setPrice(10.23);
        course.setSellable(true);
    }

    @After
    public void shutDown(){
        if(id != null){
            expertService.delete(id);
        }
        if(courseId != null){
            courseService.delete(courseId);
        }
    }

    @Test
    public void testCrud(){
        Assert.assertNotNull(expertService);
        expert = expertService.insert(expert);

        id = expert.getId();
        Assert.assertNotNull(id);
        System.out.println("id: " + id);

        List<Expert> experts = expertService.getAll();
        Assert.assertTrue(experts.size() > 0);

        expert.setIntroduction("introduction");
        expertService.update(expert);
        expert = expertService.get(id);
        Assert.assertTrue("introduction".equals(expert.getIntroduction()));
    }

    @Test
    public void testExpertCourses(){
        Assert.assertNotNull(expertService);
        expert = expertService.insert(expert);

        id = expert.getId();
        Assert.assertNotNull(id);
        System.out.println("id: " + id);

        courseId = expertService.insertCourse(id, course);
        Assert.assertNotNull(courseId);
        System.out.println("courseId: " + courseId);
        List<Course> courseList = expertService.getCourses(id);;
        Assert.assertTrue(courseList.size() > 0);
        Assert.assertTrue(courseList.get(0).getId().equals(courseId));

        expertService.deleteCourse(id, courseId);
    }

}
