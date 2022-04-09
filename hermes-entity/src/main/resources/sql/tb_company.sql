create table tb_company
(
    id                  bigint      not null auto_increment comment '主键标识',
    company_name        varchar(32)          default null comment '公司名称',
    institution_type_id varchar(32)          default null comment '机构类型',
    contact_user        varchar(32) not null comment '联系人',
    contact_phone       varchar(32)          default null comment '联系电话',
    admin_user          varchar(32)          default null comment '管理员账号',
    status              tinyint(3)  not null comment '状态（1：有效，0：无效）',
    create_user         varchar(32)          default null comment '创建人名称',
    last_update_user    varchar(32)          default null comment '最后更新人名称',
    last_update_time    datetime    not null default current_timestamp on update current_timestamp comment '最后更新时间',
    created_at          datetime    not null default current_timestamp comment '创建时间',
    updated_at          datetime    not null default current_timestamp comment '更新时间',
    primary key (id),
    key idx_account_no (contact_user)
) auto_increment 1 comment ='公司（交易商）表'