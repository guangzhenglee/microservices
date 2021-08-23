create table product (
    id                   bigint not null auto_increment,
    category_id          bigint comment '分类id',
    name                 varchar(64) not null comment '商品名称',
    product_number           varchar(64) not null comment '货号',
    delete_status        int(1) comment '删除状态：0->未删除；1->已删除',
    publish_status       int(1) comment '上架状态：0->下架；1->上架',
    price                decimal(10,2) comment '价格',
    description          text comment '商品描述',
    unit                 varchar(16) comment '单位',
    create_time timestamp not null default current_timestamp,
    update_time timestamp not null default current_timestamp on update current_timestamp,
    primary key (id),
    constraint idx_product_category_id key (category_id),
    constraint idx_product_product_number key (product_number)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
