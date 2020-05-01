package lakomika.matiibal.webservicestudent.controllers;

import lakomika.matiibal.webservicestudent.converters.StudentEntityConverter;
import lakomika.matiibal.webservicestudent.dao.entity.Student;
import lakomika.matiibal.webservicestudent.dto.StudentDto;
import lakomika.matiibal.webservicestudent.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(studentDto.getIndex());
        System.out.println(studentDto.getPhoneNumber());
        return studentService.save(StudentEntityConverter.convertToEntity(studentDto));
    }

    @DeleteMapping("/student/{id}")
    @CrossOrigin
    public void deleteStudent(@PathVariable(value = "id") Long id)
    {
        Student student = studentService.getStudentById(id).get();
        System.out.println(student.getIndex());
        studentService.deleteStudent(student);
    }
}
