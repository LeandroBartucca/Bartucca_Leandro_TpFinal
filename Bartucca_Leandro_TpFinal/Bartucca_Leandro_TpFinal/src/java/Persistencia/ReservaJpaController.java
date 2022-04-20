package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReservaJpaController implements Serializable {

    public ReservaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ReservaJpaController() {
        emf = Persistence.createEntityManagerFactory("Bartucca_Leandro_TpFinalPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reserva reserva) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Habitacion habitacion = reserva.getHabitacion();
            if (habitacion != null) {
                habitacion = em.getReference(habitacion.getClass(), habitacion.getId_hab());
                reserva.setHabitacion(habitacion);
            }
            Huesped huesped = reserva.getHuesped();
            if (huesped != null) {
                huesped = em.getReference(huesped.getClass(), huesped.getId());
                reserva.setHuesped(huesped);
            }
            Usuario usuario = reserva.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getId_user());
                reserva.setUsuario(usuario);
            }
            em.persist(reserva);
            if (habitacion != null) {
                habitacion.getListaReservasHab().add(reserva);
                habitacion = em.merge(habitacion);
            }
            if (huesped != null) {
                huesped.getListaReservasHue().add(reserva);
                huesped = em.merge(huesped);
            }
            if (usuario != null) {
                usuario.getListaReservasUsu().add(reserva);
                usuario = em.merge(usuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reserva reserva) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva persistentReserva = em.find(Reserva.class, reserva.getId_reserva());
            Habitacion habitacionOld = persistentReserva.getHabitacion();
            Habitacion habitacionNew = reserva.getHabitacion();
            Huesped huespedOld = persistentReserva.getHuesped();
            Huesped huespedNew = reserva.getHuesped();
            Usuario usuarioOld = persistentReserva.getUsuario();
            Usuario usuarioNew = reserva.getUsuario();
            if (habitacionNew != null) {
                habitacionNew = em.getReference(habitacionNew.getClass(), habitacionNew.getId_hab());
                reserva.setHabitacion(habitacionNew);
            }
            if (huespedNew != null) {
                huespedNew = em.getReference(huespedNew.getClass(), huespedNew.getId());
                reserva.setHuesped(huespedNew);
            }
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getId_user());
                reserva.setUsuario(usuarioNew);
            }
            reserva = em.merge(reserva);
            if (habitacionOld != null && !habitacionOld.equals(habitacionNew)) {
                habitacionOld.getListaReservasHab().remove(reserva);
                habitacionOld = em.merge(habitacionOld);
            }
            if (habitacionNew != null && !habitacionNew.equals(habitacionOld)) {
                habitacionNew.getListaReservasHab().add(reserva);
                habitacionNew = em.merge(habitacionNew);
            }
            if (huespedOld != null && !huespedOld.equals(huespedNew)) {
                huespedOld.getListaReservasHue().remove(reserva);
                huespedOld = em.merge(huespedOld);
            }
            if (huespedNew != null && !huespedNew.equals(huespedOld)) {
                huespedNew.getListaReservasHue().add(reserva);
                huespedNew = em.merge(huespedNew);
            }
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getListaReservasUsu().remove(reserva);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getListaReservasUsu().add(reserva);
                usuarioNew = em.merge(usuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = reserva.getId_reserva();
                if (findReserva(id) == null) {
                    throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reserva reserva;
            try {
                reserva = em.getReference(Reserva.class, id);
                reserva.getId_reserva();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reserva with id " + id + " no longer exists.", enfe);
            }
            Habitacion habitacion = reserva.getHabitacion();
            if (habitacion != null) {
                habitacion.getListaReservasHab().remove(reserva);
                habitacion = em.merge(habitacion);
            }
            Huesped huesped = reserva.getHuesped();
            if (huesped != null) {
                huesped.getListaReservasHue().remove(reserva);
                huesped = em.merge(huesped);
            }
            Usuario usuario = reserva.getUsuario();
            if (usuario != null) {
                usuario.getListaReservasUsu().remove(reserva);
                usuario = em.merge(usuario);
            }
            em.remove(reserva);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reserva> findReservaEntities() {
        return findReservaEntities(true, -1, -1);
    }

    public List<Reserva> findReservaEntities(int maxResults, int firstResult) {
        return findReservaEntities(false, maxResults, firstResult);
    }

    private List<Reserva> findReservaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reserva.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Reserva findReserva(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reserva.class, id);
        } finally {
            em.close();
        }
    }

    public int getReservaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reserva> rt = cq.from(Reserva.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
