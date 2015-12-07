package com.bionic.edu;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
@Named
public class Application{
    @Inject
    CustomerService customerService;
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context = new 	ClassPathXmlApplicationContext("spring/application-config.xml");
        Application application = (Application)context.getBean("application");
        application.printCustomerName(1);
        int id = application.addCustomer();
        System.out.println("New Customer id = " + id);
     }
    
    public void printCustomerName(int id){
    	Customer c1 = customerService.findById(id);
        System.out.println("name = " + c1.getName());
    } 
    
    public int addCustomer(){
    	Customer customer = new Customer();
    	LocalDate ld = LocalDate.now();
    	customer.setName("Erste Nick");
    	customer.setAddress("Fgdjh str.");
    	customer.setEmail("dfr@gfj.vy");
    	customer.setCcno("765678");
    	customer.setCctype("Visa");
    	customer.setMaturity(java.sql.Date.valueOf(ld));
    	customerService.save(customer);
    	return customer.getId();    }
}
*/
@Named
public class Application{
    @Inject
    MerchantService merchantService;
@SuppressWarnings("resource")
public static void main(String[] args) {
    ApplicationContext context = new 	ClassPathXmlApplicationContext("spring/application-config.xml");
    Application application = (Application)context.getBean("application");
    MerchantService merchantService = 	context.getBean(MerchantService.class);
    //application.removeMerchant(5);
    application.upadateAccount();
}

public void removeMerchant(int id){
    merchantService.remove(id);
}

public void upadateAccount(){
    merchantService.updateAccount(2, "5555555555");
}
}
