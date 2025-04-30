/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car_rental_system;

/**
 *
 * @author pari kem
 */
public class Main {
    public static void main(String[] args) {
         CarRentalSystem rentalsystem=new CarRentalSystem();
        
        Car car1=new Car("C001","Toyota","Canry",60.0);
        Car car2=new Car("C002","Honda","Accord",70.0);
        Car car3=new Car("C003","Mahindra","Thar",150.0);
        rentalsystem.addCar(car1);
        rentalsystem.addCar(car2);
        rentalsystem.addCar(car3);
        
        rentalsystem.menu();
          
    }
    
}
