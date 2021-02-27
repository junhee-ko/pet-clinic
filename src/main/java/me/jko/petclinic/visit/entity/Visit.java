package me.jko.petclinic.visit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.jko.petclinic.visit.dto.VisitCreateDto;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private LocalDate visitDate;

  private String description;

  private Long ownerId;

  private Long petId;

  public static Visit of(VisitCreateDto visitCreateDto) {
    return Visit.builder()
        .visitDate(visitCreateDto.getVisitDate())
        .description(visitCreateDto.getDescription())
        .ownerId(visitCreateDto.getOwnerId())
        .petId(visitCreateDto.getPetId())
        .build();
  }
}
