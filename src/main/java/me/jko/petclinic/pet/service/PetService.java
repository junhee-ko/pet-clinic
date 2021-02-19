package me.jko.petclinic.pet.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.jko.petclinic.owner.entity.Owner;
import me.jko.petclinic.owner.service.OwnerService;
import me.jko.petclinic.pet.dto.PetCreateDto;
import me.jko.petclinic.pet.dto.PetUpdateDto;
import me.jko.petclinic.pet.entity.Pet;
import me.jko.petclinic.pet.repository.PetRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {

  private final PetRepository petRepository;
  private final OwnerService ownerService;

  public Pet savePetBy(PetCreateDto petCreateDto) {
    Owner owner = ownerService.getOwnerBy(petCreateDto.getOwnerId());

    Pet pet = Pet.builder()
        .name(petCreateDto.getName())
        .birthDate(petCreateDto.getBirthDate())
        .owner(owner)
        .build();

    owner.add(pet);

    return petRepository.save(pet);
  }

  public List<Pet> getPets() {
    return petRepository.findAll();
  }

  @Transactional
  public Pet updatePetBy(Long petId, PetUpdateDto petUpdateDto) {
    Pet pet = petRepository.findById(petId).orElseThrow(EntityNotFoundException::new);
    pet.updateBy(petUpdateDto);

    return pet;
  }

  public void deletePetBy(Long petId) {
    Pet pet = petRepository.findById(petId).orElseThrow(EntityNotFoundException::new);
    petRepository.delete(pet);
  }
}
