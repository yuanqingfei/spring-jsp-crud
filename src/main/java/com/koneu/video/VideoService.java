package com.koneu.video;

import com.koneu.expert.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by aaron on 16-7-17.
 */
@Component
public class VideoService {

    @Autowired
    private VideoMapper videoMapper;

    public List<Video> getAll(){
        return videoMapper.getAll();
    }

    public Video get(String id){
        return videoMapper.get(Long.valueOf(id));
    }

    public Video update(Video video){
        String id = video.getId();
        Assert.notNull(id);
        videoMapper.update(Long.valueOf(id), video);
        return video;
    }

    public void delete(String id){
        videoMapper.delete(Long.valueOf(id));
    }

    public Video insert(Video video){
        videoMapper.insert(video);
        return video;
    }
}
