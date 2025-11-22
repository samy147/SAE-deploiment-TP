package com.uspn.H2Demo.repository;


import com.uspn.H2Demo.entities.Adherent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdherentRepository extends JpaRepository<Adherent, Long> {
}