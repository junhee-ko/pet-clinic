package me.jko.petclinic.owner.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import me.jko.petclinic.owner.service.OwnerService;

@RestController
@RequiredArgsConstructor
public class OwnerController {

  private final OwnerService ownerService;


}
