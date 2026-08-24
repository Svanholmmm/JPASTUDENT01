package org.example.jpastudent01.repositories;

import org.example.jpastudent01.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
@Autowired
    StudentRepository studentRepository;

@Test
    void madsExistsInDB(){
    List<Student> lst = studentRepository.findAllByName("mads");
    assertEquals(1, lst.size());
}
@Test
    void createStudent(){
    Student s1 = new Student();
    s1.setName("Joakim");
    s1.setBornDate(LocalDate.of(2020, 2, 2));
    s1.setBornTime(LocalTime.now());
    studentRepository.save(s1);
    List<Student> lst = studentRepository.findAllByName("Joakim");
    assertEquals(1, lst.size());
}

}