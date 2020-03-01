package com.tomicakorpar.eventapp.repository;

import com.tomicakorpar.eventapp.entity.Grad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GradRepository extends JpaRepository<Grad, Integer>, QuerydslPredicateExecutor<Grad> {

}
