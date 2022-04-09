CREATE TABLE `tb_trade_user`
(
    `id`                  bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键标识',
    `user_no`             varchar(16) NOT NULL COMMENT '用户编号',
    `name`                varchar(16)  DEFAULT NULL COMMENT '用户名称',
    `user_password`       varchar(32) NOT NULL COMMENT '用户密码',
    `phone`               varchar(16)  DEFAULT NULL COMMENT '电话号码',
    `company_id`          bigint(20)   DEFAULT NULL COMMENT '公司ID',
    `email`               varchar(32)  DEFAULT NULL COMMENT '邮箱',
    `address`             varchar(255) DEFAULT NULL COMMENT '地址',
    `last_login_ip`       varchar(32)  DEFAULT NULL COMMENT '最近一次用户登陆IP',
    `last_login_time`     datetime     DEFAULT NULL COMMENT '最近一次登陆时间',
    `status`              tinyint(3)  NOT NULL COMMENT '状态(0:有效， 1：锁定， 2：禁用）',
    `id_card`             varchar(32)  DEFAULT NULL COMMENT '身份证',
    `institution_type_id` varchar(32)  DEFAULT NULL COMMENT '机构类型id',
    `institution_id`      bigint(19)   DEFAULT NULL COMMENT '对应机构类型下的机构id',
    `company_name`        varchar(64)  DEFAULT NULL COMMENT '公司名称',
    `created_at`          datetime     DEFAULT NULL COMMENT '创建时间',
    `updated_at`          datetime     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `idx_userNo` (`user_no`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='用户表';
