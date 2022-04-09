create table tb_seq
(
    id         bigint     not null auto_increment comment '主键标识',
    code       varchar(32) comment '配置项编号',
    value      bigint(21) comment '序列值',
    created_at datetime   not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_at datetime   not null default CURRENT_TIMESTAMP comment '更新时间',
    primary key (id) using btree
) comment '序列表'