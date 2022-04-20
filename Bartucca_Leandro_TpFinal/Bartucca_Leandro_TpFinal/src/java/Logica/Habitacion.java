package Logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Habitacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id_hab;
    @Basic
    String num_hab;
    String piso;
    String nombre;
    String tipo;
    float precio_noche;
    @OneToMany(mappedBy = "habitacion", cascade = CascadeType.ALL, orphanRemoval = true) // con lo ultimo hago que me elimine las reservas de esa habitacion
    List<Reserva> listaReservasHab;

    public Habitacion() {
        listaReservasHab = new ArrayList();

    }

    public Habitacion(int id_hab, String num_hab, String piso, String nombre, String tipo, float precio_noche, List<Reserva> listaReservasHab) {
        this.id_hab = id_hab;
        this.num_hab = num_hab;
        this.piso = piso;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio_noche = precio_noche;
        this.listaReservasHab = listaReservasHab;
    }

    public int getId_hab() {
        return id_hab;
    }

    public void setId_hab(int id_hab) {
        this.id_hab = id_hab;
    }

    public String getNum_hab() {
        return num_hab;
    }

    public void setNum_hab(String num_hab) {
        this.num_hab = num_hab;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(float precio_noche) {
        this.precio_noche = precio_noche;
    }

    public List<Reserva> getListaReservasHab() {
        return listaReservasHab;
    }

    public void setListaReservasHab(List<Reserva> listaReservasHab) {
        this.listaReservasHab = listaReservasHab;
    }

}
