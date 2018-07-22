/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

/**
 *
 * @author QQ
 */
public abstract class PersonController {
    public abstract Boolean login(String user, String pass);

    public abstract Boolean login(String user, String pass, int role);
}
