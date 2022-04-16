create table sisyphus_omc.s_omc_order_detail
(
    id                 bigint auto_increment comment 'id'
        primary key,
    version            int                       default 0                 null comment 'version',
    detail_no          varchar(20) charset utf8  default ''                null comment 'Order detail serial number',
    user_id            bigint                                              null comment 'user id ',
    order_no           varchar(20) charset utf8  default ''                null comment 'order no',
    product_id         bigint                                              null comment 'product id',
    product_name       varchar(100) charset utf8 default ''                null comment 'product name',
    product_image      varchar(500) charset utf8 default ''                null comment 'product image',
    current_unit_price decimal(20, 2)                                      null comment 'price',
    quantity           int(10)                                             null comment 'quantity',
    total_price        decimal(20, 2)                                      null comment 'total_price',
    creator            varchar(20) charset utf8                            null comment 'creator',
    creator_id         varchar(32) charset utf8                            null comment 'creator id',
    gmt_created        datetime                  default CURRENT_TIMESTAMP null comment 'create time',
    last_operator      varchar(20) charset utf8                            null comment 'last modifier name',
    last_operator_id   varchar(32) charset utf8                            null comment 'last modifier id',
    gmt_modified       datetime                  default CURRENT_TIMESTAMP null comment 'last modifier time',
    is_deleted         int                       default 0                 null
)
    comment 'order detail';
