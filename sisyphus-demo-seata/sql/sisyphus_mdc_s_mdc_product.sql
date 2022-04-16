create table sisyphus_mdc.s_mdc_product
(
    id               bigint(32)                         not null comment 'ID'
        primary key,
    version          int      default 0                 not null comment 'version',
    product_code     varchar(20)                        not null comment 'product code',
    category_id      bigint(32)                         not null comment 'category id',
    name             varchar(100) charset utf8          not null comment 'commodity name',
    subtitle         varchar(200) charset utf8          null comment 'commodity sub name',
    main_image       varchar(500) charset utf8          null comment 'commodity main image url',
    sub_images       text charset utf8                  null comment 'commodity sub image url (json)',
    detail           text charset utf8                  null comment 'detail of commodity',
    price            decimal(20, 2)                     not null comment 'price ',
    stock            int                                not null comment 'stock',
    status           int(6)   default 1                 null comment 'status of commodity.1-on sale 2-take it down 3-deleted',
    creator                varchar(20)                default ''                null comment 'creator',
    creator_id             bigint                                               null comment 'creator id',
    gmt_created            datetime                   default CURRENT_TIMESTAMP null comment 'create time',
    last_operator          varchar(20)                default ''                null comment 'modifier',
    last_operator_id       bigint                                               null comment 'modifier id',
    gmt_modified           datetime                   default CURRENT_TIMESTAMP null comment 'modify time',
    is_deleted             int                        default 0                 null comment 'deleted or not'
)
    comment 'product(commodity) table';

INSERT INTO sisyphus_mdc.s_mdc_product (id, version, product_code, category_id, name, subtitle, main_image, sub_images, detail, price, stock, status, creator, creator_id, gmt_created, last_operator, last_operator_id, gmt_modified, is_deleted) VALUES (1, 0, '1', 100004, 'West Ham United FC vs Aston Villa FC', 'Sun, March 13, 2022 • 14:00 GMT+0', null, null, '
West Ham United FC vs Aston Villa FC  Sun, March 13, 2022 • 14:00 GMT+0 London Stadium, London, United Kingdom', 100.00, 24227, 1, 'admin', '1', '2022-03-02 15:16:42', null, null, '2022-03-02 15:16:42', 0);
INSERT INTO sisyphus_mdc.s_mdc_product (id, version, product_code, category_id, name, subtitle, main_image, sub_images, detail, price, stock, status, creator, creator_id, gmt_created, last_operator, last_operator_id, gmt_modified, is_deleted) VALUES (2, 0, '2', 100004, 'Everton vs Wolverhampton Wanderers FC', 'Sun, March 13, 2022 • 14:00 GMT+0', null, null, '
Everton vs Wolverhampton Wanderers FC  Sun, March 13, 2022 • 14:00 GMT+0 Goodison Park, Liverpool, United Kingdom', 145.00, 4141, 1, 'admin', '1', '2022-03-02 15:17:54', null, null, '2022-03-02 15:17:54', 0);
INSERT INTO sisyphus_mdc.s_mdc_product (id, version, product_code, category_id, name, subtitle, main_image, sub_images, detail, price, stock, status, creator, creator_id, gmt_created, last_operator, last_operator_id, gmt_modified, is_deleted) VALUES (3, 1, '3', 100002, 'The Power of the Dog', 'Sun, March 13, 2022 • 14:00 GMT+0', null, null, 'Broadway Cinema', 20.00, 121, 1, 'admin', '1', '2022-03-02 15:22:23', null, null, '2022-03-02 15:22:23', 0);
INSERT INTO sisyphus_mdc.s_mdc_product (id, version, product_code, category_id, name, subtitle, main_image, sub_images, detail, price, stock, status, creator, creator_id, gmt_created, last_operator, last_operator_id, gmt_modified, is_deleted) VALUES (4, 2, '4', 100001, 'Manchester MAN to Malta MLA', 'Sun, March 13, 2022 • 14:00 GMT+0', null, null, 'Manchester MAN to Malta MLA Sun, March 13, 2022 • 14:00 GMT+0', 123.00, 10, 1, 'admin', '1', '2022-03-02 15:23:46', null, null, '2022-03-02 15:23:46', 0);