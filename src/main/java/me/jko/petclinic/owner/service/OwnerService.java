package me.jko.petclinic.owner.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.jko.petclinic.owner.repository.OwnerRepository;

@Service
@RequiredArgsConstructor
public class OwnerService {

  private final OwnerRepository ownerRepository;


}
