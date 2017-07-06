CREATE TABLE players
(     id bigint NOT NULL PRIMARY KEY
    , login varchar(255) NOT NULL
    , firstname varchar(255) NOT NULL
    , lastname varchar(255) NOT NULL
    , password varchar(255) NOT NULL
    , email varchar(255) NOT NULL
    , role_id integer NOT NULL
);