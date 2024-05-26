package supermarket;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.*;
import login.NewJFrame;
//import login.NewJFrame;

public class Supermarket {

    static Scanner sc = new Scanner(System.in);
    static List<Product> stock = new LinkedList<>();
    static List<Clients> clients = new LinkedList<>();
    static List<GoldenClient> Golden = new LinkedList<>();
    static List<Staffmember> staff = new LinkedList<>();

    public static void Login() {

        System.out.println("LOGIN TO THE SYSTEM ");
        System.out.println("Enter your username:");
        String name = sc.next();
        System.out.println("Enter your id:");
        int id = sc.nextInt();
        System.out.println("Enter your code:");
        String code = sc.next();
        for (Staffmember ss : staff) {
            if (ss.getCard().getCode().equals(code)) {
                System();
            } else {
                System.err.println("Incorrect information !");
            }
        }
    }

    public static void System() {
        System.out.println("Welcome to our supermarket !");
        Address a1 = new Address("31 st", "alex", 3578);

        boolean flag = true;
        while (flag) {

            System.out.println("Operations:\n1)Add product\n2)Add Client"
                    + "\n3)Add staffmemeber\n4)Buy product\n5)Exit system");

            System.out.print("\nPlease choose your operation: ");
            int n = sc.nextInt();

            if (n <= 0 || n > 5) {

                System.out.println("Please enter a number from 1 to 8.");
                n = sc.nextInt();
            }

            switch (n) {

                case 1:// add to stock.
                    Product p1 = new Product();
                    System.out.println("Please enter the name of the product :");
                    p1.Name = sc.next();
                    System.out.println("Please enter the id of the product :");
                    p1.id = sc.nextInt();
                    System.out.println("Please enter the number of items of the product :");
                    p1.NoOfItems = sc.nextInt();
                    System.out.println("Please enter the expiration date the product :");
                    p1.ExpiritonDate = sc.next();
                    stock.add(p1);
                    System.out.println("You added to your cart : " + stock.get(0).Name);
        WriteData();

                    break;
                case 2:
                    Clients c1 = new Clients();
                    c1.address= new Address("31 st", "alex", 3578);

                     System.out.println("Please enter the name of the client :");
                     c1.name = sc.next();
                     System.out.println("Please enter the id of the client :");
                     c1.id = sc.nextInt();
                     System.out.println("Please enter the age of the client :");
                     c1.age = sc.nextInt();
                     System.out.println("Please enter the address of the client :");
                   c1.getAddress().Street =sc.next();
                     System.out.println("Please enter the phone number of the client:");
                     c1.telephoneNumber=sc.next();
                     System.out.println("Please enter the registration date of the client:");
                     c1.registrationDate=sc.next();
                                         clients.add(c1);

                     System.out.println("You added to the system Client : "+c1.name);
        WriteData();

                     break;
                case 3:
                    Staffmember s1=new Staffmember();
                                        s1.setAddress(new Address("31 st", "alex", 3578));

                    System.out.println("Please enter the id of the staffmember :");
                     s1.id = sc.nextInt();
                    

                     System.out.println("Please enter the name of the staffmember :");
                     s1.name = sc.next();
                    
                    
                     System.out.println("Please enter the address of the staffmember :");
                    s1.getAddress().Street =sc.next();
                    
                     System.out.println("Please enter the salary of the staffmember:");
                     s1.setSalary(sc.nextInt());
                                         staff.add(s1);

                     System.out.println("You added to the system Client : "+s1.name);
               WriteData();

                     break;
       

               case 4:

                    List<Product> temp = new LinkedList<>();

                    addProduct(temp);
                    System.out.println("Do you want to buy another product?\n1)yes\n2)no");
                    int num = sc.nextInt();
                    while (num != 2) {
                        addProduct(temp);
                        System.out.println("Do you want to buy another product?\n1)yes\n2)no");
                        num = sc.nextInt();
                    }
                    System.out.println("Enter client's id for this operation :");
                    int id = sc.nextInt();

                    for (Clients c : clients) {

                        if (c.id == id) {

                            Invoice curr = c.Buy(temp);
                            curr.idOfStaffMember=id;
                            c.discount(curr);
                            System.out.println("INVOICE : "+"\n Date: "+curr.date+"\n Products:  Quantity :");
                            for(Product p:curr.SoldProduct) {
                            System.out.println(p.Name+"  "+p.quantity);
                            System.out.println();
                            }
                            System.out.println("Total = " + curr.getFinalPrice());
                            break;
                        } 
                        }  for (GoldenClient g : Golden) {

                            if (g.id == id) {
                            	Invoice curr = g.Buy(temp);
                                
                                g.discount(curr);
                                System.out.println("INVOICE : "+"\n Date: "+curr.date+"\n Products:  Quantity :");
                                for(Product p:curr.SoldProduct) {
                                System.out.println(p.Name+"  "+p.quantity);
                                System.out.println();
                                }
                                System.out.println("Total = " + curr.getFinalPrice());
                                break;
                                }
                    }
                    
                    
                    break;
                
                   
                case 5:
                    System.out.println("Exit ! ");
                    flag = false;
                    break;

            }
            if (n == 5) {
            } else {

                System.out.println("Do you want to do another operation?\n"
                        + "1)yes \n" + "2)no ");

                int x = sc.nextInt();

                while (x != 1 && x != 2) {
                    System.out.println("please enter a valid input(1 or 2)");
                    x = sc.nextInt();
                }
                if (x == 1) {
                    flag = true;
                } else {
                    flag = false;
                }
            }
        }
        System.out.println("Thank you for your time :)");
    }

    public static void WriteData() {
        //staff 
        try {
            FileWriter w = new FileWriter("D:supermarketstaff.txt", true);
           
            for (Staffmember s : staff) {
                
                w.write("\n");
                w.write(s.id + "  ");
                w.write(s.name + "   ");
                w.write(s.getPhoNum() + "   ");
                w.write(s.getAddress().Street + "   ");
                w.write(s.getSalary() + "   ");
                w.write(s.totalInvoices.size());


            }
                w.close();

        } catch (IOException e) {
            System.out.println("An error ocucurred");
        }
        //products 
        try {
            FileWriter w = new FileWriter("D:products2.txt", true);
            for (Product p : stock) {
                w.write("\n");
                w.write(p.Name + "\t");
                w.write(p.id + "\t");
                w.write(String.valueOf(p.getBuyPrice()) + "\t" + "\t");
                w.write(String.valueOf(p.getSellingPrice()) + "\t" + "\t");
                w.write(p.ExpiritonDate + "\t" + "\t");
                w.write(p.NoOfItems + "\t");
            }
                w.close();

        } catch (IOException e) {
            System.out.println("An error ocucurred");
        }
        //clients
try {
            FileWriter w = new FileWriter("D:clients2.txt", true);
            for (Clients c : clients) {
                w.write("\n");
                w.write(c.name + "\t");
                w.write(c.id + "\t");
                w.write(c.age + "\t" + "\t");
                w.write(c.getAddress().Street + "/");
                w.write(c.telephoneNumber + "\t" + "\t");
                w.write(c.registrationDate + "\t");
            }
                w.close();

        } catch (IOException e) {
            System.out.println("An error ocucurred");
        }
    }

   
    static public List<Product> addProduct(List<Product> temp) {
        System.out.println("Choose proudct:");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        System.out.println("Enter quantity:");
        int q = sc.nextInt();

        boolean found = false;
        for (Product p : stock) {
            if (p.Name.equals(name)) {
                found = true;
                if (p.isAvailable() && !p.ExpriationDate()) {
                    p.quantity = q;
                    p.SoldOut(p, q);
                    temp.add(p);
                    break;
                } else {
                    System.out.println("Item is expired");
                    break;
                }
            }
        }
        if (!found) {
            System.err.println("Item not found ");
        }
        return temp;
    }

    static public void checkGolden() {

        for (Clients c : clients) {
            if (c.isGolden()) {
                System.out.println("Enter the client birthday ");
                String birthday = sc.next();
                System.out.println("Enter the client favourite product");
                String favp = sc.next();
                Product fp = null;
                for (Product p : stock) {

                    if (p.Name.equals(favp)) {

                        fp = p;
                    }
                }
                GoldenClient gc = new GoldenClient(birthday, fp, c.id, c.age, c.telephoneNumber, c.name, c.address, c.registrationDate);
                Golden.add(gc);
                clients.remove(c);
                System.out.println("Client " + gc.name + "Is golden Client" + " favorite " + gc.favoriteProduct.Name);
            }
        }
    }


    public static void main(String[] args) {
        NewJFrame frame = new NewJFrame();
        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        Address a1 = new Address("31 st", "alex", 3578);
        Staffmember s1 = new Staffmember(222, 2000, "0120002", "Ahmed", a1);
        Staffmember s2 = new Staffmember(44, 2000, "567", "mona", a1);
        staff.add(s1);
        staff.add(s2);
        Product p1 = new Product(1, "Apple", 30, 40, "02/07/2023", 13);
        Product p2 = new Product(2, "Banana", 13, 23, "04/06/2023", 12);
        stock.add(p1);
        stock.add(p2);
        Login();
        System();

    }
}
