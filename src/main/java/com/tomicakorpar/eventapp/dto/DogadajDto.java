package com.tomicakorpar.eventapp.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/*
 * Data transfer object za entitet dogadaj
 */
public class DogadajDto implements Serializable {

    private static final long serialVersionUID = 1L;
    // fields
    private Boolean valid;
    private Integer sifraDogadaja;
    private String nazivDogadaja;
    private GradDto gradDogadajaDto;
    private LocalDateTime vrijemeOd;
    private LocalDateTime vrijemeDo;
    private String slobodanUlaz;

    private List<String> errorMessages;

    // constructors
    public DogadajDto() {
        super();
    }

    // getters & setters
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

    public GradDto getGradDogadajaDto() {
        return gradDogadajaDto;
    }

    public void setGradDogadajaDto(GradDto gradDogadajaDto) {
        this.gradDogadajaDto = gradDogadajaDto;
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

    public String getSlobodanUlaz() {
        return slobodanUlaz;
    }

    public void setSlobodanUlaz(String slobodanUlaz) {
        this.slobodanUlaz = slobodanUlaz;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }
}
