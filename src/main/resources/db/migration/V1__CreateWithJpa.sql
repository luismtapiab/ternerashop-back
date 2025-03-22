create table buyer (age integer, date_of_birth date, id integer generated by default as identity, created_at timestamp(6), updated_at timestamp(6), address varchar(255), first_name varchar(255), last_name varchar(255), phone_number varchar(255), primary key (id));
create table group_purchase (end_date date, final_price integer, id integer not null, minimal_group integer, product_id integer, start_date date, status varchar(255) check (status in ('WaitingForMore','ReadyToBePicked','AllItemsGone','Cancelled')), primary key (id));
create table product (id integer generated by default as identity, price integer, stock integer, image varchar(255), name varchar(255), primary key (id));
create table vendor (age integer, date_of_birth date, id integer generated by default as identity, created_at timestamp(6), updated_at timestamp(6), address varchar(255), first_name varchar(255), last_name varchar(255), phone_number varchar(255), primary key (id));
alter table if exists group_purchase add constraint FK2uhdugohv1ea7u6yct2bkp8e7 foreign key (product_id) references product;
