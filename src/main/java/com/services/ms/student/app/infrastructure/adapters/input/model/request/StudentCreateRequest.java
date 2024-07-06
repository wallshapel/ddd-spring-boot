package com.services.ms.student.app.infrastructure.adapters.input.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateRequest {

  @NotBlank(message = "Firstname field cannot be empty or null")
  @Size(min = 2, max = 50, message = "Firstname field must be between 2 and 50 characters")
  private String firstname;

  @NotBlank(message = "Lastname field cannot be empty or null")
  @Size(min = 2, max = 50, message = "Lastname field must be between 2 and 50 characters")
  private String lastname;

  @NotNull(message = "Age field age cannot be null")
  @Positive(message = "Age field must be an integer")
  private Integer age;

  @NotBlank(message = "Address Field cannot be empty or null")
  @Size(min = 2, max = 100, message = "Address field must be between 2 and 100 characters")
  private String address;

}
