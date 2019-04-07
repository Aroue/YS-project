DROP TABLE IF EXISTS `ys_user`;
CREATE TABLE `ys_user`
(
  `id`                     int(11)      NOT NULL AUTO_INCREMENT,
  `user_name`               varchar(255) NOT NULL COMMENT '用户名.',
  `nick_name`              varchar(20)  NOT NULL COMMENT '昵称.',
  `password`               varchar(20)  NOT NULL COMMENT '密码.',
  `phone`                  varchar(20)  COMMENT '电话.',
  `autograph`              varchar(255) COMMENT '签名.',
  `email`                  varchar(255) COMMENT '电子邮件.',
  `created_at`             timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at`             timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='用户表';

DROP TABLE IF EXISTS `ys_article`;
CREATE TABLE `ys_article`
(
  `id`                     int(11)      NOT NULL AUTO_INCREMENT,
  `user_id`                     int(11)      NOT NULL COMMENT '用户ID',
  `title`                  varchar(255) NOT NULL COMMENT '标题.',
  `content`                MEDIUMTEXT   NOT NULL COMMENT ' 内容.',
  `type_id`                int(11)      COMMENT '文章类型ID.',
  `created_at`             timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at`             timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  KEY `user_id` (`user_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='文章表';


DROP TABLE IF EXISTS `ys_article_type`;
CREATE TABLE `ys_article_type`
(
  `id`                     int(11)      NOT NULL AUTO_INCREMENT,
  `title`                  varchar(255) NOT NULL COMMENT '类型名称.',
  `created_at`             timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at`             timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='文章类型表';


DROP TABLE IF EXISTS `ys_comment`;
CREATE TABLE `ys_comment`
(
  `id`                     int(11)      NOT NULL AUTO_INCREMENT,
  `parent_id`              int(11)      COMMENT '上级评论ID.',
  `article_id`             int(11)      COMMENT '文章ID.',
  `content`                varchar(255) NOT NULL COMMENT '内容.',
  `created_at`             timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at`             timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `article_id` (`article_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='评论表';


# 启动外键约束.
SET FOREIGN_KEY_CHECKS = 1;
