package gui;
import entity.Car;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class EditCarDialog extends JDialog implements ActionListener
{
    // Заголовки кнопок
    private static final String SAVE = "SAVE";
    private static final String CANCEL = "CANCEL";

    // Размер отступа
    private static final int PAD = 10;
    // Ширина метки
    private static final int W_L = 100;
    //Ширина поля для ввода
    private static final int W_T = 300;
    // Ширина кнопки
    private static final int W_B = 120;
    // высота элемента - общая для всех
    private static final int H_B = 25;

    // Поле для ввода Имени
    private final JTextPane txtMark= new JTextPane();
    // Поле для ввода Фамилии
    private final JTextPane txtModel = new JTextPane();
    // Поле для ввода Телефона
    private final JTextPane txtNumber = new JTextPane();


    // Поле для хранения ID контакта, если мы собираемся редактировать
    // Если это новый контакт - cjntactId == null
    private Long carId = null;
    // Надо ли записывать изменения после закрытия диалога
    private boolean save = false;

    public EditCarDialog() {
        this(null);
    }

    public EditCarDialog(Car car) {
        setLayout(null);
        buildFields();
        initFields(car);
        buildButtons();

        setModal(true);

        setResizable(false);

        setBounds(300, 300, 450, 200);

        setVisible(true);
    }


    private void buildFields() {

        JLabel lblFirstName = new JLabel("Марка:");
        lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblFirstName.setBounds(new Rectangle(PAD, 0 * H_B + PAD, W_L, H_B));
        add(lblFirstName);

        txtMark.setBounds(new Rectangle(W_L + 2 * PAD, 0 * H_B + PAD, W_T, H_B));

        txtMark.setBorder(BorderFactory.createEtchedBorder());

        add(txtMark);


        JLabel lblLastName = new JLabel("Модель:");
        lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblLastName.setBounds(new Rectangle(PAD, 1 * H_B + PAD, W_L, H_B));
        add(lblLastName);
        txtModel.setBounds(new Rectangle(W_L + 2 * PAD, 1 * H_B + PAD, W_T, H_B));
        txtModel.setBorder(BorderFactory.createEtchedBorder());
        add(txtModel);


        JLabel lblPhone = new JLabel("Номер:");
        lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPhone.setBounds(new Rectangle(PAD, 2 * H_B + PAD, W_L, H_B));
        add(lblPhone);
        txtNumber.setBounds(new Rectangle(W_L + 2 * PAD, 2 * H_B + PAD, W_T, H_B));
        txtNumber.setBorder(BorderFactory.createEtchedBorder());
        add(txtNumber);


    }

    // Если нам епередали контакт - заполняем поля из контакта
    private void initFields(Car car) {
        if (car != null) {
            carId = car.getId();
            txtMark.setText(car.getMark());
            txtModel.setText(car.getModel());
        }
    }

    // Размещаем кнопки на форме
    private void buildButtons() {
        JButton btnSave = new JButton("SAVE");
        btnSave.setActionCommand(SAVE);
        btnSave.addActionListener(this);
        btnSave.setBounds(new Rectangle(PAD, 5 * H_B + PAD, W_B, H_B));
        add(btnSave);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setActionCommand(CANCEL);
        btnCancel.addActionListener(this);
        btnCancel.setBounds(new Rectangle(W_B + 2 * PAD, 5 * H_B + PAD, W_B, H_B));
        add(btnCancel);
    }

    @Override
    // Обработка нажатий кнопок
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        // Если нажали кнопку SAVE (сохранить изменения) - запоминаем этой
        save = SAVE.equals(action);
        // Закрываем форму
        setVisible(false);
    }

    // Надо ли сохранять изменения
    public boolean isSave() {
        return save;
    }

    // Создаем контакт из заполенных полей, который можно будет записать
    public Car getCar() {
        Car car= new Car(carId, txtMark.getText(),
                txtModel.getText(), txtNumber.getText());
        return car;
    }
}