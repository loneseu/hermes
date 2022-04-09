create table tb_trade_user_file
(
    id            bigint      not null auto_increment comment '主键标识',
    user_id       bigint(16)  not null comment '用户ID',
    business_type tinyint(3)  not null comment '业务类型（0：身份证，1：银行卡，2：信用卡）',
    file_id       varchar(32) not null comment '文件ID',
    file_name     varchar(64) comment '文件名称',
    file_type     varchar(32) comment '文件类型',
    file_path     varchar(255) comment '文件路径',
    status        tinyint(3)  not null comment '状态（1：有效，0：无效）',
    created_at    datetime    not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_at    datetime    not null default CURRENT_TIMESTAMP comment '更新时间',
    primary key (id)
) comment '用户文件表'