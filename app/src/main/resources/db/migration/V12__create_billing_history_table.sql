DROP TABLE IF EXISTS `billing_history`;
CREATE TABLE `billing_history`
(
    `billing_id`    bigint   NOT NULL AUTO_INCREMENT COMMENT '이용내역 PK',
    `pay_id`        bigint   NOT NULL COMMENT '결제내역 PK',
    `settlement_id` bigint   NOT NULL COMMENT '정산내역 PK',
    `status`        char(1)  NOT NULL DEFAULT '' COMMENT '상태',
    `amount`        bigint   NOT NULL DEFAULT '0' COMMENT '금액',
    `create_dt`     datetime NOT NULL COMMENT '생성일자',
    `modify_dt`     datetime          DEFAULT NULL COMMENT '수정일자',
    PRIMARY KEY (`billing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='이용내역';
