package edu.du.sb1024;

import edu.du.sb1024.fileuploadboard.entity.Board;
import edu.du.sb1024.fileuploadboard.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class Sb1024ApplicationTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void testPage1() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Board> page = boardRepository.findAllByOrderByBoardIdxDesc(pageable);
        page.forEach(board -> System.out.println("수="+board));
    }
    @Test
    void testPage2() {
        Pageable pageable = PageRequest.of(0, 10);
        List<Board> page = boardRepository.findAllByOrderByBoardIdxDesc(pageable);
        System.out.println(page.getFirst());
        System.out.println(page.getLast());
        System.out.println(page.size());
        System.out.println(page.isEmpty());
//        System.out.println(page.get);


    }
}
