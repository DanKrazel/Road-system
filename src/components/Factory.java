package components;

import utilities.VehicleType;

public abstract class Factory {
public abstract VehicleType getVehicle(String VehicleType);
	public static Factory getFactory(int x) {
		Factory factory = null;
		
		if (x==2) {
			factory = new TwoWheel();
		}
		
		else if (x==4) {
			factory = new FourWheel();
		}
		
		else if (x==6) {
			factory=new TwoWheel();
		}
		
		else  if (x==10) {	
			factory = new TenWheel();
		}
		return factory;
}	

}
