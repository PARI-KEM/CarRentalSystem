/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package car_rental_system;
import java.util.*;

/**
 *
 * @author pari kem
 */
public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;
    
    public CarRentalSystem(){
        cars=new ArrayList<>();
        customers=new ArrayList<>();
        rentals=new ArrayList<>();
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car, Customer customer,int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        }
        else{
            System.out.println("Car isn't available for rent");
        }
    }
    public void returnCar(Car car){
        car.returnCar();
        Rental rentalToRemove=null;
        for(Rental rental:rentals){
            if(rental.getCar()==car){
            rentalToRemove=rental;
            break;
            }
        }
        if(rentalToRemove!=null){
            rentals.remove(rentalToRemove);
           // System.out.println("Car Returned Successfully");
                
        }
        else{
            System.out.println("Car was not rented.");
        }
    }
    public void menu(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.println("Enter Your Choic: ");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                System.out.println("=== Rent a Car");
                System.out.println("Enter Your Name :");
                String customerName=sc.nextLine();
                System.out.println("Available Cars");
                for(Car car:cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCarId()+" - "+car.getBrand()+" - "+car.getmodel());
                    }
                }
                System.out.println("Enter the car ID you want to rent:");
                String carId=sc.nextLine();
                System.out.println("Enter the name of days for rental:");
                int rentalDays=sc.nextInt();
                sc.nextLine();
                Customer newCustomer=new Customer("CUS"+(customers.size()+1), customerName);
                addCustomer(newCustomer);
                Car selectedCar=null;
                for(Car car:cars){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar=car;
                        break;
                    }
                }
                if(selectedCar!=null){
                    double totalPrice=selectedCar.CalculatePrice(rentalDays);
                    System.out.println("=== Rental Information ===");
                    System.out.println("Customer Id:"+ newCustomer.getCustomerId());
                    System.out.println("CustomerName:"+newCustomer.getName());
                    System.out.println("Car:"+ selectedCar.getBrand()+" "+ selectedCar.getmodel());
                    System.out.println("Rental Days:"+ rentalDays);
                    System.out.printf("Total Price : $%.2f%n", totalPrice);
                    
                    System.out.println("Confirm Rental (Y/N):");
                    String confirm=sc.nextLine();
                    
                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar,newCustomer,rentalDays);
                        System.out.println("Car rented successfully");
                    }
                    else{
                        System.out.println("Rental Canceled.");
                    }
                }
                else{
                    System.out.println("Invalid Car selection or Car not Available.");
                    
                }
            }
            else if(choice==2){
                System.out.println("Return a Car");
                System.out.println("Enter the car ID you want to return :");
                String carId=sc.nextLine();
                
                Car carToReturn=null;
                for(Car car:cars){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        carToReturn=car;
                        break;
                    }
                    
                }
                if(carToReturn!=null){
                    Customer customer=null;
                    for(Rental rental: rentals){
                        if(rental.getCar()==carToReturn){
                            customer=rental.getCustomer();
                            break;
                        }
                    }
                    if(customer!=null){
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by "+ customer.getName());
                    }
                    else{
                        System.out.println("Car was not rented or rental information is invalid");
                    }
                }
                else{
                    System.out.println("Invalid Car ID or Car is not rented.");
                }
            }
            else if(choice==3){
                break;
            }
            else{
                System.out.println("Invalid Choice");
            }
        }
        System.out.println("Thank You for using the Car Rental System !");
    }

   
    
    
}
