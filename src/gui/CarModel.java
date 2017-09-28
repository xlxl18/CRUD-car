package gui;

import entity.Car;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CarModel extends AbstractTableModel {
    private static final String[] head = {"ID", "Марка", "Модель", "Номер"};
    private final List<Car> cars;

    public CarModel(List<Car> cars) {
        this.cars=cars;
    }

        @Override
    public int getRowCount() {
        return cars.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    public String getColumnName(int col) {
        return head[col];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Car car = cars.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return car.getId().toString();

            case 1:
                return car.getMark();

            case 2:
                return car.getModel();

            case 3:
                return car.getNumber();
        }

        return null;
    }




}
