package com.koneu.course;

import com.koneu.course.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aaron on 16-7-16.
 */
@Mapper
public interface CourseMapper {

    @Select("select * from t_course where id = #{id}")
    @Results(value = {
            @Result(property = "startDate", column = "START_DATE"),
            @Result(property = "endDate", column = "END_DATE")
    })
//    @ResultMap("com.koneu.course.CourseMapper.CourseResult")
    public Course get(@Param("id") Long id);

    @Select("select * from t_course")
    @Results(value = {
            @Result(property = "startDate", column = "START_DATE"),
            @Result(property = "endDate", column = "END_DATE")
    })
//    @ResultMap("com.koneu.course.CourseMapper.CourseResult")
    public List<Course> getAll();

    @Insert("insert into t_course(name, description, price, start_date, end_date, location, sellable) values(#{name}, #{description}, " +
            "#{price}, #{startDate}, #{endDate}, #{location}, #{sellable})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    public void insert(Course course);

    @Update("update t_course set name=#{course.name}, description=#{course.description}, price=#{course.price}, start_date=#{course.startDate}, " +
            "end_date=#{course.endDate}, location=#{course.location}, sellable=#{course.sellable} where id=#{id}")
    public Integer update(@Param("id") Long id, @Param("course") Course course);

    @Delete("delete from t_course where id=#{id}")
    public void delete(@Param("id") Long id);
    
}
