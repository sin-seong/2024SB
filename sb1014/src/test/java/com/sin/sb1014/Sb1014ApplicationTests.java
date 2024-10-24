package com.sin.sb1014;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class Sb1014ApplicationTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    void insert_Memo() {
//        System.out.println(memoRepository.getClass().getName());
        IntStream.range(0,10).forEach(i->{
//            System.out.println(i);
            Memo memo = Memo.builder().memoText("샘플"+i)
                    .build();
//            System.out.println(memo);
        memoRepository.save(memo);
        });

    }
    @Test
    void select_Memo(){
        Long mno = 29L;
        Optional<Memo> result = memoRepository.findById(mno);
        if(result.isPresent()){
            Memo memo = result.get();
            System.out.println(memo);
        }else{
            System.out.println("음슴체");
        }
//        System.out.println(result.get());
    }
    @Test
    void findAll_Memo(){
        List<Memo> memos = memoRepository.findAll();
        for (Memo memo : memos) {
            System.out.println(memo);
        }
    }
    @Test
    void update_Memo(){
        Memo memo = Memo.builder().id(1L).memoText("샘플100")
                .build();
        memoRepository.save(memo);
    }
    @Test
    void delete_Memo(){
        Long mno = 1L;
        memoRepository.deleteById(mno);
    }
    @Test
    void 테스트_쿼리메소드(){
        List<Memo> memos = memoRepository.findByIdBetween(2L,7L);
        for (Memo memo : memos) {
            System.out.println(memo);
        }
    }

    @Test
    void 테스트_쿼리메소드2(){
        List<Memo> memos = memoRepository.findByIdBetweenOrderByIdDesc(1L,4L);
        for (Memo memo : memos) {
            System.out.println(memo);
        }
    }

    @Test
    void 테스트_쿼리어노테이션(){
        List<Memo> memos = memoRepository.getListDesc();
        for (Memo memo : memos) {
            System.out.println(memo);
        }
    }

    @Test
    void 테스트_카운팅(){
        System.out.println(memoRepository.count());
        List<Memo> memos = memoRepository.getListDesc();
        for (Memo memo : memos) {
            System.out.println(memo);
        }
    }
}