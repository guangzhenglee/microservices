create table order_operate_history
(
    id           bigint    not null auto_increment,
    order_id     bigint comment '订单id',
    operate_name varchar(100) comment '操作人：用户；系统；后台管理员',
    order_status int(1) comment '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
    create_time  timestamp not null default current_timestamp,
    updated_time timestamp not null default current_timestamp on update current_timestamp,
    primary key (id),
    index        idx_order_operate_history_order_id (order_id)
);
