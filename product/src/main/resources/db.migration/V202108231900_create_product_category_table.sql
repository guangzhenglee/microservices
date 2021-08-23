create table product_category (
    id                   bigint not null auto_increment,
    parent_id            bigint comment '上级分类的编号：0表示一级分类',
    name                 varchar(64) comment '名称',
    level                int(1) comment '分类级别：0->1级；1->2级',
    create_time timestamp not null default current_timestamp,
    update_time timestamp not null default current_timestamp on update current_timestamp,
    primary key (id),
    constraint idx_product_category_parent_id key (parent_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
