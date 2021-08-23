create table order_item
(
    id                  bigint not null auto_increment,
    order_id            bigint comment '订单id',
    product_id          bigint comment '商品id',
    product_name        varchar(200) comment '商品名称',
    product_number      varchar(64) comment '商品条码',
    product_price       decimal(10, 2) comment '销售价格',
    product_quantity    int comment '购买数量',
    product_sku_id      bigint comment '商品sku编号',
    product_sku_code    varchar(50) comment '商品sku条码',
    product_category_id bigint comment '商品分类id',
    product_attr        varchar(500) comment '商品销售属性:[{"key":"颜色","value":"颜色"},{"key":"容量","value":"4G"}]',
    primary key (id),
    constraint          idx_order_item_order_id key (order_id),
    constraint          idx_order_item_product_id key (product_id),
    constraint          idx_order_item_order_id_product_id key (order_id, product_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
