DROP TABLE IF EXISTS `vendor`;
CREATE TABLE `vendor`
(
    `vendor_id`      bigint      NOT NULL AUTO_INCREMENT COMMENT '판매회원 PK',
    `name`           varchar(50) NOT NULL COMMENT '이름',
    `bank`           varchar(50) NOT NULL COMMENT '은행',
    `account_number` varchar(50) NOT NULL COMMENT '계좌번호',
    `id`             varchar(50) NOT NULL COMMENT '아이디',
    `password`       varchar(50) NOT NULL COMMENT '비밀번호',
    `email`          varchar(50) NOT NULL COMMENT '이메일',
    `phone_number`   varchar(50) NOT NULL COMMENT '휴대번호',
    `create_dt`      datetime    NOT NULL COMMENT '생성일자',
    `modify_dt`      datetime             DEFAULT NULL COMMENT '수정일자',
    `delete_dt`      datetime             DEFAULT NULL COMMENT '탈퇴일자',
    `use_yn`         char(1)     NOT NULL DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`vendor_id`),
    UNIQUE KEY `id` (`id`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='판매회원';
