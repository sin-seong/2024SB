package com.sin.sb1018;

import com.sin.sb1018.entity.Dept;
import com.sin.sb1018.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.*;
import java.util.List;

@SpringBootTest
class Sb1018ApplicationTests {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @PersistenceContext
    private EntityManager em;

    @Test
    void 영속성테스트_find테스트() {
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Dept dept = em.find(Dept.class, 10);//find = select
        dept.setDname("서울");
        System.out.println(dept);
        tx.commit();
    }

    @Test
    void 영속성테스트_find테스트2() {
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Dept dept = em.find(Dept.class, 10);//find = select
        dept.setDname("성남");
        System.out.println(dept);
        em.detach(dept);
        em.merge(dept); //업데이트
        tx.commit();
    }

    @Test
    void 영속성_persist_테스트() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Dept newDept = new Dept();
        newDept.setDeptno(50);
        newDept.setDname("연구소");
        newDept.setLoc("서울");

        em.persist(newDept);

        em.getTransaction().commit();
    }
    @Test
    void 영속성_remove_테스트() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Dept dept = em.find(Dept.class, 50);
        System.out.println(dept);
        em.remove(dept);
        tx.commit();
    }

    @Test
    void 영속성_update_테스트() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Dept dept = em.find(Dept.class, 10);
        dept.setDname("ACCOUNTING");
        dept.setLoc("Seoul");
        System.out.println(dept);
        tx.commit();
    }

    @Test
    void createQuery_테스트() {
        Dept dept = em.find(Dept.class, 10);
        System.out.println(dept);
        System.out.println("===================================================");
        TypedQuery<Dept> query = em.createQuery("select d from Dept d", Dept.class);
        List<Dept> list = query.getResultList();
        for (Dept d : list) {
            System.out.println(d);
            System.out.println("===================================================");
            TypedQuery<Emp> query2 = em.createQuery("select e from Emp e", Emp.class);
            List<Emp> emlist = query2.getResultList();
            for (Emp e : emlist) {
                System.out.println(e);
            }
        }
    }



    @Test
    void createQuery_영속성테스트(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        System.out.println("===================================================");
        TypedQuery<Dept> query = em.createQuery("select d from Dept d", Dept.class);
        List<Dept> list = query.getResultList();
        for (Dept d : list) {
            System.out.println(d);
        }
        System.out.println(list.get(0));
        list.get(0).setLoc("서울");
        tx.commit();
    }
    @Test
    void createQuery_테스트2() {
        String jpql = "SELECT d FROM Dept d WHERE d.dname = :deptName";
        TypedQuery<Dept> query = em.createQuery(jpql, Dept.class);
        query.setParameter("deptName", "ACCOUNTING");
        List<Dept> depts = query.getResultList();
        Dept dept = depts.get(0);
        System.out.println(depts.get(0));
            System.out.println("===================================================");
            String jpql2 = "SELECT d FROM Emp d WHERE d.deptno = :deptNo";
            TypedQuery<Emp> query2 = em.createQuery(jpql2, Emp.class);
            query2.setParameter("deptNo", dept.getDeptno());
            List<Emp> emlist = query2.getResultList();
            for (Emp e : emlist) {
                System.out.println(e);
            }
        }

}
