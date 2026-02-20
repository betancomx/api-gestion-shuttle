package mx.jbs.java.arq.la.api_gestion_shuttle.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Table(name = "TBL_UNIDAD")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UnidadEntity {

    @Id
    @Column(name = "UNIDAD_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqUnidad")
    @SequenceGenerator(name = "seqUnidad", sequenceName = "SEQ_UNIDAD", allocationSize = 1)
    private Long id;

    @Column(name = "PLACA", nullable = false, length = 12)
    private String placa;

    @Column(name = "MODELO", nullable = false)
    private Integer modelo;

    @Column(name = "CAPACIDAD", nullable = false)
    private Integer capacidad;

    @Column(name = "FECHA_REGISTRO", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "ESTADO", nullable = false, length = 2)
    private String estado;

    @PrePersist
    public void prePersist(){
        this.fechaRegistro = LocalDateTime.now();
        this.estado = "AC";
    }

    public UnidadEntity(String placa, Integer modelo, Integer capacidad) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }
}
