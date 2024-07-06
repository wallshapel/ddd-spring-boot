package com.services.ms.student.app.infrastructure.adapters.input.model.response;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class StudentResponse {

  private String firstname;
  private String lastname;
  private Integer age;
  private String address;

}



