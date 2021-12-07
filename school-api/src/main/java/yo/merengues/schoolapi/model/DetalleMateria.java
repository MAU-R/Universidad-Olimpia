package yo.merengues.schoolapi.model;

import java.sql.Date;

public class DetalleMateria {
    private String id;
    private int id_alumno;
    private int id_maestro;
    private int id_materia;
    private String dias;
    private String hora;
    private Date fecha_inicio;
    private float calificacion_1;
    private float calificacion_2;
    private float calificacion_3;
    private Materia materia;
    private boolean concluido;

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
    
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setNombreMateria(String nombre) {
        this.materia.setNombre(nombre);
    }
    
    public void setDescripcionMateria(String descripcion) {
        this.materia.setDescripcion(descripcion);
    }

    public void setFotoMateria(String foto) {
        this.materia.setFoto(foto);
    }

    public DetalleMateria(){
        
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_maestro() {
        return id_maestro;
    }

    public void setId_maestro(int id_maestro) {
        this.id_maestro = id_maestro;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public float getCalificacion_1() {
        return calificacion_1;
    }

    public void setCalificacion_1(float calificacion_1) {
        this.calificacion_1 = calificacion_1;
    }

    public float getCalificacion_2() {
        return calificacion_2;
    }

    public void setCalificacion_2(float calificacion_2) {
        this.calificacion_2 = calificacion_2;
    }

    public float getCalificacion_3() {
        return calificacion_3;
    }

    public void setCalificacion_3(float calificacion_3) {
        this.calificacion_3 = calificacion_3;
    }

    @Override
    public String toString() {
        return "DetalleMateria{" + "id=" + id + ", id_alumno=" + id_alumno + ", id_maestro=" + id_maestro + ", id_materia=" + id_materia + ", dias=" + dias + ", hora=" + hora + ", fecha_inicio=" + fecha_inicio + ", calificacion_1=" + calificacion_1 + ", calificacion_2=" + calificacion_2 + ", calificacion_3=" + calificacion_3 + ", materia=" + materia + ", concluido=" + concluido + '}';
    }

   
}
