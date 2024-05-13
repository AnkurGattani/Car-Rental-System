public class Customer {
	private String userID;
	private String name;
	private String drivingLicenseNumber;
	// private Car rentedCar;

	public Customer(String userID, String name, String drivingLicenseNumber) {
		this.userID = userID;
		this.name = name;
		this.drivingLicenseNumber = drivingLicenseNumber;
	}

	public String getUserID() {
		return userID;
	}

	public String getName() {
		return name;
	}

	public String getDrivingLicenseNumber() {
		return drivingLicenseNumber;
	}

	// public Car getRentedCar() {
	// 	return rentedCar;
	// }

	
}
