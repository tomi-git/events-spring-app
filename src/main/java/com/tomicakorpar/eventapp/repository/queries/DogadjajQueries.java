package com.tomicakorpar.eventapp.repository.queries;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.tomicakorpar.eventapp.dto.DogadajFilterDto;
import com.tomicakorpar.eventapp.entity.QDogadaj;
import com.tomicakorpar.eventapp.util.DogadajAppUtil;
import org.springframework.util.StringUtils;

public class DogadjajQueries {

    public static BooleanExpression filterEventsQuery(DogadajFilterDto filterDto) {
        //default query
        BooleanExpression query = QDogadaj.dogadaj.isNotNull();

        //filter
        if (StringUtils.hasLength(filterDto.getNazivDogadaja()))
            query = query.and(QDogadaj.dogadaj.nazivDogadaja.contains(filterDto.getNazivDogadaja()));
        if (filterDto.getVrijemeOdPocetak() != null)
            query = query.and(QDogadaj.dogadaj.vrijemeOd.after(filterDto.getVrijemeOdPocetak()));
        if (filterDto.getVrijemeDoPocetak() != null)
            query = query.and(QDogadaj.dogadaj.vrijemeOd.before(filterDto.getVrijemeDoPocetak()));
        if (filterDto.getVrijemeOdKraj() != null)
            query = query.and(QDogadaj.dogadaj.vrijemeDo.after(filterDto.getVrijemeOdKraj()));
        if (filterDto.getVrijemeDoKraj() != null)
            query = query.and(QDogadaj.dogadaj.vrijemeDo.before(filterDto.getVrijemeDoKraj()));
        if (StringUtils.hasLength(filterDto.getSlobodanUlaz()))
            query = query.and(QDogadaj.dogadaj.slobodanUlaz.eq(filterDto.getSlobodanUlaz()));
        if (filterDto.getOdabraneRegije() != null && filterDto.getOdabraneRegije().length > 0)
            query = query.and(QDogadaj.dogadaj.grad.organizacijskaJedinica.nadredenaOrgJedinica.sifraOrgJedinice.in(DogadajAppUtil.getIntegerFromStringList(filterDto.getOdabraneRegije())));
        if (filterDto.getOdabraneZupanije() != null && filterDto.getOdabraneZupanije().length > 0)
            query = query.and(QDogadaj.dogadaj.grad.organizacijskaJedinica.sifraOrgJedinice.in(DogadajAppUtil.getIntegerFromStringList(filterDto.getOdabraneZupanije())));
        if (filterDto.getOdabraneVelicineGrada() != null && filterDto.getOdabraneVelicineGrada().length > 0)
            query = query.and(QDogadaj.dogadaj.grad.velicinaGrada.sifraVelicineGrada.in(DogadajAppUtil.getIntegerFromStringList(filterDto.getOdabraneVelicineGrada())));
        if (filterDto.getOdabraniGradovi() != null && filterDto.getOdabraniGradovi().length > 0) {
            query = query.and(QDogadaj.dogadaj.grad.sifraGrada.in(DogadajAppUtil.getIntegerFromStringList(filterDto.getOdabraniGradovi())));
        }

        return query;
    }

}
