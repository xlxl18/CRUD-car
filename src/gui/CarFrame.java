package gui;

import entity.Car;
import manager.CarManager;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;


public class CarFrame extends JFrame implements ActionListener {
    private static final String LOAD="LOAD";
    private static final String ADD="ADD";
    private static final String EDIT="EDIT";
    private static final String DELETE="DELETE";
    private final CarManager carManager = new CarManager();
    private final JTable carTable = new JTable();


    public CarFrame() {
        carTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 0, 5);

        JPanel panel = new JPanel();
        panel.setLayout(gridBagLayout);
        panel.add(createButton(gridBagLayout, gbc, "Обновить", LOAD));
        panel.add(createButton(gridBagLayout, gbc, "Добавить", ADD));
        panel.add(createButton(gridBagLayout, gbc, "Исправить", EDIT));
        panel.add(createButton(gridBagLayout, gbc, "Удалить", DELETE));
        JPanel left = new JPanel();
        left.setLayout(new BorderLayout());
        left.add(panel, BorderLayout.NORTH);
        add(left, BorderLayout.WEST);
        add(new JScrollPane(carTable), BorderLayout.CENTER);
        setBounds(100, 200, 900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadCar();
    }
        private JButton createButton(GridBagLayout gridBagLayout, GridBagConstraints gbc, String title, String action) {
           JButton button = new JButton(title);
           button.setActionCommand(action);
           button.addActionListener(this);
           gridBagLayout.setConstraints(button, gbc);
           return button;
        }


    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        switch (action) {
            case LOAD:
                loadCar();
                break;
            case ADD:
                addCar();
                break;
            case EDIT:
                editCar();
                break;
            case DELETE:
                deleteCar();
                break;
        }
    }

    private void loadCar() {
        List<Car> carList = carManager.findCars();
        CarModel model = new CarModel(carList);
        carTable.setModel(model);
    }

    private  void addCar() {
        EditCarDialog dialog = new EditCarDialog();
        saveCar(dialog);
    }

    private void editCar() {
        int sr=carTable.getSelectedRow();
        if(sr!=-1) {
            Long id = Long.parseLong(carTable.getModel().getValueAt(sr,0).toString());
            Car car = carManager.getCar(id);
            EditCarDialog dialog = new EditCarDialog(carManager.getCar(id));
            saveCar(dialog);
        }
        else {
            JOptionPane.showMessageDialog(this,"Выделите строку");
        }
    }

    private void deleteCar() {
        int sr=carTable.getSelectedRow();
        if(sr!=-1) {
            Long id = Long.parseLong(carTable.getModel().getValueAt(sr,0).toString());
            carManager.deleteCar(id);
            loadCar();
        }
        else {
            JOptionPane.showMessageDialog(this,"Выделите строку");
        }
        }


    private void saveCar(EditCarDialog ecd) {
        if(ecd.isSave()) {
            Car car = ecd.getCar();
            if(car.getId()!=null) {
                carManager.updateCar(car);
            }
            else {
                carManager.addCar(car);
            }
            loadCar();
        }
    }
}
