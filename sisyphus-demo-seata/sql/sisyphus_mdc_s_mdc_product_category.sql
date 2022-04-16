create table sisyphus_mdc.s_mdc_product_category
(
    id               bigint                                 not null comment 'ID'
        primary key,
    version          int          default 0                 not null comment 'version',
    category_code    varchar(100) default ''                not null comment 'category code',
    img_id           bigint                                 null comment 'img id',
    pid              bigint                                 null comment 'parent id',
    name             varchar(50) charset utf8               null comment 'category name',
    status           tinyint(1)   default 1                 null comment 'status 1-normal,2-useless',
    sort_order       int(4)                                 null comment 'order code',
    creator                varchar(20)                default ''                null comment 'creator',
    creator_id             bigint                                               null comment 'creator id',
    gmt_created            datetime                   default CURRENT_TIMESTAMP null comment 'create time',
    last_operator          varchar(20)                default ''                null comment 'modifier',
    last_operator_id       bigint                                               null comment 'modifier id',
    gmt_modified           datetime                   default CURRENT_TIMESTAMP null comment 'modify time',
    is_deleted             int                        default 0                 null comment 'deleted or not'
)
    comment 'product category(commodity) table';

INSERT INTO sisyphus_mdc.s_mdc_product_category (id, version, category_code, img_id, pid, name, status, sort_order, creator, creator_id, gmt_created, last_operator, last_operator_id, gmt_modified, is_deleted) VALUES (100001, 1, '100001', null, 1, 'airplane ticket', 1, null, 'admin', '1', '2022-03-02 15:08:42', null, null, '2022-03-02 15:08:42', 0);
INSERT INTO sisyphus_mdc.s_mdc_product_category (id, version, category_code, img_id, pid, name, status, sort_order, creator, creator_id, gmt_created, last_operator, last_operator_id, gmt_modified, is_deleted) VALUES (100002, 2, '100002', null, 1, 'cinema ticket', 1, null, 'admin', '1', '2022-03-02 15:08:43', null, null, '2022-03-02 15:08:43', 0);
INSERT INTO sisyphus_mdc.s_mdc_product_category (id, version, category_code, img_id, pid, name, status, sort_order, creator, creator_id, gmt_created, last_operator, last_operator_id, gmt_modified, is_deleted) VALUES (100003, 3, '100003', null, 1, 'gallery ticket', 1, null, 'admin', '1', '2022-03-02 15:08:54', null, null, '2022-03-02 15:08:54', 0);
INSERT INTO sisyphus_mdc.s_mdc_product_category (id, version, category_code, img_id, pid, name, status, sort_order, creator, creator_id, gmt_created, last_operator, last_operator_id, gmt_modified, is_deleted) VALUES (100004, 4, '100004', null, 1, 'sports ticket', 1, null, 'admin', '1', '2022-03-02 15:09:17', null, null, '2022-03-02 15:09:17', 0);
INSERT INTO sisyphus_mdc.s_mdc_product_category (id, version, category_code, img_id, pid, name, status, sort_order, creator, creator_id, gmt_created, last_operator, last_operator_id, gmt_modified, is_deleted) VALUES (100005, 5, '100005', null, 1, 'museum ticket', 1, null, 'admin', '1', '2022-03-02 15:09:34', null, null, '2022-03-02 15:09:34', 0);