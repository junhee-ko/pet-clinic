package me.jko.petclinic.pet.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import me.jko.petclinic.owner.entity.Owner;

import java.time.LocalDate;

@Entity
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private String name;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;

//  @ManyToOne
//  @JoinColumn(name = "type_id")
//  private PetType type;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private Owner owner;

//  @Transient
//  private Set<Visit> visits = new LinkedHashSet<>();
}
