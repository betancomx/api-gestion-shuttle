package mx.jbs.java.arq.la.api_gestion_shuttle.repository;

import mx.jbs.java.arq.la.api_gestion_shuttle.entity.ChoferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChoferRepository extends JpaRepository<ChoferEntity, Long> {

    @Query("SELECT c FROM ChoferEntity c WHERE c.licencia = :licencia")
    Optional<List<ChoferEntity>> findByLicencia(String licencia);
}