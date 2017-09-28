package manager;
import dao.CarDAO;
import dao.CarDAOFactory;
import  entity.*;

import java.util.List;

public class CarManager {
    private CarDAO carDAO;

    public CarManager() {
        carDAO=CarDAOFactory.getCarDAO();
    }

    public Long addCar(Car car) {
        return carDAO.addCar(car);
    }

    public void updateCar(Car car) {
        carDAO.updateCar(car);
    }

    public void deleteCar(Long carId) {
        carDAO.deleteCar(carId);
    }

    public Car getCar(Long carId) {
        return carDAO.getCar(carId);
    }

    public List<Car> findCars() {
        return carDAO.fingCars();
    }
}
