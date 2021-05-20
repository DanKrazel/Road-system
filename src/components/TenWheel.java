package components;

import utilities.VehicleType;

public class TenWheel extends Factory {
	public VehicleType getVehicle( String VehicleType )
	 {
	 VehicleType vehicle = null;
	 if( "public".equals(VehicleType) )
	 {
	 vehicle = vehicle.tram;
	 }
	 else if( "work".equals(VehicleType) )
	 {
	 vehicle = vehicle.semitrailer;
	 }
	 return vehicle;
	 }
}
