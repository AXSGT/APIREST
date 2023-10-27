package umg.edu.gt.DTO;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import ws.CustomDateDeserializer;


@Entity
@Table(name = "libros")
public class LibrosDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;



    @Temporal(TemporalType.DATE)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @Column(name = "fecha_carga")
    private Date fecha_carga;

    @Column(name = "id_tipo_libro")
    private Long id_tipo_libro;


    @Column(name = "id_autor")
    private Long id_autor;
    
    @Column(name ="disponible")
    private Long disponible;

  @PrePersist
    protected void onCreate() {
        this.fecha_carga = new Date();
        // Establecer solo la hora actual
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.fecha_carga);
        calendar.set(Calendar.MILLISECOND, 0); // Configurar milisegundos a 0
        this.fecha_carga = calendar.getTime();
    }
    
    
     public LibrosDTO() {}

    public LibrosDTO(String nombre, String descripcion, Date fecha_carga, Long id_tipo_libro, Long id_autor, Long disponible) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_carga = fecha_carga;
        this.id_tipo_libro = id_tipo_libro;
        this.id_autor = id_autor;
        this.disponible = disponible;
     

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    
     public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fecha_carga
     */
    public Date getFecha_carga() {
        return fecha_carga;
    }

    /**
     * @param fecha_carga the fecha_carga to set
     */
    public void setFecha_carga(Date fecha_carga) {
        this.fecha_carga = fecha_carga;
    }

    /**
     * @return the id_tipo_libro
     */
    public Long getId_tipo_libro() {
        return id_tipo_libro;
    }

    /**
     * @param id_tipo_libro the id_tipo_libro to set
     */
    public void setId_tipo_libro(Long id_tipo_libro) {
        this.id_tipo_libro = id_tipo_libro;
    }

    /**
     * @return the id_autor
     */
    public Long getId_autor() {
        return id_autor;
    }

    /**
     * @param id_autor the id_autor to set
     */
    public void setId_autor(Long id_autor) {
        this.id_autor = id_autor;
    }

    /**
     * @return the disponible
     */
    public Long getDisponible() {
        return disponible;
    }

    /**
     * @param disponible the disponible to set
     */
    public void setDisponible(Long disponible) {
        this.disponible = disponible;
    }
   
    
}
