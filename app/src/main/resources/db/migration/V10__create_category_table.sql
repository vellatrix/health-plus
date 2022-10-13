DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `category_id` bigint      NOT NULL AUTO_INCREMENT COMMENT '카테고리 PK',
    `type`        varchar(50) NOT NULL DEFAULT '' COMMENT '카테고리명',
    `create_dt`   datetime    NOT NULL COMMENT '생성일자',
    `modify_dt`   datetime             DEFAULT NULL COMMENT '수정일자',
    `use_yn`      char(1)     NOT NULL DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='메뉴 카테고리';
