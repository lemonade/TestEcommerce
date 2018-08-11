/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.company.ecommerce;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class ShoppingCart {
    
    private final User user;
    private final Map<Product, Integer> products;
    
    public ShoppingCart(final User user) {
        products = new HashMap<>();
        this.user = user;
    }
    
    /**
     * Add product to cart with specific quantity
     * @param product product to be added
     * @param count quantity
     */
    public void addProduct(Product product, int count) {
        if (products.containsKey(product)) {
            this.products.put(product, this.products.get(product) + count);
        } else {
            this.products.put(product, count);
        }
    }
    
    /**
     * Remove product with specific quantity out of cart
     * @param product product to be removed
     * @param count quantity to remove
     */
    public void removeProduct(Product product, int count) {
        if (!products.containsKey(product)) {
            return;
        }
        
        if (products.get(product) <= count) {
            products.remove(product);
        } else {
            products.put(product, products.get(product) - count);
        }
    }
    
    /**
     * Get total of all products in cart
     * @return total
     */
    public double getTotalPrice() {
        if (products.isEmpty()) {
            throw new RuntimeException("Shopping cart is empty.");
        }
        
        return products.entrySet().stream().map(p -> {
            return p.getKey().getPrice() * p.getValue();
        }).reduce((p1, p2) -> {
            return p1 + p2;
        }).get();
    }
    
    /**
     * Get total when apply promotion rule
     * @param promoRule promotion rule to be applied
     * @return total price after apply rule
     */
    public double getPriceAfterApplyPromotionRule(PromotionRule promoRule) {
        double total = getTotalPrice();
        Date now = new Date();
        
        if (now.compareTo(promoRule.getFromDate()) < 0 
                || now.compareTo(promoRule.getToDate()) > 0) {
            return total;
        }
        
        if (user.getGroup() != promoRule.getAppliedGroup()) {
            return total;
        }
        
        double totalPriceFollowColorRule = products.entrySet().stream().filter(p -> {
            return p.getKey().getColor().equals(promoRule.getColor());
        }).map(p -> {
            return p.getKey().getPrice() * p.getValue();
        }).reduce((p1, p2) -> {
            return p1 + p2;
        }).get();
        
        if (totalPriceFollowColorRule <= promoRule.getSubTotal()) {
            return total;
        }
        
        return total - promoRule.getDiscount();
    }
}
