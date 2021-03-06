package com.bionic.edu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImp implements CustomerDao {
    @PersistenceContext
    private EntityManager em;

    public Customer findById(int id){
   	return em.find(Customer.class, id);
    }
    
    public void save(Customer customer){
    	em.persist(customer);
    }
    public List<String> getNames(double sumPayed){
        String txt = "SELECT DISTINCT c.name FROM ";   
        txt += "Payment p, Customer c " ;
        txt += "WHERE c.id = p.customerId AND p.sumPayed > :limit";
        
        TypedQuery<String> query = em.createQuery(txt, String.class);
        query.setParameter("limit",sumPayed);
        return query.getResultList();
  }
}

