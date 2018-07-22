/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.ServiceBD;

import buidao.model.Product;
import java.util.ArrayList;

/**
 *
 * @author DAo NGo
 */
public interface InterProduct {
    ArrayList<Product> listProduct = new ArrayList<Product>();
    public void showProduct();
}
