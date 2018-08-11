package org.company.ecommerce;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Date;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.company.ecommerce.Group;
import org.company.ecommerce.Product;
import org.company.ecommerce.PromotionRule;
import org.company.ecommerce.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class ECommerceUnitTest {
    private User user;
    
    @Before
    public void setup() {
        user = new User("John Doe 1", "john.doe@example.com", Group.GOLD);
        user.addProductToCart(new Product("Iphone Silver", "Silver", 999), 2);
        user.addProductToCart(new Product("Iphone Black", "Black", 899), 1);
    }

    @Test
    public void testCheckTotalPrice() {
        assertTrue(user.getTotalPriceOfShoppingCart() == 2897);
    }
    
    /**
     * Promotion time is expired
     */
    @Test
    public void testApplyPromotionRule_01() {
        PromotionRule rule = new PromotionRule(Date.valueOf("2018-08-01"), 
                Date.valueOf("2018-08-07"), Group.GOLD, "Black", 800, 50);
        
        assertTrue(user.getTotalPriceOfShoppingCartOnApplyRule(rule) == 2897);
    }
    
    /**
     * During promotion time
     */
    @Test
    public void testApplyPromotionRule_02() {
        PromotionRule rule = new PromotionRule(Date.valueOf("2018-08-08"), 
                Date.valueOf("2018-08-24"), Group.GOLD, "Black", 1500, 50);
        
        assertTrue(user.getTotalPriceOfShoppingCartOnApplyRule(rule) == 2897);
    }
    
    /**
     * Before promotion time
     */
    @Test
    public void testApplyPromotionRule_03() {
        PromotionRule rule = new PromotionRule(Date.valueOf("2018-08-25"), 
                Date.valueOf("2018-08-31"), Group.GOLD, "Black", 800, 50);
        
        assertTrue(user.getTotalPriceOfShoppingCartOnApplyRule(rule) == 2897);
    }
}
