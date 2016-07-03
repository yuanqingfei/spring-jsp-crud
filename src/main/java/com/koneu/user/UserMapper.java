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
        public User get(@Param("id") Long id);

        @Select("select * from t_user where name = #{name}")
        public User getByName(@Param("name") String name);

        @Select("select * from t_user where name like '#{name}%'")
        public List<User> queryByName(@Param("name") String name);

        @Select("select * from t_user")
        public List<User> getAll();

        @Insert("insert into t_user(name, password, type, locked, last_visit, last_ip) values(#{name}, #{password}, #{type}, #{locked}, #{lastVisit}, #{lastIp})")
        @Options(useGeneratedKeys=true, keyProperty="id")
        public void insert(User user);

        @Update("update t_user set name=#{user.name}, password=#{user.password}, type=#{user.type}, locked=#{user.locked}, last_vist=#{user.lastVisit}, last_ip=#{user.lastIp} where id=#{id}")
        public Integer update(@Param("id") Long id, @Param("user") User user);

        @Delete("delete from t_user where id=#{id}")
        public void delete(@Param("id") Long id);
}
