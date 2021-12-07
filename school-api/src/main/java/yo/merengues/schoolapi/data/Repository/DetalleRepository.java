package yo.merengues.schoolapi.data.Repository;

import java.util.List;

import yo.merengues.schoolapi.model.Alumno;
import yo.merengues.schoolapi.model.DetalleMateria;
import yo.merengues.schoolapi.model.Materia;
public interface DetalleRepository {
    int save(DetalleMateria DetalleMateria);

    int update(DetalleMateria DetalleMateria);

    int updateMateria(int id);

    int updateAlumno(int id);

    int updateMaestro(int id);

    DetalleMateria findById(String id);

    Materia findByAlumnoId(int id);

    DetalleMateria findByMateriaId(int id);

    DetalleMateria findByMaestroId(int id);

    List<Alumno> findAlumnos(int id);

    int deleteById(int id);
  
    List<DetalleMateria> findAll();
  
    int deleteAll();
}
