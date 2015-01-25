drop table if exists accounts;
drop table if exists sketches;

create table accounts (
  id BIGINT identity primary key,
  username varchar(25) not null,
  password varchar(64) not null,
  email varchar(50) not null,
  date_joined datetime not null
);

create table sketches (
  id BIGINT identity primary key,
  owner_id BIGINT,
  filename varchar(256),
  desc varchar(512),
  date_uploaded datetime not null
);
