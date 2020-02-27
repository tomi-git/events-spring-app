package com.tomicakorpar.eventapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 * Dogadaj entity class
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "dogadaj", schema = "igea_tk")
public class Dogadaj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sifra", nullable = false)
    private Integer sifraDogadaja;

    @Column(name = "naziv", nullable = false, length = 250)
    private String nazivDogadaja;

    @Column(name = "vrijeme_od")
    private LocalDateTime vrijemeOd;

    @Column(name = "vrijeme_do")
    private LocalDateTime vrijemeDo;

    @JoinColumn(name = "grad", referencedColumnName = "sifra")
    @ManyToOne
    private Grad grad;

    @Column(name = "slobodan_ulaz", nullable = false, length = 250)
    private String slobodanUlaz;

    //constructors
    public Dogadaj() {
        super();
    }

    //getters & setters
    public Integer getSifraDogadaja() {
        return sifraDogadaja;
    }

    public void setSifraDogadaja(Integer sifraDogadaja) {
        this.sifraDogadaja = sifraDogadaja;
    }

    public String getNazivDogadaja() {
        return nazivDogadaja;
    }

    public void setNazivDogadaja(String nazivDogadaja) {
        this.nazivDogadaja = nazivDogadaja;
    }

    public LocalDateTime getVrijemeOd() {
        return vrijemeOd;
    }

    public void setVrijemeOd(LocalDateTime vrijemeOd) {
        this.vrijemeOd = vrijemeOd;
    }

    public LocalDateTime getVrijemeDo() {
        return vrijemeDo;
    }

    public void setVrijemeDo(LocalDateTime vrijemeDo) {
        this.vrijemeDo = vrijemeDo;
    }

    public Grad getGrad() {
        return grad;
    }

    public void setGrad(Grad grad) {
        this.grad = grad;
    }

    public String getSlobodanUlaz() {
        return slobodanUlaz;
    }

    public void setSlobodanUlaz(String slobodanUlaz) {
        this.slobodanUlaz = slobodanUlaz;
    }
}