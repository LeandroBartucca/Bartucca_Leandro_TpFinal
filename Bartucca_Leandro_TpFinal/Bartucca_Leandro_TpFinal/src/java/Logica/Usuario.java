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
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id_user;
    @Basic
    String nombre_usuario;
    String contrasenia;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true) // con lo ultimo hago que me elimine las reservas de ese usuario
    List<Reserva> listaReservasUsu;

    public Usuario() {
        listaReservasUsu = new ArrayList();
    }

    public Usuario(long id_user, String nombre_usuario, String contrasenia, List<Reserva> listaReservasUsu) {
        this.id_user = id_user;
        this.nombre_usuario = nombre_usuario;
        this.contrasenia = contrasenia;
        this.listaReservasUsu = listaReservasUsu;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Reserva> getListaReservasUsu() {
        return listaReservasUsu;
    }

    public void setListaReservasUsu(List<Reserva> listaReservasUsu) {
        this.listaReservasUsu = listaReservasUsu;
    }

}
