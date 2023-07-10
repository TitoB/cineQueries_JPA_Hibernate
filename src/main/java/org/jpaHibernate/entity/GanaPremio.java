package org.jpaHibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ganapremio")
public class GanaPremio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CodPelicula", foreignKey = @ForeignKey(name = "fk_ganapremio_pelicula"))
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "CodPremio", foreignKey = @ForeignKey(name = "fk_ganapremio_premio"))
    private Premio premio;

    private int anyo;

    // Constructor, getters, setters, etc.

    public GanaPremio() {
    }

    // Constructor con parámetros
    public GanaPremio(Pelicula pelicula, Premio premio, int anyo) {
        this.pelicula = pelicula;
        this.premio = premio;
        this.anyo = anyo;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    @Override
    public String toString() {
        return "{" +
                "pelicula=" + pelicula +
                ", premio=" + premio +
                ", anyo=" + anyo +
                '}';
    }
}
