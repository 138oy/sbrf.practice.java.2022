create table if not exists USERS
(
    ID       bigint auto_increment,
    USERNAME varchar not null,
    PASSWORD varchar not null,
    CREATED_AT timestamp not null,
    UPDATED_AT timestamp,
    constraint USERS_PK
        primary key (ID)

);

create unique index UDX_USERS_ID
    on USERS (ID);

create unique index UDX_USERS_USERNAME
    on USERS (USERNAME);

INSERT INTO "USERS" ("USERNAME", "PASSWORD", "CREATED_AT", "UPDATED_AT")
VALUES ('Charlie Scene', '$2a$10$/9aouasjYQw4/wwzSWEkdOwoRmEqg5cYHm6gQ0KnTK2QpLakSdHqW', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP()),
       ('J-Dog', '$2a$10$DIHrF7Nhig.z4eQ4RtvM3O6QKOhIsI6m..mVJjSwGli7vHP6FXf6W', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP()),
       ('Funny Man', '$2a$10$llE8XWDFCntFBROCqiYFQuk.akjbOSvw.he6EuySI6SUh3BuVnCRK', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP()),
       ('Johnny 3 Tears', '$2a$10$qxNP6DgdVOsazqML4NDMl.jmg1IgcMaRfczvAOWPBb78l744RH9gm', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP()),
       ('Danny', '$2a$10$YZhYqtiFQfHKGn6GK/eJxuP0vIJb2k9Xw4CYjk4B9fZ4SqKEX9KOi', CURRENT_TIMESTAMP(),
        CURRENT_TIMESTAMP());