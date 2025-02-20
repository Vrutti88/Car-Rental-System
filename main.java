
import java.util.Date;

public class main{
    public static void main(String[] args) {

        Customer customer = new Customer(1, "Ashutoshh", "81047338890");
        Car car = new Car(11, "Audi", 1500.0);
        
  
        BookingService bookingService = new BookingService();
        BillingService billingService = new BillingService();
        

        Date startDate = new Date(System.currentTimeMillis());
        Date endDate = new Date(System.currentTimeMillis() + (2 * 24 * 60 * 60 * 1000)); // 3 days later
        
        if (bookingService.checkAvailability(car.getCarId(), startDate, endDate)) {
            Booking booking = new Booking(1, car.getCarId(), customer.getCustomerId(), startDate, endDate, 0.0);
            bookingService.bookCar(booking);
            
            double totalAmount = billingService.calculateBill(booking, car);
            booking = new Booking(1, car.getCarId(), customer.getCustomerId(), startDate, endDate, totalAmount);
            billingService.generateBillPdf(booking, customer, car);
        } else {
            System.out.println("Car is not available for the selected dates.");
        }

        // Generate reports
        new VehicleTypeReportGenerator().generateReport();
        new BookingReportGenerator().generateReport();
        new SalesReportGenerator().generateReport();
        new CustomerReportGenerator().generateReport();
    }
}
