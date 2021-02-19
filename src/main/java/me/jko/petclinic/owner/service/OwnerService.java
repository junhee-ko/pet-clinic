package me.jko.petclinic.owner.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.jko.petclinic.owner.dto.OwnerCreateDto;
import me.jko.petclinic.owner.dto.OwnerUpdateDto;
import me.jko.petclinic.owner.entity.Owner;
import me.jko.petclinic.owner.repository.OwnerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerService {

  private final OwnerRepository ownerRepository;

  public Owner saveOwnerBy(OwnerCreateDto ownerCreateDto) {
    Owner owner = Owner.of(ownerCreateDto);
    return ownerRepository.save(owner);
  }

  public List<Owner> getOwners() {
    return ownerRepository.findAll();
  }

  public Owner getOwnerBy(Long id) {
    return ownerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  @Transactional
  public Owner updateOwnerBy(Long ownerId, OwnerUpdateDto ownerUpdateDto) {
    Owner owner = ownerRepository.findById(ownerId).orElseThrow(EntityNotFoundException::new);
    owner.updateBy(ownerUpdateDto);

    return owner;
  }

  public void deleteOwnerBy(Long ownerId) {
    Owner owner = ownerRepository.findById(ownerId).orElseThrow(EntityNotFoundException::new);
    ownerRepository.delete(owner);
  }
}
