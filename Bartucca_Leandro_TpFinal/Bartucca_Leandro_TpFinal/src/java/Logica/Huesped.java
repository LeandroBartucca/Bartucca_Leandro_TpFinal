package Logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Huesped extends Persona {

    @Basic
    String profesion;
    @OneToMany(mappedBy = "huesped", cascade = CascadeType.ALL, orphanRemoval = true) // con lo ultimo hago que me elimine las reservas de esa huesped
    List<Reserva> listaReservasHue;

    public Huesped() {
        listaReservasHue = new ArrayList();
    }

    public Huesped(String profesion, List<Reserva> listaReservasHue, int id, String dni, String nombre, String apellido, Date fecha_nac, String direccion) {
        super(id, dni, nombre, apellido, fecha_nac, direccion);
        this.profesion = profesion;
        this.listaReservasHue = listaReservasHue;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public List<Reserva> getListaReservasHue() {
        return listaReservasHue;
    }

    public void setListaReservasHue(List<Reserva> listaReservasHue) {
        this.listaReservasHue = listaReservasHue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
