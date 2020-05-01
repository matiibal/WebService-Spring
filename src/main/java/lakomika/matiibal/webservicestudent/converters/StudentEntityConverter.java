package lakomika.matiibal.webservicestudent.converters;

import lakomika.matiibal.webservicestudent.dao.entity.Student;
import lakomika.matiibal.webservicestudent.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentEntityConverter {
    private static ModelMapper modelMapper;

    @Autowired
    public StudentEntityConverter(ModelMapper modelMapper) {
        StudentEntityConverter.modelMapper = modelMapper;
    }

    public static Student convertToEntity(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        setStudentDetails(studentDto, student);
        return student;
    }

    public static StudentDto convertToDto(Student student) {
        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        setStudentDetails(student, studentDto);
        return studentDto;
    }

    private static void setStudentDetails(Student student, StudentDto studentDto) {
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        studentDto.setCity(student.getCity());
        studentDto.setIndex(student.getIndex());
        studentDto.setNumberOfFlat(student.getNumberOfFlat());
        studentDto.setTown(student.getTown());
        studentDto.setPostalCode(student.getPostalCode());
        studentDto.setPhoneNumber(student.getPhoneNumber());
    }

    private static void setStudentDetails(StudentDto studentDto, Student student) {
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setCity(studentDto.getCity());
        student.setIndex(studentDto.getIndex());
        student.setNumberOfFlat(studentDto.getNumberOfFlat());
        student.setPostalCode(studentDto.getPostalCode());
        student.setTown(studentDto.getTown());
        student.setPhoneNumber(studentDto.getPhoneNumber());
    }

}
