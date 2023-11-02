package ProjektRestorant;

import java.util.*;

public class Dish {
    private String nameOfDish;
    private int priceOfDish;
    private Map<String, Integer> menu = new HashMap<>();


    public Dish() {
        fillMenu();
    }

    Scanner scanner = new Scanner(System.in);

    public void fillMenu(){
        menu.put("Supe",150);
        menu.put("Makarona",200);
        menu.put("Sallate",100);
        menu.put("Mish",300);
    }
    public void printMenu(){
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            System.out.println("Pjata: " + entry.getKey() + ", Cmimi: " + entry.getValue());
        }
    }
    public void printAndRemoveMenu() {
        //fillMenu();
        // Print the menu first
        /*System.out.println("Menu:");
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }*/
        printMenu();
        System.out.println(" ");

        System.out.print("Enter the dish to remove: ");

        String keyToRemove = scanner.next();

        Integer removedValue = menu.remove(keyToRemove);
        if (removedValue != null) {
            System.out.println("Removed dish '" + keyToRemove + "' me cmim " + removedValue);
        } else {
            System.out.println("No dish '" + keyToRemove + "' found in the menu");
        }
    }
    public void printAndAddMenu(){
       // fillMenu();
        String nameOfAddedDish;
        int priceOfAddedDish;
        System.out.println("Ju lutem shtoni Dishin qe deshironi.");
       // scanner.nextLine();
        nameOfAddedDish = scanner.next();
        System.out.println("Ju lutem vendosni cmimin e Dishit qe shtuat.");

        priceOfAddedDish= scanner.nextInt();

        menu.put(nameOfAddedDish,priceOfAddedDish);
        /*for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());*/
        }


    public void menuManagement(){
        fillMenu();
        printMenu();
    }

    public String getNameOfDish() {
        return nameOfDish;
    }

    public void setNameOfDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }

    public int getPriceOfDish() {
        return priceOfDish;
    }

    public void setPriceOfDish(int priceOfDish) {
        this.priceOfDish = priceOfDish;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }

    public void setMenu(Map<String, Integer> menu) {
        this.menu = menu;
    }
}
