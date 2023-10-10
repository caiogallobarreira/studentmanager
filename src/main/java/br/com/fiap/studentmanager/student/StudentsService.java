package br.com.fiap.studentmanager.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentsService {
    
    @Autowired
    StudentsRepository studentRepository;

    public List<Students> findAll() {
        return studentRepository.findAll();
    }

    public boolean delete(Long id) {
        var student = studentRepository.findById(id);
        if (student.isEmpty()) return false;
        studentRepository.deleteById(id);
        return true;
    }
}
