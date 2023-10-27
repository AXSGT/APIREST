package ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import umg.edu.gt.DTO.PrestamosDTO;


/**
 * Clase para insertar préstamos.
 */
@Path("/insertarPrestamos")
public class PrestamosInsertService {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    @POST
    @Path("/insertar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarPrestamo(PrestamosDTO prestamo) {
        Session session = null;
        Transaction tx = null;

        try {
           session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.save(prestamo);

            tx.commit();

            return Response.status(Response.Status.CREATED).entity(prestamo).build();  
        } 
         catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("ERROR AL INSERTAR ") .build();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
