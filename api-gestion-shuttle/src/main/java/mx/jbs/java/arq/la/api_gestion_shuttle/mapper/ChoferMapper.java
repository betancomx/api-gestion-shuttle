package mx.jbs.java.arq.la.api_gestion_shuttle.mapper;

import mx.jbs.java.arq.la.api_gestion_shuttle.dto.ChoferRequestDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.dto.ChoferResponseDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.entity.ChoferEntity;

import java.util.List;

public interface ChoferMapper {
    ChoferResponseDto toDto(ChoferEntity choferEntity);
    List<ChoferResponseDto> toDtos(List<ChoferEntity> choferEntities);
    ChoferEntity toEntity(ChoferRequestDto choferRequestDto);
}