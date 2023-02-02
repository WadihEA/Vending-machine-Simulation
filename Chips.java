/*
Title : Project2
Course : CSIS215 Spring 20-21
Version Information : Apache NetBeans 12.0
Date : 25 Apr 2021
Author: Wadih El Atie

Purpose : Class Chips, inherits from class Item, is a type of snack sold by 
          vending machine.

Chips() : No-arg constructor that creates a Chips object with default values.
Chips(String, int, boolean, int) : Constructor that creates a Chips object 
                                   with specific values.
setChips(String, int, boolean, int) : calls setters of the data fields of the 
                                     Chips object.
setDiet(boolean): set the Chipss' type to diet or regular.
setSize(int): set the Chipss' size to small, medium or large.
setQuantity(int): set the Chipss' quantity.
getDiet(): returns a boolean showing if the drink is diet or not.
getSize(): returns an int showing if the Chips is small, medium or large.
getQuantity(): returns the Quantity of Chips items in the memory.
toString() : return a String of the Chipss' information.
 */
package Project2;

public class Chips extends Item {

    private boolean diet; //boolean idicating if the item is diet(true) or not.
    private int size; //size of Chips
    private static int quantity = 0;//Static int showing Quantity of soft drink
                                     //items in the memory.

    /*
    Purpose: No-arg constructor that creates a small, regular Chips and increments quantity.
    */
    Chips() {
        setChips(false, 1);
        quantity++;
    }

    /*
    Purpose: Constructor that creates a Chips and increments quantity.
             It calls the Constructor of the super class to set the company name 
             and the price, then sets the diet boolean and the size.
    */
    Chips(String itemCompanyName, int itemPrice, boolean diet, int size) {
        super(itemCompanyName, itemPrice);
        setChips(diet, size);
        quantity++;
    }

    public void setChips(boolean diet, int size) {
        setDiet(diet);
        setSize(size);
    }

    public void setDiet(boolean diet) {
        this.diet = diet;
    }

    public void setSize(int size) {
        if (size >= 1 && size <= 3) {
            this.size = size;
        } else {
            this.size = 1;
            //if the size given is invalid set size to the default value.
        }
    }
    
    public static void setQuantity(int quantity) {
        Chips.quantity = quantity;
    }

    public boolean getDiet() {
        return diet;
    }
    
    public int getSize() {
        return size;
    }
    
    public int getQuantity() {
        return quantity;
    }


    @Override
    public String toString(){
       return "Chips-> \t" + super.toString() + 
                (diet ? ", Diet, " : ", Regular, ") + "size: "+
                 ((size == 1) ? "Small" : (((size == 2)? "Medium" : "Large")));   
     
}
    
}
