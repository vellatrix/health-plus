DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `user_id`      bigint      NOT NULL AUTO_INCREMENT COMMENT '회원가입 PK',
    `id`           varchar(50) NOT NULL COMMENT '아이디',
    `name`         varchar(50) NOT NULL COMMENT '이름',
    `email`        varchar(50) NOT NULL COMMENT '이메일',
    `password`     varchar(50) NOT NULL COMMENT '비밀번호',
    `phone_number` varchar(50) NOT NULL COMMENT '휴대번호',
    `create_dt`    datetime    NOT NULL COMMENT '생성일자',
    `modify_dt`    datetime DEFAULT NULL COMMENT '수정일자',
    `delete_dt`    datetime DEFAULT NULL COMMENT '탈퇴일자',
    `roles`        JSON DEFAULT NULL COMMENT '회원역할',
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `id` (`id`),
    UNIQUE KEY `password` (`password`),
    UNIQUE KEY `name` (`name`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='회원가입';
