package com.studyrest.studyRest.repository;

import com.studyrest.studyRest.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Victor Hugo Olvera Cruz
 */
@Repository
public interface UserDao {


    //To get an user by his id
    public User getUserById(Long id);


    //To get all the users
    public ArrayList<User> allUsers();


    //To get all the users with the same first name
    public ArrayList<User> allUsersByFirstName(String firstName);

}
