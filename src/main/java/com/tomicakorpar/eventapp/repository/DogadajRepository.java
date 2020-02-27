package com.tomicakorpar.eventapp.repository;

import com.tomicakorpar.eventapp.dto.DogadajDto;
import com.tomicakorpar.eventapp.entity.Dogadaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogadajRepository extends JpaRepository<Dogadaj, Integer>, QuerydslPredicateExecutor<Dogadaj> {

}
