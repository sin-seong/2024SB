package com.sin.sb1101.repository;

import com.sin.sb1101.dto.Fnotice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FnoticeRepository extends JpaRepository<Fnotice, Long> {
}
