package com.sin.sb1015_2.repository;

import com.sin.sb1015_2.entity.MyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyDataRepository  extends JpaRepository<MyData,Long> {

        @Query("select m from MyData m order by m.id desc ")
        List<MyData> getListDesc();

}
