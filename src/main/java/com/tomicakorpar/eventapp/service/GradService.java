package com.tomicakorpar.eventapp.service;

import com.tomicakorpar.eventapp.dto.GradDto;
import com.tomicakorpar.eventapp.dto.OrganizacijskaJedinicaDto;
import com.tomicakorpar.eventapp.dto.VelicinaGradaDto;
import com.tomicakorpar.eventapp.entity.Grad;
import com.tomicakorpar.eventapp.repository.GradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GradService {
    @Autowired
    GradRepository repository;

    public List<GradDto> fetchAllGradDto() {
        List<GradDto> resultList = new ArrayList<>();
        repository.findAll().forEach(grad -> resultList.add(formDTO(grad)));
        return resultList;
    }

    protected GradDto formDTO(Grad entity) {
        GradDto gradDto = null;
        if (entity != null) {
            gradDto = new GradDto();
            Grad gradEntity = entity;
            gradDto.setSifraGrada(entity.getSifraGrada());
            gradDto.setNazivGrada(entity.getNazivGrada());
            OrganizacijskaJedinicaDto organizacijskaJedinicaDto = new OrganizacijskaJedinicaDto();
            organizacijskaJedinicaDto.setSifraOrgJedinice(entity.getOrganizacijskaJedinica().getSifraOrgJedinice());
            organizacijskaJedinicaDto.setNazivOrgJedinice(entity.getOrganizacijskaJedinica().getNazivOrgJedinice());
            organizacijskaJedinicaDto.setOpisOrgJedinice(entity.getOrganizacijskaJedinica().getOpisOrgJedinice());
            if (entity.getOrganizacijskaJedinica().getNadredenaOrgJedinica() != null) {
                OrganizacijskaJedinicaDto nadredenaOrganizacijskaJedinicaDto = new OrganizacijskaJedinicaDto();
                nadredenaOrganizacijskaJedinicaDto.setSifraOrgJedinice(entity.getOrganizacijskaJedinica().getNadredenaOrgJedinica().getSifraOrgJedinice());
                nadredenaOrganizacijskaJedinicaDto.setNazivOrgJedinice(entity.getOrganizacijskaJedinica().getNadredenaOrgJedinica().getNazivOrgJedinice());
                organizacijskaJedinicaDto.setNadredenaOrganizacijeDto(nadredenaOrganizacijskaJedinicaDto);
            }
            if (entity.getVelicinaGrada() != null) {
                VelicinaGradaDto velicinaGradaDto = new VelicinaGradaDto();
                velicinaGradaDto.setSifraVelicineGrada(entity.getVelicinaGrada().getSifraVelicineGrada());
                gradDto.setVelicinaGradaDto(velicinaGradaDto);
            }
            gradDto.setOrganizacijskaJedinicaDto(organizacijskaJedinicaDto);
        }
        return gradDto;
    }

}
