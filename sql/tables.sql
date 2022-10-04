CREATE TABLE `customer` (
	`customer_id`	int	NOT NULL,
	`id`	varchar	NULL,
	`password`	varchar	NULL,
	`nick`	varchar	NULL,
	`email`	varchar	NULL,
	`phone_number`	varchar	NULL,
	`create_dt`	datetime	NULL,
	`modify_dt`	datetime	NULL,
	`delete_dt`	datetime	NULL,
	`use_yn`	char	NULL
);

CREATE TABLE `delivery_driver` (
	`driver_id`	int	NOT NULL,
	`car_number`	varchar	NULL,
	`car_type`	varchar	NULL,
	`id`	varchar	NULL,
	`password`	varchar	NULL,
	`location`	varchar	NULL,
	`email`	varchar	NULL,
	`phone_number`	varchar	NULL,
	`create_dt`	datetime	NULL,
	`modify_dt`	datetime	NULL,
	`delete_dt`	datetime	NULL,
	`use_yn`	char	NULL
);

CREATE TABLE `vendor` (
	`vendor_id`	int	NOT NULL,
	`name`	varchar	NULL,
	`bank`	varchar	NULL,
	`account_number`	varchar	NULL,
	`id`	varchar	NULL,
	`password`	varchar	NULL,
	`email`	varchar	NULL,
	`phone_number`	varchar	NULL,
	`create_dt`	datetime	NULL,
	`modify_dt`	datetime	NULL,
	`delete_dt`	datetime	NULL,
	`use_yn`	char	NULL
);

CREATE TABLE `menu` (
	`menu_id`	int	NOT NULL,
	`restaurant_id`	int	NOT NULL,
	`cate_id`	int	NOT NULL,
	`type`	char	NULL,
	`name`	varchar	NULL,
	`price`	int	NULL,
	`desc`	varchar	NULL,
	`sold_yn`	char	NULL,
	`use_yn`	char	NULL,
	`create_dt`	datetime	NULL,
	`modify_dt`	datetime	NULL
);

CREATE TABLE `cart` (
	`cart_id`	int	NOT NULL,
	`customer_id`	int	NOT NULL,
	`item_id`	int	NOT NULL,
	`create_dt`	datetime	NULL,
	`modify_dt`	datetime	NULL
);

CREATE TABLE `payment` (
	`pay_id`	int	NOT NULL,
	`customer_id`	int	NOT NULL,
	`order_id`	int	NOT NULL,
	`pg`	varchar	NULL,
	`content`	varchar	NULL,
	`method`	varchar	NULL,
	`amount`	int	NULL,
	`create_dt`	datetime	NULL,
	`modify_dt`	datetime	NULL
);

CREATE TABLE `delivery` (
	`delivery_id`	int	NOT NULL,
	`order_id`	int	NOT NULL,
	`driver_id`	int	NOT NULL,
	`city`	varchar	NULL,
	`street`	varchar	NULL,
	`zipcode`	int	NULL
);

CREATE TABLE `alarm` (
	`alarm_id`	int	NOT NULL,
	`customer_id`	int	NOT NULL,
	`content`	varchar	NULL,
	`create_dt`	datetime	NULL
);

CREATE TABLE `order` (
	`order_id`	int	NOT NULL,
	`customer_id`	int	NOT NULL,
	`status`	char	NULL,
	`price`	int	NULL,
	`ordering_id`	varchar	NULL,
	`create_dt`	datetime	NULL
);

CREATE TABLE `order_menu` (
	`order_item_id`	int	NOT NULL,
	`item_id`	int	NOT NULL,
	`order_id`	int	NOT NULL,
	`create_dt`	datetime	NULL
);

CREATE TABLE `category` (
	`cate_id`	int	NOT NULL,
	`type`	varchar	NULL,
	`create_dt`	datetime	NULL,
	`modify_dt`	datetime	NULL,
	`use_yn`	char	NULL
);

CREATE TABLE `address` (
	`address_id`	int	NOT NULL,
	`customer_id`	int	NOT NULL,
	`city`	varchar	NULL,
	`street`	varchar	NULL,
	`zip_code`	int	NULL,
	`create_dt`	datetime	NULL,
	`modify_dt`	datetime	NULL,
	`type`	char	NULL
);

CREATE TABLE `option_group` (
	`option_group_id`	int	NOT NULL,
	`menu_id`	int	NOT NULL,
	`basic_choice_yn`	char	NULL,
	`etc_choice_yn`	char	NULL,
	`use_yn`	char	NULL
);

CREATE TABLE `option_detail` (
	`option_detail_id`	int	NOT NULL,
	`option_group_id`	int	NOT NULL,
	`name`	varchar	NULL,
	`price`	int	NULL,
	`use_yn`	char	NULL
);

CREATE TABLE `restaurant` (
	`restaurant_id`	int	NOT NULL,
	`vendor_id`	int	NOT NULL,
	`business_name`	varchar	NULL,
	`business_number`	varchar	NULL,
	`business_hour`	varchar	NULL,
	`main_type`	varchar	NULL,
	`sub_type`	varchar	NULL,
	`minimum_price`	int	NULL,
	`delivery_fee`	int	NULL,
	`open_yn`	char	NULL,
	`use_yn`	char	NULL,
	`city`	varchar	NULL,
	`street`	varchar	NULL,
	`zip_code`	int	NULL
);

CREATE TABLE `order_option_group` (
	`order_option_group_id`	int	NOT NULL,
	`order_item_id`	int	NOT NULL,
	`name`	varchar	NULL
);

CREATE TABLE `order_option` (
	`order_option_id`	int	NOT NULL,
	`order_option_group_id`	int	NOT NULL,
	`name`	varchar	NULL,
	`price`	int	NULL
);

CREATE TABLE `settlement` (
	`settlement_id`	int	NOT NULL,
	`vendor_id`	int	NOT NULL,
	`amount`	int	NULL
);

CREATE TABLE `billing_history` (
	`billing_id`	int	NOT NULL,
	`pay_id`	int	NOT NULL,
	`settlement_id`	int	NOT NULL,
	`status`	char	NULL,
	`amount`	int	NULL,
	`create_dt`	datetime	NULL,
	`modify_dt`	datetime	NULL
);

ALTER TABLE `customer` ADD CONSTRAINT `PK_CUSTOMER` PRIMARY KEY (
	`customer_id`
);

ALTER TABLE `delivery_driver` ADD CONSTRAINT `PK_DELIVERY_DRIVER` PRIMARY KEY (
	`driver_id`
);

ALTER TABLE `vendor` ADD CONSTRAINT `PK_VENDOR` PRIMARY KEY (
	`vendor_id`
);

ALTER TABLE `menu` ADD CONSTRAINT `PK_MENU` PRIMARY KEY (
	`menu_id`
);

ALTER TABLE `cart` ADD CONSTRAINT `PK_CART` PRIMARY KEY (
	`cart_id`
);

ALTER TABLE `payment` ADD CONSTRAINT `PK_PAYMENT` PRIMARY KEY (
	`pay_id`
);

ALTER TABLE `delivery` ADD CONSTRAINT `PK_DELIVERY` PRIMARY KEY (
	`delivery_id`
);

ALTER TABLE `alarm` ADD CONSTRAINT `PK_ALARM` PRIMARY KEY (
	`alarm_id`
);

ALTER TABLE `order` ADD CONSTRAINT `PK_ORDER` PRIMARY KEY (
	`order_id`
);

ALTER TABLE `order_menu` ADD CONSTRAINT `PK_ORDER_MENU` PRIMARY KEY (
	`order_item_id`
);

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
	`cate_id`
);

ALTER TABLE `address` ADD CONSTRAINT `PK_ADDRESS` PRIMARY KEY (
	`address_id`
);

ALTER TABLE `option_group` ADD CONSTRAINT `PK_OPTION_GROUP` PRIMARY KEY (
	`option_group_id`
);

ALTER TABLE `option_detail` ADD CONSTRAINT `PK_OPTION_DETAIL` PRIMARY KEY (
	`option_detail_id`
);

ALTER TABLE `restaurant` ADD CONSTRAINT `PK_RESTAURANT` PRIMARY KEY (
	`restaurant_id`
);

ALTER TABLE `order_option_group` ADD CONSTRAINT `PK_ORDER_OPTION_GROUP` PRIMARY KEY (
	`order_option_group_id`
);

ALTER TABLE `order_option` ADD CONSTRAINT `PK_ORDER_OPTION` PRIMARY KEY (
	`order_option_id`
);

ALTER TABLE `settlement` ADD CONSTRAINT `PK_SETTLEMENT` PRIMARY KEY (
	`settlement_id`
);

ALTER TABLE `billing_history` ADD CONSTRAINT `PK_BILLING_HISTORY` PRIMARY KEY (
	`billing_id`
);

