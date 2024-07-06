package com.services.ms.student.app.infrastructure.adapters.output.persistence;

import com.services.ms.student.app.application.ports.output.StudentPersistencePort;
import com.services.ms.student.app.domain.model.Student;
import com.services.ms.student.app.infrastructure.adapters.output.persistence.mapper.StudentPersistenceMapper;
import com.services.ms.student.app.infrastructure.adapters.output.persistence.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentPersistencePort {

  private final StudentRepository studentRepository;
  private final StudentPersistenceMapper studentPersistenceMapper;

  @Override
  public List<Student> index() {
    return studentPersistenceMapper.toStudentList(studentRepository.findAll());
  }

  @Override
  public Optional<Student> show(Long id) {
    return studentRepository.findById(id).map(studentPersistenceMapper::toStudent);
  }

  @Override
  public Student save(Student student) {
    return studentPersistenceMapper.toStudent(studentRepository.save(studentPersistenceMapper.toStudentEntity(student)));
  }

  @Override
  public void destroy(Long id) {
    studentRepository.deleteById(id);
  }
}
