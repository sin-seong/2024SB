package com.sin.sb1023;

import com.sin.sb1023.entity.Member;
import com.sin.sb1023.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import java.util.List;

@SpringBootTest
class Sb1023ApplicationTests {

        @PersistenceUnit
        private EntityManagerFactory emf;



    @Test
    void test_Save_Data(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Team team = new Team("team1", "팀1");
        em.persist(team);
        Member member1 = new Member("member1", "이르");
        member1.setTeam(team);
        em.persist(member1);
        Member member2 = new Member("member2", "힘");
        member2.setTeam(team);
        em.persist(member2);

        tx.commit();
    }

    @Test
    void test_find() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        String jqpl = "select m from Member m join m.team t where t.name=:teamName";
        List<Member> resultList = em.createQuery(jqpl, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();
        for(Member member : resultList){
            System.out.println(member);
        }

        tx.commit();
    }

    @Test
    void test_find2() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member = em.find(Member.class, "member1");
        System.out.println(member);
        System.out.println("팀이름:" + member.getTeam().getName());

        tx.commit();
    }

    @Test
    void test_update() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);
        em.find(Member.class, "member1").setTeam(team2);


        tx.commit();
    }

    @Test
    void test_연관관계제거() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null);

        tx.commit();
    }

    @Test
    void test_연관된_엔티티_삭제() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team = em.find(Team.class, "team2");
        em.remove(team);


        tx.commit();
    }

    @Test
    void test_연관된_엔티티_삭제2() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Member member2 = em.find(Member.class, "member2");
        member2.setTeam(null);

        Team team = em.find(Team.class, "team1");
        em.remove(team);



        tx.commit();
    }
    @Test
    void test_양방향_탐색() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team = em.find(Team.class, "team1");
        for(Member member : team.getMembers()){
            System.out.println(member);
        }


        tx.commit();
    }

    @Test
    void test_양방향_탐색2() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Team team = em.find(Team.class, "team1");
        for(Member member : team.getMembers()){
            System.out.println(member.getTeam().getName());
        }

        tx.commit();
    }


















    @Test
    void 순개() {
        Member member1 = new Member("member1", "회원1");
        Member member2 = new Member("member2", "회원2");
        Team team = new Team("team1","팀1");

        member1.setTeam(team);
        member2.setTeam(team);
        System.out.println(member1);
        System.out.println(member2);
    }


}
