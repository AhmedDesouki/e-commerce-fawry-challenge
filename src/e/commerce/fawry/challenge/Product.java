package e.commerce.fawry.challenge;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed Desouki
 */
public class Product {
    protected  String name;
    protected  double price;
    protected  int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
     public boolean updateQuantity(int amount) {
        if (this.quantity + amount >= 0) {
            this.quantity += amount;
            return true;
        }
        return false;
    }

    public double getTotalPrice(int quantity) {
        return this.price * quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
