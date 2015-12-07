package com.bionic.edu;

public interface MerchantService {
	public Merchant findById(int id);
	public void save(Merchant merchant);
	public void remove(int id);
	public void updateAccount(int id, String newAccount);
}
