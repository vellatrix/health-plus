create table if not exists `order_option`
(
    `order_option_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주문 옵션 PK',
    `name`                varchar(50)  NOT NULL DEFAULT '' COMMENT '옵션명',
    `price`               int(11) NOT NULL DEFAULT 0 COMMENT '옵션 가격',
    PRIMARY KEY (`order_option_id`) USING BTREE,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;