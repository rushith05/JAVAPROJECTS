package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.Registration;

public class RegistrationDao {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("saikiran");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();

    public void insert(Registration registration) {
        entityTransaction.begin();
        entityManager.persist(registration);
        entityTransaction.commit();
    }
    public boolean deletebyid(int id)
    {
    	Registration registration=entityManager.find(Registration.class, id);
    	if(registration!=null)
    	{
    		entityTransaction.begin();
    		entityManager.remove(registration);
    		entityTransaction.commit();
    		return true;
    	}
    	return false;
    }

    public Registration fetchByEmail(String email) {
        Query query = entityManager.createQuery("SELECT r FROM Registration r WHERE r.registrationEmail = ?1");
        query.setParameter(1, email);
        Registration registration = (Registration) query.getSingleResult();
        return registration;
    }
    
    public List<Registration> fetchall()
    {
    	Query query=entityManager.createQuery("Select r from Registration r");
    	 List<Registration> registration= query.getResultList();
    	 return registration;
    }

    public Registration fetchByPin(int pin) {
        Query query = entityManager.createQuery("SELECT r FROM Registration r WHERE r.registrationPIN = ?1");
        query.setParameter(1, pin);
        Registration registration = (Registration) query.getSingleResult();
        return registration;
    }

    public void updateAmount(double newAmount, int pin) {
        entityTransaction.begin();
        Query query = entityManager.createQuery("UPDATE Registration r SET r.registrationAmount = :newAmount WHERE r.registrationPIN = :pin");
        query.setParameter("newAmount", newAmount);
        query.setParameter("pin", pin);
        query.executeUpdate();
        entityTransaction.commit();
    }
    
    public boolean updatepin(int oldpin,int newpin,Registration registration)
    {
    	entityTransaction.begin();
    	if(registration.getRegistrationPIN()==oldpin)
    	{
    		registration.setRegistrationPIN(newpin);
            entityManager.merge(registration);
            entityTransaction.commit();
        	return true;
        }
    	return false;
    	
    }
}
