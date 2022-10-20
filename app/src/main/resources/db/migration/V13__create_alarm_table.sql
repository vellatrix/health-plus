DROP TABLE IF EXISTS `alarm`;
CREATE TABLE `alarm`
(
    `alarm_id`    bigint NOT NULL AUTO_INCREMENT COMMENT '알람 PK',
    `customer_id` bigint NOT NULL COMMENT '구매회원 PK',
    `content`     varchar(50) DEFAULT NULL COMMENT '추가 내용',
    `create_dt`   datetime    DEFAULT NULL COMMENT '생성일자',
    PRIMARY KEY (`alarm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='알림';
