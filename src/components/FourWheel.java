package components;

import utilities.VehicleType;

public class FourWheel extends Factory {
	public VehicleType getVehicle( String VehicleType )
	 {
	 VehicleType vehicle = null;
	 if( "private".equals(VehicleType) )
	 {
	 vehicle = vehicle.car;
	 }
	 else if( "work".equals(VehicleType) )
	 {
	 vehicle = vehicle.truck;
	 }
	 else if( "public".equals(VehicleType) )
	 {
	 vehicle = vehicle.bus;
	 }
	 return vehicle;
	 }
}
