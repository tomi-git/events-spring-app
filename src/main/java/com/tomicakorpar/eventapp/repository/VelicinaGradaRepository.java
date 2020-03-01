package com.tomicakorpar.eventapp.repository;

import com.tomicakorpar.eventapp.entity.VelicinaGrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VelicinaGradaRepository extends JpaRepository<VelicinaGrada, Integer>, QuerydslPredicateExecutor<VelicinaGrada> {

}
