create table tb_trade_global_config
(
    id         bigint     not null auto_increment comment '主键标识',
    code       varchar(32) comment '配置项编号',
    category   varchar(32) comment '分类编号（BASIC：基础配置，BUSINESS：业务配置，SYSTEM：系统项配置）',
    value      varchar(128) comment '配置项值',
    status     tinyint(2) not null comment '状态（1：启用，0：禁用）',
    created_at datetime   not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_at datetime   not null default CURRENT_TIMESTAMP comment '更新时间',
    primary key (id) using btree
) comment '系统全局配置表'