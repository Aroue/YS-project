package org.ys.project.service;

import org.ys.project.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    User get(Integer id);
    Boolean create(User user);
    Boolean edit(User user);
    Boolean delete(User user);
}
