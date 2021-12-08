package yo.merengues.schoolapi.data.Repository;

import java.util.List;

import yo.merengues.schoolapi.model.Materia;
public interface MateriaRepository {
    int save(Materia Materia);

    int update(Materia Materia);

    Materia findById(int id);

    int deleteById(int id);
  
    List<Materia> findAll();
  
    int deleteAll();
}
