package com.tomicakorpar.eventapp.service;

import com.tomicakorpar.eventapp.dto.OrganizacijskaJedinicaDto;
import com.tomicakorpar.eventapp.dto.TipOrganizacijskeJediniceDto;
import com.tomicakorpar.eventapp.entity.OrganizacijskaJedinica;
import com.tomicakorpar.eventapp.repository.OrganizacijskaJedinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizacijskaJedinicaService {
    @Autowired
    OrganizacijskaJedinicaRepository repository;

    public List<OrganizacijskaJedinicaDto> fetchAllOrganizacijskaJedinicaDto() {
        List<OrganizacijskaJedinicaDto> resultList = new ArrayList<>();
        repository.findAll().forEach(organizacijskaJedinica -> resultList.add(formDTO(organizacijskaJedinica)));
        return resultList;
    }

    protected OrganizacijskaJedinicaDto formDTO(OrganizacijskaJedinica o) {
        OrganizacijskaJedinicaDto organizacijskaJedinicaDto = null;
        if (o != null) {
            organizacijskaJedinicaDto = new OrganizacijskaJedinicaDto();

            OrganizacijskaJedinica orgJedinicaEntity = o;
            organizacijskaJedinicaDto.setSifraOrgJedinice(orgJedinicaEntity.getSifraOrgJedinice());
            organizacijskaJedinicaDto.setNazivOrgJedinice(orgJedinicaEntity.getNazivOrgJedinice());
            organizacijskaJedinicaDto.setOpisOrgJedinice(orgJedinicaEntity.getOpisOrgJedinice());
            //tip
            if (orgJedinicaEntity.getTipOrganizacijskeJedinice() != null) {
                TipOrganizacijskeJediniceDto tipOrganizacijskeJediniceDto = new TipOrganizacijskeJediniceDto();
                tipOrganizacijskeJediniceDto.setSifraTipOrgJedinice(orgJedinicaEntity.getTipOrganizacijskeJedinice().getSifraTipOrgJedinice());
                tipOrganizacijskeJediniceDto.setNazivOrgJedinice(orgJedinicaEntity.getTipOrganizacijskeJedinice().getNazivTipOrgJedinice());
                tipOrganizacijskeJediniceDto.setAktivna(orgJedinicaEntity.getTipOrganizacijskeJedinice().getAktivanTipOrgJedinice());
                organizacijskaJedinicaDto.setTipOrganizacijskeJediniceDto(tipOrganizacijskeJediniceDto);
            }
            if (orgJedinicaEntity.getNadredenaOrgJedinica() != null) {
                OrganizacijskaJedinicaDto nadredenaOrgJedinicaDto = new OrganizacijskaJedinicaDto();
                nadredenaOrgJedinicaDto.setSifraOrgJedinice(orgJedinicaEntity.getNadredenaOrgJedinica().getSifraOrgJedinice());
                nadredenaOrgJedinicaDto.setNazivOrgJedinice(orgJedinicaEntity.getNadredenaOrgJedinica().getNazivOrgJedinice());
                nadredenaOrgJedinicaDto.setOpisOrgJedinice(orgJedinicaEntity.getNadredenaOrgJedinica().getOpisOrgJedinice());
                //tip
                if (orgJedinicaEntity.getNadredenaOrgJedinica().getTipOrganizacijskeJedinice() != null) {
                    TipOrganizacijskeJediniceDto tipOrganizacijskeJediniceNadredenaDto = new TipOrganizacijskeJediniceDto();
                    tipOrganizacijskeJediniceNadredenaDto.setSifraTipOrgJedinice(orgJedinicaEntity.getNadredenaOrgJedinica().getTipOrganizacijskeJedinice().getSifraTipOrgJedinice());
                    tipOrganizacijskeJediniceNadredenaDto.setNazivOrgJedinice(orgJedinicaEntity.getNadredenaOrgJedinica().getTipOrganizacijskeJedinice().getNazivTipOrgJedinice());
                    tipOrganizacijskeJediniceNadredenaDto.setAktivna(orgJedinicaEntity.getNadredenaOrgJedinica().getTipOrganizacijskeJedinice().getAktivanTipOrgJedinice());
                    nadredenaOrgJedinicaDto.setTipOrganizacijskeJediniceDto(tipOrganizacijskeJediniceNadredenaDto);
                }
                organizacijskaJedinicaDto.setNadredenaOrganizacijeDto(nadredenaOrgJedinicaDto);
            }
        }
        return organizacijskaJedinicaDto;
    }

}
