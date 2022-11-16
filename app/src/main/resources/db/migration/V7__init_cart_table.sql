create table if not exists `cart`
(
    `cart_id`     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '장바구니 PK',
    `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
    `menu_id`     bigint(20) NOT NULL DEFAULT 0 COMMENT '메뉴 PK',
    `name`        varchar(50)  NOT NULL DEFAULT '' COMMENT '메뉴명',
    `price`       int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 가격',
    `desc`        varchar(100) NOT NULL DEFAULT '' COMMENT '메뉴 설명 (옵션명)',
    `quantity`    int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 수량',
    `create_dt`   datetime              DEFAULT NULL COMMENT '생성일자',
    PRIMARY KEY (`cart_id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customer` (customer_id),
    FOREIGN KEY (`menu_id`) REFERENCES `menu` (menu_id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
