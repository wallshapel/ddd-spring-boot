package com.services.ms.student.app.application.ports.output;

import com.services.ms.student.app.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentPersistencePort {

  List<Student> index();
  Optional<Student> show(Long id);
  Student save(Student student);
  void destroy(Long id);

}
