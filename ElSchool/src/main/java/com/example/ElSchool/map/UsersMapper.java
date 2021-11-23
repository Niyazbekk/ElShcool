package com.example.ElSchool.map;

import com.example.ElSchool.model.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users")
    List<Users> findAll();

    @Insert("insert into users(name,sub_class) values(#{name},#{sub_class})")
    void insert(Users users);

    @Delete("delete from users where name=#{name}")
    void delete(Users users);
}
