
create table if not exists `vendor`
(
    `vendor_id`      bigint(20) NOT NULL AUTO_INCREMENT COMMENT '판매자 PK',
    `user_id`        bigint(20) NOT NULL DEFAULT 0 COMMENT '회원 PK',
    `nick`           varchar(50)  NOT NULL DEFAULT '' COMMENT '닉네임',
    `email`          varchar(50)  NOT NULL DEFAULT '' COMMENT '이메일',
    `phone_number`   varchar(11)  NOT NULL DEFAULT '' COMMENT '휴대폰 번호',
    `name`           varchar(50)  NOT NULL DEFAULT '' COMMENT '사업자명',
    `bank`           varchar(50)  NOT NULL DEFAULT '' COMMENT '은행명',
    `account_number` varchar(30)  NOT NULL DEFAULT '' COMMENT '계좌번호',
    `password`       varchar(100) NOT NULL DEFAULT '' COMMENT '암호',
    `create_dt`      datetime              DEFAULT NULL COMMENT '가입일자',
    `modify_dt`      datetime              DEFAULT NULL COMMENT '수정일자',
    `delete_dt`      datetime              DEFAULT NULL COMMENT '탈퇴일자',
    `use_yn`         char(1)               DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`vendor_id`),
    UNIQUE KEY `phone_number` (`phone_number`),
    UNIQUE KEY `email` (`email`),
    UNIQUE KEY `nick` (`nick`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (user_id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

create table if not exists `shop`
(
    `shop_id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT '가게 PK',
    `vendor_id`       bigint(20) NOT NULL DEFAULT 0 COMMENT '판매자 PK',
    `business_name`   varchar(50) NOT NULL DEFAULT '' COMMENT '가게명',
    `business_number` varchar(50) NOT NULL DEFAULT '' COMMENT '가게 전화번호',
    `business_hour`   varchar(50) NOT NULL DEFAULT '' COMMENT '영업시간',
    `main_type`       varchar(50) NOT NULL DEFAULT '' COMMENT '업종',
    `sub_type`        varchar(50) NOT NULL DEFAULT '' COMMENT '업태',
    `minimum_price`   bigint(20) NOT NULL DEFAULT 0 COMMENT '최소 주문 가격',
    `delivery_fee`    bigint(20) NOT NULL DEFAULT 0 COMMENT '배달료',
    `city`            varchar(50) NOT NULL DEFAULT '' COMMENT '시/군/구',
    `street`          varchar(50) NOT NULL DEFAULT '' COMMENT '동/내/읍',
    `zip_code`        varchar(6)           DEFAULT '' COMMENT '우편번호',
    `open_yn`         char(1)              DEFAULT NULL COMMENT '영업 여부',
    `use_yn`          char(1)              DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`shop_id`),
    FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (vendor_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

create table if not exists `vendor_alarm`
(
    `alarm_id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '판매자 알람 PK',
    `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '판매자 PK',
    `content`   varchar(100) NOT NULL DEFAULT '' COMMENT '알람 내용',
    `url`       varchar(50)  NOT NULL DEFAULT '' COMMENT '알람 URL',
    `create_dt` datetime              DEFAULT NULL COMMENT '알람 생성일자',
    `read_dt`   datetime              DEFAULT NULL COMMENT '알람 확인일자',
    PRIMARY KEY (`alarm_id`),
    FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (vendor_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

create table if not exists `category`
(
    `cate_id`   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '카테고리 PK',
    `type`      varchar(30) NOT NULL DEFAULT '' COMMENT '카테고리명',
    `create_dt` datetime             DEFAULT NULL COMMENT '생성일자',
    `use_yn`    char(1)              DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

create table if not exists `menu`
(
    `menu_id`   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '메뉴 PK',
    `shop_id`   bigint(20) NOT NULL DEFAULT 0 COMMENT '가게 PK',
    `cate_id`   bigint(20) NOT NULL DEFAULT 0 COMMENT '카테고리 PK',
    `type`      char(1)               DEFAULT 'A' COMMENT 'A : 조리 / B : 비조리',
    `name`      varchar(50)  NOT NULL DEFAULT '' COMMENT '메뉴명',
    `price`     int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 가격',
    `desc`      varchar(100) NOT NULL DEFAULT '' COMMENT '메뉴 설명',
    `sold_yn`   char(1)               DEFAULT 'N' COMMENT '품절 여부',
    `use_yn`    char(1)               DEFAULT 'Y' COMMENT '사용 여부',
    `create_dt` datetime              DEFAULT NULL COMMENT '생성일자',
    `modify_dt` datetime              DEFAULT NULL COMMENT '수정일자',
    PRIMARY KEY (`menu_id`),
    FOREIGN KEY (`shop_id`) REFERENCES `shop` (shop_id),
    FOREIGN KEY (`cate_id`) REFERENCES `category` (cate_id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

create table if not exists `option_group`
(
    `option_group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '옵션 그룹 PK',
    `menu_id`         bigint(20) NOT NULL DEFAULT 0 COMMENT '메뉴 PK',
    `basic_choice_yn` char(1) DEFAULT 'Y' COMMENT '기본 선택 여부',
    `etc_choice_yn`   char(1) DEFAULT 'N' COMMENT '기타 선택 여부',
    `use_yn`          char(1) DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`option_group_id`),
    FOREIGN KEY (`menu_id`) REFERENCES `menu` (menu_id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

create table if not exists `option`
(
    `option_id`       bigint(20) NOT NULL AUTO_INCREMENT COMMENT '옵션 PK',
    `option_group_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '옵션 그룹 PK',
    `name`            varchar(50) NOT NULL DEFAULT '' COMMENT '옵션명',
    `price`           int(11) NOT NULL DEFAULT 0 COMMENT '옵션 가격',
    `use_yn`          char(1)              DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`option_id`),
    FOREIGN KEY (`option_group_id`) REFERENCES `option_group` (option_group_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
