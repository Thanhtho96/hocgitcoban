/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bka.binhnk.model;



/**
 *
 * @author Bibi
 */
public class Car {

    public String idCar;
    public String nameCar;
    public Integer priceIn;
    public Integer soLuong;

    public Car() {
    }

    public Car(String idCar, String nameCar, Integer priceIn, Integer soLuong) {
        this.idCar = idCar;
        this.nameCar = nameCar;
        this.priceIn = priceIn;
        this.soLuong = soLuong;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public Integer getPriceIn() {
        return priceIn;
    }

    public void setPriceIn(Integer priceIn) {
        this.priceIn = priceIn;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Mã xe: " + idCar + ", Tên xe: " + nameCar + ", Giá: "
                + priceIn + ", Số Lượng: " + soLuong;
    }
}
