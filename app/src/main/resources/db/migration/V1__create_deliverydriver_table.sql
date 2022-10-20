DROP TABLE IF EXISTS `delivery_driver`;
CREATE TABLE `delivery_driver`
(
    `driver_id`      bigint                                                       NOT NULL AUTO_INCREMENT COMMENT '라이더 PK',
    `vehicle_number` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '차량 번호',
    `delivery_type`  varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '차량 유형',
    `id`             varchar(50)                                                  NOT NULL COMMENT '아이디',
    `password`       varchar(50)                                                  NOT NULL COMMENT '비밀번호',
    `email`          varchar(50)                                                  NOT NULL COMMENT '이메일',
    `phone_number`   varchar(50)                                                  NOT NULL COMMENT '휴대번호',
    `create_dt`      datetime                                                     NOT NULL COMMENT '생성일자',
    `modify_dt`      datetime                                                              DEFAULT NULL COMMENT '수정일자',
    `delete_dt`      datetime                                                              DEFAULT NULL COMMENT '탈퇴일자',
    `use_yn`         char(1)                                                      NOT NULL DEFAULT 'Y' COMMENT '사용 여부',
    `name`           varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '이름',
    `location`       varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '위치정보',
    PRIMARY KEY (`driver_id`),
    UNIQUE KEY `id` (`id`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `phone_number` (`phone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='라이더';
