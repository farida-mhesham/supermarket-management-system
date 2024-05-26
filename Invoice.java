package supermarket;

import java.time.LocalDate;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Farida
 */
public class Invoice {

    LocalDate date;
    Time time;
    List<Product> SoldProduct = new LinkedList<>();
    private double totalInitialPrice, totalFinalPrice;
    int idOfStaffMember, idOfPointOfSale;

    public Invoice() {
    }

    public Invoice(LocalDate date, Time time, List<Product> SoldProduct, double totalInitialPrice, double totalFinalPrice, int idOfStaffMember, int idOfPointOfSale, int quantity) {
        this.date = date;
        this.time = time;
        this.SoldProduct = SoldProduct;
        this.totalInitialPrice = totalInitialPrice;
        this.totalFinalPrice = totalFinalPrice;
        this.idOfStaffMember = idOfStaffMember;
        this.idOfPointOfSale = idOfPointOfSale;
    }

    double getInitialPrice() {
        return totalInitialPrice;
    }

    double getFinalPrice() {
        return totalFinalPrice;
    }

    void setInitiallPrice() {
        for (Product p : SoldProduct) {
            totalInitialPrice += p.getSellingPrice() * p.quantity;
        }
    }

    void setFinalPrice(double discount) {
        this.totalFinalPrice = totalInitialPrice - discount;
    }

    public void DateTime() {
        LocalDate date = LocalDate.now();
        this.date = date;
        System.out.println(date);
    }

}
