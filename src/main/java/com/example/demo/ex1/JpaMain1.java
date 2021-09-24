package com.example.demo.ex1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JpaMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		try {
			Team team1 = new Team();
			team1.setName("팀A");
			em.persist(team1);
			
			Team team2 = new Team();
			team2.setName("팀B");
			em.persist(team2);
			
			Member mem1 = new Member();
			mem1.setUserName("회원1");
			mem1.setTeam(team1);
			em.persist(mem1);
			
			Member mem2 = new Member();
			mem2.setUserName("회원2");
			mem2.setTeam(team1);
			em.persist(mem2);
			
			
			Member mem3 = new Member();
			mem3.setUserName("회원3");
			mem3.setTeam(team2);
			em.persist(mem3);
	
			em.flush();
			em.clear();
			
			
//			String query = "select m from Member m join m.team";
//			
//			List<Member> result = em.createQuery(query, Member.class)
//									.getResultList();
//			
//			for(Member member : result) {
//				System.out.println(member.getUserName() +" ----  "+member.getTeam().getName());
//			}
			
//			em.createNamedQuery("Member.findByUserName")
//				.setParameter("userName","회원1").getResultList();
				
			em.createQuery("update Member m set m.age = 20").executeUpdate();
			em.clear();
			
			Member findMember = em.find(Member.class,mem1.getId());
			System.out.println("Member1.age = "+findMember.getAge());
			
			tx.commit();
			
		} catch(Exception e){
			tx.rollback();
			
		}finally {
			em.close();
			emf.close();
		}
		
	}

}
