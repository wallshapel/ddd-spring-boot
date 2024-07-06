package com.services.ms.student.app.application.ports.input;

import com.services.ms.student.app.domain.model.Student;

import java.util.List;

public interface StudentServicePort {

  List<Student> index();
  Student show(Long id);
  Student store(Student student);
  Student update(Long id, Student student);
  void destroy(Long id);

}
