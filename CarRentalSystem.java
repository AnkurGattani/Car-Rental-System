import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class CarRentalSystem {
	private List<Rental> rentals;
	private List<Customer> customers;
	private List<Car> cars;
	private Garage garage;

	public CarRentalSystem(Garage garage) {
		rentals = new ArrayList<>();
		customers = new ArrayList<>();
		this.garage = garage;
		cars = garage.getCars();
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void rentCar(Customer customer, Car car, LocalDate rentalDate, LocalDate returnDate) {
		if (garage.isCarAvailable(car.getCarID())) {
			Rental rental = new Rental(customer, car, rentalDate, returnDate);
			rentals.add(rental);
			System.out.println("Rental ID: " + rental.getRentalID());
			car.rent();
		} else {
			System.out.println("Car is not available for rental.");
		}
	}

	public void returnCar(String rentalID) {
		Rental rental = findRental(rentalID);
		if (rental != null) {
			System.out.println("\n=== Rental Details ===");
			System.out.println("Rental ID: " + rental.getRentalID());
			System.out.println("Customer: " + rental.getCustomer().getName());
			System.out.println("Car: " + rental.getCar().getCarID() + " - " + rental.getCar().getBrand() + " - "
					+ rental.getCar().getModel());
			rental.calculateTotalPrice();
			rental.getCar().returnCar();
		} else {
			System.out.println("Rental ID not found.");
		}
	}

	public Rental findRental(String rentalID) {
		for (Rental rental : rentals) {
			if (rental.getRentalID().equals(rentalID)) {
				return rental;
			}
		}
		return null;
	}

	// Display all rental transactions
	public void displayAllRentals() {
		for (Rental rental : rentals) {
			System.out.println("Rental ID: " + rental.getRentalID());
			System.out.println("Customer: " + rental.getCustomer().getName());
			System.out.println("Car: " + rental.getCar().getBrand() + " " + rental.getCar().getModel());
			System.out.println("Rental Date: " + rental.getRentalDate());
			System.out.println("Return Date: " + rental.getReturnDate());
		}
	}

	public void menu() {
		Scanner in = new Scanner(System.in);
		int choice = 0;

		while (true) {
			System.out.println("\n===== Car Rental System =====");
			System.out.println("1. Rent a car");
			System.out.println("2. Return a car");
			System.out.println("3. Display all rentals");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			choice = in.nextInt();
			in.nextLine();	// Consume newline character being left out by nextInt()

			if (choice == 1) {
				System.out.println("\n===== Rent a car =====");
				System.out.print("Enter customer name: ");
				String name = in.nextLine();
				System.out.println("Enter driving license number: ");
				String drivingLicenseNumber = in.next();
				// in.nextLine();

				Customer customer = new Customer("CUS" + customers.size() + 1, name, drivingLicenseNumber);
				addCustomer(customer);

				System.out.println("\nAvailable Cars: ");
				for (Car car : cars) {
					if (car.isAvailable()) {
						System.out.println(
								"Car details: " + car.getCarID() + " - " + car.getBrand() + " - " + car.getModel());

						System.out.println("Rental rate: " + car.getRentalPricePerDay() + " per day");
					}
				}

				System.out.print("Enter car ID: ");
				String carID = in.next();

				System.out.print("Enter rental date (yyyy-mm-dd): ");
				String rentalDateStr = in.next();

				System.out.print("Enter return date (yyyy-mm-dd): ");
				String returnDateStr = in.next();

				LocalDate rentalDate = LocalDate.parse(rentalDateStr);
				LocalDate returnDate = LocalDate.parse(returnDateStr);

				Car carSelected = null;
				for (Car car : cars) {
					if (car.getCarID().equals(carID)) {
						carSelected = car;
						break;
					}
				}

				if (carSelected != null) {
					rentCar(customer, carSelected, rentalDate, returnDate);
					System.out.println("Car rented successfully.");
				} else {
					System.out.println("\nInvalid car selection or car not available for rent.");
				}
			} else if (choice == 2) {
				System.out.println("\n===== Return a car =====");
				System.out.print("Enter rental ID: ");
				String rentalID = in.next();
				returnCar(rentalID);
			} else if (choice == 3) {
				System.out.println("\n===== Display all rentals =====");
				displayAllRentals();
			} else if (choice == 4) {
				System.out.println("Exiting program...");
				break;
			} else {
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}