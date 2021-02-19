package me.jko.petclinic.pet.entity;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.jko.petclinic.owner.entity.Owner;
import me.jko.petclinic.pet.dto.PetUpdateDto;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  @JsonBackReference
  private Owner owner;

  public void updateBy(PetUpdateDto petUpdateDto) {
    this.name = petUpdateDto.getName();
    this.birthDate = petUpdateDto.getBirthDate();
  }
}
