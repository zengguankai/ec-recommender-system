-- 全部字段未给默认值
CREATE TABLE `ecrecommender`.`user`
(
    `id`         int(0) NOT NULL AUTO_INCREMENT,
    `created_at` datetime(0) NOT NULL,
    `updated_at` datetime(0) NOT NULL,
    `telphone`   varchar(40)  NOT NULL,
    `password`   varchar(200) NOT NULL,
    `nick_name`  varchar(40)  NOT NULL,
    `gender`     int(0) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `telphone_unique_index`(`telphone`) USING BTREE
);

-- 除了时间字段都给了默认值
CREATE TABLE `ecrecommender`.`seller`  (
                           `id` int(0) NOT NULL AUTO_INCREMENT,
                           `name` varchar(80) NOT NULL DEFAULT '',
                           `created_at` datetime(0) NOT NULL ,
                           `updated_at` datetime(0) NOT NULL ,
                           `remark_score` decimal(2, 1) NOT NULL DEFAULT 0,
                           `disabled_flag` int(0) NOT NULL DEFAULT 0,
                           PRIMARY KEY (`id`)
);


CREATE TABLE `ecrecommender`.`category`  (
                             `id` int(0) NOT NULL AUTO_INCREMENT,
                             `created_at` datetime(0) NOT NULL ,
                             `updated_at` datetime(0) NOT NULL ,
                             `name` varchar(20) NOT NULL DEFAULT '',
                             `icon_url` varchar(200) NOT NULL DEFAULT '',
                             `sort` int(0) NOT NULL DEFAULT 0,
                             PRIMARY KEY (`id`),
                             UNIQUE INDEX `name_unique_index`(`name`) USING BTREE
);


CREATE TABLE `ecrecommender`.`shop`  (
                                         `id` int(0) NOT NULL AUTO_INCREMENT,
                                         `created_at` datetime(0) NOT NULL,
                                         `updated_at` datetime(0) NOT NULL,
                                         `name` varchar(80) NOT NULL DEFAULT '',
                                         `remark_score` decimal(2, 1) NOT NULL DEFAULT 0,
                                         `price_per_man` int(0) NOT NULL DEFAULT 0,
                                         `latitude` decimal(10, 6) NOT NULL DEFAULT 0,
                                         `longitude` decimal(10, 6) NOT NULL DEFAULT 0,
                                         `category_id` int(0) NOT NULL DEFAULT 0,
                                         `tags` varchar(2000) NOT NULL DEFAULT '',
                                         `start_time` varchar(200) NOT NULL DEFAULT '',
                                         `end_time` varchar(200) NOT NULL DEFAULT '',
                                         `address` varchar(200) NOT NULL DEFAULT '',
                                         `seller_id` int(0) NOT NULL DEFAULT 0,
                                         `icon_url` varchar(100) NOT NULL DEFAULT '',
                                         PRIMARY KEY (`id`)
);