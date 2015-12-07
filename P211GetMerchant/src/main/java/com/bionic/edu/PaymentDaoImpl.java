package com.bionic.edu;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl implements PaymentDao{
    @PersistenceContext
    private EntityManager em;
    
    public List<Payment> findByMerchantId(int id){
        TypedQuery<Payment> query = 	em.createQuery("SELECT p FROM Payment p 	WHERE p.merchantId = :id", Payment.class);
        query.setParameter("id",id);
        return query.getResultList();
    }
    public Payment findById(int id){
        return em.find(Payment.class, id);
    }
}
