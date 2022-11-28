DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery`
(
    `delivery_id` bigint      NOT NULL AUTO_INCREMENT COMMENT '배달 PK',
    `order_id`    bigint      NOT NULL COMMENT '주문 PK',
    `driver_id`   bigint      NOT NULL COMMENT '라이더 PK',
    `city`        varchar(50) NOT NULL COMMENT '시/군/구',
    `street`      varchar(50) NOT NULL COMMENT '동/내/읍',
    `zipcode`     varchar(6) DEFAULT NULL COMMENT '우편번호',
    PRIMARY KEY (`delivery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='배달';
