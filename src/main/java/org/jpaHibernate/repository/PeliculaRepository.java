package org.jpaHibernate.repository;

import jakarta.persistence.EntityManager;
import org.jpaHibernate.entity.Pelicula;

import java.util.List;

public class PeliculaRepository implements CrudRepository{

    private EntityManager em;
    public PeliculaRepository(EntityManager em) {
        this.em = em;
    }
    @Override
    public List<Pelicula> listar() {
        return em.createQuery("select p from Pelicula p", Pelicula.class).getResultList();
    }

    @Override
    public Pelicula porId(Integer codPelicula) {
        return em.find(Pelicula.class, codPelicula);
    }

    @Override
    public void editar(Object codPelicula) throws Exception {
    }

    @Override
    public void eliminar(Integer codPelicula) {
        Pelicula pelicula = porId(codPelicula);
        em.remove(pelicula);
    }

    @Override
    public void crear(Object codPelicula) {
        if(codPelicula.getClass() != null) {
            em.merge(codPelicula);
        } else {
            em.persist(codPelicula);
        }
    }
}
