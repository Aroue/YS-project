package org.ys.project.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ys.project.entity.User;

public interface YSUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User userLogin(@Param("userName") String userName, @Param("password") String password);
}