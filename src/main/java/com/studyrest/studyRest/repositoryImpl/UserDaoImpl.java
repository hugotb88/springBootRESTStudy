package com.studyrest.studyRest.repositoryImpl;

import com.studyrest.studyRest.model.User;
import com.studyrest.studyRest.repository.UserDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Victor Hugo Olvera Cruz
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User getUserById(Long id) {
        ArrayList<User> mockListOfUsers = new ArrayList<>();
        mockListOfUsers.add(new User(1L,"Victor Hugo","Olvera Cruz", 30));
        mockListOfUsers.add(new User(2L,"Victor","Rivera", 32));
        mockListOfUsers.add(new User(3L,"Hugo","Hernandez", 31));
        mockListOfUsers.add(new User(4L,"Hugo Enrique","Olvera", 20));
        mockListOfUsers.add(new User(5L,"Fernando","Montes de Oca", 22));
        mockListOfUsers.add(new User(6L,"Dwayne","Johnson", 12));
        mockListOfUsers.add(new User(7L,"Tony","Stark", 18));
        mockListOfUsers.add(new User(8L,"Bruce","Wayne", 35));
        mockListOfUsers.add(new User(9L,"Andrea","Pirlo", 25));
        mockListOfUsers.add(new User(10L,"Alessandro","Del Piero", 28));

        //Convert to Stream
        Stream<User> streamUser = mockListOfUsers.stream();

        //Search of user by id
        Optional<User> result = streamUser.filter(user -> user.getId().equals(id)).findFirst();
        User userResult = result.orElse(null);
        return userResult;
    }

    @Override
    public ArrayList<User> allUsers() {

        ArrayList<User> mockListOfUsers = new ArrayList<>();
        mockListOfUsers.add(new User(1L,"Victor Hugo","Olvera Cruz", 30));
        mockListOfUsers.add(new User(2L,"Victor","Rivera", 32));
        mockListOfUsers.add(new User(3L,"Hugo","Hernandez", 31));
        mockListOfUsers.add(new User(4L,"Hugo Enrique","Olvera", 20));
        mockListOfUsers.add(new User(5L,"Fernando","Montes de Oca", 22));
        mockListOfUsers.add(new User(6L,"Dwayne","Johnson", 12));
        mockListOfUsers.add(new User(7L,"Tony","Stark", 18));
        mockListOfUsers.add(new User(8L,"Bruce","Wayne", 35));
        mockListOfUsers.add(new User(9L,"Andrea","Pirlo", 25));
        mockListOfUsers.add(new User(10L,"Alessandro","Del Piero", 28));

        return mockListOfUsers;
    }

    @Override
    public ArrayList<User> allUsersByFirstName(String firstName) {
        ArrayList<User> mockListOfUsers = new ArrayList<>();
        mockListOfUsers.add(new User(1L,"Victor Hugo","Olvera Cruz", 30));
        mockListOfUsers.add(new User(2L,"Victor","Rivera", 32));
        mockListOfUsers.add(new User(3L,"Hugo","Hernandez", 31));
        mockListOfUsers.add(new User(4L,"Hugo Enrique","Olvera", 20));
        mockListOfUsers.add(new User(5L,"Fernando","Montes de Oca", 22));
        mockListOfUsers.add(new User(6L,"Dwayne","Johnson", 12));
        mockListOfUsers.add(new User(7L,"Tony","Stark", 18));
        mockListOfUsers.add(new User(8L,"Bruce","Wayne", 35));
        mockListOfUsers.add(new User(9L,"Andrea","Pirlo", 25));
        mockListOfUsers.add(new User(10L,"Alessandro","Del Piero", 28));

        //Convert to Stream
        Stream<User> streamUser = mockListOfUsers.stream();

        //Search of user by name
        ArrayList<User> userResult = (ArrayList<User>) streamUser.filter(user -> user.getFirstName().contains(firstName)).collect(Collectors.toList());

        return userResult;

    }
}
