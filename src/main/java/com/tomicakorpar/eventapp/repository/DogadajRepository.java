package com.tomicakorpar.eventapp.repository;

import com.tomicakorpar.eventapp.entity.Dogadaj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DogadajRepository extends JpaRepository<Dogadaj, Integer>, QuerydslPredicateExecutor<Dogadaj> {

}
