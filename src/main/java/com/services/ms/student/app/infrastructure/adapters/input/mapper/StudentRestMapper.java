package com.services.ms.student.app.infrastructure.adapters.input.mapper;

import com.services.ms.student.app.domain.model.Student;
import com.services.ms.student.app.infrastructure.adapters.input.model.request.StudentCreateRequest;
import com.services.ms.student.app.infrastructure.adapters.input.model.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentRestMapper {

  Student toStudent(StudentCreateRequest request);

  StudentResponse toStudentResponse(Student student);

  List<StudentResponse> toStudentResponseList(List<Student> studentList);

}
