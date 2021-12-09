package yo.merengues.schoolapi.data.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import yo.merengues.schoolapi.data.Repository.DetalleRepository;
import yo.merengues.schoolapi.data.db.jdbcConfig;
import yo.merengues.schoolapi.model.Alumno;
import yo.merengues.schoolapi.model.DetalleMateria;
import yo.merengues.schoolapi.model.Materia;

@Repository
@Component
@Primary
public class DetalleDAO extends jdbcConfig implements DetalleRepository{

    @Override
    public int save(DetalleMateria detalle){
        return jdbcTemplate.update("INSERT INTO detalle_materia(id_alumno, id_maestro, id_materia,dias,horas,fecha_inicio,calificacion_1,calificacion_2,calificacion_3)values(?,?,?,?,?,?,?,?,?)",
         detalle.getId_alumno(),detalle.getId_maestro(),detalle.getId_materia(),detalle.getDias(),detalle.getHora(),detalle.getFecha_inicio(),detalle.getCalificacion_1(),detalle.getCalificacion_2(),detalle.getCalificacion_3());
    }
    @Override
   public int update(DetalleMateria detalle){
    return jdbcTemplate.update("UPDATE  detalle_materia SET id_alumno=?, id_maestro=?, id_materia=?,dias=?,horas=?,fecha_inicio=?,calificacion_1=?,calificacion_2=?,calificacion_3=? WHERE id=?",
    detalle.getId_alumno(),detalle.getId_maestro(),detalle.getId_materia(),detalle.getDias(),detalle.getHora(),detalle.getFecha_inicio(),detalle.getCalificacion_1(),detalle.getCalificacion_2(),detalle.getCalificacion_3(),detalle.getId());
    }
    @Override
    public int updateMateria(int id){
        return jdbcTemplate.update("UPDATE detalle_materia SET id_materia=?", id);
    }
    @Override
    public int updateAlumno(int id){
        return jdbcTemplate.update("UPDATE detalle_materia SET id_alumno=?", id);
    }
    @Override
    public int updateMaestro(int id){
        return jdbcTemplate.update("UPDATE detalle_materia SET id_maestro=?", id);
    }
    @Override
    public DetalleMateria findById(String id){
    try{
        DetalleMateria detalle = jdbcTemplate.queryForObject(
            "SELECT * FROM  detalle_materia where matricula =?", BeanPropertyRowMapper.newInstance(DetalleMateria.class),id);
        return detalle;
        }catch(IncorrectResultSizeDataAccessException e){
        System.out.println(e);
            return null;
    }
   }
   @Override
   public DetalleMateria findByIdAndAlumnoId(String id, int a){
   try{
       DetalleMateria detalle = jdbcTemplate.queryForObject(
           "SELECT * FROM  detalle_materia where matricula =? and id_alumno=?", BeanPropertyRowMapper.newInstance(DetalleMateria.class),id,a);
       return detalle;
       }catch(IncorrectResultSizeDataAccessException e){
       System.out.println(e);
           return null;
   }
  }
  @Override
  public DetalleMateria findByIdAndMaestroId(String id, int a){
  try{
      DetalleMateria detalle = jdbcTemplate.queryForObject(
          "SELECT * FROM  detalle_materia where matricula =? and id_maestro=?", BeanPropertyRowMapper.newInstance(DetalleMateria.class),id,a);
      return detalle;
      }catch(IncorrectResultSizeDataAccessException e){
      System.out.println(e);
          return null;
  }
 }
   @Override
   public Materia findByAlumnoId(int id){
    try{
        Materia detalle = jdbcTemplate.queryForObject(
            "select m.nombre, m.descripcion  from detalle_materia det inner join materias m on m.matricula=det.id_alumno where det.id_alumno=?;", BeanPropertyRowMapper.newInstance(Materia.class),id);
        return detalle;
        }catch(IncorrectResultSizeDataAccessException e){
        System.out.println(e);
            return null;
    }
   }
   @Override
    public DetalleMateria findByMateriaId(int id){
        try{
            DetalleMateria detalle = jdbcTemplate.queryForObject(
                "SELECT * FROM  detalle_materia where id_materia =?", BeanPropertyRowMapper.newInstance(DetalleMateria.class),id);
            return detalle;
            }catch(IncorrectResultSizeDataAccessException e){
            System.out.println(e);
                return null;
        }
    }
    @Override
    public  DetalleMateria findByMaestroId(int id){
        try{
            DetalleMateria detalle = jdbcTemplate.queryForObject(
                "SELECT * FROM  detalle_materia where id_maestro =?", BeanPropertyRowMapper.newInstance(DetalleMateria.class),id);
            return detalle;
            }catch(IncorrectResultSizeDataAccessException e){
            System.out.println(e);
                return null;
        }
    }
    @Override
    public  List<DetalleMateria> findAllByMaestroId(int id){
        try{
            List<DetalleMateria> detalle = jdbcTemplate.query(
                "SELECT * FROM  detalle_materia where id_maestro =?", BeanPropertyRowMapper.newInstance(DetalleMateria.class),id);
            return detalle;
            }catch(IncorrectResultSizeDataAccessException e){
            System.out.println(e);
                return null;
        }
    }
    @Override
    public  List<DetalleMateria> findAllByAlumnosId(int id){
        try{
            List<DetalleMateria> detalle = jdbcTemplate.query(
                "SELECT * FROM  detalle_materia where id_alumno =?", BeanPropertyRowMapper.newInstance(DetalleMateria.class),id);
            return detalle;
            }catch(IncorrectResultSizeDataAccessException e){
            System.out.println(e);
                return null;
        }
    }
    @Override
    public List<Alumno> findAlumnos(String id){
        return jdbcTemplate.query(
            "select u.nombre, u.apellido_paterno,u.apellido_materno,u.foto,u.correo,u.contraseña,u.matricula from detalle_materia inner join alumnos u on detalle_materia.id_alumno= u.matricula where detalle_materia.matricula=?;",
             BeanPropertyRowMapper.newInstance(Alumno.class),id);
    }
    @Override
   public int deleteById(int id){
        return jdbcTemplate.update("DELETE FROM detalle_materia WHERE id =?",id);
    }
    @Override
  public  List<DetalleMateria> findAll(){
    
        return jdbcTemplate.query("SELECT * FROM detalle_materia", BeanPropertyRowMapper.newInstance(DetalleMateria.class));
    
    }
    @Override 
   public int deleteAll(){
        return jdbcTemplate.update("Delete from detalle_materia");
    } 
    
}
