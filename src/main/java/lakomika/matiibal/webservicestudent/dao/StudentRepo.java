package lakomika.matiibal.webservicestudent.dao;

import lakomika.matiibal.webservicestudent.dao.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
