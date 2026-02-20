package mx.jbs.java.arq.la.api_gestion_shuttle.mapper;

import mx.jbs.java.arq.la.api_gestion_shuttle.dto.UnidadRequestDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.dto.UnidadResponseDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.entity.UnidadEntity;
import mx.jbs.java.arq.la.api_gestion_shuttle.util.DateUtil;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UnidadMapperImpl implements UnidadMapper {

    @Override
    public UnidadResponseDto toDto(UnidadEntity unidadEntity) {
        return new UnidadResponseDto(unidadEntity.getId(),
                unidadEntity.getPlaca(),
                unidadEntity.getModelo(),
                unidadEntity.getCapacidad(),
                DateUtil.getDateStr(unidadEntity.getFechaRegistro()),
                unidadEntity.getEstado());
    }

    @Override
    public List<UnidadResponseDto> toDtos(List<UnidadEntity> unidadEntities) {
        return unidadEntities.stream().map(this::toDto).toList();
    }

    @Override
    public UnidadEntity toEntity(UnidadRequestDto unidadRequestDto) {
        return new UnidadEntity(unidadRequestDto.placa(), unidadRequestDto.modelo(), unidadRequestDto.capacidad());
    }
}