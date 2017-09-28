package entity;

public class Car {
    private Long carId;
    private String mark;
    private String model;
    private String number;

    public Car() {

    }

    public Car(String mark, String model, String number) {
        this.mark=mark;
        this.model=model;
        this.number=number;
    }

    public Car (long carId, String mark, String model, String number ) {
        this.carId=carId;
        this.mark=mark;
        this.model=model;
        this.number=number;
    }

    public Long getId() {
        return this.carId;
    }

    public void setId(Long carId) {
        this.carId = carId;
    }

    public String getMark() {
        return this.mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "entity.Car{"+"carId="+carId+", mark="+mark+", model="+model+",number="+number+"}";
    }
}
