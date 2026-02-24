package mx.jbs.java.arq.la.api_gestion_shuttle.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ChoferRequestDto(
        @NotBlank
        @Size(min = 2, max = 50, message = "Nombre debe tener entre 2 y 50 caracteres")
        String nombre,

        @NotBlank
        @Size(min = 2, max = 50, message = "Apellido paterno debe tener entre 2 y 50 caracteres")
        String apellidoPat,

        @Size(min = 2, max = 50, message = "Apellido materno debe tener entre 2 y 50 caracteres")
        String apellidoMat,

        @NotBlank
        @Size(min = 8, max = 12, message = "Licencia debe tener entre 8 y 12 caracteres")
        String licencia,

        @NotBlank
        String telefono
) {
}