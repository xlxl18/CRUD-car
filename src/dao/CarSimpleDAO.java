package dao;
import java.util.ArrayList;

import entity.Car;

import java.util.Iterator;
import java.util.List;

public class CarSimpleDAO implements CarDAO {
        private final List<Car> cars = new ArrayList<Car>();

        public CarSimpleDAO() {
            Car car1 = new Car("Toyota", "Camry","062KUA01");
            Car car2 = new Car("Lexus", "ES300","062KUA03");
            Car car3 = new Car("Volkswagen", "Polo","062KUA05");
        }

    @Override
    public Long addCar(Car car) {
        Long id=generateCarId();
        car.setId(id);
        cars.add(car);
        return id;
    }

    @Override
    public void updateCar(Car car) {
        Car oldCar = getCar(car.getId());
        if(oldCar!=null) {
            oldCar.setMark(car.getMark());
            oldCar.setModel(car.getModel());
            oldCar.setNumber(car.getNumber());
        }
    }

    @Override
    public void deleteCar(Long carId) {
        for(Iterator<Car> iterator=cars.iterator(); iterator.hasNext();) {
            if(iterator.next().getId().equals(carId)) {
                iterator.remove();
            }
        }
    }

    @Override
    public Car getCar(Long carId) {
        for(Car cars: cars) {
            if(cars.getId().equals(carId)) {
                return cars;
            }
        }
        return null;
    }

    @Override
    public List<Car> findCars() {
        return cars;
    }

    private Long generateCarId() {
        Long carId = Math.round(Math.random()*1000+System.currentTimeMillis());
        while(getCar(carId)!=null) {
            carId=Math.round(Math.random() * 1000 + System.currentTimeMillis());
        }
        return carId;
    }
}
