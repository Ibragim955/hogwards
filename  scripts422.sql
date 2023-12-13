create table expenses
(
    id       integer default nextval('table_name_id_seq'::regclass) not null,
    name     text                                                   not null,
    date     date                                                   not null,
    category text                                                           ,
    amount   integer                                                not null
)