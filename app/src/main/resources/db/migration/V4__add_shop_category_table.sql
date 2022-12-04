create table if not exists `shop_category`
(
    `cate_id`   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '가게 카테고리 PK',
    `type`      varchar(30) NOT NULL DEFAULT '' COMMENT '가게 카테고리명',
    `create_dt` datetime             DEFAULT NULL COMMENT '생성일자',
    `use_yn`    char(1)              DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`cate_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;