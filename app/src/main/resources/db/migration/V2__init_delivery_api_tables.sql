create table if not exists `rider`
(
    `rider_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '라이더 PK',
    `user_id`      bigint(20) NOT NULL DEFAULT 0 COMMENT '회원 PK',
    `nick`         varchar(50)  NOT NULL DEFAULT '' COMMENT '닉네임',
    `email`        varchar(50)  NOT NULL DEFAULT '' COMMENT '이메일',
    `phone_number` varchar(11)  NOT NULL DEFAULT '' COMMENT '휴대폰 번호',
    `car_number`   varchar(20)  NOT NULL DEFAULT '' COMMENT '차량 번호',
    `car_type`     varchar(50)  NOT NULL DEFAULT '' COMMENT '차종',
    `password`     varchar(100) NOT NULL DEFAULT '' COMMENT '암호',
    `create_dt`    datetime              DEFAULT NULL COMMENT '가입일자',
    `modify_dt`    datetime              DEFAULT NULL COMMENT '수정일자',
    `delete_dt`    datetime              DEFAULT NULL COMMENT '삭제일자',
    `use_yn`       char(1)               DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`rider_id`) USING BTREE,
    UNIQUE KEY `nick` (`nick`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `phone_number` (`phone_number`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

DROP TABLE IF EXISTS `delivery_history`;
create table if not exists `delivery_history`
(
    `history_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '배달내역 PK',
    `rider_id`   bigint(20) NOT NULL DEFAULT 0 COMMENT '라이더 PK',
    `content`    text        NOT NULL COMMENT '배달내역',
    `request`    varchar(50)          DEFAULT NULL COMMENT '요청사항',
    `city`       varchar(50) NOT NULL DEFAULT '' COMMENT '시/군/구',
    `street`     varchar(50) NOT NULL DEFAULT '' COMMENT '동/내/읍',
    `zipcode`    varchar(6)           DEFAULT NULL COMMENT '우편번호',
    `create_at`  datetime             DEFAULT NULL COMMENT '생성일자',
    PRIMARY KEY (`history_id`),
    FOREIGN KEY (`rider_id`) REFERENCES `rider` (rider_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


create table if not exists `rider_alarm`
(
    `alarm_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '라이더 알람 PK',
    `rider_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '라이더 PK',
    `content`   varchar(100) NOT NULL DEFAULT '' COMMENT '알람 내용',
    `url`       varchar(50)  NOT NULL DEFAULT '' COMMENT '알람 URL',
    `create_dt` datetime              DEFAULT NULL COMMENT '알람 생성일자',
    `read_dt`   datetime              DEFAULT NULL COMMENT '알람 확인일자',
    PRIMARY KEY (`alarm_id`),
    FOREIGN KEY (`rider_id`) REFERENCES `rider` (rider_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
