package mx.jbs.java.arq.la.api_gestion_shuttle.repository;

import mx.jbs.java.arq.la.api_gestion_shuttle.entity.UnidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
@Repository
public interface UnidadRepository extends JpaRepository<UnidadEntity, Long> {
}