package components;

import utilities.VehicleType;

public class TwoWheel extends Factory {
	public VehicleType getVehicle( String VehicleType )
	 {
	 VehicleType vehicle = null;
	 if( "fast".equals(VehicleType) )
	 {
	 vehicle = vehicle.motorcycle;
	 }
	 else if( "slow".equals(VehicleType) )
	 {
	 vehicle = vehicle.bicycle;
	 }
	 return vehicle;
	 }
}
