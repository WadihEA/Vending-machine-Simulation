/*
Title : Project2
Course : CSIS215 Spring 20-21
Version Information : Apache NetBeans 12.0
Date : 26 Apr 2021
Author: Wadih El Atie

Purpose : Class VendingMachine, creates a vending machine object to which Item 
          class instances can be added and sold.

VendingMachine() : No-arg constructor that creates an empty vending machine
setVendingMachine()  : creates an ArrayList that will store the item of the machine
getTotalSellings(): returns the Totall sellings made by the machine in L.P..
getItems(): returns an ArrayList of the items stored in the machine
addItem(Item): adds an instance of Item clas to the machine at the end of its right category
buyItem(int): Sells an item stored in the Array list removes it from the array 
              and adds its price to the totalSellings. 
              Returns a boolean indicating if the item was sold or not.
toString() : return a String that displays the information of all the items 
             available in the machine.
 */
package Project2;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList items; //ArrayList that will store the item of the machine
    private static int totalSellings = 0; //Totall sellings made by the machine in L.P.
                                          // intialized to 0.

    /*
    Purpose: No-arg constructor that creates an empty Vending machine.
     */
    VendingMachine() {
        setVendingMachine();
    }

    public void setVendingMachine() {
        items = new ArrayList();
    }

    public int getTotalSellings() {
        return totalSellings;
    }

    public ArrayList getItems() {
        return items;
    }

    public void addItem(Item i) {
        boolean added = false; //boolean that checks if he item was added intialized to false
        
        if (items.size() < 2) {
            items.add(i);
            //add the first 2 items since they will be added and sorted
        }
        
        /*
        The following code block check the instance of the Item i and loops from
        the last item of the ArrayList to the first getting the instance of each
        item. If it finds an item with the same instance of i it adds i directly
        after it and sets boolean added to true to prevent addind other items.
        if the item wasn't added, it gets added at the end of the list.
        */
        
        if (i instanceof Chocolate) {
            for (int x = items.size() - 1; x > 0; x--) {
                if (items.get(x) instanceof Chocolate && !added) {
                    items.add(x + 1, i);
                    added = true;
                }
            }
            if (!added) {
                items.add(items.size(), i);
            }
        } 
        else if (i instanceof Chips) {
            for (int x = items.size() - 1; x > 0; x--) {
                if (items.get(x) instanceof Chips && !added) {
                    items.add(x + 1, i);
                    added = true;
                }
            }
            if (!added) {
                items.add(items.size(), i);
            }
        } 
        else if (i instanceof Water) {
            for (int x = items.size() - 1; x > 0; x--) {
                if (items.get(x) instanceof Water && !added) {
                    items.add(x + 1, i);
                    added = true;
                }
            }
            if (!added) {
                items.add(items.size(), i);
            }

        } 
        else if (i instanceof SoftDrink) {
            for (int x = items.size() - 1; x > 0; x--) {
                if (items.get(x) instanceof SoftDrink && !added) {
                    items.add(x + 1, i);
                    added = true;
                }
            }
            if (!added) {
                items.add(items.size(), i);
            }

        }

    }

    public boolean buyItem(int x) {
        /* 
        The following code block Check the int x passed to the method and determines
        the type of item the user is buying (1 for Chocolate, 2 for Chips, 3 for
        Water, and 4 for Soft Drink). Then it loops till it fing the first item 
        in the vending machine that is from the same instance of the item 
        corresponding to int x. when it does, it adds it casts it to item, adds its
        price to total sellings, removes it from the list and returns true idicating 
        that the purchase was succesful. In case the item was not available, it
        return false idicating that the purchase was unsuccesful
        */
        if (x == 1) {
            for (int y = 0; y < items.size() - 1; y++) {
                if (items.get(y) instanceof Chocolate) {
                    totalSellings += ((Item) (items.get(y))).getItemPrice();
                    items.remove(y);
                    return true;
                }
            }
        }
        if (x == 2) {
            for (int y = 0; y < items.size() - 1; y++) {
                if (items.get(y) instanceof Chips) {
                    totalSellings += ((Item) (items.get(y))).getItemPrice();
                    items.remove(y);
                    return true;
                }
            }
        }
        if (x == 3) {
            for (int y = 0; y < items.size() - 1; y++) {
                if (items.get(y) instanceof Water) {
                    totalSellings += ((Item) (items.get(y))).getItemPrice();
                    items.remove(y);
                    return true;
                }
            }
        }
        if (x == 4) {
            for (int y = 0; y < items.size() - 1; y++) {
                if (items.get(y) instanceof SoftDrink) {
                    totalSellings += ((Item) (items.get(y))).getItemPrice();
                    items.remove(y);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s = ""; //empty String s
        /*
        The following code blocks loops on every item in the ArrayList, checks
        for it's instance, casts it to the item. calls it's toString method and 
        add the returned String to s. Then returns s.
        */
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) instanceof Chocolate) {
                s += ( items.get(i)).toString() + "\n";
            } 
            else if (items.get(i) instanceof Chips) {
                s += (items.get(i)).toString() + "\n";
            } 
            else if (items.get(i) instanceof Water) {
                s += (items.get(i)).toString() + "\n";
            } 
            else {
                s += (items.get(i)).toString() + "\n";
            }
        }
        return s; //String that displays the information of all the items available in the machine
    }

}
