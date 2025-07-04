package e.commerce.fawry.challenge;


import java.io.PrintStream;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed Desouki
 */
public class Checkout {
     private ShippingService shippingService = new ShippingService();
    
    public void checkout(Customer customer, ShoppingCart cart) {
        if (cart.getItems().isEmpty()) {
            System.out.printf("Cannot checkout empty cart");
            
        }
        else{
        if(cart.getSubtotal()>customer.getBalance()){
            System.out.println("Balance: "+customer.getBalance()+"$");
             System.out.println("Your balance is insufficient");
              
        }
        else{
        // Process shipment
        List<ShippableProduct> shippableItems = cart.getShippableItems();
        if (!shippableItems.isEmpty()) {
            shippingService.processShipment(shippableItems);
        }
        
        // Calculate totals
        double subtotal = cart.getSubtotal();
        double shippingFee = shippableItems.isEmpty() ? 0 : 30;
        double total = subtotal + shippingFee;
        
        // Print receipt
        System.out.println("** Checkout receipt **");
        for (Cart item : cart.getItems()) {
    String quantity = item.getQuantity() + "x";
    String name = item.getProduct().getName();
    String price = String.valueOf(Math.round(item.getTotalPrice()));
    
    System.out.println("    "+quantity +"    "+ name +"    "+ price);
}
         /*
        for (Cart item : cart.getItems()) {
            System.out.println(item.getQuantity());
            System.out.println( item.getProduct());
            System.out.println(item.getProduct().getName());
            System.out.println(item.getTotalPrice());
        }
        */
        System.out.println("----------------------");
        System.out.println("Subtotal         "+ subtotal);
        System.out.println("Shipping         "+ shippingFee);
        System.out.println("Amount           "+ total);
        System.out.println("Balance: "+(customer.getBalance() - total)+"$");
        
        // Update inventory
        for (Cart item : cart.getItems()) {
            item.getProduct().updateQuantity(item.getQuantity());
        }
    }
    }
        }
}
