package com.sin.sb1101.service;

import com.sin.sb1101.dto.Fnotice;
import com.sin.sb1101.dto.Notice;
import com.sin.sb1101.repository.FnoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FnoticeService {

    @Autowired
    FnoticeRepository fnoticeRepository;

    public Fnotice savaNotice(String title, String content, String username) {
        Fnotice fnotice = new Fnotice();
        fnotice.setTitle(title);
        fnotice.setContent(content);
        fnotice.setUsername(username);
        fnotice.setDate(java.time.LocalDateTime.now());
        fnotice.setHitCnt(0);


        return fnoticeRepository.save(fnotice);

    }
    public List<Fnotice> getAllFnotices() {
        return fnoticeRepository.findAll();
    }

}
