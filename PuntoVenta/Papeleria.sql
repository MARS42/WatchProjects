create database Papeleria;
use Papeleria;

/*Creacion del tabla Roles*/
create table Roleas(id_rol int primary key auto_increment , descripcion varchar(30));
insert into Roleas(descripcion) values("Administrador");
insert into Roleas(descripcion) values("Empleado");
/*Creacion de la tabla Usuarios  son los empleados y la administradora */
create table Usuarios(usarName varchar(50) primary key , nombreU varchar(30),password varchar(30),id_rol int , foreign key (id_rol)references Roleas (id_rol));
insert into Usuarios values ("Liz","Liz","12345",1);