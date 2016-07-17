package com.koneu.user;

import com.koneu.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by aaron on 16-7-3.
 */
@Mapper
public interface UserMapper {

        @Select("select * from t_user where id = #{id}")
        @Results(value = {
                @Result(property = "lastVisit", column = "LAST_VISIT"),
                @Result(property = "lastIp", column = "LAST_IP")
        })
        public User get(@Param("id") Long id);

        @Select("select * from t_user where name = #{name}")
        @Results(value = {
                @Result(property = "lastVisit", column = "LAST_VISIT"),
                @Result(property = "lastIp", column = "LAST_IP")
        })
        public User getByName(@Param("name") String name);

        @Select("select * from t_user where name like '#{name}%'")
        @Results(value = {
                @Result(property = "lastVisit", column = "LAST_VISIT"),
                @Result(property = "lastIp", column = "LAST_IP")
        })
        public List<User> queryByName(@Param("name") String name);

        @Select("select * from t_user")
        @Results(value = {
                @Result(property = "lastVisit", column = "LAST_VISIT"),
                @Result(property = "lastIp", column = "LAST_IP")
        })
        public List<User> getAll();

        @Insert("insert into t_user(name, password, type, locked, credit, last_visit, last_ip) values(#{name}, #{password}, " +
                "#{type}, #{locked}, #{credit}, #{lastVisit}, #{lastIp})")
        @Options(useGeneratedKeys=true, keyProperty="id")
        public void insert(User user);

        @Update("update t_user set name=#{user.name}, password=#{user.password}, type=#{user.type}, locked=#{user.locked}, " +
                "credit=#{user.credit}, last_visit=#{user.lastVisit}, last_ip=#{user.lastIp} where id=#{id}")
        public Integer update(@Param("id") Long id, @Param("user") User user);

        @Delete("delete from t_user where id=#{id}")
        public void delete(@Param("id") Long id);
}
