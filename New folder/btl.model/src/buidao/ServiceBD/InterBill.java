/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.ServiceBD;

import buidao.model.Bill;
import java.util.ArrayList;

/**
 *
 * @author DAo NGo
 */
public interface InterBill {
    ArrayList<Bill> listBill = new ArrayList<Bill>();
    public void showBill();
    public void find(int productID);
}
