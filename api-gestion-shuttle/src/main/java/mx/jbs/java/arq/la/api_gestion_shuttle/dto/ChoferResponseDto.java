package mx.jbs.java.arq.la.api_gestion_shuttle.dto;

public record ChoferResponseDto(
        Long id,
        String nombre,
        String apellidoPat,
        String apellidoMat,
        String licencia,
        String telefono
) { };