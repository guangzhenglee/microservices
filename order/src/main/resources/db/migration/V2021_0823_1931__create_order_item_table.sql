create table order_item
(
    id                bigint    not null auto_increment,
    order_id          bigint comment '订单id',
    product_id        bigint comment '商品id',
    purchase_quantity int comment '购买数量',
    product_name      varchar(200) comment '商品名称',
    product_number    varchar(64) comment '商品条码',
    product_price     decimal(10, 2) comment '销售价格',
    product_sku_id    bigint comment '商品sku编号',
    product_sku_code  varchar(50) comment '商品sku条码',
    create_time       timestamp not null default current_timestamp,
    updated_time      timestamp not null default current_timestamp on update current_timestamp,
    primary key (id),
    index             idx_order_item_order_id (order_id),
    index             idx_order_item_product_id (product_id),
    index             idx_order_item_order_id_product_id (order_id, product_id)
);
