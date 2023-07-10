package org.jpaHibernate.repository;

import org.jpaHibernate.entity.Pelicula;

import java.util.List;

public interface CrudRepository <T>{
    List<T> listar();
    T porId(Integer id);
    void editar(T t) throws Exception;
    void crear(T t) throws Exception;
    void eliminar(Integer id) throws Exception;
}
