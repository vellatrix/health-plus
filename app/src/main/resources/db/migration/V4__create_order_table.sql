DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `order_id`    bigint      NOT NULL AUTO_INCREMENT COMMENT '주문 PK',
    `customer_id` bigint      NOT NULL COMMENT '구매회원 PK',
    `ordering_id` varchar(50) NOT NULL,
    `status`      varchar(50) NOT NULL DEFAULT 'N' COMMENT 'Complete : 완료 / Delivering : 배달중 / Cooking : 조리중 / Checking : 접수중',
    `price`       bigint      NOT NULL COMMENT '총 주문 금액',
    `create_dt`   datetime    NOT NULL COMMENT '생성일자',
    PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='주문';
