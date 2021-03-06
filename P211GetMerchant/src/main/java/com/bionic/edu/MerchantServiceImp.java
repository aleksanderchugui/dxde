package com.bionic.edu;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;
@Named
public class MerchantServiceImp implements 	MerchantService{
    @Inject
    private MerchantDao merchantDao;
    public Merchant findById(int id) { 
    	return merchantDao.findById(id); 
    }
    @Transactional
    public void save(Merchant merchant){
    	merchantDao.save(merchant);
    }
    
    @Transactional
    public void remove(int id){
        merchantDao.remove(id);
    }
    
    @Transactional
    public void updateAccount(int id, String newAccount){
      	merchantDao.updateAccount(id, newAccount);
    }
    public List<Merchant> findAll(){
    	return merchantDao.findAll();
        }
    public List<Result> getTotalReport(){
    	return merchantDao.getTotalReport();
    }
}

