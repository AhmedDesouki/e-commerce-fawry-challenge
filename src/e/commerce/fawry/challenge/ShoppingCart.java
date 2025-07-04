package e.commerce.fawry.challenge;


import java.util.ArrayList;
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
public class ShoppingCart {
    private List<Cart> items = new ArrayList<>();
    public List<Cart> getItems() { return items; }   
    
     public void add(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            System.out.printf("Not enough stock for " + product.getName());
        }
        items.add(new Cart(product, quantity));
    }
     
     public double getSubtotal() {
        return items.stream().mapToDouble(Cart::getTotalPrice).sum();
}
     
      public List<ShippableProduct> getShippableItems() {
        List<ShippableProduct> shippables = new ArrayList<>();
        for (Cart item : items) {
            if (item.getProduct() instanceof ShippableProduct) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippables.add((ShippableProduct) item.getProduct());
                }
            }
        }
        return shippables;
    }
     
}
