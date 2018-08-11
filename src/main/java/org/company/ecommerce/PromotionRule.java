/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.company.ecommerce;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class PromotionRule {
    private Date fromDate;
    private Date toDate;
    private Group appliedGroup;
    private String color;
    private double subTotal;
    private double discount;

    public PromotionRule(Date fromDate, Date toDate, Group appliedGroup, 
            String color, double subTotal, double discount) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.appliedGroup = appliedGroup;
        this.color = color;
        this.subTotal = subTotal;
        this.discount = discount;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Group getAppliedGroup() {
        return appliedGroup;
    }

    public void setAppliedGroup(Group appliedGroup) {
        this.appliedGroup = appliedGroup;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
