package me.jko.petclinic.visit.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VisitCreateDto {

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate visitDate;

  @NotEmpty
  private String description;

  private Long ownerId;

  private Long petId;
}
