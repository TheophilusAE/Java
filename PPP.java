package ppp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Medicine {
    String name;
    double price;
    int stock;

    Medicine(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

public class PPP {
    static Scanner scn = new Scanner(System.in);
    static Medicine[] medicines = {
        new Medicine("Paracetamol", 21.500, 60),
        new Medicine("Tremenza", 35.900, 40),
        new Medicine("Sanmol", 25.500, 80),
        new Medicine("Panadol", 15.700, 90)
    };

    public static void main(String[] args) {
        if (login()) {
            int input;
            do {
                input = displayMenu();
                switch (input) {
                    case 1:
                        viewStock();
                        break;
                    case 2:
                        sellMedicine();
                        break;
                    case 3:
                        restockMedicine();
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Wrong Input !!!");
                }
            } while (input != 4);
        }
    }

    static boolean login() {
        String user = "Sunib";
        String pass = "Pharmac";
        boolean logged = false;

        do {
            System.out.println("Sunib Pharmacy Cashier");
            System.out.print("Username : ");
            String userInput = scn.nextLine();
            System.out.print("Password : ");
            String passInput = scn.nextLine();
            if (userInput.equals(user) && passInput.equals(pass)) {
                System.out.println("Login successful!");
                logged = true;
            } else {
                System.out.println("Incorrect username or password. Please try again.");
            }
        } while (!logged);

        return logged;
    }

    static int displayMenu() {
        System.out.println("\n\nMenu");
        System.out.println("=============");
        System.out.println("1. View Stock");
        System.out.println("2. Sell Medicine");
        System.out.println("3. Restock Medicine");
        System.out.println("4. Exit");
        System.out.print("Choose >> ");
        while (!scn.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scn.next();
        }
        return scn.nextInt();
    }

    static void viewStock() {
        System.out.println("Sort by:");
        System.out.println("1. Name");
        System.out.println("2. Stock");
        System.out.println("3. Price");
        System.out.print("Choose >> ");
        
        while (!scn.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scn.next();
        }
        int sortChoice = scn.nextInt();
        scn.nextLine(); // Clear buffer after reading an integer

        switch (sortChoice) {
            case 1:
                Arrays.sort(medicines, Comparator.comparing(m -> m.name));
                break;
            case 2:
                Arrays.sort(medicines, Comparator.comparingInt(m -> m.stock));
                break;
            case 3:
                Arrays.sort(medicines, Comparator.comparingDouble(m -> m.price));
                break;
            default:
                System.out.println("Invalid choice! Showing default order.");
        }

        System.out.println("--------------------------------------");
        System.out.println("| No  | Medicine Name | Stock | Price |");
        System.out.println("--------------------------------------");
        for (int i = 0; i < medicines.length; i++) {
            System.out.printf("|  %d  | %-12s |   %d  | Rp %.3f |\n", i + 1, medicines[i].name, medicines[i].stock, medicines[i].price);
        }
        System.out.println("--------------------------------------");
    }

    static void sellMedicine() {
        System.out.println("--------------------------------------");
        System.out.println("| No  | Medicine Name | Stock | Price |");
        System.out.println("--------------------------------------");
        for (int i = 0; i < medicines.length; i++) {
            System.out.printf("|  %d  | %-12s |   %d  | Rp %.3f |\n", i + 1, medicines[i].name, medicines[i].stock, medicines[i].price);
        }
        System.out.println("--------------------------------------");
        System.out.print("Choice >> ");
        
        while (!scn.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scn.next();
        }
        int choice = scn.nextInt();
        scn.nextLine(); // Clear buffer after reading an integer

        if (choice < 1 || choice > medicines.length) {
            System.out.println("Invalid choice!");
            return;
        }

        Medicine selectedMedicine = medicines[choice - 1];
        System.out.printf("Input quantity to sell [1..%d] : ", selectedMedicine.stock);
        
        while (!scn.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scn.next();
        }
        int quantity = scn.nextInt();
        while (quantity < 1 || quantity > selectedMedicine.stock) {
            System.out.printf("Invalid quantity. Please input again [1..%d] : ", selectedMedicine.stock);
            
            while (!scn.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scn.next();
            }
            quantity = scn.nextInt();
        }
        scn.nextLine(); // Clear buffer after reading an integer

        double total = quantity * selectedMedicine.price;
        if (quantity > 10) {
            total *= 0.9; // 10% discount for more than 10 items
        }

        System.out.println("Your Purchase Bill");
        System.out.println("===================");
        System.out.printf("Item name : %s\n", selectedMedicine.name);
        System.out.printf("Item Price : %.3f\n", selectedMedicine.price);
        System.out.printf("Total  : %.3f\n", total);
        System.out.println("===================");

        double money;
        do {
            System.out.print("Input money : ");
            
            while (!scn.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a number.");
                scn.next();
            }
            money = scn.nextDouble();
            if (money < total) {
                System.out.println("Not enough money. Please input again.");
            }
        } while (money < total);
        scn.nextLine(); // Clear buffer after reading a double

        double change = money - total;
        System.out.println("===================");
        System.out.printf("Change : %.3f\n", change);
        selectedMedicine.stock -= quantity;
    }

    static void restockMedicine() {
        System.out.println("--------------------------------------");
        System.out.println("| No  | Medicine Name | Stock | Price |");
        System.out.println("--------------------------------------");
        for (int i = 0; i < medicines.length; i++) {
            System.out.printf("|  %d  | %-12s |   %d  | Rp %.3f |\n", i + 1, medicines[i].name, medicines[i].stock, medicines[i].price);
        }
        System.out.println("--------------------------------------");
        System.out.print("Choice >> ");
        
        while (!scn.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scn.next();
        }
        int choice = scn.nextInt();
        scn.nextLine(); // Clear buffer after reading an integer

        if (choice < 1 || choice > medicines.length) {
            System.out.println("Invalid choice!");
            return;
        }

        Medicine selectedMedicine = medicines[choice - 1];
        System.out.printf("Input stock to add [1..%d] : ", 100 - selectedMedicine.stock);
        
        while (!scn.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scn.next();
        }
        int stockToAdd = scn.nextInt();
        while (stockToAdd < 1 || stockToAdd > 100 - selectedMedicine.stock) {
            System.out.printf("Invalid quantity. Please input again [1..%d] : ", 100 - selectedMedicine.stock);
            
            while (!scn.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scn.next();
            }
            stockToAdd = scn.nextInt();
        }
        scn.nextLine(); // Clear buffer after reading an integer

        selectedMedicine.stock += stockToAdd;
        System.out.println("Stock updated!!");
    }
}
