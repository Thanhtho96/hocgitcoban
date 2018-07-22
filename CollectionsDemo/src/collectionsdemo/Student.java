/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionsdemo;

/**
 *
 * @author nghiemmanh
 */
public class Student {

    private Integer mark;
    private String name;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int mark, String name) {
        this.mark = mark;
        this.name = name;
    }

}
