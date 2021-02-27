package me.jko.petclinic.owner.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.jko.petclinic.owner.dto.OwnerCreateDto;
import me.jko.petclinic.owner.dto.OwnerUpdateDto;
import me.jko.petclinic.pet.entity.Pet;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Owner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;

  private String lastName;

  private String address;

  private String city;

  private String telephone;

  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
  @JsonManagedReference
  private Set<Pet> pets;

  public static Owner of(OwnerCreateDto ownerCreateDto) {
    return Owner.builder()
        .firstName(ownerCreateDto.getFirstName())
        .lastName(ownerCreateDto.getLastName())
        .address(ownerCreateDto.getAddress())
        .city(ownerCreateDto.getCity())
        .telephone(ownerCreateDto.getTelephone())
        .pets(null)
        .build();
  }

  public void updateBy(OwnerUpdateDto ownerUpdateDto) {
    this.firstName = ownerUpdateDto.getFirstName();
    this.lastName = ownerUpdateDto.getLastName();
    this.address = ownerUpdateDto.getAddress();
    this.city = ownerUpdateDto.getCity();
    this.telephone = ownerUpdateDto.getTelephone();
  }

  public void add(Pet pet) {
    if (pets == null) {
      this.pets = new HashSet<>();
    }

    pets.add(pet);
  }
}
