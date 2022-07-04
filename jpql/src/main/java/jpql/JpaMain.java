package jpql;

import javax.persistence.*;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx= em.getTransaction();

        tx.begin();
        try{

          Member member = new Member();
          member.setUsername("member1");
          member.setAge(10);
          em.persist(member);

          TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
          // TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class); // 변환 타입이 명확한 경우
          // Query query3 = em.createQuery("select m.username, m.age from Member m"); //반환 타입이 명확하지 않은 경우

            Member result = query.getSingleResult();
            System.out.println("result = " + result);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}