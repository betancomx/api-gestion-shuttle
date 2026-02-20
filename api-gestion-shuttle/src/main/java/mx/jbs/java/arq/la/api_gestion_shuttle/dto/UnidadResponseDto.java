package mx.jbs.java.arq.la.api_gestion_shuttle.dto;

import java.time.LocalDateTime;

public record UnidadResponseDto(
        Long id,
        String placa,
        Integer modelo,
        Integer capacidad,
        String fechaRegistro,
        String estado
) { };