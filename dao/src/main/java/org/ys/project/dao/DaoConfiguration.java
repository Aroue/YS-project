package org.ys.project.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 配置注解
@PropertySource(value = "classpath:application.properties")
@MapperScan("org.ys.project.dao.mapper")
public class DaoConfiguration {
}
