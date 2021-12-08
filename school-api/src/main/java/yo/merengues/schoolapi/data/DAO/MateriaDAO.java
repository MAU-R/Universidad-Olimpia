package yo.merengues.schoolapi.data.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import yo.merengues.schoolapi.data.Repository.MateriaRepository;
import yo.merengues.schoolapi.data.db.jdbcConfig;
import yo.merengues.schoolapi.model.Materia;
@Repository
@Component
@Primary
public class MateriaDAO extends jdbcConfig implements MateriaRepository {

    
    @Override
    public int save(Materia materia){
        return jdbcTemplate.update("INSERT INTO materias(nombre, descripcion, fotovalues(?,?,?)",
        materia.getNombre(),materia.getDescripcion(),materia.getFoto()); 
    }
    @Override
  public int update(Materia materia){
    return jdbcTemplate.update("UPDATE materias SET nombre=?, descripcion=?, fotovalues=? where matricula =?",
    materia.getNombre(),materia.getDescripcion(),materia.getFoto(), materia.getMatricula()); 
  }
  @Override
  public  Materia findById(int id){
    try{
        Materia materia = jdbcTemplate.queryForObject("SELECT * FROM materias where matricula =?", 
        BeanPropertyRowMapper.newInstance(Materia.class),id);
        return materia;
    }catch(IncorrectResultSizeDataAccessException e){
        System.out.println(e);
        return null;
    }
  }
  @Override
  public int deleteById(int id){
    return jdbcTemplate.update("DELETE FROM materias WHERE matricula =?",id);
}
@Override
public  List<Materia> findAll(){

    return jdbcTemplate.query("SELECT * FROM materias", BeanPropertyRowMapper.newInstance(Materia.class));

}
@Override
public int deleteAll(){
    return jdbcTemplate.update("Delete from materias");
}

}
