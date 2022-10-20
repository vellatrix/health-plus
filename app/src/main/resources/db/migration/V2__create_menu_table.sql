DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`
(
    `menu_id`       bigint      NOT NULL AUTO_INCREMENT COMMENT '메뉴 PK',
    `restaurant_id` bigint      NOT NULL COMMENT '식당 PK',
    `category_id`   bigint      NOT NULL COMMENT '카테고리 PK',
    `type`          char(1)     NOT NULL COMMENT '조리 가능 타입 (A : 가능 / B 불가능)',
    `name`          varchar(50) NOT NULL COMMENT '메뉴명',
    `price`         int         NOT NULL DEFAULT '0' COMMENT '가격',
    `desc`          varchar(50)          DEFAULT NULL COMMENT '메뉴 설명',
    `calorie`       int         NOT NULL COMMENT '칼로리',
    `sold_yn`       char(1)     NOT NULL DEFAULT 'N' COMMENT '매진 여부',
    `use_yn`        char(1)     NOT NULL DEFAULT 'Y' COMMENT '사용 여부',
    `create_dt`     datetime    NOT NULL COMMENT '생성일자',
    `modify_dt`     datetime             DEFAULT NULL COMMENT '수정일자',
    PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COMMENT='메뉴';
