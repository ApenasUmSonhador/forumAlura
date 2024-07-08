create table topic (
    id bigInt not null auto_increment,
    title varchar(255) not null,
    message varchar(500) not null,
    creation_date timestamp not null,
    primary key (id)
);
