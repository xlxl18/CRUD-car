package dao;
import entity.Car;

import java.util.List;

public interface CarDAO {
    public Long addCar(Car car);
    public void updateCar(Car car);
    public void deleteCar(Long carId);
    public Car getCar(Long carId);

    public List<Car> findCars();


}
