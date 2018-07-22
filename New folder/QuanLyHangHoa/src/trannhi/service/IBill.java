/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trannhi.service;

import java.util.ArrayList;
import trannhi.model.Bill;

/**
 *
 * @author Tran Nhi
 */
public interface IBill {

    ArrayList<Bill> listBill = new ArrayList<>();

    public void showBill();
}
