package com.jugal.adminsecurity.user.controller;

import com.jugal.adminsecurity.user.model.Student;
import com.jugal.adminsecurity.user.service.StudentServiceImpl;
import com.jugal.adminsecurity.user.utils.PdfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
@RestController
public class SelectedPdfDownloadController {
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "/user/student/checked", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> citiesReport(@RequestParam("checkIds") List<Long> ids) throws IOException {
        List<Student> std = studentService.findAllById(ids);
        //Student student =  studentService.findById(id);// yema multiple id haney ra multiple student chiney

        ByteArrayInputStream bis = PdfUtils.citiesReport(std); // yema pathaya ra multiple data line

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=selectStudentResult.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}

