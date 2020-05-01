package lakomika.matiibal.webservicestudent.services;

import lakomika.matiibal.webservicestudent.converters.StudentEntityConverter;
import lakomika.matiibal.webservicestudent.dao.StudentRepo;
import lakomika.matiibal.webservicestudent.dao.entity.Student;
import lakomika.matiibal.webservicestudent.dto.StudentDto;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.EntityConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Iterable<StudentDto> getAllStudents() {
        List<Student> students = IterableUtils.toList(studentRepo.findAll());
        List<StudentDto> studentsDto = new ArrayList<>();
        students.forEach(e ->
        {
            studentsDto.add(StudentEntityConverter.convertToDto(e));
        });
        return studentsDto;
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    public Optional<Student> getStudentById(Long id)
    {
        return studentRepo.findById(id);
    }

    public void deleteStudent(Student student)
    {
        studentRepo.delete(student);
    }
}
