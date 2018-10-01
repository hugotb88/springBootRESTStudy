package com.studyrest.studyRest.controllers;


import com.studyrest.studyRest.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HelloController {

    @RequestMapping(path = "/testGet", method = RequestMethod.GET)
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(path = "/testPost", method = RequestMethod.POST)
    @ResponseBody //The @ResponseBody annotation tells a controller that the object returned is automatically serialized into JSON and passed back into the HttpResponse object.
    public User testPost() {
        return new User(1L,"Hugo","Olvera",30);
    }


    @RequestMapping(path = "/testPut", method = RequestMethod.PUT)
    public String testPut() {
        return "This is a PUT Test";
    }

    @RequestMapping(path = "/testDelete", method = RequestMethod.DELETE)
    public String testDelete() {
        return new String("This is a DELETE Test");
    }

}