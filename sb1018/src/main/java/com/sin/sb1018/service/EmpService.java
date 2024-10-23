package com.sin.sb1018.service;

import com.sin.sb1018.entity.Dept;
import com.sin.sb1018.entity.Emp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EmpService {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    public Dept updateDept(int deptNo, String deptName) {
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Dept dept = em.find(Dept.class, deptNo);//find = select
        if (dept != null) {
            dept.setDname(deptName);
            log.info("update dept {}  with name {}", deptName, deptNo);
        } else {
            log.info("그런 {} 부서음슴", deptNo);
        }
        System.out.println(dept);
        tx.commit();
        return dept;
    }

    public Dept delete(int deptNo) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Dept dept = em.find(Dept.class, deptNo);
        System.out.println(dept);
        em.remove(dept);
        tx.commit();
        return dept;
    }

    public List<Dept> list() {
        EntityManager em = emf.createEntityManager();
        List<Dept> list = new ArrayList<>();
        TypedQuery<Dept> query = em.createQuery("select d from Dept d", Dept.class);
         list = query.getResultList();
        for (Dept d : list) {
            System.out.println(d);
            System.out.println("===================================================");

        }
        return list;
    }

    public String insert(int deptNo, String deptName, String loc) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Dept newDept = new Dept();
        newDept.setDeptno(deptNo);
        newDept.setDname(deptName);
        newDept.setLoc(loc);

        em.persist(newDept);

        em.getTransaction().commit();
        return "부서 '" + deptName + "'가 추가되었습니다.";
    }

    public List<Emp> empSelect(int deptNo) {
            TypedQuery<Emp> query = em.createQuery("select e from Emp e where e.deptno =:deptNo", Emp.class);
            query.setParameter("deptNo", deptNo);
            List<Emp> emlist = query.getResultList();
        for (Emp e : emlist) {
            System.out.println(e);
            System.out.println("===================================================");

        }
            return emlist;
            }
        }



