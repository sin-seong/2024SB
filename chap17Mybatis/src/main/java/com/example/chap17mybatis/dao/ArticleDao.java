package com.example.chap17mybatis.dao;

import com.example.chap17mybatis.model.Article;
import org.apache.ibatis.annotations.*;

import java.sql.Connection;
import java.util.List;

@Mapper
public interface ArticleDao {

    @Select("select count(*) from article")
    public int selectCount();
    @Select("select article_id id, group_id groupId, sequence_no sequenceNumber, posting_date postingDate, read_count readCount, writer_name writerName, password, title from article order by sequence_no desc limit #{firstRow}, #{endRow}")
    public List<Article> select(int firstRow, int endRow);
    @Insert("insert into article "
            + "(group_id, sequence_no, posting_date, read_count, "
            + "writer_name, password, title, content) "
            + "values (#{article.groupId}, #{article.sequenceNumber}, #{article.postingDate}, 0, #{article.writerName}, #{article.password}, #{article.title}, #{article.content})")
   @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int insert(Article article);
    @Select("select article_id id, group_id groupId, sequence_no sequenceNumber, posting_date postingDate, read_count readCount, writer_name writerName, password, title, content from article where article_id = #{articleId}")
    public Article selectById(int articleId);
    @Update("update article "
            + "set read_count = read_count + 1 "
            + "where article_id = #{articleId}")
    public void increaseReadCount(int articleId);
    public String selectLastSequenceNumber(String searchMaxSeqNum, String searchMinSeqNum);
    public int update(Article article);
    public void delete(int articleId);


}
