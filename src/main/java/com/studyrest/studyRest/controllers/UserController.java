package com.studyrest.studyRest.controllers;

import com.studyrest.studyRest.model.User;
import com.studyrest.studyRest.services.UserLocalService;
import com.studyrest.studyRest.services.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * @author Victor Hugo Olvera Cruz
 */
@RefreshScope
@RestController
public class UserController {

    @Autowired
    UserLocalService userLocalService;

    @Autowired
    UserFeignService userFeignService;


    //Local REST web Services
    @RequestMapping("/users/local/{myself}")
    public User findMe(@PathVariable Long myself){

        return userLocalService.findById(myself);
    }

    @RequestMapping("/users/local/findAll")
    public Collection<User> allUsers(){
        return userLocalService.findAll();
    }

    @RequestMapping("/users/local/findAllMatchesByFirstName/{firstName}")
    public Collection<User> allMatchesByFirstName(@PathVariable(value = "firstName") String firstName){
        return userLocalService.findAllMatchesByFirstName(firstName);
    }


    //******************************************************************************************************//

    //Services called by FeignClient
    @RequestMapping("/users/feign/find/{id}")
    @ResponseBody
    public User findById(@PathVariable (value="id") Long id){
        User userResult = userFeignService.getUserByIdWithFeign(id);
        return userResult;
    }

    @RequestMapping("/users/feign/findAll")
    @ResponseBody
    public ArrayList<User> findAll(){
        ArrayList<User> listUserResult = userFeignService.getAll();
        return listUserResult;
    }

    @RequestMapping("/users/feign/findAllMatchesByFirstName/{firstName}")
    @ResponseBody
    public ArrayList<User> findAllMatchesByFirstName(@PathVariable (value="firstName") String firstName){
        ArrayList<User> listUserResult = userFeignService.getAllMatchesByFirstName(firstName);
        return listUserResult;
    }

}
