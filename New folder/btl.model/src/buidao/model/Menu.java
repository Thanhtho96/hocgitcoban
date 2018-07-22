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
public class Menu {
    private int option;
    private String decscription;

    public Menu() {
    }

    public Menu(int option, String decscription) {
        this.option = option;
        this.decscription = decscription;
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getDecscription() {
        return decscription;
    }

    public void setDecscription(String decscription) {
        this.decscription = decscription;
    }
}
