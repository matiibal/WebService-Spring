package lakomika.matiibal.webservicestudent.controllers;

import lakomika.matiibal.webservicestudent.converters.StudentEntityConverter;
import lakomika.matiibal.webservicestudent.dao.entity.Student;
import lakomika.matiibal.webservicestudent.dto.StudentDto;
import lakomika.matiibal.webservicestudent.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/allStudents")
    @CrossOrigin
    public Iterable<StudentDto> getAllStudents()
    {
    return studentService.getAllStudents();
    }

    @PostMapping("/addStudent")
    @CrossOrigin
    public Student addNewStudent(@RequestBody StudentDto studentDto)
    {
        return studentService.save(StudentEntityConverter.convertToEntity(studentDto));
    }

    @DeleteMapping("/student/{id}")
    @CrossOrigin
    public void deleteStudent(@PathVariable(value = "id") Long id)
    {
        Student student = studentService.getStudentById(id).get();
        studentService.deleteStudent(student);
    }
    @GetMapping("/student/{id}")
    @CrossOrigin
    public Optional<StudentDto> getStudent(@PathVariable(value = "id") Long id)
    {
        return Optional.ofNullable(StudentEntityConverter.convertToDto(studentService.getStudentById(id).get()));

    }
    @PutMapping("/student/{id}")
    @CrossOrigin
    public ResponseEntity<Student> updateEmployee(@PathVariable(value = "id") Long id,
                                                     @Valid @RequestBody StudentDto studentDetails) {

        Student student = studentService.getStudentById(id).get();
        student.setName(studentDetails.getName());
        student.setSurname(studentDetails.getSurname());
        student.setIndex(studentDetails.getIndex());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setPostalCode(studentDetails.getPostalCode());
        student.setCity(studentDetails.getCity());
        student.setNumberOfFlat(studentDetails.getNumberOfFlat());
        student.setTown(studentDetails.getTown());
        final Student updatedStudent = studentService.save(student);
        return ResponseEntity.ok(updatedStudent);
    }
}
