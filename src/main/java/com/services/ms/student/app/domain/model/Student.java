package com.services.ms.student.app.domain.model;

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
public class Student {

  private Long id;
  private String firstname;
  private String lastname;
  private Integer age;
  private String address;

}

