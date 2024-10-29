package com.sin.sb1029.service;

import com.sin.sb1029.entity.Notice;
import com.sin.sb1029.repository.NoticeRepository;
import groovy.util.logging.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class NoticeService {

    @Autowired
    NoticeRepository noticeRepository;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    public Page<Notice> findAllBoards(Pageable pageable) {
        return noticeRepository.findAll(pageable); // Page<Notice> 반환
    }

    public List<Notice> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Notice> notices = em.createQuery("select n from Notice n").getResultList();
        em.close();
        return notices;
    }
    public void save(Notice notice) {
        noticeRepository.save(notice); // JPA를 사용하여 저장
    }

    public Notice findById(int boardIdx) {
        Optional<Notice> noticeOptional = noticeRepository.findById(boardIdx);
        return noticeOptional.orElse(null); // 존재하지 않을 경우 null 반환
    }

    public void update(Notice notice) {
        noticeRepository.save(notice); // JPA를 사용하여 업데이트
    }

    public void delete(int boardIdx) {
        noticeRepository.deleteById(boardIdx); // ID로 삭제
    }
}
