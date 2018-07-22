/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.ServiceBD;

import buidao.model.Employees;
import java.util.ArrayList;

/**
 *
 * @author DAo NGo
 */
public interface InterEmployee {
    ArrayList<Employees> listEmployee = new ArrayList<Employees>();
     public void makeBill();
    public void makeImportBill();
}
