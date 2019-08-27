package Modelo;

public class SubTipoMovimiento {
    private static int INGRESO = 1;
    private static int EGRESO = 2;
    private int id;
    private String descripcion;

    public SubTipoMovimiento(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
        return "SubTipoMovimiento{" +
                "id=" + this.id +
                ", descripcion='" + this.descripcion + '\'' +
                '}';
    }
}
