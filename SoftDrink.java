/*
Title : Project2
Course : CSIS215 Spring 20-21
Version Information : Apache NetBeans 12.0
Date : 26 Apr 2021
Author: Wadih El Atie

Purpose : Class SoftDrink, inherits from class Item, is a type of snack sold by 
          vending machine.

SoftDrink() : No-arg constructor that creates a SoftDrink object with default values.
SoftDrink(String, int, boolent) : Constructor that creates a SoftDrink object 
                                 with specific values.
setSoftDrink(String, int, boolean) : calls setters of the data fields of the 
                                     SoftDrink object.
setDiet(boolean): set the Soft Drink's type to diet or regular.
setQuantity(int): set the Soft Drink's quantity.
getDiet(): returns a boolean showing if the drink is diet or not.
getQuantity(): returns the Quantity of soft drink items in the memory.
toString() : return a String of the Soft Drinks' information.
 */ 
package Project2;

public class SoftDrink extends Item {

    private boolean diet; //boolean idicating if the item is diet(true) or not.
    private static int quantity = 0; //Static int showing Quantity of soft drink
                                     //items in the memory.
    /*
    Purpose: No-arg constructor that creates a regular soft drink and increments quantity.
    */
    SoftDrink() {
        setSoftDrink(false);
        quantity++;
    }

    /*
    Purpose: Constructor that creates a soft drink and increments quantity.
             It calls the Constructor of the super class to set the company name 
             and the price, then sets the boolean diet.
    */
    SoftDrink(String itemCompanyName, int itemPrice, boolean diet ) {
        super(itemCompanyName, itemPrice);
        setSoftDrink(diet); // this.diet = diet
        quantity++;
    }

    public void setSoftDrink(boolean diet) {
        setDiet(diet);
    }

    public void setDiet(boolean diet) {
        this.diet = diet;
    }
    
    public static void setQuantity(int quantity) {
        SoftDrink.quantity = quantity;
    }

    public boolean getDiet() {
        return diet;
    }

    public int getQuantity() {
        return quantity;
    }
    
    @Override
    public String toString(){
        return "Soft drink-> \t" + super.toString()+
                (diet ? ", Diet." : ", Regular.");
    }
}
