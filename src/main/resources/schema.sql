create table if not exists "transactions"
(
    id      uuid  default random_uuid() primary key,
    amount  int,
    timestamp_data timestamp,
    reference varchar(255),
    slogan varchar(255),
    owner varchar(255)
);

