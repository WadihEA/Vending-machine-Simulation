/*
Title : Project2
Course : CSIS215 Spring 20-21
Version Information : Apache NetBeans 12.0
Date : 26 Apr 2021
Author: Wadih El Atie

Purpose : Class Chocolate, inherits from class Item, is a type of snack sold by 
vending machine.

Chocolate() : No-arg constructor that creates a Chocolate object with default values.
Chocolate(String, int, int) : Constructor that creates a Chocolate object 
                                 with specific values.
setChocolate(String, int, boolean) : calls setters of the data fields of the 
                                     Chocolate object.
setWeight(int): set the Chocolate's weight in grams.
setQuantity(int): set the Chocolate's quantity.
getweight(): returns an int showing the weight of the chocolate.
getQuantity(): returns the Quantity of Chocolate items in the memory.
toString() : return a String of the Chocolate's information.
 */
package Project2;


public class Chocolate  extends Item{
    private int weight; //weight of the Chocolate in gr
    private static int quantity = 0; //Static int showing Quantity of soft drink
                                     //items in the memory.
    
    /*
    Purpose: No-arg constructor that creates a 50gr Chocolate and increments quantity.
    */
    Chocolate() {
        setChocolate(50);
        quantity++;
    }
    /*
    Purpose: Constructor that creates a Chocolate and increments quantity.
             It calls the Constructor of the super class to set the company name 
             and the price, then sets the weight.
    */
    Chocolate(String itemCompanyName, int itemPrice, int weight ) {
        super(itemCompanyName, itemPrice);
        setChocolate(weight);
        quantity++;
    }

    public void setChocolate(int weight) {
        setWeight(weight);
    }

    public void setWeight(int weight) {
        if(weight>0)
            this.weight= weight;
        else
            this.weight=50;
        //set the weight to the default value if the given weight int is negative
    }
    
    public static void setQuantity(int quantity) {
        Chocolate.quantity = quantity;
    }

    public int getweight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }
    @Override
    public String toString(){
        return "Chocolate-> \t" + super.toString() + 
                ". Net weight: " + weight + "gr.";
    }
    
}
