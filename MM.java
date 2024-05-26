
package supermarket;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static supermarket.Supermarket.staff;


public class MM {
     public static void loadData() {
// clients
//        try {
//            File myfile = new File("D:clients2.txt");
//            Scanner input = new Scanner(myfile);
//
//            while (input.hasNext()) {
//                Clients c = new Clients();
//                c.address = new Address();
//                c.name = input.next();
//                c.id = input.nextInt();
//                c.age = input.nextInt();
//                c.address.Street = input.next();
//                c.telephoneNumber = input.next();
//                c.registrationDate = input.next();
//                clients.add(c);
//                System.out.println(c.name + "    " + c.id + "    " + c.age + "   " + c.address.Street + "    " + c.telephoneNumber + "   " + c.registrationDate);
//            }
//
//        } catch (IOException e) {
//            System.out.println("An error ocucurred");
//        }
//staff
        try {
            File myfile = new File("D:staff2.txt");
            Scanner input = new Scanner(myfile);

            while (input.hasNext()) {
                Staffmember s = new Staffmember();
                s.id = input.nextInt();
                s.name = input.next();
                Card card = new Card();
                String cardCode = input.next();
                s.setCard(card);
                s.getCard().setCode(cardCode);
                String r = input.next();
                s.setPhoneNumber(input.next());
                  s.getAddress().Street=input.next();
                String rr = input.next();
                s.setSalary(input.nextDouble());
                staff.add(s);
                System.out.println(s.name + "    " + s.id + s.getCard().getCode() + "   " + "    " + s.getPhoNum() + "   " + s.getSalary());
            }

        } catch (IOException e) {
            System.out.println("An error ocucurred");
        }
//try {
//    File myfile = new File("D:staff2.txt");
//    Scanner input = new Scanner(myfile);
//
//    while (input.hasNext()) {
//        int id = input.nextInt();
//        String name = input.next();
//        
//        // Create a new Card object and assign it to the Staffmember
//        Card card = new Card();
//        
//        String cardCode = input.next();
//        String r = input.next();
//        String phoneNumber = input.next();
//        String rr = input.next();
//        double salary = input.nextDouble();
//        
//        // Create a new Staffmember using the constructor
//        Staffmember s = new Staffmember(id, salary, phoneNumber, name, null);
//        
//        // Set the created Card object to the Staffmember
//        s.setCard(card);
//        s.getCard().setCode(cardCode);
//        
//        staff.add(s);
//        System.out.println(s.name + "    " + s.id + s.getCard().getCode() + "   " + "    " + s.getPhoNum() + "   " + s.getSalary());
//    }
//
//} catch (IOException e) {
//    System.out.println("An error occurred: " );
//}

        //products     
//        try {
//            File myfile = new File("D:products2.txt");
//            Scanner input = new Scanner(myfile);
//
//            while (input.hasNext()) {
//                Product p = new Product();
//                p.id = input.nextInt();
//                p.Name= input.next();
//                p.NoOfItems = input.nextInt();
//                p.setBuyPrice(input.nextFloat());
//                p.setSellingPrice(input.nextFloat());
//                p.ExpiritonDate=input.next();
//                stock.add(p);
//                System.out.println(p.Name + "    " + p.id + "    " + p.NoOfItems + "   " + p.getSellingPrice() + "    " +p.ExpiritonDate + "   " );
//            }
//
//        } catch (IOException e) {
//            System.out.println("An error ocucurred");
//        }
        //invoices
//        try {
//            File myfile = new File("D:clients2.txt");
//            Scanner input = new Scanner(myfile);
//
//            while (input.hasNext()) {
//                Clients c = new Clients();
//                c.address = new Address();
//                c.name = input.next();
//                c.id = input.nextInt();
//                c.age = input.nextInt();
//                c.address.Street = input.next();
//                c.telephoneNumber = input.next();
//                c.registrationDate = input.next();
//                clients.add(c);
//                System.out.println(c.name + "    " + c.id + "    " + c.age + "   " + c.address.Street + "    " + c.telephoneNumber + "   " + c.registrationDate);
//            }
//
//        } catch (IOException e) {
//            System.out.println("An error ocucurred");
//        }
//
//    }
    }

}
