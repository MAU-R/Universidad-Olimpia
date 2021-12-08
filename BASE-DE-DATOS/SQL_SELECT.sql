select u.nombre, u.apellido_paterno,u.apellido_materno,u.foto,u.correo,u.contraseña,u.matricula from detalle_materia inner join alumnos u on detalle_materia.id_alumno= u.matricula;
use school;
select * from alumnos inner join detalle_materia on detalle_materia.id_alumno= alumnos.matricula where detalle_materia.matricula="2021-12-041";