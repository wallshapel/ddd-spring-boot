package com.services.ms.student.app.application.service;

import com.services.ms.student.app.application.ports.input.StudentServicePort;
import com.services.ms.student.app.application.ports.output.StudentPersistencePort;
import com.services.ms.student.app.infrastructure.adapters.input.exception.NotFoundException;
import com.services.ms.student.app.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements StudentServicePort {

    private final StudentPersistencePort studentPersistencePort;

    @Override
    @Transactional(readOnly = true)
    public List<Student> index() {
    return studentPersistencePort.index();
    }

    @Override
    @Transactional(readOnly = true)
    public Student show(Long id) {
        return studentPersistencePort.show(id).orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public Student store(Student student) {
    return studentPersistencePort.save(student);
    }

    @Override
    @Transactional
    public Student update(Long id, Student student) {
    return studentPersistencePort.show(id)
        .map(savedStudent -> {
          savedStudent.setFirstname(student.getFirstname());
          savedStudent.setLastname(student.getLastname());
          savedStudent.setAge(student.getAge());
          savedStudent.setAddress(student.getAddress());
          return studentPersistencePort.save(savedStudent);
        })
        .orElseThrow(NotFoundException::new);
    }

    @Override
    @Transactional
    public void destroy(Long id) {
        this.show(id);
        studentPersistencePort.destroy(id);
    }

}
