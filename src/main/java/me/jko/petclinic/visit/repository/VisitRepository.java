package me.jko.petclinic.visit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.jko.petclinic.visit.entity.Visit;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

}
