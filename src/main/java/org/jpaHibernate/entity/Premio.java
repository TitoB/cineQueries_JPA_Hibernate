package org.jpaHibernate.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "premio")
public class Premio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodPremio")
    Long codPremio;
    @Column(name = "Premio")
    String premio;
    @OneToMany(mappedBy = "premio")
    private List<GanaPremio> premios = new ArrayList<>();
    public Premio() {
    }
    public Long getCodPremio() {
        return codPremio;
    }

    public void setCodPremio(Long codPremio) {
        this.codPremio = codPremio;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "{" +
                "codPremio=" + codPremio +
                ", premio='" + premio + '\'' +
                '}';
    }
}
