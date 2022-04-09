create table tb_institution
(
    id                      bigint   not null auto_increment comment '机构id',
    institution_type_id     varchar(48)       default null comment '机构类型id',
    detail_institution_id   varchar(32)       default null comment '机构关联id',
    detail_institution_name varchar(255)      default null comment '机构关联名称',
    created_at              datetime not null default CURRENT_TIMESTAMP comment '创建时间',
    updated_at              datetime not null default CURRENT_TIMESTAMP comment '更新时间',
    primary key (id) using btree
) comment '机构表'