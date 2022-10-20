DROP TABLE IF EXISTS `restaurant`;
CREATE TABLE `restaurant`
(
    `restaurant_id`   bigint      NOT NULL AUTO_INCREMENT COMMENT '식당 PK',
    `vendor_id`       bigint      NOT NULL COMMENT '판매회원 PK',
    `business_name`   varchar(50) NOT NULL COMMENT '식당명',
    `business_number` varchar(50) NOT NULL COMMENT '사업자번호',
    `business_hour`   varchar(50) NOT NULL COMMENT '영업시간',
    `main_type`       varchar(50) NOT NULL COMMENT '업종',
    `sub_type`        varchar(50) NOT NULL COMMENT '업태',
    `minimum_price`   bigint      NOT NULL COMMENT '최소 주문 금액',
    `delivery_fee`    bigint      NOT NULL COMMENT '배달료',
    `open_yn`         char(1)     NOT NULL DEFAULT 'N' COMMENT '영업여부',
    `use_yn`          char(1)     NOT NULL DEFAULT 'Y' COMMENT '사용여부',
    `city`            varchar(50) NOT NULL COMMENT '시/군/구',
    `street`          varchar(50) NOT NULL COMMENT '동/내/읍',
    `zip_code`        bigint      NOT NULL COMMENT '우편번호',
    PRIMARY KEY (`restaurant_id`),
    UNIQUE KEY `business_number` (`business_number`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='식당';
