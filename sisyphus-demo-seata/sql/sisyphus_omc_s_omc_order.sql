create table sisyphus_omc.s_omc_order
(
    id               bigint auto_increment comment 'ID'
        primary key,
    version          int                      default 0                 not null comment 'version',
    order_no         varchar(20) charset utf8 default ''                null comment 'order id',
    user_id          bigint                                             null comment 'user id',
    shipping_id      bigint                                             null comment 'shipping_id',
    payment          decimal(20, 2)                                     null comment 'payment',
    payment_type     int(4)                   default 1                 not null comment 'payment,1-pay online',
    postage          decimal(20, 2)           default 0.00              null comment 'postage',
    status           int(10)                  default 0                 null comment 'order status:0-cancel-10-unpay，20-paid，40-shipped，50-success，60-finish',
    payment_time     datetime                                           null comment 'payment time',
    send_time        datetime                                           null comment 'send delivery time',
    end_time         datetime                                           null comment 'order finish time',
    close_time       datetime                                           null comment 'order close time',
    creator_id       varchar(32) charset utf8                           null comment 'creator id
',
    gmt_created      datetime                 default CURRENT_TIMESTAMP null comment 'create time',
    last_operator    varchar(20) charset utf8                           null comment 'last modifier name',
    last_operator_id varchar(32) charset utf8                           null comment 'last modifier id',
    gmt_modified     datetime                 default CURRENT_TIMESTAMP null comment 'last modifier time',
    is_deleted       int                      default 0                 null,
    creator          varchar(32)              default ''                null,
)
    comment 'order';