package com.example.chap17mybatis;

import com.example.chap17mybatis.dao.ArticleDao;
import com.example.chap17mybatis.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chap17MybatisApplicationTests {

    @Autowired
    ArticleDao articleDao;

    @Test
    void 게시판_건수_출력() {
        System.out.println(articleDao.selectCount());
    }
    @Test
    void 게시판_목록_출력() {
        for (Article article : articleDao.select(0, 9)) {
            System.out.println(article);
        }
    }
}