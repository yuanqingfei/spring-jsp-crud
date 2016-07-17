package com.koneu.course;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aaron on 16-7-17.
 */
@Mapper
public interface CourseVideoMapper {

    @Select("select course_id from t_video_course where video_id = #{videoId}")
    public List<Long> getCourseIds(@Param("videoId") Long videoId);

    @Select("select video_id from t_video_course where course_id = #{courseId}")
    public List<Long> getVideoIds(@Param("courseId") Long courseId);

    @Insert("insert into t_video_course(video_id, course_id) values(#{videoId}, #{courseId})")
    public void insert(@Param("courseId")Long courseId, @Param("videoId")Long videoId);

    @Update("update t_video_course set video_id=#{newVideoId} where course_id=#{courseId} and video_id=#{videoId}")
    public Integer updateVideo(@Param("courseId")Long courseId, @Param("videoId")Long videoId, @Param("newVideoId")Long newVideoId);

    @Update("update t_video_course set course_id=#{newCourseId} where course_id=#{courseId} and video_id=#{videoId}")
    public Integer updateCourse(@Param("courseId")Long courseId, @Param("videoId")Long videoId, @Param("newVideoId")Long newCourseId);

    @Delete("delete from t_video_course where course_id=#{courseId} and video_id=#{videoId}")
    public void delete(@Param("courseId")Long courseId, @Param("videoId")Long videoId);
}
