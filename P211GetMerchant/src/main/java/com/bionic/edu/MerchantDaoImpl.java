package com.bionic.edu;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class MerchantDaoImpl implements MerchantDao {
    @PersistenceContext
    private EntityManager em;

    public Merchant findById(int id){
   	return em.find(Merchant.class, id);
    }
    
    public void save(Merchant merchant){
    	em.persist(merchant);
    }
    
    public void remove(int id){
        Merchant merchant = em.find(Merchant.class, id);
        if (merchant != null){
        	em.remove(merchant);
        }
    }
    public void updateAccount(int id, String newAccount){
        Merchant merchant = em.find(Merchant.class, id);
        if (merchant != null){
        	merchant.setAccount(newAccount);
        }
    }
}

