package yo.merengues.schoolapi.model;

public class Materia {
    
    private int matricula;
    private String nombre;
    private String Descripcion;
    private String foto;

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    public Materia(){
        
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "Materia{" + "matricula=" + matricula + ", nombre=" + nombre + ", Descripcion=" + Descripcion + ", foto=" + foto + '}';
    }

   
    
}
