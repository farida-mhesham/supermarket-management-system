
package supermarket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class Product {
    int id;
    String Name;
    private float BuyPrice,SellingPrice;
    String ExpiritonDate;
    int NoOfItems;
    int quantity;

    public Product() {
    }
   

    public Product(int id, String Name, float BuyPrice, float SellingPrice, String ExpiritonDate, int NoOfItems) {
        this.id = id;
        this.Name = Name;
        this.BuyPrice = BuyPrice;
        this.SellingPrice = SellingPrice;
        this.ExpiritonDate = ExpiritonDate;
        this.NoOfItems = NoOfItems;
    }
    float getBuyPrice(){
        return BuyPrice;
    }
    float getSellingPrice(){
        return SellingPrice;
    }
    void setBuyPrice(float BuyPrice){
        this.BuyPrice=BuyPrice;
    }
    void setSellingPrice(float SellingPrice){
        this.SellingPrice=SellingPrice;
    }
    public void SoldOut(Product p,int num){
    p.NoOfItems-=num;
    if(NoOfItems<10){
       System.err.println("Items left of "+p.Name+"= "+p.NoOfItems);
   }
    }
    public boolean ExpriationDate(){
        DateTimeFormatter f=DateTimeFormatter.ofPattern("dd/MM/yyyy");
       LocalDate d1=LocalDate.parse(this.ExpiritonDate,f);
       LocalDate d2=LocalDate.now();
        if (d2.isAfter(d1) ) {
        return true ;
        } 
       return false;
    } 

    public boolean isAvailable(){
        if (NoOfItems>0){
            return true;
        }
        else 
        return false;
    }
    }
