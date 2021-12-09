package yo.merengues.schoolapi.data.Repository;

import java.util.List;

import yo.merengues.schoolapi.model.Maestro;
public interface MaestroRepository {
    int save(Maestro Maestro);

    int update(Maestro Maestro);

    Maestro findById(int id);

    int deleteById(int id);
  
    List<Maestro> findAll();
  
    int deleteAll();

    Maestro login(Maestro maestro);
}
