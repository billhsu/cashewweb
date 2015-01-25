create table if not exists accounts (
  id BIGINT identity,
  username varchar(25) not null,
  password varchar(64) not null,
  email varchar(50) not null,
  date_joined datetime not null
);

create table if not exists sketches (
  id BIGINT identity,
  owner_id BIGINT,
  filename varchar(256),
  desc varchar(512),
  date_uploaded datetime not null
);
