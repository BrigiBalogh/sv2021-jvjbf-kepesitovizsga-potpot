

 create table gardenworks (id bigint not null auto_increment,
   description varchar(255), done bit not null, answer varchar(255),
   created_at datetime(6), answered_at datetime(6),
   gardener_id bigint not null,
   primary key (id)
   foreign key (gardener_id) references gardener(id));

