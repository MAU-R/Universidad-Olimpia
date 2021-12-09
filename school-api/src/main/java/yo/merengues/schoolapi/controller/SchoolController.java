package yo.merengues.schoolapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yo.merengues.schoolapi.data.Repository.AlumnoRepository;
import yo.merengues.schoolapi.data.Repository.DetalleRepository;
import yo.merengues.schoolapi.data.Repository.MaestroRepository;
import yo.merengues.schoolapi.data.Repository.MateriaRepository;
import yo.merengues.schoolapi.model.Alumno;
import yo.merengues.schoolapi.model.DetalleMateria;
import yo.merengues.schoolapi.model.Maestro;
import yo.merengues.schoolapi.model.Materia;
import yo.merengues.schoolapi.model.detalleMaterias;



@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    DetalleRepository detalleMateria;
    @Autowired
    MateriaRepository materiaRepository;
    @Autowired
    MaestroRepository maestroRepository;
    @GetMapping(value="/get/alumnos")
    public List<Alumno> getAlumnos() {
        List<Alumno> alumnos=  alumnoRepository.findAll();
        return alumnos;
    }
    @GetMapping(value="/get/alumno/{id}")
    public ResponseEntity<Alumno> getAlumno(@PathVariable int id) {
       Alumno alumnos=  alumnoRepository.findById(id);
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
    @GetMapping(value="/get/maestro/{id}")
    public ResponseEntity<Maestro> getMaestro(@PathVariable int id) {
       Maestro maestro=  maestroRepository.findById(id);
        return new ResponseEntity<>(maestro, HttpStatus.OK);
    }
    @GetMapping(value="/get/alumnos/{id}")
    public ResponseEntity<List<Alumno>> getAlumnos(@PathVariable String id) {
        List<Alumno> alumnos=  detalleMateria.findAlumnos(id);
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
    @PostMapping("/login/alumno")
    public ResponseEntity<Alumno> login(@RequestBody Alumno alumno){
        Alumno alumnoLog= alumnoRepository.login(alumno);
        return new ResponseEntity<>(alumnoLog, HttpStatus.OK);
    }
    @PostMapping("/login/maestro")
    public ResponseEntity<Maestro> loginMaestro(@RequestBody Maestro maestro){
        Maestro alumnoLog= maestroRepository.login(maestro);
        return new ResponseEntity<>(alumnoLog, HttpStatus.OK);
    }
    @PostMapping("edit/alumno")
    public ResponseEntity<Alumno> editAlumno(@RequestBody Alumno alumno){
      int x= alumnoRepository.update(alumno);
      if(x==0){
        return new ResponseEntity<>(alumno,HttpStatus.CONFLICT);
      }
      else{
          return new ResponseEntity<>(alumno,HttpStatus.OK);
      }
    }

    @PostMapping("edit/maestro")
    public ResponseEntity<Maestro> editMaestro(@RequestBody Maestro maestro){
      int x= maestroRepository.update(maestro);
      if(x==0){
        return new ResponseEntity<>(maestro,HttpStatus.CONFLICT);
      }
      else{
          return new ResponseEntity<>(maestro,HttpStatus.OK);
      }
    }

    @GetMapping("get/detalle/{id}/{ida}")
        public ResponseEntity<DetalleMateria> getMateria(@PathVariable String id, @PathVariable int ida){
            System.out.println(id);
            System.out.println(ida);
           try{
            DetalleMateria det = detalleMateria.findByIdAndAlumnoId(id,ida);
            System.out.println(det.getId());
            System.out.println(det.getId_alumno());
            Materia materia = materiaRepository.findById(det.getId_materia());
            detalleMaterias detalle = new detalleMaterias();
            
            detalle.materia=materia;
            detalle.detalleMateria=det;
            return new ResponseEntity<>(det,HttpStatus.OK);
           }catch(Exception e){
               System.out.println(e);
               return new ResponseEntity<>(null,HttpStatus.CONFLICT);
           }
        }
        @GetMapping("get/detalle/maestro/{id}/{ida}")
        public ResponseEntity<DetalleMateria> getMateriaMaestro(@PathVariable String id, @PathVariable int ida){
            System.out.println(id);
            System.out.println(ida);
           try{
            DetalleMateria det = detalleMateria.findByIdAndAlumnoId(id,ida);
            System.out.println(det.getId());
            System.out.println(det.getId_alumno());
            Materia materia = materiaRepository.findById(det.getId_materia());
            detalleMaterias detalle = new detalleMaterias();
            
            detalle.materia=materia;
            detalle.detalleMateria=det;
            return new ResponseEntity<>(det,HttpStatus.OK);
           }catch(Exception e){
               System.out.println(e);
               return new ResponseEntity<>(null,HttpStatus.CONFLICT);
           }
        }
    @GetMapping("get/materias/maestro/{id}")
        public ResponseEntity<List<Materia>> getMateriasMaestro(@PathVariable int id){
            List<DetalleMateria> detmaterias= detalleMateria.findAllByMaestroId(id);
            List<Materia> materias = new ArrayList<>();
            for (DetalleMateria detalleMateria : detmaterias) {
                materias.add(materiaRepository.findById(detalleMateria.getId_materia()));
            }
            return new ResponseEntity<>(materias,HttpStatus.OK);
        }
    
    @GetMapping("get/materias/alumnos/{id}")
        public ResponseEntity<List<Materia>> getAlumnosMaestro(@PathVariable int id){
            List<DetalleMateria> detmaterias= detalleMateria.findAllByAlumnosId(id);
            List<Materia> materias = new ArrayList<>();
            for (DetalleMateria detalleMateria : detmaterias) {
                materias.add(materiaRepository.findById(detalleMateria.getId_materia()));
            }
            return new ResponseEntity<>(materias,HttpStatus.OK);
        }
        @GetMapping("get/materia/{id}")
        public ResponseEntity<Materia> getMateriaID(@PathVariable int id){
           Materia materia= materiaRepository.findById(id);
            return new ResponseEntity<>(materia,HttpStatus.OK);
        }
    @PostMapping("edit/detalle")
    public ResponseEntity<DetalleMateria> editDetalle(@RequestBody DetalleMateria detalle){
      int x= detalleMateria.update(detalle);
      if(x==0){
        return new ResponseEntity<>(detalle,HttpStatus.CONFLICT);
      }else{
        return new ResponseEntity<>(detalle,HttpStatus.OK);
      }
    }
}
