package ProjektRestorant;

import java.util.Scanner;

public class Employee {
    private String position;
    private String name;
    private String lastName;
    private static final  String password = "1234";

    public Employee() {
    }

    public String getPassword() {
        return password;
    }

    Scanner scanner = new Scanner(System.in);

    public Employee(String name, String lastName, String position) {
        this.name = name;
        this.lastName= lastName;
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void accessOfEmployersToAddOrRemoveItemsOnMenu(Dish dish){
        if (position.equalsIgnoreCase("Boss")||position.equalsIgnoreCase("Waiter")){
           // Dish dish=new Dish();
            System.out.println("Doni te shtoni dicka nga menu ditore? Type 'Add' or 'Remove' please. ");
            String answer = scanner.next();
            //scanner.next();
            if (answer.equalsIgnoreCase("Add")){
                dish.printAndAddMenu();
            }else if (answer.equalsIgnoreCase("Remove")){
                dish.printAndRemoveMenu();
                }
            }
        dish.printMenu();

        }
    }

