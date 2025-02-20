
import java.util.*;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();

    public boolean checkAvailability(int carId, Date startDate, Date endDate) {
        for (Booking booking : bookings) {
            if (booking.getCarId() == carId && !(endDate.before(booking.getStartDate()) || startDate.after(booking.getEndDate()))) {
                return false;
            }
        }
        return true;
    }

    public void bookCar(Booking booking) {
        bookings.add(booking);
    }

    public void cancelBooking(int bookingId) {
        bookings.removeIf(booking -> booking.getBookingId() == bookingId);
    }

    public Booking getBookingById(int bookingId) {
        return bookings.stream().filter(b -> b.getBookingId() == bookingId).findFirst().orElse(null);
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}