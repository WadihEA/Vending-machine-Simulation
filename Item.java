/*
Title : Project2
Course : CSIS215 Spring 20-21
Version Information : Apache NetBeans 12.0
Date : 26 Apr 2021
Author: Wadih El Atie

Purpose : Class item, superclass for all the diffrent types of snack in the vending machine
it sets each item's price and company name

Item() : No-arg constructor that creates an item object with default values.
Item(String, int) : Constructor that creates an item object with specific values.
setItem(String, int) : calls setters of the data fields of the item object.
setItemCompanyName(String): set the item's company name.
setItemPrice(int): set the item's price.
getItemCompanyName(): returns the item's company name.
getItemPrice(): returns the item's price.
toString() : return a String of the item's information 
 */ 
package Project2;

public class Item {

    private String itemCompanyName; //name of the item's producing company
    private int itemPrice; //price of the item in L.P.

    /*
    No-arg constructor that creates an item with Empty String for 
    company name and 0 for price.
    */
    Item() {
        this("", 0);
    }
    
    /*
    Constructor that creates an item with given value.
    P.S. : if the given price was < 0 price will be set to 0.
    */  
    Item(String itemCompanyName, int itemPrice) {
        setItem(itemCompanyName, itemPrice);
    }

    public void setItem(String itemCompanyName, int itemPrice) {
        setItemCompanyName(itemCompanyName);
        setItemPrice(itemPrice);
    }

    public void setItemCompanyName(String itemCompanyName) {
        this.itemCompanyName = itemCompanyName;
    }

    public void setItemPrice(int itemPrice) {
        if (itemPrice > 0) {
            this.itemPrice = itemPrice;
        } 
        else {
            this.itemPrice = 0;
            //Set the price to 0 if the price is negative
        } 
    }

    public String getItemCompanyName() {
        return itemCompanyName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString(){
        return "price: " + itemPrice + "L.P., company name: " + itemCompanyName ;
    }
}
