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
public class Tv extends Product implements ShippableProduct{
    private double weight;

    public Tv(double weight, String name, double price, int quantity) {
        super(name, price, quantity);
        this.weight = weight;
    }

    

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getShippingName() {
        return name;
    }
   
    
}
