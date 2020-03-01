package com.tomicakorpar.eventapp.repository;

import com.tomicakorpar.eventapp.entity.OrganizacijskaJedinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizacijskaJedinicaRepository extends JpaRepository<OrganizacijskaJedinica, Integer>, QuerydslPredicateExecutor<OrganizacijskaJedinica> {

}
