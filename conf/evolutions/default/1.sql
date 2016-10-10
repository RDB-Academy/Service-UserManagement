# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table credential (
  id                            bigint not null,
  profile_id                    bigint,
  password                      varchar(255),
  constraint uq_credential_profile_id unique (profile_id),
  constraint pk_credential primary key (id)
);
create sequence credential_seq;

create table profile (
  id                            bigint not null,
  email                         varchar(255),
  constraint uq_profile_email unique (email),
  constraint pk_profile primary key (id)
);
create sequence profile_seq;

alter table credential add constraint fk_credential_profile_id foreign key (profile_id) references profile (id) on delete restrict on update restrict;


# --- !Downs

alter table credential drop constraint if exists fk_credential_profile_id;

drop table if exists credential;
drop sequence if exists credential_seq;

drop table if exists profile;
drop sequence if exists profile_seq;

