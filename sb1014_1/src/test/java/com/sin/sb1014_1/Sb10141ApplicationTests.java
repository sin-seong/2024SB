package com.sin.sb1014_1;

import com.sin.sb1014_1.entity.Board;
import com.sin.sb1014_1.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Sb10141ApplicationTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void selectAll() {
        for (Board board : boardRepository.findAll()) {
            System.out.println(board);
        }
    }
    @Test
    void selectAll2() {
        for (Board board : boardRepository.selectBoardList()) {
            System.out.println(board);
        }
    }

}
