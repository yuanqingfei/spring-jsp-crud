package com.koneu.expert;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aaron on 16-7-2.
 */

@Mapper
public interface ExpertMapper {

    @Select("select * from expert where id = #{id}")
    public Expert get(@Param("id") Long id);

    @Select("select * from expert")
    public List<Expert> getAll();

    @Insert("insert into expert(name, title, department) values(#{name}, #{title}, #{department})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    public void insert(Expert expert);

    @Update("update expert set name=#{expert.name}, title=#{expert.title}, department=#{expert.department} where id=#{id}")
    public Integer update(@Param("id") Long id, @Param("expert") Expert expert);

    @Delete("delete from expert where id=#{id}")
    public void delete(@Param("id") Long id);
}
