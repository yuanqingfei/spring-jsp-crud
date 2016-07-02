package com.koneu.expert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by aaron on 16-7-2.
 */
@Component
public class ExpertService {

    @Autowired
    private ExpertMapper expertMapper;

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

}
