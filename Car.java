public class Car {
	private String carID;
	private String brand;
	private String model;
	private double rentalPricePerDay;
	private boolean isAvailable;

	public Car(String carID, String brand, String model, double rentalPricePerDay) {
		this.carID = carID;
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
		this.isAvailable = true;	
	}

	public String getCarID() {
		return carID;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void rent() {
		isAvailable = false;
	}

	public void returnCar() {
		isAvailable = true;
	}
}