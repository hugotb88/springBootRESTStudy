package com.studyrest.studyRest.services;

import com.studyrest.studyRest.model.User;
import com.studyrest.studyRest.repository.UserDao;
import com.studyrest.studyRest.repositoryImpl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Victor Hugo Olvera Cruz
 */
@Service
public class UserFeignService {

    @Autowired
    UserDaoImpl userDaoImpl;

    //Methods
    public User getUserByIdWithFeign(Long id){
        System.out.println("An user will be returned consuming another remote REST web Service with FeignClient");
        User result = userDaoImpl.getUserById(id);

        return result;
    }

    public ArrayList<User> getAll(){
        System.out.println("Get all the users");
        ArrayList<User> listResult = userDaoImpl.allUsers();
        return listResult;
    }


    public ArrayList<User> getAllMatchesByFirstName(String firstName){
        System.out.println("Get all the Users that matches with the firstName");
        ArrayList<User> listResult = userDaoImpl.allUsersByFirstName("Victor");
        return listResult;
    }


}
