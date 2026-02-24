package mx.jbs.java.arq.la.api_gestion_shuttle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name = "TBL_CHOFER")
@Entity
public class ChoferEntity {

    @Id
    @Column(name = "CHOFER_ID")
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
}
