package Modelo;

public class Proveedor extends Persona {
    private int id;
    private String cuit;
    private String contacto;
    private String telefonoContacto;

    public Proveedor(){}

    public Proveedor(String nombre, String apellido, String dni, String genero, String nacionalidad, int id, String cuit, String contacto, String telefonoContacto) {
        super(nombre, apellido, dni, genero, nacionalidad);
        this.id = id;
        this.cuit = cuit;
        this.contacto = contacto;
        this.telefonoContacto = telefonoContacto;
    }

    public Proveedor(int id, String cuit, String contacto, String telefonoContacto) {
        this.id = id;
        this.cuit = cuit;
        this.contacto = contacto;
        this.telefonoContacto = telefonoContacto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + this.id +
                ", cuit='" + this.cuit + '\'' +
                ", contacto='" + this.contacto + '\'' +
                ", telefonoContacto='" + this.telefonoContacto + '\'' +
                '}';
    }
}
