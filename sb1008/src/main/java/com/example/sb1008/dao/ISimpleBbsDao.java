package com.example.sb1008.dao;


import com.example.sb1008.dto.SimpleBbsDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ISimpleBbsDao {

//  @Select("select * from simple_bbs order by id desc")
    public List<SimpleBbsDto> listDao();
//    @Select("select * from simple_bbs where id = #{id};")
    public SimpleBbsDto viewDao(String id);
//    @Insert("insert into simple_bbs(writer,title,content) values (#{writer},#{title},#{content})")
    public int writeDao(String writer, String title, String content);
//    @Delete("delete from simple_bbs where id = #{id}")
    public int deleteDao(String id);
//    @Update("update simple_bbs SET writer = #{writer}, title = #{title}, content = #{content} where id = #{id}")
    public int updateDao(String id, String writer, String title, String content);

}
