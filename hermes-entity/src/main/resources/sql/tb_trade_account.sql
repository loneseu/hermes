CREATE TABLE `tb_trade_account`
(
    `id`                  bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键标识',
    `user_id`             bigint(20)  NOT NULL COMMENT '用户ID',
    `account_no`          varchar(16) NOT NULL COMMENT '账号',
    `balance`             bigint(21)  DEFAULT NULL COMMENT '余额',
    `trade_group_id`      bigint(20)  NOT NULL COMMENT '交易组ID',
    `active_time`         datetime    DEFAULT NULL COMMENT '激活时间',
    `status`              tinyint(3)  NOT NULL COMMENT '状态',
    `institution_type_id` varchar(32) DEFAULT NULL COMMENT '',
    `institution_id`      bigint(19)  DEFAULT NULL COMMENT '',
    `company_id`          bigint(20)  DEFAULT NULL COMMENT '',
    `username`            varchar(32) DEFAULT NULL COMMENT '',
    `trade_group_name`    varchar(32) DEFAULT NULL COMMENT '',
    created_at    datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_at    datetime    not null default CURRENT_TIMESTAMP comment '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `idx_accountNo` (`account_no`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='用户账号表';

