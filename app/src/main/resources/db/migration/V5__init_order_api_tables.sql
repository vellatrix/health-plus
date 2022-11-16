create table if not exists `order`
(
    `order_id`    bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주문 PK',
    `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
    `vendor_id`   bigint(20) NOT NULL DEFAULT 0 COMMENT '판매자 PK',
    `rider_id`    bigint(20) NOT NULL DEFAULT 0 COMMENT '라이더 PK',
    `status`      varchar(20) NOT NULL DEFAULT '' COMMENT '주문 상태',
    `total_price` int(11) NOT NULL DEFAULT 0 COMMENT '총 가격',
    `city`        varchar(50) NOT NULL DEFAULT '' COMMENT '시/군/구',
    `street`      varchar(50) NOT NULL DEFAULT '' COMMENT '동/내/읍',
    `zip_code`    varchar(6)           DEFAULT '' COMMENT '우편번호',
    `create_dt`   datetime             DEFAULT NULL COMMENT '생성일자',
    `modify_dt`   datetime             DEFAULT NULL COMMENT '수정일자',
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`customer_id`) REFERENCES `customer` (customer_id),
    FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (vendor_id),
    FOREIGN KEY (`rider_id`) REFERENCES `rider` (rider_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

create table if not exists `order_lines`
(
    `order_lines_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주문 항목 PK',
    `order_id`       bigint(20) NOT NULL DEFAULT 0 COMMENT '주문 PK',
    `menu_id`        bigint(20) NOT NULL DEFAULT 0 COMMENT '메뉴 PK',
    `name`           varchar(50) NOT NULL DEFAULT '' COMMENT '메뉴명',
    `price`          int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 가격',
    `quantity`       int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 수량',
    `create_dt`      datetime             DEFAULT NULL COMMENT '생성일자',
    PRIMARY KEY (`order_lines_id`),
    FOREIGN KEY (`order_id`) REFERENCES `order` (order_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

create table if not exists `payment`
(
    `pay_id`    bigint(20) NOT NULL AUTO_INCREMENT COMMENT '결제 PK',
    `order_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '주문 PK',
    `pg`        varchar(10) NOT NULL DEFAULT '' COMMENT 'PG사',
    `content`   varchar(50) NOT NULL DEFAULT '' COMMENT '결제 내용',
    `method`    varchar(50) NOT NULL DEFAULT '' COMMENT '결제 수단',
    `amount`    int(11) NOT NULL DEFAULT 0 COMMENT '결제 가격',
    `create_dt` datetime             DEFAULT NULL COMMENT '생성일자',
    PRIMARY KEY (`pay_id`),
    FOREIGN KEY (`order_id`) REFERENCES `order` (order_id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
