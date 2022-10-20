DROP TABLE IF EXISTS `order_option`;
CREATE TABLE `order_option`
(
    `order_option_id`       bigint      NOT NULL AUTO_INCREMENT COMMENT '주문 옵션 PK',
    `order_option_group_id` bigint      NOT NULL COMMENT '주문 옵션 그룹 PK',
    `name`                  varchar(50) NOT NULL COMMENT '메뉴명',
    `price`                 bigint      NOT NULL COMMENT '메뉴 금액',
    PRIMARY KEY (`order_option_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='주문 옵션';
