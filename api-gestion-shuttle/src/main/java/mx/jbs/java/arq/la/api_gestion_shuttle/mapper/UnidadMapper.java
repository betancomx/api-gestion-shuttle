package mx.jbs.java.arq.la.api_gestion_shuttle.mapper;

import mx.jbs.java.arq.la.api_gestion_shuttle.dto.UnidadRequestDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.dto.UnidadResponseDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.entity.UnidadEntity;

import java.util.List;

public interface UnidadMapper {
    UnidadResponseDto toDto(UnidadEntity unidadEntity);
    List<UnidadResponseDto> toDtos(List<UnidadEntity> unidadEntities);
    UnidadEntity toEntity(UnidadRequestDto unidadRequestDto);
}