package yo.merengues.schoolapi.data.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import yo.merengues.schoolapi.data.Repository.AlumnoRepository;
import yo.merengues.schoolapi.data.db.jdbcConfig;
import yo.merengues.schoolapi.model.Alumno;

@Repository
@Component
@Primary
public class AlumnoDAO extends jdbcConfig implements AlumnoRepository {

   
    @Override
    public int save(Alumno alumno){
        return jdbcTemplate.update("INSERT INTO alumnos(nombre, apellido_paterno, apellido_materno, correo,foto,contraseña)values(?,?,?,?,?,?)",
         alumno.getNombre(),alumno.getApellido_paterno(),alumno.getApellido_materno(),alumno.getCorreo(),alumno.getFoto(),alumno.getContraseña());
    }
    @Override
   public int update(Alumno alumno){
    return jdbcTemplate.update("UPDATE alumnos SET nombre=?, apellido_paterno=?, apellido_materno=?, correo=?,foto=?,contraseña=? where matricula=?",
    alumno.getNombre(),alumno.getApellido_paterno(),alumno.getApellido_materno(),alumno.getCorreo(),alumno.getFoto(),alumno.getContraseña(),alumno.getMatricula());
    }
    @Override
   public Alumno findById(int id){
    try{
        Alumno alumno = jdbcTemplate.queryForObject(
            "SELECT * FROM  alumnos where matricula =?", BeanPropertyRowMapper.newInstance(Alumno.class),id);
        return alumno;
        }catch(IncorrectResultSizeDataAccessException e){
        System.out.println(e);
            return null;
    }
   }
   @Override
   public int deleteById(int id){
        return jdbcTemplate.update("DELETE FROM alumnos WHERE matricula =?",id);
    }
    @Override 
  public  List<Alumno> findAll(){
    
        return jdbcTemplate.query("SELECT * FROM alumnos", BeanPropertyRowMapper.newInstance(Alumno.class));
    
    }
    @Override 
   public int deleteAll(){
        return jdbcTemplate.update("Delete from alumnos");
    }
}
