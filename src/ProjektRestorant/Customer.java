package ProjektRestorant;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private String name;
    private String lastName;
    private int nId;
    private static int ID;
    //List<Order> listaOrders = new ArrayList<>();


    Scanner scanner = new Scanner(System.in);

    List<Order> porosiaIme = new ArrayList<>();
    public void printoPorosineTime(){ // old methods ignore them
        System.out.println("Vendos emrin e klientit qe doni te shihni porosite.");
        String name = scanner.next();
        System.out.println("Vendosni mbiemrin e klientit qe doni te shihni porosite");
        String lastName = scanner.next();
        if (this.name.equalsIgnoreCase(name)&&this.lastName.equalsIgnoreCase(lastName)){
            System.out.println(name + " " + lastName + " ka porositur " + porosiaIme);
        } else System.out.println("Nuk ka klient me kete emer.");
    }
    public void printoCustomerPerPorosi(){ // old methods ignore them
        System.out.println("Vendosni ID e porosise qe doni te shikoni kush e ka porositur.");
        int orderName = scanner.nextInt();
        for (Order order : porosiaIme) {
            if (order.getId()==orderName) {
                System.out.println(name + " " + lastName + " Ka porositur kete dish");
            } else {
                System.out.println("Nuk ka ndonje klient qe ka bere kete order");
            }
        }
    }
    public Order shfaqPorosineMeTeShtrenjte() { // old methods ignore them
        Order cmimiMeIMadh = new Order();
        for(int i = 0; i<porosiaIme.size(); i++) {
            if(porosiaIme.get(i).getPriceOfOrder() > cmimiMeIMadh.getPriceOfOrder()) {
                cmimiMeIMadh = porosiaIme.get(i);
            }
        }
        return cmimiMeIMadh;
    }




    public Customer(){
        this("firstNameExample","lastNameExample");
    }

    public Customer(String name, String lastName) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("What's your name?");
            while (!scanner.hasNext("[a-zA-Z]+")) {
                System.out.println("Please use only letters for the name");
                scanner.next();
            }
            name = scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("What's your last name?");
            while (!scanner.hasNext("[a-zA-Z]+")) {
                System.out.println("Please use only letters for the last name");
                scanner.next();
            }
            lastName = scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }

        this.name = name;
        this.lastName = lastName;
       nId=ID;
        ID++;
        System.out.println("Your name is " + name + " " + lastName + " and your ID on this restauraunt is " + ID);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        nId = id;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Customer.ID = ID;
    }
}
