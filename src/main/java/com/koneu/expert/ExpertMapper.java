package com.koneu.expert;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aaron on 16-7-2.
 */

@Mapper
public interface ExpertMapper {

    @Select("select * from t_expert where id = #{id}")
    public Expert get(@Param("id") Long id);

    @Select("select * from t_expert where name = #{name}")
    public Expert getByName(@Param("name") String name);

    @Select("select * from t_expert")
    public List<Expert> getAll();

    @Insert("insert into t_expert(name, gender, title, hospital, department, speciality, introduction, photo) values(#{name}, " +
            "#{gender}, #{title}, #{hospital}, #{department}, #{speciality}, #{introduction}, #{photo})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    public void insert(Expert expert);

    @Update("update t_expert set name=#{expert.name}, gender=#{expert.gender}, title=#{expert.title}, hospital=#{expert.hospital}, " +
            "department=#{expert.department}, speciality=#{expert.speciality}, introduction=#{expert.introduction}, photo=#{expert.photo} where id=#{id}")
    public Integer update(@Param("id") Long id, @Param("expert") Expert expert);

    @Delete("delete from t_expert where id=#{id}")
    public void delete(@Param("id") Long id);
}
