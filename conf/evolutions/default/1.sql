# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table profile (
  id                            bigint auto_increment not null,
  email                         varchar(255) not null,
  password                      varchar(255) not null,
  username                      varchar(255) not null,
  constraint uq_profile_email unique (email),
  constraint uq_profile_username unique (username),
  constraint pk_profile primary key (id)
);


# --- !Downs

drop table if exists profile;

