DROP TABLE IF EXISTS T_BOOKING;
DROP TABLE IF EXISTS T_RACK;
DROP TABLE IF EXISTS T_TEAM_MEMBER;
DROP TABLE IF EXISTS T_RACK_ASSET;
DROP TABLE IF EXISTS T_TEAM;

create table t_team
(
    id               uuid      default gen_random_uuid() not null
        primary key,
    name             varchar(30),
    created_at       timestamp default CURRENT_TIMESTAMP not null,
    modified_at      timestamp,
    default_location varchar(10)                         not null
        constraint t_team_default_location_check
            check ((default_location)::text = ANY
        ((ARRAY ['LISBON'::character varying, 'PORTO'::character varying, 'BRAGA'::character varying])::text[])),
    product          varchar(30)
);

alter table t_team
    owner to postgres;

create table t_rack
(
    id               uuid      default gen_random_uuid() not null
        primary key,
    serial_number    varchar(20)                         not null,
    team_id          uuid
        constraint t_rack_team_id_foreign_key
            references t_team,
    created_at       timestamp default CURRENT_TIMESTAMP not null,
    is_reserved      boolean   default FALSE             not null,
    default_location varchar(10)                         not null
        constraint t_team_default_location_check
            check ((default_location)::text = ANY
                   (ARRAY [('LISBON'::character varying)::text, ('PORTO'::character varying)::text, ('BRAGA'::character varying)::text]))
);

alter table t_rack
    owner to postgres;

create table t_rack_asset
(
    id        uuid default gen_random_uuid() not null
        primary key,
    asset_tag varchar(10)   UNIQUE           not null,
    rack_id   uuid                           not null
        references t_rack
);

alter table t_rack_asset
    owner to postgres;

create table t_team_member
(
    id          uuid      default gen_random_uuid() not null
        primary key,
    team_id     uuid
        references t_team,
    ctw_id      varchar(8)                          not null
        constraint t_team_member_ctw_id_check
            check ((ctw_id)::text ~* 'ctw\d{4,5}'::text),
    name        varchar(30)                         not null
        constraint t_team_member_name_check
            check ((name)::text ~ '^[ a-zA-ZÀ-ÿ\s00f1\s00d1]*$'::text),
    created_at  timestamp default CURRENT_TIMESTAMP not null,
    modified_at timestamp
);

alter table t_team_member
    owner to postgres;

create table t_booking
(
    id           uuid      default gen_random_uuid() not null
        primary key,
    rack_id      uuid
        references t_rack,
    requester_id uuid
        references t_team_member,
    book_from    timestamp                           not null,
    book_to      timestamp                           not null,
    created_at   timestamp default CURRENT_TIMESTAMP not null,
    modified_at  timestamp
);

alter table t_booking
    owner to postgres;

