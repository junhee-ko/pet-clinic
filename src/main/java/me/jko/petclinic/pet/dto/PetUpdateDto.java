package me.jko.petclinic.pet.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PetUpdateDto {

  @NotEmpty
  private String name;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate birthDate;
}
