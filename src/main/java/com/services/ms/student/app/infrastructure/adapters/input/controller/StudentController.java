package com.services.ms.student.app.infrastructure.adapters.input.controller;

import com.services.ms.student.app.application.ports.input.StudentServicePort;
import com.services.ms.student.app.infrastructure.adapters.input.mapper.StudentRestMapper;
import com.services.ms.student.app.infrastructure.adapters.input.model.request.StudentCreateRequest;
import com.services.ms.student.app.infrastructure.adapters.input.model.response.StudentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
@CrossOrigin(origins = "*")
public class StudentController {

  private final StudentServicePort studentServicePort;
  private final StudentRestMapper studentRestMapper;

  @GetMapping
  public List<StudentResponse> index() {
    return studentRestMapper.toStudentResponseList(studentServicePort.index());
  }

  @GetMapping("/{id}")
  public StudentResponse show(@PathVariable Long id) {
    return studentRestMapper.toStudentResponse(studentServicePort.show(id));
  }

  @PostMapping
  public ResponseEntity<StudentResponse> store(@Valid @RequestBody StudentCreateRequest studentCreateRequest) {
    return ResponseEntity.status(HttpStatus.CREATED).body(studentRestMapper.toStudentResponse(studentServicePort.store(studentRestMapper.toStudent(studentCreateRequest))));
  }

  @PutMapping("/{id}")
  public StudentResponse update(@PathVariable Long id, @Valid @RequestBody StudentCreateRequest request) {
    return studentRestMapper.toStudentResponse(studentServicePort.update(id, studentRestMapper.toStudent(request)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> destroy(@PathVariable Long id) {
    studentServicePort.destroy(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
