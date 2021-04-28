create schema debt_app;
GRANT ALL ON `debt_app`.* TO 'admin'@'%';
/*
CREATE USER 'usuario'@'localhost' IDENTIFIED VIA mysql_native_password;
SET PASSWORD FOR 'usuario'@'localhost' = PASSWORD('patata');
CREATE DATABASE IF NOT EXISTS `usuario`;
GRANT ALL PRIVILEGES ON `usuario`.* TO 'usuario'@'localhost';*/

create table client
(
    identification varchar(15) not null,
    name           varchar(60) not null,
    email          varchar(60) not null,
    constraint client_email_uindex
        unique (email),
    constraint client_identification_uindex
        unique (identification)
)
    comment 'tabla de clientes de la deuda';

alter table client
    add primary key (identification);

create table debt
(
    id                    varchar(15) not null
        primary key,
    amount                bigint      not null,
    due_date              date        not null,
    client_identification varchar(15) null,
    constraint debt_client_identification_fk
        foreign key (client_identification) references client (identification)
)
    comment 'deuda';
