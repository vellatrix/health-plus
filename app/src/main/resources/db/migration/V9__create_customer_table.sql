DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`
(
    `customer_id`  bigint       NOT NULL AUTO_INCREMENT COMMENT '구매회원 PK',
    `id`           varchar(50)  NOT NULL COMMENT '아이디',
    `password`     varchar(100) NOT NULL COMMENT '비밀번호',
    `nick`         varchar(30)  NOT NULL COMMENT '닉네임',
    `email`        varchar(30)  NOT NULL COMMENT '이메일',
    `phone_number` varchar(12)  NOT NULL COMMENT '휴대번호',
    `create_dt`    datetime     NOT NULL COMMENT '생성일자',
    `modify_dt`    datetime              DEFAULT NULL COMMENT '수정일자',
    `delete_dt`    datetime              DEFAULT NULL COMMENT '탈퇴일자',
    `use_yn`       char(1)      NOT NULL DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`customer_id`),
    UNIQUE KEY `id` (`id`),
    UNIQUE KEY `nick` (`nick`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='구매회원';
