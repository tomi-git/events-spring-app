package com.tomicakorpar.eventapp.dto;

import java.time.LocalDateTime;

public class DogadajDtoInput {

    private String nazivDogadaja;
    private Integer sifraGrada;
    private LocalDateTime vrijemeOd;
    private LocalDateTime vrijemeDo;
    private Boolean slobodanUlaz;

    public DogadajDtoInput() {
    }

    public DogadajDtoInput(String nazivDogadaja, Integer sifraGrada, LocalDateTime vrijemeOd, LocalDateTime vrijemeDo, Boolean slobodanUlaz) {
        this.nazivDogadaja = nazivDogadaja;
        this.sifraGrada = sifraGrada;
        this.vrijemeOd = vrijemeOd;
        this.vrijemeDo = vrijemeDo;
        this.slobodanUlaz = slobodanUlaz;
    }

    public String getNazivDogadaja() {
        return nazivDogadaja;
    }

    public void setNazivDogadaja(String nazivDogadaja) {
        this.nazivDogadaja = nazivDogadaja;
    }

    public Integer getSifraGrada() {
        return sifraGrada;
    }

    public void setSifraGrada(Integer sifraGrada) {
        this.sifraGrada = sifraGrada;
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

    public Boolean getSlobodanUlaz() {
        return slobodanUlaz;
    }

    public void setSlobodanUlaz(Boolean slobodanUlaz) {
        this.slobodanUlaz = slobodanUlaz;
    }
}
