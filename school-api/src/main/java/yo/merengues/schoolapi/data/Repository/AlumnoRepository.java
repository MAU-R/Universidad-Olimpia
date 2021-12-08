package yo.merengues.schoolapi.data.Repository;


import java.util.List;

import yo.merengues.schoolapi.model.Alumno;

public interface AlumnoRepository {
    int save(Alumno alumno);

    int update(Alumno alumno);

    Alumno findById(int id);

    int deleteById(int id);
  
    List<Alumno> findAll();
  
    int deleteAll();

    Alumno login(Alumno alumno);
}
