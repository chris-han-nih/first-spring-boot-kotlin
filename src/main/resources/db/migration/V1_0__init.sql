create table issue
(
    id          bigint auto_increment
        primary key,
    user_id     bigint                               null,
    summary     varchar(255)                         null,
    description varchar(255)                         null,
    type        enum ('BUG', 'TASK', 'STORY')        null,
    priority    enum ('LOW', 'MEDIUM', 'HIGH')       null,
    status      enum ('OPEN', 'IN_PROGRESS', 'DONE') null,
    created_at  timestamp default CURRENT_TIMESTAMP  not null,
    updated_at  timestamp default CURRENT_TIMESTAMP  not null
);

create table comment
(
    id         bigint auto_increment
        primary key,
    created_at datetime(6)  null,
    updated_at datetime(6)  null,
    body       varchar(255) null,
    user_id    bigint       not null,
    issue_id   bigint       null,
    constraint FKomjg70m9sundkar1el2rtonrn
        foreign key (issue_id) references issue (id)
);

create table issue_comments
(
    issue_id    bigint not null,
    comments_id bigint not null,
    constraint UK_i2wsltp4dgthwf8ttsjnubl35
        unique (comments_id),
    constraint FKkhmlb7vhqq1anw92ijsoeilp1
        foreign key (issue_id) references issue (id),
    constraint FKtjg467psbei20vci3sfn9iak
        foreign key (comments_id) references comment (id)
);
