package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id_reserva;
    @ManyToOne()
    Habitacion habitacion;
    @ManyToOne
    Huesped huesped;
    @ManyToOne
    Usuario usuario;
    @Temporal(TemporalType.DATE)
    Date check_in;
    @Temporal(TemporalType.DATE)
    Date check_out;
    @Temporal(TemporalType.DATE)
    Date fecha_rsv;
    @Basic
    int cant_personas;
    int cant_noches;
    float precio_reserva;

    public Reserva() {
    }

    public Reserva(long id_reserva, Habitacion habitacion, Huesped huesped, Usuario usuario, Date check_in, Date check_out, Date fecha_rsv, int cant_personas, int cant_noches, float precio_reserva) {
        this.id_reserva = id_reserva;
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.usuario = usuario;
        this.check_in = check_in;
        this.check_out = check_out;
        this.fecha_rsv = fecha_rsv;
        this.cant_personas = cant_personas;
        this.cant_noches = cant_noches;
        this.precio_reserva = precio_reserva;
    }

    public long getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(long id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getCheck_in() {
        return check_in;
    }

    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    public Date getFecha_rsv() {
        return fecha_rsv;
    }

    public void setFecha_rsv(Date fecha_rsv) {
        this.fecha_rsv = fecha_rsv;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public int getCant_noches() {
        return cant_noches;
    }

    public void setCant_noches(int cant_noches) {
        this.cant_noches = cant_noches;
    }

    public float getPrecio_reserva() {
        return precio_reserva;
    }

    public void setPrecio_reserva(float precio_reserva) {
        this.precio_reserva = precio_reserva;
    }

}
