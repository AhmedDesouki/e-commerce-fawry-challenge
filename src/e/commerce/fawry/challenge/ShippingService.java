package e.commerce.fawry.challenge;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed Desouki
 */
public class ShippingService {
    public void processShipment(List<ShippableProduct> items) {
        System.out.println("** Shipment notice **");
        Map<String, Integer> itemCounts = new HashMap<>();
        double totalWeight = 0;
        
        for (ShippableProduct item : items) {
            itemCounts.merge(item.getShippingName(), 1, Integer::sum);
            totalWeight += item.getWeight();
        }
        
        itemCounts.forEach((name, count) -> {
            double itemWeight = items.stream()
                .filter(i -> i.getShippingName().equals(name))
                .findFirst()
                .map(ShippableProduct::getWeight)
                .orElse(0.0);
            System.out.println("x" +count +"  " +name +"    " + itemWeight * 1000 + "g");
        });
        
        System.out.println("Total package weight" +"    "+totalWeight+"kg");
    }
}
