create database Papeleria;
use Papeleria;
create table Roleas(id_rol int primary key auto_increment , descripcion varchar(30));
insert into Roleas(descripcion) values("Administrador");
insert into Roleas(descripcion) values("Empleado");