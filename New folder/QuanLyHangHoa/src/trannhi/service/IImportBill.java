/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trannhi.service;

import java.util.ArrayList;
import trannhi.model.ImportBill;

/**
 *
 * @author Tran Nhi
 */
public interface IImportBill {
    ArrayList<ImportBill> listImportBill = new ArrayList<ImportBill>();
    public void showImportBill();
}
