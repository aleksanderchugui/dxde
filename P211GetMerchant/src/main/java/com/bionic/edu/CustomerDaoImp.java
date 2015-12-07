package com.bionic.edu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}

