package components;

import java.util.ArrayList;

import utilities.VehicleType;

public class CountryCar {

	public VehicleType getVehicle( String VehicleType )
	 {
	 VehicleType vehicle = null;
	 ArrayList<VehicleType> vehType=new ArrayList<VehicleType>();
	 
	 if( "work".equals(VehicleType) )
	 {
	 vehicle = vehicle.semitrailer;
	 }
	 else if( "fast".equals(VehicleType) )
	 {
	 vehicle = vehicle.motorcycle;
	 }
	 else if( "private".equals(VehicleType) )
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
