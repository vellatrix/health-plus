DROP TABLE IF EXISTS `refresh_token`;
CREATE TABLE `refresh_token`
(
    `token_id`   bigint NOT NULL AUTO_INCREMENT COMMENT 'RefreshToken PK',
    `user_id`    bigint NOT NULL COMMENT '유저 PK',
    `token`      varchar(255) DEFAULT NULL COMMENT 'Token',
    `expired_dt` datetime     DEFAULT NULL COMMENT '만료 일자',
    PRIMARY KEY (`token_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='RefreshToken';
