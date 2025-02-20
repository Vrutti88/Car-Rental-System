import java.util.Date;
import java.util.Scanner;

public class main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Ask if the user is already registered
        System.out.print("Are you registered? (yes/no): ");
        String isRegistered = scanner.nextLine().trim().toLowerCase();
        
        Customer customer;
        if (isRegistered.equals("yes")) {
            // In a real application, you would query the database.
            // For now, simulate with dummy data.
            customer = new Customer(1, "Registered Customer", "123-456-7890");
            System.out.println("Welcome back, " + customer.getName() + "!");
        } else {
            // New registration flow
            System.out.println("Let's register you.");
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your contact number: ");
            String contact = scanner.nextLine();
            // In a real system, you'd generate a unique customer ID
            customer = new Customer(2, name, contact);
            System.out.println("Registration successful, welcome " + customer.getName() + "!");
        }
        
        // Ask for booking details
        System.out.print("Enter Car Model: ");
        String carModel = scanner.nextLine();
        System.out.print("Enter Car ID (numeric): ");
        int carId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter number of rental days: ");
        int rentalDays = Integer.parseInt(scanner.nextLine());
        
        // Create a Car object (using a fixed daily rate for simplicity)
        Car car = new Car(carId, carModel, 50.0);
        
        // Create booking dates
        Date startDate = new Date(); // current date
        Date endDate = new Date(System.currentTimeMillis() + rentalDays * 24L * 60L * 60L * 1000L);
        
        // Booking process
        BookingService bookingService = new BookingService();
        Booking booking = new Booking(1, car.getCarId(), customer.getCustomerId(), startDate, endDate, 0.0);
        if (bookingService.checkAvailability(car.getCarId(), startDate, endDate)) {
            bookingService.bookCar(booking);
            
            // Billing process
            BillingService billingService = new BillingService();
            double totalAmount = billingService.calculateBill(booking, car);
            // Create an updated booking with the total amount
            booking = new Booking(1, car.getCarId(), customer.getCustomerId(), startDate, endDate, totalAmount);
            billingService.generateBillPdf(booking, customer, car);
        } else {
            System.out.println("Car is not available for the selected dates.");
        }
        
        // Optionally, generate reports
        new VehicleTypeReportGenerator().generateReport();
        new BookingReportGenerator().generateReport();
        new SalesReportGenerator().generateReport();
        new CustomerReportGenerator().generateReport();
        
        scanner.close();
    }
}
