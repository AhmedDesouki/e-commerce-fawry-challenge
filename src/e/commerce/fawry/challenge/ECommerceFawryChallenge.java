/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.commerce.fawry.challenge;

import java.util.Date;

/**
 *
 * @author Ahmed Desouki
 */
public class ECommerceFawryChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          // Create products
        Product cheese = new Cheese(new Date(),10,"cheese",20,10);
        Product Tv = new Tv(50,"LG",4000,3); 
        Product scratchCard = new MobileScratchCard("ScratchCard", 50, 20);
        
        // Create cart and add items
        ShoppingCart cart = new ShoppingCart();
        cart.add(cheese, 6);
        cart.add(Tv, 1);
        cart.add(scratchCard, 1);
        
        // Create customer and checkout
        Customer customer = new Customer("AHMED", 80);
        Checkout checkoutService = new Checkout();
        checkoutService.checkout(customer, cart);
    }
    
}
