package supermarket;

import java.util.Random;
import java.util.Scanner;

public class Card {

    private int id;
    private String Code;
    private String Username;

    public Card() {
        Scanner sc = new Scanner(System.in);
//       System.out.println("Enter your username:");
//       this.Username = sc.next();  
//       System.out.println("Enter your id:");
//       this.id =sc.nextInt();

        System.out.print("Enter code for new staffmember :");
        this.Code = sc.next();
    }

    String getUser() {
        return Username;
    }

    void setUser(String Username) {
        this.Username = Username;

    }

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getCode() {
        return Code;
    }

    void setCode(String Code) {

        this.Code = Code;
    }

}
