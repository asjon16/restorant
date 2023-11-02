package ProjektRestorant;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private Customer customer;
    private Dish dish;
    private ArrayList<String> customerChoice = new ArrayList<String>();
    private static int ID;
    private int id;

    private int priceOfOrder;

    public void caPorosita(){ //ignoreeeeeeeeeee


    }


    Scanner scanner = new Scanner(System.in);

    //List<Order> listaOrders = new ArrayList<>();

    public void getNewOrder(Customer customerName,Dish dishChoice) {
        String choice;
        String yesOrNo;
        dish.printMenu();

        System.out.println("_-_-_-_-_-_-_-_-_");
        System.out.println("Doni te porosisni?");
        yesOrNo = scanner.next();
        while (yesOrNo.equalsIgnoreCase("po")) {
            System.out.println("Cfare doni te porosisni nga menuja? Case sensitive please.");
            choice = scanner.next();
            if (dish.getMenu().containsKey(choice)) {
                customerChoice.add(choice);
               this .priceOfOrder+= dish.getMenu().get(choice);
            } else {
                System.out.println("Ndjese nuk kemi " + choice + " ne menu.");
            }
            System.out.println("_-_-_-_-_-_-_-_-_");
            System.out.println("Deshironi te porosisni akoma?");
                yesOrNo = scanner.next();
                if (yesOrNo.equalsIgnoreCase("Jo")){
                    int myI= 0;
                   for (myI =0; myI<customerChoice.size(); myI++){
                       System.out.println("Ju porositet " + customerChoice.get(myI)  );
                   }

                    System.out.println("Cmimi total " + priceOfOrder +" ID e ketij orderi eshte " + id);

                    break;
            }
        }
    }

    public Order(Customer customer, Dish dish) {
        ID++;
        this.id = ID;
        this.customer = customer;
        this.dish = dish;
        //getNewOrder(customer,dish);
    }

    public Order() {
       // this(new Customer(),new Dish());
    }

    public int getPriceOfOrder() {
        return priceOfOrder;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return customerChoice+
                " Cmimi i porosise eshte " + priceOfOrder +
                " ID e ketij orderi eshte " + id;

    }
}
