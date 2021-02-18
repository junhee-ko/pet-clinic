package me.jko.petclinic.owner.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.jko.petclinic.owner.dto.OwnerCreateDto;
import me.jko.petclinic.owner.dto.OwnerUpdateDto;
import me.jko.petclinic.owner.entity.Owner;
import me.jko.petclinic.owner.service.OwnerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OwnerController {

  private final OwnerService ownerService;

  @PostMapping("/owners")
  public Owner createOwner(@Valid OwnerCreateDto ownerCreateDto) {
    return ownerService.saveOwnerBy(ownerCreateDto);
  }

  @GetMapping("/owners")
  public List<Owner> getOwners() {
    return ownerService.getOwners();
  }

  @PutMapping("/owners/{ownerId}")
  public Owner updateOwnerBy(@PathVariable Long ownerId, @Valid OwnerUpdateDto ownerUpdateDto) {
    return ownerService.updateOwnerBy(ownerId, ownerUpdateDto);
  }

  @DeleteMapping("/owners/{ownerId}")
  public void deleteOwnerBy(@PathVariable Long ownerId) {
    ownerService.deleteOwnerBy(ownerId);
  }
}
