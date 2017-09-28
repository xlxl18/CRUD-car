package test;
import entity.Car;
import manager.CarManager;
import java.util.List;
public class CarTest {

    public static void main(String[] args) {
        CarManager manager = new CarManager();
        Car car1 = new Car("Toyota", "Camry","062KUA01");
        Car car2 = new Car("Lexus", "ES300","062KUA03");
        Car car3 = new Car("Volkswagen", "Polo","062KUA05");

        System.out.println("ADD CONTACT =====================");
        Long car1Id = manager.addCar(car1);
        Long car2Id = manager.addCar(car2);
        Long car3Id = manager.addCar(car3);
        List<Car> result1 = manager.findCars();
        for(Car car: result1) {
            System.out.println(car);
        }

        System.out.println("UPDATE CONTACT =====================");
        Car change = new Car(car1Id,"Toyota", "Camry","062KUA01");
        manager.updateCar(change);
        List<Car> result2 = manager.findCars();

        for(Car car:result2) {
            System.out.println(car);
        }

        System.out.println("DELETE CONTACT =====================");
        manager.deleteCar(car1Id);
        List<Car> result3 = manager.findCars();
        for(Car car:result3) {
            System.out.println(car);
        }

        System.out.println("GET CONTACT =====================");
        Car car = manager.getCar(car2Id);
        System.out.println(car);
    }

}
