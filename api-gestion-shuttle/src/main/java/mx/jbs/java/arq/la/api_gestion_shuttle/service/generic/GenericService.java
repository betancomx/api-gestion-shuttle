package mx.jbs.java.arq.la.api_gestion_shuttle.service.generic;

/*
Q   Dto Request
S   Dto Response
ID  ID record
*/

import mx.jbs.java.arq.la.api_gestion_shuttle.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface GenericService<Q,S,ID> {
    List<S> findAll() throws ServiceException;
    Optional<S> findById(ID id) throws ServiceException;
    Long save(Q dto) throws ServiceException;
    void delete(ID id) throws ServiceException;
}