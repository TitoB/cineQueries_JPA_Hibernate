package org.jpaHibernate.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodActor")
    Long codActor;
    @Column(name = "Nombre")
    String nombre;
    @Column(name = "FNacimiento")
    LocalDateTime fNAcimiento;
    @Column(name = "LNacimiento")
    String lNacimiento;
    @Column(name = "Nacionalidad")
    String nacionalidad;
    @Column(name = "FMuerte")
    LocalDateTime fMuerte;
    @Column(name = "LMuerte")
    String lMuerte;

    @ManyToMany(mappedBy = "actores")
    private List<Pelicula> peliculas = new ArrayList<>();

    public Actor() {
    }

    public Long getCodActor() {
        return codActor;
    }

    public void setCodActor(Long codActor) {
        this.codActor = codActor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getfNAcimiento() {
        return fNAcimiento;
    }

    public void setfNAcimiento(LocalDateTime fNAcimiento) {
        this.fNAcimiento = fNAcimiento;
    }

    public String getlNacimiento() {
        return lNacimiento;
    }

    public void setlNacimiento(String lNacimiento) {
        this.lNacimiento = lNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDateTime getfMuerte() {
        return fMuerte;
    }

    public void setfMuerte(LocalDateTime fMuerte) {
        this.fMuerte = fMuerte;
    }

    public String getlMuerte() {
        return lMuerte;
    }

    public void setlMuerte(String lMuerte) {
        this.lMuerte = lMuerte;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "codActor=" + codActor +
                ", nombre='" + nombre + '\'' +
                ", fNAcimiento=" + fNAcimiento +
                ", lNacimiento='" + lNacimiento + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", fMuerte=" + fMuerte +
                ", lMuerte='" + lMuerte + '\'' +
                '}';
    }
}
