package me.jko.petclinic.pet.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.jko.petclinic.pet.dto.PetCreateDto;
import me.jko.petclinic.pet.dto.PetUpdateDto;
import me.jko.petclinic.pet.entity.Pet;
import me.jko.petclinic.pet.service.PetService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetController {

  private final PetService petService;

  @PostMapping("/pets")
  public Pet createPet(@Valid PetCreateDto petCreateDto) {
    return petService.savePetBy(petCreateDto);
  }

  @GetMapping("/pets")
  public List<Pet> getPets() {
    return petService.getPets();
  }

  @PutMapping("/pets/{petId}")
  public Pet updatePetBy(@PathVariable Long petId, @Valid PetUpdateDto petUpdateDto) {
    return petService.updatePetBy(petId, petUpdateDto);
  }

  @DeleteMapping("/pets/{petId}")
  public void deletePetBy(@PathVariable Long petId) {
    petService.deletePetBy(petId);
  }
}
