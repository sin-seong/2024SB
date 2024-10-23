package com.sin.sb1021_2.repository;

import com.sin.sb1021_2.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
