package com.bionic.edu;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

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
   
    //application.removeMerchant(5);
    //application.upadateAccount();
    //application.findAll();
    CustomerService customerService = 	context.getBean(CustomerService.class);
    //application.getCustomersWithLargePays(500.0);
    MerchantService merchantService = 	context.getBean(MerchantService.class);
    //application.getTotalReport();
    application.findPayment(2);
}
public void findPayment(int id){
	ApplicationContext context = new 	ClassPathXmlApplicationContext("spring/application-config.xml");
	PaymentService paymentService = 	context.getBean(PaymentService.class);
    Payment p = paymentService.findById(2);
    SimpleDateFormat fmt = new 	SimpleDateFormat("dd.MM.yyyy HH:mm");
    System.out.println("Date = " + fmt.format(p.getDt()) + "   	merchant = " + p.getMerchant().getName() + "   sum 	= " + p.getSumPayed());
}
public void getTotalReport(){
    List<Result> list = merchantService.getTotalReport();
    for(Result r: list)
        System.out.format("%1$25s  %2$8.2f %n", 	r.getName(), r.getSum()); 
}

public void getCustomersWithLargePays(double limit){
	ApplicationContext context = new 	ClassPathXmlApplicationContext("spring/application-config.xml");
	CustomerService customerService = 	context.getBean(CustomerService.class);
    List<String> list = customerService.getNames(limit);
    for(String s: list)
        System.out.println(s); 
    }
/*public void getPaymentsForMerchant(int id){
	ApplicationContext context = new 	ClassPathXmlApplicationContext("spring/application-config.xml");
    Application application = (Application)context.getBean("application");
	 PaymentService paymentService = 	context.getBean(PaymentService.class);
    List<Payment> list = paymentService.findByMerchantId(id);
    System.out.println("        date        merchant   sum  ");
    for(Payment p: list){
    	SimpleDateFormat dtFrm = new 	 
	       SimpleDateFormat("dd.MM.yyyy HH:mm"); 
    	String txDate = dtFrm.format(p.getDt());
       	System.out.format("  %1s   %2$3d     %3$6.2f   %n", 	   
	       txDate, p.getMerchantId(), p.getSumPayed());
    }
}*/
public void findAll(){
    List<Merchant> list = merchantService.findAll();
    System.out.println("           name              charge");
    for(Merchant m: list){
        System.out.format("%1$25s     %2$4.1f  %n", 	  
	       m.getName(), m.getCharge());
    }
}
public void removeMerchant(int id){
    merchantService.remove(id);
}

public void upadateAccount(){
    merchantService.updateAccount(2, "5555555555");
}
}
