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
