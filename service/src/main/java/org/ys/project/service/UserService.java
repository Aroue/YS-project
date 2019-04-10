package org.ys.project.service;

import org.ys.project.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    User getUser(Integer id);

    Boolean addUser(User user);

    Boolean updateUser(User user);

    Boolean deleteUser(Integer id);

    User userLogin(String userName,String password);


}
