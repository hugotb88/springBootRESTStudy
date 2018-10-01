package com.studyrest.studyRest.services;

import com.studyrest.studyRest.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author Victor Hugo Olvera Cruz
 */
@FeignClient(name="UserService", url = "http://localhost:8080/studyrest/users")
public interface UserService {

    @RequestMapping("/find/{id}")
    public User findById(@PathVariable (value="id") Long id);

    @RequestMapping("/findAll")
    public Collection<User> findAll();
}
