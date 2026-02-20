package mx.jbs.java.arq.la.api_gestion_shuttle.service;

import lombok.RequiredArgsConstructor;
import mx.jbs.java.arq.la.api_gestion_shuttle.dto.UnidadRequestDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.dto.UnidadResponseDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.mapper.UnidadMapper;
import mx.jbs.java.arq.la.api_gestion_shuttle.repository.UnidadRepository;
import mx.jbs.java.arq.la.api_gestion_shuttle.service.exception.ServiceException;
import mx.jbs.java.arq.la.api_gestion_shuttle.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UnidadServiceImpl extends GenericServiceImpl implements UnidadService {

    private final UnidadMapper unidadMapper;
    private final UnidadRepository unidadRepository;

    @Override
    public List<UnidadResponseDto> findAll() throws ServiceException {
        try {
            return unidadMapper.toDtos(unidadRepository.findAll());
        } catch (Exception e) {
            throw new ServiceException("Error al obtener las unidades",e);
        }
    }

    @Override
    public Optional<UnidadResponseDto> findById(Long id) throws ServiceException {
        try{
            return unidadRepository.findById(id).map(unidadMapper::toDto);
        } catch (Exception e) {
            throw new ServiceException("Error al obtener la unidad con id: "+id,e);
        }
    }

    @Override
    public Long save(UnidadRequestDto dto) throws ServiceException {
        try{
            var unidadSaved = unidadRepository.save(unidadMapper.toEntity(dto));
            return unidadSaved.getId();
        }catch (Exception e) {
            throw new ServiceException("Error al guardar la unidad",e);
        }
    }

    @Override
    public void delete(Long id) throws ServiceException {
        try {
            unidadRepository.deleteById(id);
        }catch (Exception e) {
            throw new ServiceException("Error al eliminar la unidad con id: "+id,e);
        }
    }
}
