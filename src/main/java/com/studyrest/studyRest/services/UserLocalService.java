package com.studyrest.studyRest.services;

import com.studyrest.studyRest.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author Victor Hugo Olvera Cruz
 */
@FeignClient(name="UserService", url = "${feign.user}")
public interface UserLocalService {

    //Find by id
    @RequestMapping(value = "/feign/find/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable (value="id") Long id);

    //Find all
    @RequestMapping(value = "/feign/findAll", method = RequestMethod.GET)
    public Collection<User> findAll();


    //Find All by FirstName
    @RequestMapping(value = "/feign/findAllMatchesByFirstName/{firstName}", method = RequestMethod.GET)
    public Collection<User> findAllMatchesByFirstName(@PathVariable(value = "firstName") String firstName);
}
