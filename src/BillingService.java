
public class BillingService {
    public double calculateBill(Booking booking, Car car) {
        long days = (booking.getEndDate().getTime() - booking.getStartDate().getTime()) / (1000 * 60 * 60 * 24);
        return days * car.getDailyRate();
    }

    public void generateBillPdf(Booking booking, Customer customer, Car car) {
        System.out.println("Generating PDF Bill for Customer: " + customer.getName());
        System.out.println("Car ID: " + booking.getCarId());
        System.out.println("Total Amount: " + booking.getTotalAmount());
    }
}


