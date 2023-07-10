package org.jpaHibernate.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodPelicula")
    private Long codPelicula;
    @Column(name = "Titulo")
    String titulo;
    @Column(name = "Anyo")
    String anyo;
    @Column(name = "Nacionalidad")
    String nacionalidad;
    @Column(name = "Duracion")
    Float duracion;
    @Column(name = "FechaEstreno")
    LocalDateTime fechaEstreno;
    @Column(name = "Genero")
    int genero;
    @Column(name = "Taquilla")
    double taquilla;
    @Column(name = "Productora")
    String productora;
    @Column(name = "Distribuidora")
    String distribuidora;

//    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinTable(
//            name = "participa",
//            joinColumns = {
//                    @JoinColumn(name = "CodPelicula", referencedColumnName = "CodPelicula")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "CodActor", referencedColumnName = "CodActor")
//            }
//    )
@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "participa",
            joinColumns = @JoinColumn(name = "CodPelicula", referencedColumnName = "CodPelicula",
                    foreignKey = @ForeignKey(name = "FK_Participa_Pelicula")),
            inverseJoinColumns = @JoinColumn(name = "CodActor", referencedColumnName = "CodActor",
                    foreignKey = @ForeignKey(name = "FK_Participa_Actor"))
    )
    private List<Actor> actores = new ArrayList<>();

    @OneToMany(mappedBy = "pelicula")
    private List<GanaPremio> premios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="Director")
    private Director director;

    public Pelicula() {
    }

    public Long getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(Long codPelicula) {
        this.codPelicula = codPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Float getDuracion() {
        return duracion;
    }

    public void setDuracion(Float duracion) {
        this.duracion = duracion;
    }

    public LocalDateTime getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDateTime fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public double getTaquilla() {
        return taquilla;
    }

    public void setTaquilla(double taquilla) {
        this.taquilla = taquilla;
    }

    public String getProductora() {
        return productora;
    }

    public void setProductora(String productora) {
        this.productora = productora;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void setActores(List<Actor> actores) {
        this.actores = actores;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "{" +
                "codPelicula=" + codPelicula +
                ", titulo='" + titulo + '\'' +
                ", anyo='" + anyo + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", duracion=" + duracion +
                ", fechaEstreno=" + fechaEstreno +
                ", genero=" + genero +
                ", taquilla=" + taquilla +
                ", productora='" + productora + '\'' +
                ", distribuidora='" + distribuidora + '\'' +
                ", actores=" + actores +
                ", director=" + director +
                '}';
    }
}
