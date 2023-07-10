package org.jpaHibernate.services;

import java.util.List;

public interface IService <T> {
    List<T> listar() throws Exception;
    T porId(Long id) throws Exception;
    void editar(T t) throws Exception;
    void crear(T t) throws Exception;
    void eliminar(long id) throws Exception;
}
