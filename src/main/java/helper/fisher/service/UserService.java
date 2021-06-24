package helper.fisher.service;

import helper.fisher.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByUserName(String name);


    void registerUser(User user);

    void saveUser(User user);
}
