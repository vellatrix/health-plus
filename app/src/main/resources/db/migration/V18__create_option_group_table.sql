DROP TABLE IF EXISTS `option_group`;
CREATE TABLE `option_group`
(
    `option_group_id` bigint  NOT NULL AUTO_INCREMENT COMMENT '메뉴 옵션 그룹 PK',
    `menu_id`         bigint  NOT NULL COMMENT '메뉴 PK',
    `basic_choice_yn` char(1) NOT NULL DEFAULT 'Y' COMMENT '기본 선택',
    `etc_choice_yn`   char(1) NOT NULL DEFAULT 'N' COMMENT '기타 선택 (메뉴 옵션 상세 메뉴 중 택일)',
    `use_yn`          char(1) NOT NULL DEFAULT 'Y' COMMENT '사용 여부',
    PRIMARY KEY (`option_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COMMENT='메뉴 옵션 그룹';
