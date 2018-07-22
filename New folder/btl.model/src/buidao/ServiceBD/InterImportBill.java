/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.ServiceBD;

import buidao.model.ImportBill;
import java.util.ArrayList;

/**
 *
 * @author DAo NGo
 */
public interface InterImportBill {
    ArrayList<ImportBill> listImportBill = new ArrayList<ImportBill>();
    public void showImportBill();
    
}
