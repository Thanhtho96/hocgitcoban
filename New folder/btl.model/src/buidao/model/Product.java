/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.model;

/**
 *
 * @author DAo NGo
 */
public class Product {
    private int productID;
    private String productName;
    private double productPrice;
    private String color;
    private double weight;

    public Product() {
    }

    public Product(int productID, String productName, double productPrice, String color, double weight) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.color = color;
        this.weight = weight;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public double getweight() {
        return weight;
    }

    public void setweight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice + ", color=" + color + ", weight=" + weight + '}';
    }

   
    
    
    
}
