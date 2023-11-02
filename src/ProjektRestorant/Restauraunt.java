package ProjektRestorant;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Restauraunt {
    Scanner scanner = new Scanner(System.in);
    Employee employee = new Employee();
    Dish dish = new Dish();
    Map<Customer,Order> mapCustomerOrders = new HashMap<>();

    public Restauraunt() {
        frontPage();
    }
    // Order order= new Order();


    public void doRestaurantThings(){
        // this is all testing
        //Employee employee = new Employee("Asjon","Memishahi","Waiter");
        /*Customer customer = new Customer();
        Dish dish = new Dish();
        //employee.accessOfEmployersToAddOrRemoveItemsOnMenu(dish);
        // dish.printMenu();
        Order order = new Order(customer,dish);
        order.getNewOrder(customer,dish);
        customer.porosiaIme.add(order);
        customer.printoPorosineTime();
        customer.printoCustomerPerPorosi();
        System.out.println(customer.shfaqPorosineMeTeShtrenjte());*/

        //Restauraunt restauraunt = new Restauraunt();

        //restauraunt.porositePerCustomer();










    }
    public void opsionetTeFaqjaKryesore(){
        System.out.println("Welcome to our restaurant !\n"+
                "Press 1 if you are an employee. \n"+
                "Press 2 if you are a costumer.\n"+
                "Press 3 if you want to leave this menu");
    }

    public void frontPage() {
        int choice = 0;
        while (choice != 3) {
            opsionetTeFaqjaKryesore();
            try {
                choice = scanner.nextInt();
                String name;
                String lastName;
                String position;
                if (choice == 1) {
                    System.out.println("Please prove it by inserting the password.");
                    String password = scanner.next();
                    if (employee.getPassword().equals(password)) {
                        System.out.println("Please state your name, last name and your position.");
                        name = scanner.next();
                        lastName = scanner.next();
                        position = scanner.next();
                        Employee employee = new Employee(name, lastName, position);
                        while (choice == 1) {
                            System.out.println("Shtypni 1 per te abuzuar pozicionin tuaj, ose 2 per te shkuar ne menu kryesore.");
                            choice = scanner.nextInt();
                            if (choice == 1&&(employee.getPosition().equalsIgnoreCase("boss")||employee.getPosition().equalsIgnoreCase("waiter"))){
                                employee.accessOfEmployersToAddOrRemoveItemsOnMenu(dish);
                            } else if (choice==1 &&(!employee.getPosition().equalsIgnoreCase("boss")||!employee.getPosition().equalsIgnoreCase("waiter"))) {
                                System.out.println("Ndjese ju nuk keni akses!");
                                break;
                            } else {
                                System.out.println("Po deshe m.");
                            }
                        }
                    } else System.out.println("Nice try thief!");

                } else if (choice == 2) {
                    Customer costumer = new Customer();
                    Order order1 = new Order(costumer, dish);
                    System.out.println("Mire se erdhe" + costumer.getName() + "." + "\nKjo eshte menuja jone");
                    System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                    dish.printMenu();
                    System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-");
                    while (choice != 5) {
                        frontPageTemplate();
                        try {
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1:
                                    order1.getNewOrder(costumer, dish);
                                    mapCustomerOrders.put(costumer, order1);
                                    break;
                                case 2:
                                    customerOrders(order1);
                                    break;
                                case 3:
                                    customerPerOrder(order1, costumer);
                                    break;
                                case 4:
                                    System.out.println(shfaqPorosineMeTeShtrenjte());
                                    break;
                                case 5:
                                    break;
                              /*  default:
                                    System.out.println("Wrong input try again please.");*/
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Ju lutem fusni nje number.");
                            scanner.next();
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Ju lutem fusni nje number.");
                scanner.next();
            }

        }
        System.out.println("Thank you");
    }
    public void frontPageTemplate(){
        System.out.println("Cfare deshironi te beni : \n"+
                "Press 1 to order something \n"+
                "Press 2 to check a certain costumer orders. \n"+
                "Press 3 to check the costumers of a certain dish. \n"+
                "Press 4 to check the most expensive order. \n"+
                "Press 5 to leave this menu.");
    }

    public void customerOrders(Order order) {
        System.out.println("Enter the name of the customer you want to check orders for:");
        String name = scanner.next();
        System.out.println("Enter the last name of the customer you want to check orders for:");
        String lastName = scanner.next();

        for (Map.Entry<Customer, Order> entry : mapCustomerOrders.entrySet()) {
            Customer customer = entry.getKey();
            Order customerOrder = entry.getValue();

            if (customer.getName().equalsIgnoreCase(name) && customer.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Customer " + customer.getName() + " " + customer.getLastName() + " has ordered " + customerOrder);
                return;
            }
        }

        System.out.println("Customer not found.");
    }
    public void customerPerOrder(Order order, Customer customer) {
       /* System.out.println("Enter the name of the customer you want to check orders for:");
        String name = scanner.next();
        System.out.println("Enter the last name of the customer you want to check orders for:");
        String lastName = scanner.next();*/
        System.out.println("Enter the ID of the order that you want to see the clients that ordered it.");
        int idOfOrder = scanner.nextInt();

        for (Map.Entry<Customer, Order> entry : mapCustomerOrders.entrySet()) {
             customer = entry.getKey();
            Order customerOrder = entry.getValue();

            if (entry.getValue().getId()==idOfOrder) {
                System.out.println("Dish with ID : " + idOfOrder + " was ordered by " + customer.getName() + " " + customer.getLastName());
                return;
            }
        }

        System.out.println("Customer not found.");
    }
    public Order shfaqPorosineMeTeShtrenjte() {
        Order mostExpensiveOrder = null;
        int highestPrice = 0;

        for (Order order : mapCustomerOrders.values()) {
            if (order.getPriceOfOrder() > highestPrice) {
                highestPrice = order.getPriceOfOrder();
                mostExpensiveOrder = order;
            }
        }
        return mostExpensiveOrder;


    }
}





