/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trannhi.model;

/**
 *
 * @author Tran Nhi
 */
public class Product {
    private int productID;
    private String productName;
    private double productPrice;
    private String color;
    private String size;

    public Product() {
    }

    public Product(int productID, String productName, double productPrice, String color, String size) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
        this.color = color;
        this.size = size;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice + ", color=" + color + ", size=" + size + '}';
    }
    
    
}
