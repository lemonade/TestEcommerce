package org.company.ecommerce;

import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
