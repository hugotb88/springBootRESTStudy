package com.studyrest.studyRest.controllers;

import com.studyrest.studyRest.model.User;
import com.studyrest.studyRest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author Victor Hugo Olvera Cruz
 */
@RefreshScope
@RestController
public class UserController {

    @Autowired
    UserService userService;


    //Local REST web Services
    @RequestMapping("/users/feign/{myself}")
    public User findMe(@PathVariable Long myself){
        return userService.findById(myself);
    }

    @RequestMapping("/users/feign/findAll")
    public Collection<User> allUsers(){
        return userService.findAll();
    }



    //Services called by FeignClient
    @RequestMapping("/users/find/{id}")
    @ResponseBody
    public User findById(@PathVariable (value="id") Long id){
        User userResult = new User(1L,"Victor", "Olvera", 29);
        return userResult;
    }
}
