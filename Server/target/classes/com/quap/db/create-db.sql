DROP TABLE IF EXISTS users, participants, chatrooms, friends;

--shows the user information
CREATE TABLE users
(
    id         integer primary key generated always as identity,
    name       varchar unique not null check (length(name) <= 12 and length(name) >= 4),
    password   varchar        not null check (length(password) <= 12 and length(password) >= 8),
    created_at timestamp      not null default now()
);

--shows the chatroom information
CREATE TABLE chatrooms
(
    id         integer primary key generated always as identity,
    name       varchar   not null check (length(name) <= 12 and length(name) >= 4),
    friend_id  integer unique references friends ON DELETE CASCADE,
    created_at timestamp not null default now()
);

--shows the chatrooms to each user
CREATE TABLE participants
(
    user_id     integer   NOT NULL references users (id) ON DELETE CASCADE,
    chatroom_id integer   NOT NULL references chatrooms (id) ON DELETE CASCADE,
    created_at  timestamp not null default now(),
    unique (user_id, chatroom_id)
);

--shows that two users are friends
CREATE TABLE friends
(
    id         integer primary key generated always as identity,
    friend1_id integer   NOT NULL references users (id) ON DELETE CASCADE,
    friend2_id integer   NOT NULL references users (id) ON DELETE CASCADE,
    created_at timestamp not null default now(),
    unique (friend1_id, friend2_id)
);
