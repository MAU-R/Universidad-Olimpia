insert into alumnos(nombre, apellido_paterno,apellido_materno,correo,contraseña)values
("Mauricio","Ramirez","Castro","mr@outsome.com","1234"),
("Jose Ruben","Delgado","Perez","JD@outsome.com","4321"),
("Edgar","Perez","Nieto","pen@outsome.com","4321");

insert into maestros(nombre, apellido_paterno,apellido_materno,correo,contraseña)values
("Jesus","Monroy","B","JB@outsome.com","1234"),
("Andres","Manuel","Lopez","AML@outsome.com","4321");

insert into materias(nombre,descripcion)values
("Desarrollo colaborativo","Taller donde se enseña a desarrollar colaborando entre 2 o mas personas de forma remota y eficiente"),
("Desarrollo Android","Taller de introduccion a desarrollar aplicaciones usando kotlin y xml"),
("Modelos matematicos","Clase de algebra lineal"),
("Calculo integral","Clase de calculo integral");

insert into detalle_materia(matricula,id_materia,fecha_inicio)values
(concat(Date(NOW()),1),1,Date(NOW())),
(concat(Date(NOW()),2),2,Date(NOW())),
(concat(Date(NOW()),3),3,Date(NOW()));

insert into detalle_materia(matricula, id_materia, fecha_inicio, id_alumno, id_maestro, dias, horas)values
("2021-12-041", 1, "2021-12-04", 1, 1, "Lunes y Martes", "1"),
("2021-12-041", 1, "2021-12-04", 2, 1, "Lunes y Martes", "1"),
("2021-12-043", 1, "2021-12-04", 1, 1, "Lunes y Martes", "1"),
("2021-12-043", 1, "2021-12-04", 3, 1, "Lunes y Martes", "1"),
("2021-12-041", 1, "2021-12-04", 3, 1, "Lunes y Martes", "1");

insert into detalle_sucursal(id_usuario, id_sucursal)values
(9,2),
(18,3);


