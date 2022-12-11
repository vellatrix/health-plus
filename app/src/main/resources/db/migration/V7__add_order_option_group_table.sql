create table if not exists `order_option_group`
(
    `order_option_group_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주문 옵션 그룹 PK',
    `name`                      varchar(50)  NOT NULL DEFAULT '' COMMENT '옵션 그룹명',
    PRIMARY KEY (`order_option_group_id`) USING BTREE,
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;