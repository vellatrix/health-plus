DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`
(
    `pay_id`      bigint      NOT NULL AUTO_INCREMENT COMMENT '결제내역 PK',
    `customer_id` bigint      NOT NULL COMMENT '구매회원 PK',
    `order_id`    bigint      NOT NULL COMMENT '주문 PK',
    `pg`          varchar(50) NOT NULL COMMENT 'PG사',
    `content`     varchar(50) NOT NULL COMMENT '기타사항',
    `method`      varchar(50) NOT NULL COMMENT '주문 방식',
    `amount`      bigint      NOT NULL COMMENT '결제금액',
    `create_dt`   datetime    NOT NULL COMMENT '생성일자',
    `modify_dt`   datetime DEFAULT NULL COMMENT '수정일자',
    PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='결제내역';
