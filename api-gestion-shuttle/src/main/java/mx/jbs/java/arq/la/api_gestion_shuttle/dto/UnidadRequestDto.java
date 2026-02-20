package mx.jbs.java.arq.la.api_gestion_shuttle.dto;

import jakarta.validation.constraints.*;

public record UnidadRequestDto(

        @NotBlank
        @Size(min = 1, max = 12, message = "La placa debe contener al menos un caracter y máximo 12")
        String placa,

        @NotNull
        @Min(value = 2000, message = "El módelo minimo de la unidad que se acepta es 2000")
        Integer modelo,

        @NotNull(message = "La capacidad es requerida")
        @Min(value = 1, message = "La capacidad de la unidad tiene que ser positiva de al menos un asiento")
        Integer capacidad
) { };