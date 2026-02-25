package mx.jbs.java.arq.la.api_gestion_shuttle.mapper;

import mx.jbs.java.arq.la.api_gestion_shuttle.dto.ChoferRequestDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.dto.ChoferResponseDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.entity.ChoferEntity;
import mx.jbs.java.arq.la.api_gestion_shuttle.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChoferMapperImpl implements ChoferMapper {
    @Override
    public ChoferResponseDto toDto(ChoferEntity choferEntity) {
        return new ChoferResponseDto(choferEntity.getId(),
                choferEntity.getNombre(),
                choferEntity.getApellidoPat(),
                choferEntity.getApellidoMat(),
                choferEntity.getLicencia(),
                choferEntity.getTelefono(),
                choferEntity.getEstado(),
                DateUtil.getDateStr(choferEntity.getFechaRegistro()));
    }

    @Override
    public List<ChoferResponseDto> toDtos(List<ChoferEntity> choferEntities) {
        return choferEntities.stream().map(this::toDto).toList();
    }

    @Override
    public ChoferEntity toEntity(ChoferRequestDto choferRequestDto) {
        return new ChoferEntity(choferRequestDto.nombre(),
                choferRequestDto.apellidoPat(),
                choferRequestDto.apellidoMat(),
                choferRequestDto.licencia(),
                choferRequestDto.telefono()
        );
    }
}