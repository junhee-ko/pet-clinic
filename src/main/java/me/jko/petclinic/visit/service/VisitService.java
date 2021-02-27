package me.jko.petclinic.visit.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.jko.petclinic.owner.entity.Owner;
import me.jko.petclinic.owner.service.OwnerService;
import me.jko.petclinic.visit.dto.VisitCreateDto;
import me.jko.petclinic.visit.entity.Visit;
import me.jko.petclinic.visit.repository.VisitRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitService {

  private final VisitRepository visitRepository;
  private final OwnerService ownerService;

  public Visit saveVisitBy(VisitCreateDto visitCreateDto) {
    Owner owner = ownerService.getOwnerBy(visitCreateDto.getOwnerId());
    if (!owner.isOwnerOfPetBy(visitCreateDto)) {
      throw new RuntimeException("Not Owner of Pet");
    }

    Visit visit = Visit.of(visitCreateDto);

    return visitRepository.save(visit);
  }

  public List<Visit> getVisits() {
    return visitRepository.findAll();
  }
}
