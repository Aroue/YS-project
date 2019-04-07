package org.ys.project.service.impl;

import org.ys.project.dao.mapper.YSUserMapper;
import org.ys.project.entity.User;
import org.ys.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserServiceImpl implements UserService {
    private final YSUserMapper ysUserMapper;

    @Autowired
    public UserServiceImpl(YSUserMapper ysUserMapper){
        this.ysUserMapper = ysUserMapper;
    }

    @Override
    public List<User> getAll() {
        return this.ysUserMapper.selectAll();
    }

    @Override
    public User get(Integer id) {
        return this.ysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean create(User user) {
        return this.ysUserMapper.insert(user) > 0;
    }

    @Override
    public Boolean edit(User user) {
        return this.ysUserMapper.updateByPrimaryKey(user) > 0;
    }

    @Override
    public Boolean delete(User user) {
        return this.ysUserMapper.deleteByPrimaryKey(user.getId()) > 0;
    }
}
