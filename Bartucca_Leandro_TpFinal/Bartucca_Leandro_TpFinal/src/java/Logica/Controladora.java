package Logica;

import Persistencia.ControladoraPersistencia;
import static java.lang.Float.parseFloat;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controladora {

    ControladoraPersistencia controlPersist = new ControladoraPersistencia();

    //Funcion que uso para el login
    public Long verificarUsuario(String usuario, String contra) {
        List<Usuario> listaUsuarios = controlPersist.traerUsuarios();

        if (listaUsuarios != null) {
            for (Usuario usu : listaUsuarios) {

                if (usu.getNombre_usuario().equals(usuario) && usu.getContrasenia().equals(contra)) {
                    return usu.getId_user();
                }
            }

        }
        return null;
    }

    //Convierte DATE a String en el formato indicado y lo retorna
    public static String DateaString(Date fecha) {

        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha);

    }

    //Convierte un String a un tipo DATE en el formato indicado y lo retorna
    public static synchronized java.util.Date deStringToDate(String fecha) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public void crearEmpleado(String dni, String nombre, String apellido, String fechanac, String direccion, String cargo, String nombre_usuario, String contrasenia) {

        Empleado emple = new Empleado();
        emple.setDni(dni);
        emple.setNombre(nombre);
        emple.setApellido(apellido);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaAux = null;
        try {
            fechaAux = df.parse(fechanac);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        emple.setFecha_nac(fechaAux);

        emple.setDireccion(direccion);
        emple.setCargo(cargo);
        Usuario usu = new Usuario();
        usu.setNombre_usuario(nombre_usuario);
        usu.setContrasenia(contrasenia);
        emple.setUsuario(usu);

        controlPersist.crearEmpleado(emple);

    }

    public void crearHabitacion(String num_hab, String piso, String nombre, String tipo, String precio_noche) {

        Habitacion hab = new Habitacion();
        hab.setNum_hab(num_hab);
        hab.setPiso(piso);
        hab.setNombre(nombre);
        hab.setTipo(tipo);
        float prec_noc = parseFloat(precio_noche);
        hab.setPrecio_noche(prec_noc);

        controlPersist.crearHabitacion(hab);

    }

    public void crearHuesped(String dni, String nombre, String apellido, String fechanac, String direccion, String profesion) {

        Huesped hue = new Huesped();
        hue.setDni(dni);
        hue.setNombre(nombre);
        hue.setApellido(apellido);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaAux = null;
        try {
            fechaAux = df.parse(fechanac);

        } catch (ParseException ex) {
            ex.printStackTrace();

        }

        hue.setFecha_nac(fechaAux);

        hue.setDireccion(direccion);
        hue.setProfesion(profesion);

        controlPersist.crearHuesped(hue);

    }

    public List<Habitacion> getHabitaciones() {

        return (this.controlPersist.traerHabitaciones());

    }

    public void borrarHabitacion(int id_hab) {

        controlPersist.borrarHabitacion(id_hab);

    }

    public Habitacion buscarHabitacion(int id_hab) {
        return controlPersist.buscarHabitacion(id_hab);
    }

    public void modificarHabitacion(Habitacion hab) {

        controlPersist.modificarHabitacion(hab);

    }

    public List<Huesped> getHuespedes() {

        return (this.controlPersist.traerHuespedes());

    }

    public List<Empleado> getEmpleados() {

        return (this.controlPersist.traerEmpleados());

    }

    public List<Reserva> getReservas() {

        return (this.controlPersist.traerReservas());

    }

    //Funcion utilizada para la busqueda por nombre de usuario
    public List<Reserva> getReservasPorEmpleado(String usuario_nombre) {

        List<Reserva> resTotales = controlPersist.traerReservas();
        List<Reserva> resUsu = new ArrayList<>();

        if (resTotales != null) {
            for (Reserva res : resTotales) {
                String resId = res.getUsuario().getNombre_usuario();
                if (resId.equals(usuario_nombre)) {
                    resUsu.add(res);
                }
            }
        }
        return resUsu;
    }

    //Funcion utilizada para la busqueda por fecha de carga
    public List<Reserva> getReservasPorFecha(Date fechaCarga) {

        List<Reserva> resTotales = controlPersist.traerReservas();
        List<Reserva> resFecha = new ArrayList<>();

        if (resTotales != null) {
            for (Reserva res : resTotales) {
                Date resFech = res.getFecha_rsv();
                if (resFech.equals(fechaCarga)) {
                    resFecha.add(res);
                }
            }
        }
        return resFecha;
    }

    public List<Reserva> getReservasPorRango(Date fecha_desde, Date fecha_hasta) {

        List<Reserva> resTotales = controlPersist.traerReservas();
        List<Reserva> resRango = new ArrayList<>();

        if (resTotales != null) {
            for (Reserva res : resTotales) {
                Date resFech = res.getFecha_rsv();
                if (resFech.after(fecha_desde) && resFech.before(fecha_hasta)) {
                    resRango.add(res);
                }
            }
        }
        return resRango;
    }

    //Funcion utilizada para la busqueda por nombre y apellido de huesped y fecha desde/hasta
    public List<Reserva> getReservasPorHuespedPeriodo(String nombre_hue, String apellido_hue, Date fecha_desde, Date fecha_hasta) {

        List<Reserva> resTotales = controlPersist.traerReservas();
        List<Reserva> resHuePeri = new ArrayList<>();

        if (resTotales != null) {
            for (Reserva res : resTotales) {

                String hue_nombre = res.getHuesped().getNombre();
                String hue_apellido = res.getHuesped().getApellido();
                Date resFech = res.getFecha_rsv();
                if ((hue_nombre.equals(nombre_hue)) && (hue_apellido.equals(apellido_hue))
                        && (resFech.after(fecha_desde)) && (resFech.before(fecha_hasta))) {
                    resHuePeri.add(res);
                }
            }
        }
        return resHuePeri;

    }

    public void borrarHuesped(int id_hue) {
        controlPersist.borrarHuesped(id_hue);
    }

    public Huesped buscarHuesped(int id_hue) {
        return controlPersist.buscarHuesped(id_hue);
    }

    public void modificarHuesped(Huesped hue) {
        controlPersist.modificarHuesped(hue);
    }

    public Empleado buscarEmpleado(int id_emp) {
        return controlPersist.buscarEmpleado(id_emp);
    }

    public void modificarEmpleado(Empleado emp) {
        controlPersist.modificarEmpleado(emp);
    }

    public void borrarEmpleado(int id_emp) {
        controlPersist.borrarEmpleado(id_emp);
    }

    //Funcion utilizada para la carga de una reserva
    public boolean verificarCant_personas(String cant_personas, String id_habitacion) {

        int cant_personas_aux = Integer.parseInt(cant_personas);
        int id_habitacion_aux = Integer.parseInt(id_habitacion);

        Habitacion hab = buscarHabitacion(id_habitacion_aux);

        boolean autorizarCant_personas = false;

        String hab_tipo = hab.getTipo();

        switch (hab_tipo) {
            case "Single":
                if (cant_personas_aux <= 1) {
                    autorizarCant_personas = true;

                }
                break;
            case "Doble":
                if (cant_personas_aux <= 2) {
                    autorizarCant_personas = true;

                }
                break;
            case "Triple":
                if (cant_personas_aux <= 3) {
                    autorizarCant_personas = true;

                }
                break;
            case "Multiple": //Supuse que el tope máximo para una habitacion multiple es de 5 personas
                if (cant_personas_aux <= 5) {
                    autorizarCant_personas = true;

                }
                break;
            default:
                autorizarCant_personas = false;
        }

        return autorizarCant_personas;

    }

    //Funcion segunda utilizada para la carga de una reserva
    public boolean verificarFechas(String check_in, String check_out, String id_habitacion) {

        int id_habitacion_aux = Integer.parseInt(id_habitacion);

        Date check_in_aux = deStringToDate(check_in);
        Date check_out_aux = deStringToDate(check_out);

        Habitacion hab = buscarHabitacion(id_habitacion_aux);
        List<Reserva> listaReservas = controlPersist.traerReservas();

        boolean autorizarFechas = false;

        if (check_in_aux.before(check_out_aux)) {

            if (listaReservas.size() > 0) {

                for (Reserva res : listaReservas) {
                    if (res.getHabitacion().getNombre().equals(hab.getNombre())) {
                        Date check_in_res = res.getCheck_in();
                        Date check_out_res = res.getCheck_out();
                        autorizarFechas = (check_in_aux.before(check_in_res) && check_out_aux.before(check_in_res))
                                || (check_in_aux.after(check_out_res) && check_out_aux.after(check_out_res));
                        if (autorizarFechas == true) {
                            if ((check_in_aux.after(check_in_res) && check_out_aux.before(check_out_res))
                                    || (check_out_aux.after(check_in_res)) && (check_out_aux.before(check_out_res))) {
                                return autorizarFechas == false;
                            }
                        }
                    } else {
                        autorizarFechas = true;
                    }
                }

            } else {
                autorizarFechas = true;
            }

        } else {
            autorizarFechas = false;
        }

        return autorizarFechas;
    }

    public Usuario buscarUsuario(int usu_id) {
        return controlPersist.buscarUsuario(usu_id);
    }

    public void crearReserva(Habitacion hab, Huesped hue, Usuario usuario, Date check_in2, Date check_out2, Date fechaHoy2, String cant_personas, int cant_noc, float precio_rsv) {

        Reserva res = new Reserva();

        res.setHabitacion(hab);
        res.setHuesped(hue);
        res.setUsuario(usuario);
        res.setCheck_in(check_in2);
        res.setCheck_out(check_out2);
        res.setFecha_rsv(fechaHoy2);
        int cant_per = Integer.parseInt(cant_personas);
        res.setCant_personas(cant_per);
        res.setCant_noches(cant_noc);
        res.setPrecio_reserva(precio_rsv);

        controlPersist.crearReserva(res);

    }

    public Reserva buscarReserva(int id_res) {
        return controlPersist.buscarReserva(id_res);
    }

    public void modificarReserva(Reserva res) {
        controlPersist.modificarReserva(res);
    }

    public void borrarReserva(int id_res) {
        controlPersist.borrarReserva(id_res);
    }

}
