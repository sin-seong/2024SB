package com.sin.sb1101.service;

import com.sin.sb1101.dto.Comment;
import com.sin.sb1101.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

        @Autowired
        CommentRepository commentRepository;

        public void addComment(Comment comment) {
            commentRepository.save(comment);
        }

        public List<Comment> getComments(Long fnoticeId) {
            return commentRepository.findByFnoticeId(fnoticeId);
        }

}
