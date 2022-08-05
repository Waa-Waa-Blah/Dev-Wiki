-- auto-generated definition
create table IF NOT EXISTS member
(
    member_id      bigint auto_increment
        primary key,
    account_active bit          not null,
    nickname       varchar(255) null,
    password       varchar(255) null,
    phone_number   varchar(255) null,
    real_name      varchar(255) null
);

-- auto-generated definition
create table IF NOT EXISTS board
(
    board_id  bigint auto_increment
        primary key,
    content   longtext     null,
    hit       bigint       not null,
    title     varchar(255) null,
    member_id bigint       null,
    constraint FKsds8ox89wwf6aihinar49rmfy
        foreign key (member_id) references member (member_id)
);

-- auto-generated definition
create table IF NOT EXISTS bookmark
(
    bookmark_id bigint auto_increment
        primary key,
    board_id    bigint null,
    member_id   bigint null,
    constraint FK5bm7rup91j277mc7gg63akie2
        foreign key (member_id) references member (member_id),
    constraint FK9ok583i44955hw16uacv1v9pv
        foreign key (board_id) references board (board_id)
);

-- auto-generated definition
create table IF NOT EXISTS record
(
    record_id bigint auto_increment
        primary key,
    content   longtext     null,
    hit       bigint       not null,
    title     varchar(255) null,
    version   bigint       not null,
    board_id  bigint       null,
    constraint FK2ic7u5j3vpdhc3hhv5rsmtm4o
        foreign key (board_id) references board (board_id)
);

-- auto-generated definition
create table IF NOT EXISTS file
(
    file_id     bigint auto_increment
        primary key,
    hash_name   varchar(255) null,
    origin_name varchar(255) null,
    path        varchar(255) null,
    board_id    bigint       null,
    constraint FKhxmhyint41lp428u8yxcy4alx
        foreign key (board_id) references board (board_id)
);

