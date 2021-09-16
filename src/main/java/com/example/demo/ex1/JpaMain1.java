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
			Member member = new Member();
			member.setUserName("hongma");
			member.setAge(31);
			em.persist(member);
			
//			Member result = 
//					em.createQuery("select m from Member m WHERE m.userName = :userName", Member.class)
//						.setParameter("userName","hongma")
//						.getSingleResult();
//			System.out.println(result.getUserName());
			
//			em.createQuery("select o from Order o",Order.class);
			
			
			List<MemberDTO> result = em.createQuery("select new com.example.demo.ex1.MemberDTO(m.userName,m.age) from Member m", MemberDTO.class)
				.getResultList();
			
			System.out.println(result.get(0).getUserName());
			
			tx.commit();
			
		} catch(Exception e){
			tx.rollback();
			
		}finally {
			em.close();
			emf.close();
		}
		
	}

}
