package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Admin;

public class AdminDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("saikiran");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public void insertadmin(Admin admin)
	{
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
	}
	 public Admin fetchByEmail(String email) {
	        Query query = entityManager.createQuery("SELECT a FROM Admin a WHERE a.adminEmail = ?1");
	        query.setParameter(1, email);
	        Admin admin = (Admin) query.getSingleResult();
	        return admin;
	    }

}
