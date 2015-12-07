package com.bionic.edu;

public interface CustomerDao {
	public Customer findById(int id);
	public void save(Customer customer);
}

