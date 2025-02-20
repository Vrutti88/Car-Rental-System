// File: Booking.java
import java.util.Date;

public class Booking {
    private int bookingId;
    private int carId;
    private int customerId;
    private Date startDate;
    private Date endDate;
    private double totalAmount;

    public Booking(int bookingId, int carId, int customerId, Date startDate, Date endDate, double totalAmount) {
        this.bookingId = bookingId;
        this.carId = carId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalAmount = totalAmount;
    }

    public int getBookingId() { return bookingId; }
    public int getCarId() { return carId; }
    public int getCustomerId() { return customerId; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public double getTotalAmount() { return totalAmount; }
}
