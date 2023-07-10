package org.jpaHibernate;

import antlr.collections.impl.LList;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.jpaHibernate.entity.Actor;
//import org.jpaHibernate.entity.Actor1;
import jakarta.persistence.EntityManager;
import org.jpaHibernate.entity.Pelicula;
import org.jpaHibernate.services.ServiceImpl;
import org.jpaHibernate.util.JpaUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("\n\n\n------------------ | ----------------");

        EntityManager em = JpaUtil.getEntityManager();
        System.out.println("\n\n\n------------------ | ----------------");
        //6.¿Qué empresa es la distribuidora de la película ‘Casablanca’?
        List<Pelicula> distribuidora = em.createQuery("select p from Pelicula p where p.titulo = 'Casablanca'", Pelicula.class)
                .getResultList();
        if (!distribuidora.isEmpty()) {
            Pelicula pelicula = distribuidora.get(0);
            System.out.println("Distribuidora de Casablanca \n " + pelicula.getDistribuidora());
        } else {
            System.out.println("No se encontró la película 'Casablanca'");
        }
        System.out.println("\n\n\n------------------ || ----------------");
        //7.Muestra qué actores y actrices, nacidos en Suecia, han fallecido ya,
        // según la información almacenada en nuestra base de datos
        List<Object[]> resultados = em.createQuery("select a.nombre, a.nacionalidad, a.fMuerte from Actor a where a.nacionalidad = 'Suecia'", Object[].class)
                .getResultList();

        for (Object[] resultado : resultados) {
            String nombre = (String) resultado[0];
            String nacionalidad = (String) resultado[1];
            LocalDateTime fMuerte = (LocalDateTime) resultado[2];
            LocalDate fechaMuerte = fMuerte.toLocalDate(); // Conversión de LocalDateTime a LocalDate
            // Realiza las operaciones que necesites con los valores obtenidos
            System.out.println(nombre + " - " + nacionalidad + " - " + fMuerte);
        }
        System.out.println("\n\n\n------------------ || ----------------");
        //8.¿Cuál ha sido la recaudación total de las películas realizadas en España?
        Query query = em.createQuery("select sum(p.taquilla) from Pelicula p where p.nacionalidad = 'España'");
        Object result = query.getSingleResult();
        if (result != null) {
            Double recaudacion = (Double) result;
            BigDecimal recaudacionDecimal = BigDecimal.valueOf(recaudacion);
            System.out.println("Recaudación total de las películas realizadas en España: " + recaudacionDecimal);
        } else {
            System.out.println("No se encontraron películas realizadas en España.");
        }
        //System.out.println("\n\n\n------------------ || ----------------");
        //9.Muestra el nombre y lugar de nacimiento de las actrices que actuaban en la
        //película ‘Solas’.
//        List<Object[]> r2 = em.createQuery
//                        ("SELECT a.nombre, a.lNacimiento " +
//                                "FROM Actor a " +
//                                "JOIN FETCH a.participaciones par " +
//                                "JOIN FETCH par.pelicula pel " +
//                                "WHERE pel.titulo = 'Solas'", Object[].class)
//                .getResultList();
//
//        for (Object[] r : r2) {
//            String nombre = (String) r[0];
//            String lNacimiento = (String) r[1];
//            System.out.println("Nombre: " + nombre + ", Lugar de nacimiento: " + lNacimiento);
//        }
        System.out.println("\n\n\n------------------ || ----------------");
        //10.Mostrar un listado en el que aparezcan cuántas películas
        // tenemos de cada nacionalidad.
        List<Object[]> r3 = em.createQuery(
                        "select nacionalidad, Count(nacionalidad) as cantidad " +
                                "from Pelicula " +
                                "group by nacionalidad " +
                                "order by nacionalidad", Object[].class)
                .getResultList();

        for (Object[] resultado : r3) {
            String nacionalidad = (String) resultado[0];
            Long cantidad = (Long) resultado[1];
            System.out.println(nacionalidad + " - " + cantidad );
        }
        System.out.println("\n\n\n------------------ || ----------------");
        //11. Saca un listado de las películas españolas, pero en el que
        // en el mismo campo aparezca el título seguido del año entre
        // paréntesis (p.e.: El Bola (2000)).
        List<Object[]> r4 = em.createQuery(
                        "select titulo, anyo, concat(titulo, ' (', anyo, ')') as Junto, nacionalidad " +
                                "from Pelicula " +
                                "where nacionalidad like 'España'", Object[].class)
                .getResultList();

        for (Object[] resultado : r4) {
            String titulo = (String) resultado[0];
            String anyo = (String) resultado[1];
            String junto = (String) resultado[2];
            String nacionalidad = (String) resultado[3];
            System.out.println(nacionalidad + " - " + anyo+ " - "
                    + junto+ " - " + nacionalidad );
        }
        System.out.println("\n\n\n------------------ || ----------------");
        //14.¿Qué directores (de los que tenemos almacenados) no han
        // dirigido ninguna de las películas de la tabla `films`?
        String jpqlQuery = "SELECT d.nombre, d.lNacimiento AS nacionalidad " +
                "FROM Director d " +
                "LEFT JOIN Pelicula p ON (p.director = d.codDirector) " +
                "WHERE p.director IS NULL";

        TypedQuery<Object[]> queri = em.createQuery(jpqlQuery, Object[].class);
        List<Object[]> resultado = queri.getResultList();

        for (Object[] row : resultado) {
            String nombre = (String) row[0];
            String lNacimiento = (String) row[1];

            System.out.println(nombre + " - " + lNacimiento);
        }

    }
}
