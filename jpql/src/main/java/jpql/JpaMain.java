package jpql;import javax.persistence.*;import java.util.List;public class JpaMain {    public static void main(String[] args) {        EntityManagerFactory emf =Persistence.createEntityManagerFactory("hello");        EntityManager em = emf.createEntityManager();        EntityTransaction tx= em.getTransaction();        tx.begin();        try{            Member member = new Member();            member.setUsername("관리자");            member.setAge(10);            em.persist(member);            Member member2 = new Member();            member2.setUsername("회원");            member2.setAge(20);            em.persist(member2);            em.flush();            em.clear();            String query = "select function('group_concat', m.username) From Member m";            List<String> resultList = em.createQuery(query, String.class).getResultList();            for (String s : resultList) {                System.out.println("s = " + s);            }          //프로젝션          List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)                  .getResultList();          MemberDTO memberDTO = result.get(0);          System.out.println("memberDTO = " + memberDTO.getUsername());          System.out.println("memberDTO = " + memberDTO.getAge());            tx.commit();        } catch (Exception e){            tx.rollback();        }finally {            em.close();        }        emf.close();    }}