DROP TABLE IF EXISTS `order_menu`;
CREATE TABLE `order_menu`
(
    `order_item_id` bigint   NOT NULL AUTO_INCREMENT COMMENT '주문 메뉴 PK',
    `item_id`       bigint   NOT NULL COMMENT '메뉴 PK',
    `order_id`      bigint   NOT NULL COMMENT '주문 PK',
    `create_dt`     datetime NOT NULL COMMENT '생성일자',
    PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='주문 메뉴';
