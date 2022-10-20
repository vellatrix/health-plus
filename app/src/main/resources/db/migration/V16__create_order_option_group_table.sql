DROP TABLE IF EXISTS `order_option_group`;
CREATE TABLE `order_option_group`
(
    `order_option_group_id` bigint      NOT NULL AUTO_INCREMENT COMMENT '주문 옵션 그룹 PK',
    `order_item_id`         bigint      NOT NULL COMMENT '주문 메뉴 PK',
    `name`                  varchar(50) NOT NULL COMMENT '그룹명',
    PRIMARY KEY (`order_option_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='주문 옵션 그룹';
