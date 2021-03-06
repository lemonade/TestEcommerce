package org.company.ecommerce;

public class User {
    private String name;
    private String email;
    private Group group;
    private final ShoppingCart shoppingCart;

    public User(String name, String email, Group group) {
        this.name = name;
        this.email = email;
        this.group = group;
        this.shoppingCart = new ShoppingCart(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    
    public void addProductToCart(Product product, int count) {
        this.shoppingCart.addProduct(product, count);
    }
    
    public void removeProductFromCart(Product product, int count) {
        this.shoppingCart.removeProduct(product, count);
    }
    
    public double getTotalPriceOfShoppingCart() {
        return this.shoppingCart.getTotalPrice();
    }
    
    public double getTotalPriceOfShoppingCartOnApplyRule(PromotionRule rule) {
        return this.shoppingCart.getPriceAfterApplyPromotionRule(rule);
    }
}
