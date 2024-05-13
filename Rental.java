import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Rental {
	private String rentalID;
	private Customer customer;
	private Car car;
	private LocalDate rentalDate;
	private LocalDate returnDate;
	private int totalRentalDays;
	private double totalRentalPrice;

	public Rental(Customer customer, Car car, LocalDate rentalDate, LocalDate returnDate) {
		this.rentalID = setRentalID();
		this.customer = customer;
		this.car = car;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}

	public String setRentalID() {
		return UUID.randomUUID().toString();
	}

	public String getRentalID() {
		return rentalID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Car getCar() {
		return car;
	}

	public LocalDate getRentalDate() {
		return rentalDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void calculateTotalRentalDays() {
		if (rentalDate != null && returnDate != null) {
			this.totalRentalDays = (int) ChronoUnit.DAYS.between(rentalDate, returnDate);
		} else {
			this.totalRentalDays = 0;
		}
		System.out.println("Total rental days: " + totalRentalDays);
	}

	public void calculateTotalPrice() {
		calculateTotalRentalDays();
		if (car != null) {
			this.totalRentalPrice = totalRentalDays * car.getRentalPricePerDay();
		}
		System.out.println("Total rental price: " + totalRentalPrice);
	}
}