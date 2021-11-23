package com.example.ElSchool.controllers;


import com.example.ElSchool.map.UsersMapper;
import com.example.ElSchool.model.Users;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Component
public class UsersCont {

    private UsersMapper usersMapper;

    @Autowired
    public UsersCont(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @ModelAttribute("users")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }


    List<Users> update(String name, String sub_class) {

        Users users = new Users();
        users.setName(name);
        users.setSub_class(sub_class);

        usersMapper.insert(users);

        return usersMapper.findAll();
    }

    List<Users> delete(String name) {

        Users users = new Users();
        users.setName(name);

        usersMapper.delete(users);

        return usersMapper.findAll();

    }
}
