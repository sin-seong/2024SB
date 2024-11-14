package com.sin.sb1101.repository;

import com.sin.sb1101.dto.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByFnoticeId(Long fnoticeId);
}
