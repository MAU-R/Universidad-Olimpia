create database if not exists school;
use school;
 
 create table if not exists alumnos(
 matricula int not null primary key auto_increment,
 nombre nvarchar(50) not null,
 apellido_paterno nvarchar(50) not null,
 apellido_materno nvarchar(50) not null,
 correo nvarchar(50),
 foto nvarchar(250),
 contraseña nvarchar(50) not null
 );
 
  create table if not exists maestros(
 matricula int not null primary key auto_increment,
 nombre nvarchar(50) not null,
 apellido_paterno nvarchar(50) not null,
 apellido_materno nvarchar(50) not null,
 correo nvarchar(50),
 foto nvarchar(250),
 contraseña nvarchar(50) not null
 );

  create table if not exists materias(
 matricula int not null primary key auto_increment,
 nombre nvarchar(50) not null,
 descripcion nvarchar(250),
 foto nvarchar(250)
 );

  create table if not exists detalle_materia(
 id int not null primary key auto_increment,
 matricula nvarchar(35) not null,
 id_alumno int,
 id_maestro int,
 id_materia int not null default(1) ,
 dias nvarchar(35),
 horas nvarchar(35),
 fecha_inicio date,
 calificacion_1 float,
 calificacion_2 float,
 calificacion_3 float,
 concluido bool default(false),
 foreign key (id_alumno) references alumnos(matricula),
 foreign key (id_maestro) references maestros(matricula),
 foreign key (id_materia) references materias(matricula)
 );