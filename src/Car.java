
public class Car {
    private int carId;
    private String model;
    private double dailyRate;

    public Car(int carId, String model, double dailyRate) {
        this.carId = carId;
        this.model = model;
        this.dailyRate = dailyRate;
    }

    public int getCarId() { return carId; }
    public String getModel() { return model; }
    public double getDailyRate() { return dailyRate; }
}
