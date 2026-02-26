package mx.jbs.java.arq.la.api_gestion_shuttle.service;

import lombok.RequiredArgsConstructor;
import mx.jbs.java.arq.la.api_gestion_shuttle.dto.ChoferRequestDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.dto.ChoferResponseDto;
import mx.jbs.java.arq.la.api_gestion_shuttle.mapper.ChoferMapper;
import mx.jbs.java.arq.la.api_gestion_shuttle.repository.ChoferRepository;
import mx.jbs.java.arq.la.api_gestion_shuttle.service.exception.ServiceException;
import mx.jbs.java.arq.la.api_gestion_shuttle.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChoferServiceImpl
        extends GenericServiceImpl
        implements ChoferService{

    private final ChoferMapper choferMapper;
    private final ChoferRepository choferRepository;

    @Override
    public List<ChoferResponseDto> findAll() throws ServiceException {
        try{
            return choferRepository.findAll().stream().map(choferMapper::toDto).toList();
        }catch (Exception e){
            throw new ServiceException("Error al obtener los choferes",e);
        }
    }

    @Override
    public Optional<ChoferResponseDto> findById(Long aLong) throws ServiceException {
        try{
            return choferRepository.findById(aLong).map(choferMapper::toDto);
        }catch (Exception e){
            throw new ServiceException("Error al obtener el chofer con id: "+aLong,e);
        }
    }

    @Override
    @Transactional
    public Long save(ChoferRequestDto dto) throws ServiceException {
        try{
            var chkLic = choferRepository.findByLicencia(dto.licencia());
            if(chkLic.isPresent()){
                throw new ServiceException("El chofer con licencia: "+dto.licencia()+" ya existe");
            }
            var choferRecord = choferRepository.save(choferMapper.toEntity(dto));
            return choferRecord.getId();
        }catch (Exception e){
            throw new ServiceException("Error al guardar el chofer",e);
        }
    }

    @Override
    @Transactional
    public void delete(Long aLong) throws ServiceException {
        try{
            var choferRecord = choferRepository.findById(aLong);
            if(choferRecord.isPresent()){
                var choferRecordAux = choferRecord.get();
                choferRecordAux.setEstado("IN");
                choferRepository.save(choferRecordAux);
            }else{
                throw new ServiceException("El chofer con id: "+aLong+" no existe");
            }
        }catch (Exception e){
            throw new ServiceException("Error al eliminar el chofer con id: "+aLong,e);
        }
    }
}
