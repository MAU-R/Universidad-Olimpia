package yo.merengues.schoolapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import yo.merengues.schoolapi.data.Repository.AlumnoRepository;
import yo.merengues.schoolapi.model.Alumno;
import yo.merengues.schoolapi.model.DetalleMateria;


@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    AlumnoRepository alumnoRepository;
    @Autowired
    DetalleMateria detalleMateria;
    @GetMapping(value="/get/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos() {
        List<Alumno> alumnos=  alumnoRepository.findAll();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
    @GetMapping(value="/get/alumno/{id}")
    public ResponseEntity<Alumno> getAlumno(@PathVariable int id) {
       Alumno alumnos=  alumnoRepository.findById(id);
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
    @GetMapping(value="/get/materias/{id}")
    public ResponseEntity<List<Alumno>> getMaterias(@PathVariable int id) {
        List<Alumno> alumnos=  alumnoRepository.findAll();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }
    
}
