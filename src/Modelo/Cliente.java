package Modelo;

public class Cliente extends Persona {

    private int id;
    private String descripcion;

    public Cliente(String nombre, String apellido, String dni, String genero, String nacionalidad, int id, String descripcion) {
        super(nombre, apellido, dni, genero, nacionalidad);
        this.id = id;
        this.descripcion = descripcion;
    }

    public Cliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + this.id +
                ", descripcion='" + this.descripcion + '\'' +
                '}';
    }
}
