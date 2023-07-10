package org.jpaHibernate.services;

import org.jpaHibernate.entity.Actor;
import org.jpaHibernate.repository.ActorRepository;

import java.util.List;

public class ServiceImpl<T> implements IService<T>{
    ActorRepository repository = new ActorRepository();
    private T t;

    public ServiceImpl() {
    }

    public ServiceImpl(T t) {
        this.t = t;
    }
    @Override
    public List<T> listar() throws Exception {
        try {
            return (List<T>) repository.listar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public T porId(Long id) throws Exception {
        try {
            return (T) repository.porId(Math.toIntExact(id));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void editar(T t) throws Exception {
        repository.editar((Actor) t);
    }

    @Override
    public void crear(T t) throws Exception {
        repository.crear((Actor) t);
    }

    @Override
    public void eliminar(long id) throws Exception {
        t = (T) repository.porId((int) id);
        if (t == null) throw new Exception("No existe el empleado con el id " + id);
        repository.eliminar((int) id);
    }
}
