/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car_rental_system;

/**
 *
 * @author pari kem
 */
public class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;
    public Car(String carId,String brand,String model,double basePricePerDay){
        this.carId=carId;
        this.brand=brand;
        this.model=model;
        this.basePricePerDay=basePricePerDay;
        this.isAvailable=true;
    }
    public String getCarId(){
        return carId;
    }
     public String getBrand(){
        return brand;
    }
     public String getmodel(){
        return model;
    }
     public boolean isAvailable(){
         return isAvailable;
     }
     public void rent(){
         isAvailable=false;
     }
      public void returnCar(){
         isAvailable=true;
     }
     public double CalculatePrice(int rentalDays){
         return basePricePerDay*rentalDays;
     }
     
    
}
