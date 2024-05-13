import java.util.ArrayList;
import java.util.List;

public class Garage {
	private List<Car> cars;

	// Constructor
	public Garage() {
		cars = new ArrayList<>();
	}

	public void addCar(Car car) {	// Add a car to the garage
		cars.add(car);
	}

	public void removeCar(Car car) {	// Remove a car from the garage
		cars.remove(car);
	}

	public List<Car> getCars() {	// Get all cars in the garage
		return cars;
	}

	public boolean isCarAvailable(String carId) {	// Check if the car is available
		for (Car car : cars) {
			if (car.getCarID().equals(carId)) {
				return car.isAvailable();
			}
		}
		return false;
	}
}