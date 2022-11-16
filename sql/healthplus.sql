-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.6.4-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 test.address 구조 내보내기
CREATE TABLE IF NOT EXISTS `address` (
  `address_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주소 PK',
  `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
  `city` varchar(50) NOT NULL DEFAULT '' COMMENT '시/군/구',
  `street` varchar(50) NOT NULL DEFAULT '' COMMENT '동/내/읍',
  `zip_code` varchar(6) DEFAULT NULL COMMENT '우편번호',
  `basic_yn` char(1) DEFAULT 'N' COMMENT '기본 주소 여부',
  PRIMARY KEY (`address_id`),
  KEY `FK_customer_TO_address` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.address:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;

-- 테이블 test.cart 구조 내보내기
CREATE TABLE IF NOT EXISTS `cart` (
  `cart_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '장바구니 PK',
  `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
  `menu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '메뉴 PK',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '메뉴명',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 가격',
  `desc` varchar(100) NOT NULL DEFAULT '' COMMENT '메뉴 설명 (옵션명)',
  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 수량',
  `create_dt` datetime DEFAULT NULL COMMENT '생성일자',
  PRIMARY KEY (`cart_id`),
  KEY `FK_customer_TO_cart` (`customer_id`),
  KEY `FK_menu_TO_cart` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.cart:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;

-- 테이블 test.category 구조 내보내기
CREATE TABLE IF NOT EXISTS `category` (
  `cate_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '카테고리 PK',
  `type` varchar(30) NOT NULL DEFAULT '' COMMENT '카테고리명',
  `create_dt` datetime DEFAULT NULL COMMENT '생성일자',
  `use_yn` char(1) DEFAULT 'Y' COMMENT '사용 여부',
  PRIMARY KEY (`cate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.category:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- 테이블 test.customer 구조 내보내기
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '구매자 PK',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '회원 PK',
  `nick` varchar(50) NOT NULL DEFAULT '' COMMENT '닉네임',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '이메일',
  `phone_number` varchar(11) NOT NULL DEFAULT '' COMMENT '휴대폰 번호',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '암호',
  `create_dt` datetime DEFAULT NULL COMMENT '가입일',
  `modify_dt` datetime DEFAULT NULL COMMENT '수정일자',
  `delete_dt` datetime DEFAULT NULL COMMENT '삭제일자',
  `use_yn` char(1) DEFAULT 'Y' COMMENT '사용 여부',
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `nick` (`nick`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`),
  KEY `FK_user_TO_customer` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.customer:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- 테이블 test.customer_alarm 구조 내보내기
CREATE TABLE IF NOT EXISTS `customer_alarm` (
  `alarm_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '구매자 알람 PK',
  `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
  `content` varchar(100) NOT NULL DEFAULT '' COMMENT '알람 내용',
  `url` varchar(50) DEFAULT NULL COMMENT '알람 URL',
  `create_dt` datetime DEFAULT NULL COMMENT '알람 생성일자',
  `read_dt` datetime DEFAULT NULL COMMENT '알람 확인일자',
  PRIMARY KEY (`alarm_id`),
  KEY `FK_customer_TO_customer_alarm` (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.customer_alarm:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `customer_alarm` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_alarm` ENABLE KEYS */;

-- 테이블 test.delivery_history 구조 내보내기
CREATE TABLE IF NOT EXISTS `delivery_history` (
  `history_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '배달내역 PK',
  `rider_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '라이더 PK',
  `content` text NOT NULL DEFAULT '' COMMENT '배달내역',
  `request` varchar(50) DEFAULT NULL COMMENT '요청사항',
  `city` varchar(50) NOT NULL DEFAULT '' COMMENT '시/군/구',
  `street` varchar(50) NOT NULL DEFAULT '' COMMENT '동/내/읍',
  `zipcode` varchar(6) DEFAULT NULL COMMENT '우편번호',
  `create_at` datetime DEFAULT NULL COMMENT '생성일자',
  PRIMARY KEY (`history_id`),
  KEY `FK_rider_TO_delivery_history` (`rider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.delivery_history:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `delivery_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_history` ENABLE KEYS */;

-- 테이블 test.menu 구조 내보내기
CREATE TABLE IF NOT EXISTS `menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '메뉴 PK',
  `shop_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '가게 PK',
  `cate_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '카테고리 PK',
  `type` char(1) DEFAULT 'A' COMMENT 'A : 조리 / B : 비조리',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '메뉴명',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 가격',
  `desc` varchar(100) NOT NULL DEFAULT '' COMMENT '메뉴 설명',
  `sold_yn` char(1) DEFAULT 'N' COMMENT '품절 여부',
  `use_yn` char(1) DEFAULT 'Y' COMMENT '사용 여부',
  `create_dt` datetime DEFAULT NULL COMMENT '생성일자',
  `modify_dt` datetime DEFAULT NULL COMMENT '수정일자',
  PRIMARY KEY (`menu_id`),
  KEY `FK_shop_TO_menu` (`shop_id`),
  KEY `FK_category_TO_menu` (`cate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.menu:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;

-- 테이블 test.option 구조 내보내기
CREATE TABLE IF NOT EXISTS `option` (
  `option_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '옵션 PK',
  `option_group_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '옵션 그룹 PK',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '옵션명',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '옵션 가격',
  `use_yn` char(1) DEFAULT 'Y' COMMENT '사용 여부',
  PRIMARY KEY (`option_id`),
  KEY `FK_option_group_TO_option` (`option_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.option:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `option` DISABLE KEYS */;
/*!40000 ALTER TABLE `option` ENABLE KEYS */;

-- 테이블 test.option_group 구조 내보내기
CREATE TABLE IF NOT EXISTS `option_group` (
  `option_group_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '옵션 그룹 PK',
  `menu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '메뉴 PK',
  `basic_choice_yn` char(1) DEFAULT 'Y' COMMENT '기본 선택 여부',
  `etc_choice_yn` char(1) DEFAULT 'N' COMMENT '기타 선택 여부',
  `use_yn` char(1) DEFAULT 'Y' COMMENT '사용 여부',
  PRIMARY KEY (`option_group_id`),
  KEY `FK_menu_TO_option_group` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.option_group:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `option_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `option_group` ENABLE KEYS */;

-- 테이블 test.order 구조 내보내기
CREATE TABLE IF NOT EXISTS `order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주문 PK',
  `customer_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '구매자 PK',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '판매자 PK',
  `rider_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '라이더 PK',
  `status` varchar(20) NOT NULL DEFAULT '' COMMENT '주문 상태',
  `total_price` int(11) NOT NULL DEFAULT 0 COMMENT '총 가격',
  `city` varchar(50) NOT NULL DEFAULT '' COMMENT '시/군/구',
  `street` varchar(50) NOT NULL DEFAULT '' COMMENT '동/내/읍',
  `zip_code` varchar(6) DEFAULT '' COMMENT '우편번호',
  `create_dt` datetime DEFAULT NULL COMMENT '생성일자',
  `modify_dt` datetime DEFAULT NULL COMMENT '수정일자',
  PRIMARY KEY (`order_id`),
  KEY `FK_customer_TO_order` (`customer_id`),
  KEY `FK_vendor_TO_order` (`vendor_id`),
  KEY `FK_rider_TO_order` (`rider_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.order:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;

-- 테이블 test.order_lines 구조 내보내기
CREATE TABLE IF NOT EXISTS `order_lines` (
  `order_lines_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '주문 항목 PK',
  `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '주문 PK',
  `menu_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '메뉴 PK',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '메뉴명',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 가격',
  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '메뉴 수량',
  `create_dt` datetime DEFAULT NULL COMMENT '생성일자',
  PRIMARY KEY (`order_lines_id`),
  KEY `FK_order_TO_order_lines_` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.order_lines:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `order_lines` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_lines` ENABLE KEYS */;

-- 테이블 test.payment 구조 내보내기
CREATE TABLE IF NOT EXISTS `payment` (
  `pay_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '결제 PK',
  `order_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '주문 PK',
  `pg` varchar(10) NOT NULL DEFAULT '' COMMENT 'PG사',
  `content` varchar(50) NOT NULL DEFAULT '' COMMENT '결제 내용',
  `method` varchar(50) NOT NULL DEFAULT '' COMMENT '결제 수단',
  `amount` int(11) NOT NULL DEFAULT 0 COMMENT '결제 가격',
  `create_dt` datetime DEFAULT NULL COMMENT '생성일자',
  PRIMARY KEY (`pay_id`),
  KEY `FK_order_TO_payment` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.payment:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

-- 테이블 test.refresh_token 구조 내보내기
CREATE TABLE IF NOT EXISTS `refresh_token` (
  `token_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '토큰 PK',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '회원 PK',
  `token` varchar(50) NOT NULL DEFAULT '' COMMENT '토큰',
  `expired_dt` datetime DEFAULT NULL COMMENT '토큰 만기일자',
  PRIMARY KEY (`token_id`),
  KEY `FK_user_TO_refresh_token` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.refresh_token:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `refresh_token` DISABLE KEYS */;
/*!40000 ALTER TABLE `refresh_token` ENABLE KEYS */;

-- 테이블 test.rider 구조 내보내기
CREATE TABLE IF NOT EXISTS `rider` (
  `rider_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '라이더 PK',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '회원 PK',
  `nick` varchar(50) NOT NULL DEFAULT '' COMMENT '닉네임',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '이메일',
  `phone_number` varchar(11) NOT NULL DEFAULT '' COMMENT '휴대폰 번호',
  `car_number` varchar(20) NOT NULL DEFAULT '' COMMENT '차량 번호',
  `car_type` varchar(50) NOT NULL DEFAULT '' COMMENT '차종',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '암호',
  `create_dt` datetime DEFAULT NULL COMMENT '가입일자',
  `modify_dt` datetime DEFAULT NULL COMMENT '수정일자',
  `delete_dt` datetime DEFAULT NULL COMMENT '삭제일자',
  `use_yn` char(1) DEFAULT 'Y' COMMENT '사용 여부',
  PRIMARY KEY (`rider_id`) USING BTREE,
  UNIQUE KEY `nick` (`nick`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_number` (`phone_number`),
  KEY `FK_user_TO_rider` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.rider:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `rider` DISABLE KEYS */;
/*!40000 ALTER TABLE `rider` ENABLE KEYS */;

-- 테이블 test.rider_alarm 구조 내보내기
CREATE TABLE IF NOT EXISTS `rider_alarm` (
  `alarm_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '라이더 알람 PK',
  `rider_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '라이더 PK',
  `content` varchar(100) NOT NULL DEFAULT '' COMMENT '알람 내용',
  `url` varchar(50) NOT NULL DEFAULT '' COMMENT '알람 URL',
  `create_dt` datetime DEFAULT NULL COMMENT '알람 생성일자',
  `read_dt` datetime DEFAULT NULL COMMENT '알람 확인일자',
  PRIMARY KEY (`alarm_id`),
  KEY `FK_rider_TO_rider_alarm` (`rider_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.rider_alarm:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `rider_alarm` DISABLE KEYS */;
/*!40000 ALTER TABLE `rider_alarm` ENABLE KEYS */;

-- 테이블 test.shop 구조 내보내기
CREATE TABLE IF NOT EXISTS `shop` (
  `shop_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '가게 PK',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '판매자 PK',
  `business_name` varchar(50) NOT NULL DEFAULT '' COMMENT '가게명',
  `business_number` varchar(50) NOT NULL DEFAULT '' COMMENT '가게 전화번호',
  `business_hour` varchar(50) NOT NULL DEFAULT '' COMMENT '영업시간',
  `main_type` varchar(50) NOT NULL DEFAULT '' COMMENT '업종',
  `sub_type` varchar(50) NOT NULL DEFAULT '' COMMENT '업태',
  `minimum_price` bigint(20) NOT NULL DEFAULT 0 COMMENT '최소 주문 가격',
  `delivery_fee` bigint(20) NOT NULL DEFAULT 0 COMMENT '배달료',
  `city` varchar(50) NOT NULL DEFAULT '' COMMENT '시/군/구',
  `street` varchar(50) NOT NULL DEFAULT '' COMMENT '동/내/읍',
  `zip_code` varchar(6) DEFAULT '' COMMENT '우편번호',
  `open_yn` char(1) DEFAULT NULL COMMENT '영업 여부',
  `use_yn` char(1) DEFAULT 'Y' COMMENT '사용 여부',
  PRIMARY KEY (`shop_id`),
  KEY `FK_vendor_TO_shop` (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.shop:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;

-- 테이블 test.user 구조 내보내기
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '회원 PK',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '암호',
  `nick` varchar(50) NOT NULL DEFAULT '' COMMENT '닉네임',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '이메일',
  `phone_number` varchar(11) NOT NULL DEFAULT '' COMMENT '휴대폰 번호',
  `roles`        JSON DEFAULT NULL COMMENT '회원역할',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.user:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- 테이블 test.vendor 구조 내보내기
CREATE TABLE IF NOT EXISTS `vendor` (
  `vendor_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '판매자 PK',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '회원 PK',
  `nick` varchar(50) NOT NULL DEFAULT '' COMMENT '닉네임',
  `email` varchar(50) NOT NULL DEFAULT '' COMMENT '이메일',
  `phone_number` varchar(11) NOT NULL DEFAULT '' COMMENT '휴대폰 번호',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '사업자명',
  `bank` varchar(50) NOT NULL DEFAULT '' COMMENT '은행명',
  `account_number` varchar(30) NOT NULL DEFAULT '' COMMENT '계좌번호',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '암호',
  `create_dt` datetime DEFAULT NULL COMMENT '가입일자',
  `modify_dt` datetime DEFAULT NULL COMMENT '수정일자',
  `delete_dt` datetime DEFAULT NULL COMMENT '탈퇴일자',
  `use_yn` char(1) DEFAULT 'Y' COMMENT '사용 여부',
  PRIMARY KEY (`vendor_id`),
  UNIQUE KEY `phone_number` (`phone_number`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `nick` (`nick`),
  KEY `FK_user_TO_vendor_` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.vendor:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;

-- 테이블 test.vendor_alarm 구조 내보내기
CREATE TABLE IF NOT EXISTS `vendor_alarm` (
  `alarm_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '판매자 알람 PK',
  `vendor_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '판매자 PK',
  `content` varchar(100) NOT NULL DEFAULT '' COMMENT '알람 내용',
  `url` varchar(50) NOT NULL DEFAULT '' COMMENT '알람 URL',
  `create_dt` datetime DEFAULT NULL COMMENT '알람 생성일자',
  `read_dt` datetime DEFAULT NULL COMMENT '알람 확인일자',
  PRIMARY KEY (`alarm_id`),
  KEY `FK_vendor_TO_vendor_alarm` (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- 테이블 데이터 test.vendor_alarm:~0 rows (대략적) 내보내기
/*!40000 ALTER TABLE `vendor_alarm` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor_alarm` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
