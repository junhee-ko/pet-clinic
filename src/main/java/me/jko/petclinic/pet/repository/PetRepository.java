package me.jko.petclinic.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.jko.petclinic.pet.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
