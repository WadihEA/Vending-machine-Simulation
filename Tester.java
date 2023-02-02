/*
Title : Project2
Course : CSIS215 Spring 20-21
Version Information : Apache NetBeans 12.0
Date : 25 Apr 2021
Author: Wadih El Atie

Purpose : This programs aims to strengthen, hands-on experience in applying class design, 
composition, inheritance and polymorphism.
*/
package Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester {
    /*
    Main Class that simulates vending maachine actions from both an owner or a
    cutstomer's perspective.
    */
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner inp = new Scanner(System.in); //Scanner that takes input from the user
        
        VendingMachine v = new VendingMachine(); // A vending Machine v
        
        int menuChoice; //Choice of whether the user is an admin(1), customer(2) or wants to exits(3)
        int customerChoice; //Choice if the customer wants to buy an item(1) or exit(2)
        int adminChoice; //Choice if the admin wants to add an item(1),
                         //get the tottal selling(2) or exit(3)
        int itemChoice; //choice of item the Customer wants to buy
        int price; //the price of an item
        int weight; //the weight of an item
        int size; //the size of an item
                
        boolean diet; //boolean that shows if the item is diet or not
        
        String password = "OOP123"; //the Admin password intialzed to OOP123
        String enteredPassword; //the password entered by the admin
        String type; //the type of the item
        String company; //the name of the item's producing company

        
        File file = new File("./vending.txt"); //file from which the program reads items's data
        Scanner inputF = new Scanner(file); //Scanner that reads items's data

        while (inputF.hasNext()) {
            type = inputF.next(); //read item type
            company = inputF.next(); //read item company
            price = inputF.nextInt(); //read item price
            if (type.equals("Chocolate")) {
                weight = inputF.nextInt(); //read the weight of Chocolate
                v.addItem(new Chocolate(company, price, weight)); //Add the Chocolate to the vending machine
            } //if the type is Chocolate
            else if (type.equals("Water")) {
                size = inputF.nextInt(); //read the size of the water
                v.addItem(new Water(company, price, size)); //Add the Water to the vending machine
            } //if the type is Water
            if (type.equals("Chips") || type.equals("SoftDrinks")) {
                diet = inputF.nextBoolean(); //read boolean diet
                if (type.equals("Chips")) {
                    size = inputF.nextInt();
                    v.addItem(new Chips(company, price, diet, size));
                    //read the size if the item is chips then add it to the vending machine
                } 
                else {
                    v.addItem(new SoftDrink(company, price, diet));
                    //add the SoftDrink item the vending machine
                }
            } //if the type is Chips or SoftDrink
        } //keep getting data as long as the Scanner has another token in its input.
        
        inputF.close(); //Close the Scanner

        do {
            System.out.println("Welcome to the OOP Vending Machine \n"
                    + "Are you an Admin or a Customer? Pick an option below \n"
                    + "1.Admin\n"
                    + "2.User\n"
                    + "3.Quit.");
            //ask if the user is an admin or a customer
            
            menuChoice = inp.nextInt();

            if (menuChoice == 1) {
                System.out.println("Enter the ADMIN password");
                //Ask the admin to enter the password
                enteredPassword = inp.next();
                
                do {
                    if (enteredPassword.equals(password)) {
                        System.out.println("Admin Menu- Pick an option below: "
                                + "\n 1-Get the totall sellings \n 2 - Add Item\n 3-Exit");
                        adminChoice = inp.nextInt();
                        //Ask the admin what he wants
                        if (adminChoice == 1) {
                            System.out.println("your Total Selling are: "
                                    + v.getTotalSellings() + "L.P.");
                        } //if the choice is one show the admin the totla sellings

                        if (adminChoice == 2) {
                             //Ask the admin for the correct input about the item so it can be added
                            System.out.println("Enter the type of item you wan to add"
                                    + "\n Make sure the type is Chocolate, Chips,"
                                    + "SoftDrink or Water");
                            type = inp.next();

                            if (type.equals("Chocolate")) {
                                System.out.println("Now enter the company name, price and "
                                        + "the weight in grams");
                                company = inp.next();
                                price = inp.nextInt();
                                weight = inp.nextInt();
                                v.addItem(new Chocolate(company, price, weight));
                            }

                            if (type.equals("Chips")) {
                                System.out.println("Now enter the company name, price , "
                                        + "true or false depending on if it is diet or not"
                                        + " and the size(1 for small, 2 for medium, "
                                        + "3 for large)");
                                company = inp.next();
                                price = inp.nextInt();
                                diet = inp.nextBoolean();
                                size = inp.nextInt();
                                v.addItem(new Chips(company, price, diet, size));
                            }
                            if (type.equals("Water")) {
                                System.out.println("Now enter the company name, price and "
                                        + "size(250, 330, 500, 1000)");
                                company = inp.next();
                                price = inp.nextInt();
                                size = inp.nextInt();
                                v.addItem(new Water(company, price, size));
                            }
                            if (type.equals("SoftDrink")) {
                                System.out.println("Now enter the company name, price and "
                                        + "true or false depending on if it is diet or not");
                                company = inp.next();
                                price = inp.nextInt();
                                diet = inp.nextBoolean();
                                v.addItem(new SoftDrink(company, price, diet));
                            }

                        }//if the choice is 2 add an item to the machine
                        
                    } //if the password is correct
                    
                    else {
                        System.out.println("The entered password is incorret");
                        adminChoice = 3;
                        //display incorrect password message and set admin choice to 3
                        //so the program will return to main menu
                    } //if the password is incorrect
                } while (adminChoice != 3); //keep Showing the admin menu until the admin wants to exit  

            } //if the user is an Admin
            
            if (menuChoice == 2) {
                do {
                    System.out.println(v.toString()); //Display all the available items
                    System.out.println("User Menu- Pick an option below: "
                            + "\n 1-buy an item \n 2-exit");
                    customerChoice = inp.nextInt();
                    //ask the customer what he wants
                    if (customerChoice == 1) {
                        System.out.println("Enter a number for the item that you would "
                                + "like to buy: \n 1 for Chocolate, 2 for Chips, "
                                + "3 for Water, 4 for SoftDrinks");
                        itemChoice = inp.nextInt();
                        //Ask the customer what type of item he wants 
                        if (v.buyItem(itemChoice)) {
                            //if item type is avaiable sell him the first one of that type
                            System.out.println("Enjoy your snack \n");
                        } 
                        else {
                            System.out.println("Item not available, try buying another "
                                    + "kind. \n");
                            //Display a mesage saying that item is not available
                        }

                    } //if the customer wants to buy an item
                } while (customerChoice != 2);
            } //if the user is a customer
            
            if (menuChoice == 3) {
                System.exit(0);
            } //Exit the program
        } while (menuChoice >= 1 && menuChoice <= 3); //keep Showing the main menu until the user wants to exit

    }

}
