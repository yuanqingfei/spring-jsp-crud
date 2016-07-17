package com.koneu.course;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aaron on 16-7-16.
 */
@Mapper
public interface CourseExpertMapper {

    @Select("select course_id from t_expert_course where expert_id = #{expertId}")
    public List<Long> getCourseIds(@Param("expertId") Long expertId);

    @Select("select expert_id from t_expert_course where course_id = #{courseId}")
    public List<Long> getExpertIds(@Param("courseId") Long courseId);

    @Insert("insert into t_expert_course(expert_id, course_id) values(#{expertId}, #{courseId})")
    public void insert(@Param("courseId")Long courseId, @Param("expertId")Long expertId);

    @Update("update t_expert_course set expert_id=#{newExpertId} where course_id=#{courseId} and expert_id=#{expertId}")
    public Integer updateExpert(@Param("courseId")Long courseId, @Param("expertId")Long expertId, @Param("newExpertId")Long newExpertId);

    @Update("update t_expert_course set course_id=#{newCourseId} where course_id=#{courseId} and expert_id=#{expertId}")
    public Integer updateCourse(@Param("courseId")Long courseId, @Param("expertId")Long expertId, @Param("newExpertId")Long newCourseId);

    @Delete("delete from t_expert_course where course_id=#{courseId} and expert_id=#{expertId}")
    public void delete(@Param("courseId")Long courseId, @Param("expertId")Long expertId);
}
