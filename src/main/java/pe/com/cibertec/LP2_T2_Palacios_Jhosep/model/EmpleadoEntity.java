package pe.com.cibertec.LP2_T2_Palacios_Jhosep.model;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "tb_empleado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {
    @Id 
    @Column(name = "dni_empleado", length = 8)
    private String dniEmpleado;

    @Column(name = "nombre_empleado", length = 45, nullable = false)
    private String nombreEmpleado;

    @Column(name = "apellido_empleado", length = 45, nullable = false)
    private String apellidoEmpleado;

    @Column(name = "fecha_nacimiento", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    @Column(name = "direccion", length = 45)
    private String direccion;

    @Column(name = "correo", length = 45)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private AreaEntity area;
}