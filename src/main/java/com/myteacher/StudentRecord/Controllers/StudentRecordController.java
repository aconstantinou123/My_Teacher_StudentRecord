package com.myteacher.StudentRecord.Controllers;

import com.myteacher.StudentRecord.Models.Record;
import com.myteacher.StudentRecord.Repositories.StudentRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:8080", allowedHeaders="*")
public class StudentRecordController {
    @Autowired
    StudentRecordRepository studentRecordRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Record> getAllStudentRecords() {
        return studentRecordRepository.findAll();
    }

    @RequestMapping(value = "/teacher/{teacherId}", method = RequestMethod.GET)
    public List<Record> getAllStudentRecordsByTeacher(@PathVariable("teacherId") String teacherId) {
        return studentRecordRepository.findAllByTeacherId(teacherId);
    }
}
