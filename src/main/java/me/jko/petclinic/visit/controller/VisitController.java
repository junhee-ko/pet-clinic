package me.jko.petclinic.visit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import me.jko.petclinic.visit.dto.VisitCreateDto;
import me.jko.petclinic.visit.entity.Visit;
import me.jko.petclinic.visit.service.VisitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VisitController {

  private final VisitService visitService;

  @PostMapping("/visits")
  public Visit createVisit(@Valid VisitCreateDto visitCreateDto) {
    return visitService.saveVisitBy(visitCreateDto);
  }

  @GetMapping("/visits")
  public List<Visit> getVisits() {
    return visitService.getVisits();
  }
}
