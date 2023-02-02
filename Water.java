/*
Title : Project2
Course : CSIS215 Spring 20-21
Version Information : Apache NetBeans 12.0
Date : 26 Apr 2021
Author: Wadih El Atie

Purpose : Class Water, inherits from class Item, is a type of snack sold by 
vending machine.

Water() : No-arg constructor that creates a Water object with default values.
Water(String, int, int) : Constructor that creates a Water object 
                          with specific values.
setWater(String, int, boolean, int) : calls setters of the data fields of the 
                                      Water object..
setSize(int): set the Water's size to 250, 330, 500, 1000.
setQuantity(int): set the Water's quantity
getSize(): returns an int showing the size of the Water .
getQuantity(): returns the Quantity of Water items in the memory.
toString() : return a String of the Water's information.
 */
package Project2;

public class Water extends Item{

    private int size; //size of the water
    private static int quantity =0; //Static int showing Quantity of soft drink
                                    //items in the memory.

    /*
    Purpose: No-arg constructor that creates a 250 size Water and increments quantity.
    */
    Water() {
        setWater(250);
        quantity++;
    }

    /*
    Purpose: Constructor that creates a Water and increments quantity.
             It calls the Constructor of the super class to set the company name 
             and the price, then sets the size.
    */
    Water(String itemCompanyName, int itemPrice, int size) {
        super(itemCompanyName, itemPrice);
        setWater(size);
        quantity++;
    }

    public void setWater(int size) {
        setSize(size);
    }

    public void setSize(int size) {
        if (size == 330 || size == 500 || size == 1000) {
            this.size = size;
        } 
        else {
            this.size = 250;
            //set the size to 250 if it is not 330 or 500 or 1000
        }
        
    }
    
    public static void setQuantity(int quantity) {
        Water.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSize() {
        return size;
    }
    
    @Override
    public String toString(){
        return "Water-> \t" + super.toString()+ " size: " + size;
    }
    
}
