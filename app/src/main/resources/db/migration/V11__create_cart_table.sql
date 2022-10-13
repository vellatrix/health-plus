DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`
(
    `cart_id`     bigint   NOT NULL AUTO_INCREMENT COMMENT '장바구니 PK',
    `customer_id` bigint   NOT NULL COMMENT '구매회원 PK',
    `menu_id`     bigint   NOT NULL COMMENT '상품 PK',
    `create_dt`   datetime NOT NULL COMMENT '생성일자',
    `modify_dt`   datetime DEFAULT NULL COMMENT '수정일자',
    PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='장바구니';
