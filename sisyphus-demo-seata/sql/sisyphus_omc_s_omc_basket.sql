create table sisyphus_omc.s_omc_basket
(
    id               bigint auto_increment comment 'ID'
        primary key,
    version          int      default 0                 null comment 'version',
    user_id          bigint                             not null comment 'userid',
    product_id       bigint                             not null comment 'product id',
    quantity         int                                null comment 'quantity',
    checked          int                                null comment 'checked,1=yes,0=no',
    creator          varchar(20) charset utf8           null comment 'creator',
    creator_id       varchar(32) charset utf8           null comment 'creator id
',
    gmt_created      datetime default CURRENT_TIMESTAMP null comment 'create time',
    last_operator    varchar(20) charset utf8           null comment 'last modifier name',
    last_operator_id varchar(32) charset utf8           null comment 'last modifier id',
    gmt_modified     datetime default CURRENT_TIMESTAMP null comment 'last modifier time',
    is_deleted       int      default 0                 null
)
    comment 'basket';