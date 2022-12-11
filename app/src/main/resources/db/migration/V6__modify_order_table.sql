alter table `order` CHANGE `vendor_id` `shop_id` bigint (20) NOT NULL DEFAULT 0 COMMENT '가게 PK';
