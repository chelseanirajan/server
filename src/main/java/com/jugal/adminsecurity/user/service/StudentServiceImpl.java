package com.jugal.adminsecurity.user.service;

import com.jugal.adminsecurity.model.User;
import com.jugal.adminsecurity.service.UserService;
import com.jugal.adminsecurity.user.model.Student;
import com.jugal.adminsecurity.user.repository.StudentRepository;
import com.jugal.adminsecurity.user.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {

    @Autowired
    protected UserService userService;


    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student){
        return studentRepository.save(student);
    }
    public List<Student> findAll(){
        return studentRepository.findAll();
    }
    public Student findByUser(User user){
        return studentRepository.findByUser(user);
    }
    public Student findById(long id) {
        return studentRepository.findById(id).get();
    }
    public void deleteById(Long id){
        studentRepository.deleteById(id);
    }
    public void store(MultipartFile file){
        List<Student> lstStudents = ExcelUtils.parseExcelFile(file);
        lstStudents.stream().forEach(student-> student.setUser(userService.getCurrentUser()));
        // Save Students to DataBase
        studentRepository.saveAll(lstStudents);
    }

    // Load Data to Excel File
    public ByteArrayInputStream loadFile() {
        List<Student> product = (List<Student>) studentRepository.findAll();

        try {
            ByteArrayInputStream in = ExcelUtils.productsToExcel(product);
            return in;
        } catch (IOException e) {}

        return null;
    }
    public List<Student> findAllById(List<Long> ids){
        return studentRepository.findAllById(ids);
    }
    public List<Student> findByNameLike(String name){
        return studentRepository.findByNameLike("%" +name+ "%");
    }
    public List<Student> findAllByUser(User user){
        return studentRepository.findAllByUser(user);
    }
}
