package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {

    EmpleadoJpaController jpaEmpleado = new EmpleadoJpaController();
    HabitacionJpaController jpaHabitacion = new HabitacionJpaController();
    HuespedJpaController jpaHuesped = new HuespedJpaController();
    ReservaJpaController jpaReserva = new ReservaJpaController();
    UsuarioJpaController jpaUsuario = new UsuarioJpaController();

    public List<Usuario> traerUsuarios() {

        return jpaUsuario.findUsuarioEntities();

    }

    public void crearEmpleado(Empleado emple) {

        try {
            jpaEmpleado.create(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearHabitacion(Habitacion hab) {

        try {
            jpaHabitacion.create(hab);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void crearHuesped(Huesped hue) {

        try {
            jpaHuesped.create(hue);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Habitacion> traerHabitaciones() {
        return (jpaHabitacion.findHabitacionEntities());
    }

    public void borrarHabitacion(int id_hab) {
        try {
            jpaHabitacion.destroy(id_hab);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Habitacion buscarHabitacion(int id_hab) {
        return jpaHabitacion.findHabitacion(id_hab);
    }

    public void modificarHabitacion(Habitacion hab) {

        try {
            jpaHabitacion.edit(hab);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Huesped> traerHuespedes() {
        return (jpaHuesped.findHuespedEntities());
    }

    public List<Empleado> traerEmpleados() {
        return (jpaEmpleado.findEmpleadoEntities());
    }

    public void borrarHuesped(int id_hue) {
        try {
            jpaHuesped.destroy(id_hue);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Huesped buscarHuesped(int id_hue) {
        return jpaHuesped.findHuesped(id_hue);
    }

    public void modificarHuesped(Huesped hue) {
        try {
            jpaHuesped.edit(hue);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Empleado buscarEmpleado(int id_emp) {
        return jpaEmpleado.findEmpleado(id_emp);
    }

    public void modificarEmpleado(Empleado emp) {
        try {
            jpaEmpleado.edit(emp);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarEmpleado(int id_emp) {
        try {
            jpaEmpleado.destroy(id_emp);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Reserva> traerReservas() {
        return (jpaReserva.findReservaEntities());
    }

    public Usuario buscarUsuario(int usu_id) {
        return jpaUsuario.findUsuario(usu_id);
    }

    public void crearReserva(Reserva res) {

        jpaReserva.create(res);

    }

    public Reserva buscarReserva(int id_res) {
        return jpaReserva.findReserva(id_res);
    }

    public void modificarReserva(Reserva res) {
        try {
            jpaReserva.edit(res);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarReserva(int id_res) {
        try {
            jpaReserva.destroy(id_res);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
