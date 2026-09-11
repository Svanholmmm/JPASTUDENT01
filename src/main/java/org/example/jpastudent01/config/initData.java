package org.example.jpastudent01.config;

import org.example.jpastudent01.model.Student;
import org.example.jpastudent01.model.Unicode;
import org.example.jpastudent01.repositories.StudentRepository;
import org.example.jpastudent01.repositories.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class initData implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    UnicodeRepository unicodeRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Hans");
        s1.setBornDate(LocalDate.of(2001, 12, 29));
        s1.setBornTime(LocalTime.of(10, 11, 12));
        Student s2 = new Student();
        s2.setName("Freja");
        s2.setBornDate(LocalDate.of(2002, 7, 7));
        s2.setBornTime(LocalTime.of(9, 10, 11));
        studentRepository.save(s1);
        s1.setName("Mads");
        studentRepository.save(s1);
        studentRepository.save(s2);

        Set<Character> characters = new HashSet<>();
        characters.add('A');
        characters.add('B');
        characters.add('C');

      for (Character c : characters){
          Unicode u = new Unicode();
          u.setUnicode((int) c);
          u.setSymbol(c);
          u.setDescription("Character " + c);
          unicodeRepository.save(u);
        }
    }
}