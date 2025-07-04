package e.commerce.fawry.challenge;


import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed Desouki
 */
public class Biscuits extends Product implements ExpirableProduct,ShippableProduct {
    private Date expiryDate;
    private double weight;

    public Biscuits(Date expiryDate, double weight, String name, double price, int quantity) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

 

    

    @Override
    public Date getExpiryDate() {
        return expiryDate;
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
    

