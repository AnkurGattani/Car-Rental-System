public class Main {
	public static void main(String[] args) {
		Garage garage = new Garage();
		CarRentalSystem crs = new CarRentalSystem(garage);

		Car car1 = new Car("C001", "Tata", "Harrier", 1700);
		Car car2 = new Car("C002", "Toyota", "Vios", 600);
		Car car3 = new Car("C003", "Mahindra", "XUV", 2100);

		garage.addCar(car1);
		garage.addCar(car2);
		garage.addCar(car3);

		crs.menu();
	}
}
