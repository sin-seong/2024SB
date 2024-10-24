package com.sin.sb1024.service;


import com.sin.sb1024.entity.AnsweredData;
import com.sin.sb1024.entity.Respondent;
import com.sin.sb1024.repository.AnsweredDateRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Service
@Log4j2
public class AnswereDataService {
    @PersistenceUnit
    private EntityManagerFactory emf;

    public void save(AnsweredData data) {
        // 트랜잭션 시작
        EntityManager em = emf.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        log.info(data.toString());
        Respondent respondent = data.getRes();
        em.persist(respondent);
        em.persist(data);
        transaction.commit();
    }
}