package com.services.ms.student.app.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ErrorResponse {

  private String code;
  private String message;
  private List<String> details;
  private LocalDateTime timestamp;

}

