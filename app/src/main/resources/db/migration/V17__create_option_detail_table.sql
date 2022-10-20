DROP TABLE IF EXISTS `option_detail`;
CREATE TABLE `option_detail`
(
    `option_detail_id` bigint      NOT NULL AUTO_INCREMENT COMMENT '메뉴 옵션 상세 PK',
    `option_group_id`  bigint      NOT NULL COMMENT '메뉴 옵션 그룹 PK',
    `name`             varchar(50) NOT NULL COMMENT '옵션명',
    `price`            int         NOT NULL DEFAULT '0' COMMENT '옵션 가격',
    `use_yn`           char(1)     NOT NULL DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`option_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COMMENT='메뉴 옵션 상세';
