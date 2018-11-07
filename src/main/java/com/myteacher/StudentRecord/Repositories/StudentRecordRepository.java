package com.myteacher.StudentRecord.Repositories;

import com.myteacher.StudentRecord.Models.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRecordRepository extends MongoRepository<Record, String> {
    Record findByUsername(String username);
    List<Record> findAllByTeacherId(String teacherId);
}