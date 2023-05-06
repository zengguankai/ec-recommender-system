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