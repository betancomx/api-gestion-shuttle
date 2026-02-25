package mx.jbs.java.arq.la.api_gestion_shuttle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "TBL_CHOFER")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChoferEntity {

    @Id
    @Column(name = "ID_CHOFER")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqChofer")
    @SequenceGenerator(name = "seqChofer", sequenceName = "SEQ_CHOFER", allocationSize = 1)
    private Long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "APELLIDO_PAT",nullable = false)
    private String apellidoPat;

    @Column(name = "APELLIDO_MAT",nullable = true)
    private String apellidoMat;

    @Column(name = "LICENCIA", nullable = false)
    private String licencia;

    @Column(name = "TELEFONO", nullable = false)
    private String telefono;

    @Column(name = "ESTADO",nullable = false)
    private String estado;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    private LocalDateTime fechaRegistro;

    @PrePersist
    private void prePersist() {
        fechaRegistro = LocalDateTime.now();
        estado = "AC";
    }

    public ChoferEntity(String nombre, String apellidoPat, String apellidoMat, String licencia, String telefono) {
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.licencia = licencia;
        this.telefono = telefono;
    }
}
