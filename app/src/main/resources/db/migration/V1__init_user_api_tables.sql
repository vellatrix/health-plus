create table if not exists `user`
(
    `user_id`      bigint(20) NOT NULL AUTO_INCREMENT COMMENT '회원 PK',
    `password`     varchar(100) NOT NULL DEFAULT '' COMMENT '암호',
    `nick`         varchar(50)  NOT NULL DEFAULT '' COMMENT '닉네임',
    `email`        varchar(50)  NOT NULL DEFAULT '' COMMENT '이메일',
    `phone_number` varchar(11)  NOT NULL DEFAULT '' COMMENT '휴대폰 번호',
    `role`        varchar(20)                DEFAULT NULL COMMENT '회원역할',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
