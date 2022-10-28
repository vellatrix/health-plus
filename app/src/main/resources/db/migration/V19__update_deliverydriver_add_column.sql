ALTER TABLE delivery_driver ADD COLUMN delivery_status char(1) NOT NULL DEFAULT 'Y' COMMENT '배달 가능 여부';
