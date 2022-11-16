create table if not exists `customer`
(
    `customer_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '구매자 PK',
    `user_id`      bigint(20) NOT NULL DEFAULT 0 COMMENT '회원 PK',
    `nick`         varchar(50)  NOT NULL DEFAULT '' COMMENT '닉네임',
    `email`        varchar(50)  NOT NULL DEFAULT '' COMMENT '이메일',
    `phone_number` varchar(11)  NOT NULL DEFAULT '' COMMENT '휴대폰 번호',
    `password`     varchar(100) NOT NULL DEFAULT '' COMMENT '암호',
    `create_dt`    datetime              DEFAULT NULL COMMENT '가입일',
    `modify_dt`    datetime              DEFAULT NULL COMMENT '수정일자',
    `delete_dt`    datetime              DEFAULT NULL COMMENT '삭제일자',
    `use_yn`       char(1)               DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`customer_id`),
    UNIQUE KEY `nick` (`nick`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `phone_number` (`phone_number`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


create table if not exists `address`
(
    `address_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주소 PK',
    `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
    `city`        varchar(50) NOT NULL DEFAULT '' COMMENT '시/군/구',
    `street`      varchar(50) NOT NULL DEFAULT '' COMMENT '동/내/읍',
    `zip_code`    varchar(6)           DEFAULT NULL COMMENT '우편번호',
    `basic_yn`    char(1)              DEFAULT 'N' COMMENT '기본 주소 여부',
    PRIMARY KEY (`address_id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customer` (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

create table if not exists `customer_alarm`
(
    `alarm_id`    bigint(20) NOT NULL AUTO_INCREMENT COMMENT '구매자 알람 PK',
    `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
    `content`     varchar(100) NOT NULL DEFAULT '' COMMENT '알람 내용',
    `url`         varchar(50)           DEFAULT NULL COMMENT '알람 URL',
    `create_dt`   datetime              DEFAULT NULL COMMENT '알람 생성일자',
    `read_dt`     datetime              DEFAULT NULL COMMENT '알람 확인일자',
    PRIMARY KEY (`alarm_id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customer` (customer_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
