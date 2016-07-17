package com.koneu.course;

import com.koneu.expert.Expert;
import com.koneu.expert.ExpertMapper;
import com.koneu.order.OrderItem;
import com.koneu.order.OrderItemMapper;
import com.koneu.video.Video;
import com.koneu.video.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aaron on 16-7-16.
 */
@Component
public class CourseService {

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

    @Autowired
    private OrderItemMapper orderItemMapper;

    public List<Course> getAll(){
        return courseMapper.getAll();
    }

    public Course get(String id){
        return courseMapper.get(Long.valueOf(id));
    }

    public Course update(Course c){
        String id = c.getId();
        Assert.notNull(id);
        courseMapper.update(Long.valueOf(id), c);
        return c;
    }

    public void delete(String id){
        courseMapper.delete(Long.valueOf(id));
    }


    public Course insert(Course c){
        courseMapper.insert(c);
        return c;
    }

    public String insertVideo(String id, Video video){
        videoMapper.insert(video);
        String videoId = video.getId();
        Assert.notNull(videoId);
        courseVideoMapper.insert(Long.valueOf(id), Long.valueOf(videoId));
        return videoId;
    }

    public void deleteVideo(String id, String videoId){
        courseVideoMapper.delete(Long.valueOf(id), Long.valueOf(videoId));
    }

    public List<Expert> getExperts(String id){
        Assert.notNull(id);
        List<Expert> experts = new ArrayList<>();
        List<Long> expertIds = courseExpertMapper.getExpertIds(Long.valueOf(id));
        for(Long expertId : expertIds){
            experts.add(expertMapper.get(expertId));
        }
        return experts;
    }

    public List<Video> getVideos(String id){
        Assert.notNull(id);
        List<Video> videos = new ArrayList<>();
        List<Long> videoIds = courseVideoMapper.getVideoIds(Long.valueOf(id));
        for(Long videoId : videoIds){
            videos.add(videoMapper.get(videoId));
        }
        return videos;
    }

    public List<OrderItem> getOrderItems(String id){
        return orderItemMapper.getByCourseId(Long.valueOf(id));
    }

    public void stopSell(String id){
        Course course = get(id);
        course.setSellable(false);
        update(course);
    }
}
