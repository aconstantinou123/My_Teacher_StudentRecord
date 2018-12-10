package com.myteacher.StudentRecord.Controllers;

import com.myteacher.StudentRecord.Models.Record;
import com.myteacher.StudentRecord.Repositories.StudentRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/")
public class StudentRecordController {

    @Autowired
    StudentRecordRepository studentRecordRepository;

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Record> getAllStudentRecords() {
        return studentRecordRepository.findAll();
    }

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value = "/teacher/{teacherId}", method = RequestMethod.GET)
    public List<Record> getAllStudentRecordsByTeacher(@PathVariable("teacherId") String teacherId) {
        return studentRecordRepository.findAllByTeacherId(teacherId);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @RequestMapping(value = "/student/{username}", method = RequestMethod.GET)
    public Record getStudentByUserName(@PathVariable("username") String username){
        return studentRecordRepository.findByUsername(username);
    }
}
