package umg.edu.gt.DTO;

import java.util.Calendar;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "prestamos")  // Asegúrate de reemplazar con el nombre real de tu tabla
public class PrestamosDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "id_libro")
    private Long idLibro;
    
    @Column (name ="id_cuenta")
    private Long id_cuenta;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_prestamo")
    private Date fechaPrestamo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_devolucion")
    private Date fechaDevolucion;


     @PrePersist
    protected void onCreate() {
        this.fechaPrestamo = new Date();
        // Establecer solo la hora actual
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.fechaPrestamo);
        calendar.set(Calendar.MILLISECOND, 0); // Configurar milisegundos a 0
        this.fechaPrestamo = calendar.getTime();
        
         this.fechaDevolucion = new Date();
          
        calendar.setTime(this.fechaDevolucion);
        calendar.set(Calendar.MILLISECOND, 0); // Configurar milisegundos a 0
        this.fechaDevolucion = calendar.getTime();
      
    }
 
    
    public PrestamosDTO() {}

    public PrestamosDTO(Long idLibro, Long id_cuenta, Date fechaPrestamo, Date fechaDevolucion) {
        this.idLibro = idLibro;
        this.id_cuenta = id_cuenta;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }


    /**
     * @return the id_cuenta
     */
    public Long getId_cuenta() {
        return id_cuenta;
    }

    /**
     * @param id_cuenta the id_cuenta to set
     */
    public void setId_cuenta(Long id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
}
