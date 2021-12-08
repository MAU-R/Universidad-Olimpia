package yo.merengues.schoolapi.data.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import yo.merengues.schoolapi.data.Repository.MaestroRepository;
import yo.merengues.schoolapi.data.db.jdbcConfig;
import yo.merengues.schoolapi.model.Maestro;

@Repository
@Component
@Primary
public class MaestroDAO extends jdbcConfig implements MaestroRepository {

    @Override
    public int save(Maestro Maestro){
        return jdbcTemplate.update("INSERT INTO maestros(nombre, apellido_paterno, apellido_materno, correo,foto,contraseña)values(?,?,?,?,?,?)",
         Maestro.getNombre(),Maestro.getApellido_paterno(),Maestro.getApellido_materno(),Maestro.getCorreo(),Maestro.getFoto(),Maestro.getContraseña());
    }
    @Override
   public int update(Maestro Maestro){
    return jdbcTemplate.update("UPDATE maestros SET nombre=?, apellido_paterno=?, apellido_materno=?, correo=?,foto=?,contraseña=? where matricula=?",
    Maestro.getNombre(),Maestro.getApellido_paterno(),Maestro.getApellido_materno(),Maestro.getCorreo(),Maestro.getFoto(),Maestro.getContraseña(),Maestro.getMatricula());
    }
    @Override
   public Maestro findById(int id){
    try{
        Maestro Maestro = jdbcTemplate.queryForObject(
            "SELECT * FROM  maestros where matricula =?", BeanPropertyRowMapper.newInstance(Maestro.class),id);
        return Maestro;
        }catch(IncorrectResultSizeDataAccessException e){
        System.out.println(e);
            return null;
    }
   }
   @Override
   public int deleteById(int id){
        return jdbcTemplate.update("DELETE FROM maestros WHERE matricula =?",id);
    }
    @Override
  public  List<Maestro> findAll(){
    
        return jdbcTemplate.query("SELECT * FROM maestros", BeanPropertyRowMapper.newInstance(Maestro.class));
    
    }
    @Override
   public int deleteAll(){
        return jdbcTemplate.update("Delete from maestros");
    }
}
