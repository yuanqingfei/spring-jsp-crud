package com.koneu.video;

import com.koneu.video.Video;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aaron on 16-7-16.
 */
@Mapper
public interface VideoMapper {

    @Select("select * from t_video where id = #{id}")
    public Video get(@Param("id") Long id);

    @Select("select * from t_video")
    public List<Video> getAll();

    @Insert("insert into t_video(name, description, size, length, path) values(#{name}, #{description}, #{size}, #{length}, #{path})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    public void insert(Video video);

    @Update("update t_video set name=#{video.name}, description=#{video.description}, size=#{video.size}, length=#{video.length}, " +
            "path=#{video.path} where id=#{id}")
    public Integer update(@Param("id") Long id, @Param("video") Video video);

    @Delete("delete from t_video where id=#{id}")
    public void delete(@Param("id") Long id);
}
