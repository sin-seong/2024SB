package com.sin.test1023.service;

import com.sin.test1023.entity.AnsweredData;
import com.sin.test1023.repository.AnsweredDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswereDataService {
    @Autowired
    private AnsweredDateRepository repository;

    public void saveAnsweredDate(AnsweredData data) {
        repository.save(data);
    }
}
