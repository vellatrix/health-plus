create table if not exists `refresh_token`
(
    `token_id`   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '토큰 PK',
    `user_id`    bigint(20) NOT NULL COMMENT '회원 PK',
    `token`      varchar(50) NOT NULL DEFAULT '' COMMENT '토큰',
    `expired_dt` datetime             DEFAULT NULL COMMENT '토큰 만기일자',
    PRIMARY KEY (`token_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
