/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trannhi.service;

import java.util.ArrayList;
import trannhi.model.Product;

/**
 *
 * @author Tran Nhi
 */
public interface IProduct {
    ArrayList<Product> listProduct = new ArrayList<Product>();
    public void showProduct();
}
