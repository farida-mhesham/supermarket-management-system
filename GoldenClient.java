package supermarket;

import java.time.LocalDate;

/**
 *
 * @author Farida
 */
public class GoldenClient extends Clients {

    String BirthDay;
    Product favoriteProduct;

    public GoldenClient() {
    }

    public GoldenClient(String BirthDay, Product favoriteProduct, int id, int age, String telephoneNumber, String name, Address address, String registrationDate) {
        super(id, age, telephoneNumber, name, address, registrationDate);
        this.BirthDay = BirthDay;
        this.favoriteProduct = favoriteProduct;
    }
@Override
  public void discount(Invoice invoice){
	        double discount;
	        LocalDate date1 = LocalDate.parse(BirthDay);
	        LocalDate date2 = invoice.date;
	          if(date1.getMonthValue()==date2.getMonthValue()&&date1.getDayOfMonth()==date2.getDayOfMonth() ){
	             
	              discount=invoice.getInitialPrice()*0.10;
	              System.out.println("you got a discount of 10%");
	              invoice.setFinalPrice(discount);
	          }
	         else if(invoice.SoldProduct.contains(favoriteProduct)){
	               
	              discount=invoice.getInitialPrice()*0.20;
	              System.out.println("you got a discount of 20%");
	              invoice.setFinalPrice(discount);
	              }
	                  
	           else{ 
	              
	              discount=invoice.getInitialPrice()*0.02;
	              System.out.println("you got a discount of 2%");
	              invoice.setFinalPrice(discount);
	              }

}}
