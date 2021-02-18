package me.jko.petclinic.owner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.jko.petclinic.owner.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
