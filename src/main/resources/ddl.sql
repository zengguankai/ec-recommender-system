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
CREATE TABLE `seller`  (
                           `id` int(0) NOT NULL AUTO_INCREMENT,
                           `name` varchar(80) NOT NULL DEFAULT '',
                           `created_at` datetime(0) NOT NULL ,
                           `updated_at` datetime(0) NOT NULL ,
                           `remark_score` decimal(2, 1) NOT NULL DEFAULT 0,
                           `disabled_flag` int(0) NOT NULL DEFAULT 0,
                           PRIMARY KEY (`id`)
);