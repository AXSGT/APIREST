package ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import umg.edu.gt.DTO.AutoresDTO;
import umg.edu.gt.DTO.LibrosDTO;
import umg.edu.gt.DTO.TiposDTO;


@Path("/insertarLibros")
public class LibrosInsertService {
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
public Response insertarLibro(LibrosDTO libro) {
    Session session = null;
    Transaction tx = null;

    try {
        session = sessionFactory.openSession();   
        tx = session.beginTransaction();
        
        session.save(libro);

        tx.commit();
          
       return Response.status(Response.Status.CREATED).entity(libro).build();
        
        // Validar si el idTipo existe en la base de datos.
      
   }  catch (Exception e) {
    if (tx != null) {
        tx.rollback();
    }
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                   .entity("Error al insertar libro: " ).build();
      }
    finally {
            if (session != null) {
                session.close();
            }
        }      
   }
}