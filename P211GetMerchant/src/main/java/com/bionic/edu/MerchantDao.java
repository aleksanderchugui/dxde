package com.bionic.edu;

public interface MerchantDao {
	public Merchant findById(int id);
	public void save(Merchant merchant);
	public void remove(int id);
	public void updateAccount(int id, String newAccount);
}

