package com.tomicakorpar.eventapp.service;

import com.tomicakorpar.eventapp.dto.*;
import com.tomicakorpar.eventapp.entity.Dogadaj;
import com.tomicakorpar.eventapp.entity.Grad;
import com.tomicakorpar.eventapp.repository.DogadajRepository;
import com.tomicakorpar.eventapp.repository.queries.DogadjajQueries;
import com.tomicakorpar.eventapp.util.DogadajAppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class DogadajService {
    @Autowired
    DogadajRepository repository;

    public DogadajDto createDogadaj(DogadajDtoInput dto) {
        DogadajDto dogadajDto = new DogadajDto();
        if (validateBeforeCreate(dto).isEmpty()) {
            Dogadaj dogadaj = repository.save(formEntity(dto));
            dogadajDto.setValid(Boolean.TRUE);
            dogadajDto.setSifraDogadaja(dogadaj.getSifraDogadaja());
        } else {
            dogadajDto.setValid(Boolean.FALSE);
            dogadajDto.setErrorMessages(validateBeforeCreate(dto));
        }
        return dogadajDto;
    }

    public List<DogadajDto> getFilterDogadajList(DogadajFilterDto dto) {
        List<DogadajDto> resultList = new ArrayList<>();
        repository.findAll(DogadjajQueries.filterEventsQuery(dto)).forEach(dogadaj -> resultList.add(formDTO(dogadaj)));
        return resultList;
    }

    private Dogadaj formEntity(DogadajDtoInput dto) {
        Dogadaj entity = null;
        if (dto != null) {
            entity = new Dogadaj();
            entity.setNazivDogadaja(dto.getNazivDogadaja());
            entity.setVrijemeOd(dto.getVrijemeOd());
            entity.setVrijemeDo(dto.getVrijemeDo());
            Grad grad = new Grad();
            grad.setSifraGrada(dto.getSifraGrada());
            entity.setGrad(grad);
            if (dto.getSlobodanUlaz()) {
                entity.setSlobodanUlaz(DogadajAppConstants.ENTITY_SLOBODAN_ULAZ_DA);
            } else {
                entity.setSlobodanUlaz(DogadajAppConstants.ENTITY_SLOBODAN_ULAZ_NE);
            }
        }
        return entity;
    }

    protected DogadajDto formDTO(Dogadaj o) {
        DogadajDto dogadajDto = null;
        if (o != null) {
            dogadajDto = new DogadajDto();
            Dogadaj dogadajEntity = o;
            dogadajDto.setSifraDogadaja(dogadajEntity.getSifraDogadaja());
            dogadajDto.setNazivDogadaja(dogadajEntity.getNazivDogadaja());
            dogadajDto.setVrijemeOd(dogadajEntity.getVrijemeOd());
            dogadajDto.setVrijemeDo(dogadajEntity.getVrijemeDo());
            dogadajDto.setSlobodanUlaz(dogadajEntity.getSlobodanUlaz());
            //grad dogadaja
            if (dogadajEntity.getGrad() != null) {
                GradDto gradDto = new GradDto();

                gradDto.setSifraGrada(dogadajEntity.getGrad().getSifraGrada());
                gradDto.setNazivGrada(dogadajEntity.getGrad().getNazivGrada());
                //org jedinica grada
                if (dogadajEntity.getGrad().getOrganizacijskaJedinica() != null) {
                    OrganizacijskaJedinicaDto organizacijskaJedinicaDto = new OrganizacijskaJedinicaDto();
                    organizacijskaJedinicaDto.setSifraOrgJedinice(dogadajEntity.getGrad().getOrganizacijskaJedinica().getSifraOrgJedinice());
                    organizacijskaJedinicaDto.setNazivOrgJedinice(dogadajEntity.getGrad().getOrganizacijskaJedinica().getNazivOrgJedinice());
                    organizacijskaJedinicaDto.setOpisOrgJedinice(dogadajEntity.getGrad().getOrganizacijskaJedinica().getOpisOrgJedinice());
                    //tip organizacijske jedinice grada
                    TipOrganizacijskeJediniceDto tipOrganizacijskeJediniceDto = new TipOrganizacijskeJediniceDto();
                    tipOrganizacijskeJediniceDto.setNazivOrgJedinice(dogadajEntity.getGrad().getOrganizacijskaJedinica().getTipOrganizacijskeJedinice().getNazivTipOrgJedinice());
                    tipOrganizacijskeJediniceDto.setSifraTipOrgJedinice(dogadajEntity.getGrad().getOrganizacijskaJedinica().getTipOrganizacijskeJedinice().getSifraTipOrgJedinice());
                    organizacijskaJedinicaDto.setTipOrganizacijskeJediniceDto(tipOrganizacijskeJediniceDto);
                    //nadredena organizacijska jedinica organizacijske jedinice
                    if (dogadajEntity.getGrad().getOrganizacijskaJedinica().getNadredenaOrgJedinica() != null) {
                        OrganizacijskaJedinicaDto nadredenaOrganizacijskaJedinicaDto = new OrganizacijskaJedinicaDto();
                        nadredenaOrganizacijskaJedinicaDto.setSifraOrgJedinice(dogadajEntity.getGrad().getOrganizacijskaJedinica().getNadredenaOrgJedinica().getSifraOrgJedinice());
                        nadredenaOrganizacijskaJedinicaDto.setNazivOrgJedinice(dogadajEntity.getGrad().getOrganizacijskaJedinica().getNadredenaOrgJedinica().getNazivOrgJedinice());
                        organizacijskaJedinicaDto.setNadredenaOrganizacijeDto(nadredenaOrganizacijskaJedinicaDto);
                    }
                    gradDto.setOrganizacijskaJedinicaDto(organizacijskaJedinicaDto);
                    //velicina grada
                    VelicinaGradaDto velicinaGradaDto = new VelicinaGradaDto();
                    velicinaGradaDto.setNazivVelicineGrada(dogadajEntity.getGrad().getVelicinaGrada().getNazivVelicineGrada());
                    velicinaGradaDto.setSifraVelicineGrada(dogadajEntity.getGrad().getVelicinaGrada().getSifraVelicineGrada());
                    gradDto.setVelicinaGradaDto(velicinaGradaDto);
                    dogadajDto.setGradDogadajaDto(gradDto);
                }
            }
        }
        return dogadajDto;
    }

    private List<String> validateBeforeCreate(DogadajDtoInput dogadajDto) {
        List<String> messages = new ArrayList<String>();

        if (dogadajDto == null) {
            messages.add("Događaj nema podatke!");
        }
        if (StringUtils.isEmpty(dogadajDto.getNazivDogadaja())) {
            messages.add("Događaj nema popunjen naziv!");
        }
        if (dogadajDto.getVrijemeOd() == null) {
            messages.add("Događaj nema odabrano vrijeme od!");
        }
        if (dogadajDto.getVrijemeOd() != null && dogadajDto.getVrijemeOd().isBefore(LocalDateTime.now())) {
            messages.add("Događaj ne može biti u proplosti!");
        }
        if (dogadajDto.getVrijemeOd() != null && dogadajDto.getVrijemeDo() != null && dogadajDto.getVrijemeDo().isBefore(dogadajDto.getVrijemeOd())) {
            messages.add("Događaj ne može završiti prije nego je započeo!");
        }
        if (dogadajDto.getSifraGrada() == null) {
            messages.add("Događaj nama odabran grad!");
        }
        if (dogadajDto.getSlobodanUlaz() == null) {
            messages.add("Događaj nema odabran način ulaza!");
        }
        return messages;
    }
}
