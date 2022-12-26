ALTER TABLE vendor_alarm RENAME shop_alarm;
ALTER TABLE `shop_alarm` CHANGE `vendor_id` `shop_id` bigint (20) NOT NULL DEFAULT 0 COMMENT '가게 PK';
