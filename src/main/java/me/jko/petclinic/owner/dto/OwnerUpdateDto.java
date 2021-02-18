package me.jko.petclinic.owner.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerUpdateDto {

  @NotEmpty
  private String firstName;

  @NotEmpty
  private String lastName;

  @NotEmpty
  private String address;

  @NotEmpty
  private String city;

  @NotEmpty
  @Digits(fraction = 0, integer = 10)
  private String telephone;
}
