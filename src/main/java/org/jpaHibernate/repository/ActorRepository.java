package org.jpaHibernate.repository;

import org.jpaHibernate.entity.Actor;
import jakarta.persistence.EntityManager;
import org.jpaHibernate.util.JpaUtil;

import java.util.List;

public class ActorRepository implements CrudRepository<Actor>{
    private EntityManager em;
    private Actor act;
    private Class<? extends Actor> clazz;
    public ActorRepository() {
        act = new Actor();
        clazz = act.getClass();
    }
    //Class<? extends Actor> clazz = act.getClass();
    @Override
    public List<Actor> listar(){
        em = JpaUtil.getEntityManager();

        List<Actor> actores = em.createQuery("select e from Actor e"
                ).getResultList();
        em.close();
        return actores;
    }

    @Override
    public Actor porId(Integer id ){
        em = JpaUtil.getEntityManager();
        act = em.find(clazz,id);
        em.close();
        return act;
    }

    @Override
    public void editar(Actor actor) throws Exception {
        try{
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.merge(actor);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            throw new Exception(e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void crear(Actor actor)throws Exception{
        try {
            em = JpaUtil.getEntityManager();
            //Actor actor = em.find(Actor.class, id);
            em.getTransaction().begin();
            em.persist(actor);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Integer id) throws Exception{
        try {
            em = JpaUtil.getEntityManager();
            Actor actor = em.find(Actor.class, id);
            em.getTransaction().begin();
            em.remove(actor);
            em.getTransaction().commit();
        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}