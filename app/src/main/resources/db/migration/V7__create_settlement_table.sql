DROP TABLE IF EXISTS `settlement`;
CREATE TABLE `settlement`
(
    `settlement_id` bigint   NOT NULL AUTO_INCREMENT COMMENT '정산내역 PK',
    `vendor_id`     bigint   NOT NULL COMMENT '판매회원 PK',
    `customer_id`   bigint   NOT NULL COMMENT '구매회원 PK',
    `driver_id`     bigint   NOT NULL COMMENT '라이더 PK',
    `amount`        bigint   NOT NULL COMMENT '정산 금액',
    `create_dt`     datetime NOT NULL COMMENT '생성일자',
    PRIMARY KEY (`settlement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='정산내역';
