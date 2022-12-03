alter table `user` CHANGE `nick` `name` varchar (50) NOT NULL DEFAULT '' COMMENT '이름';
alter table `user` CHANGE `roles` `role` varchar (20) NOT NULL DEFAULT '' COMMENT '회원역할';
