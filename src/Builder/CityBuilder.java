package Builder;

import java.util.ArrayList;
import components.Factory;
import components.Junction;
import components.Map;
import components.Vehicle;
import gui.RoadSystemPanel;
import utilities.VehicleType;

public class CityBuilder {

	public int numJunction;
	public Map map;
	private VehicleType vehicleType;
	private ArrayList<Vehicle>vehicle;
	private RoadSystemPanel panel;
	private Junction junction;

	
	public static class Builder {
		
		private int numJunction;
        private Junction junction;
        private Map map;
        private VehicleType vehicleType;
		private ArrayList<Vehicle> vehicle;
		private RoadSystemPanel panel;
	
       
        
        public Builder(int numJunction) {
            this.numJunction=numJunction;
        }
        
        
        /*public Builder chooseVehicleType(VehicleType vehicleType) {
        	if(vehicleType==Factory.getFactory(2).getVehicle("slow") ||
        			vehicleType==Factory.getFactory(10).getVehicle("public"))
        		this.vehicleType=vehicleType;
        	return this;
        }*/


        public CityBuilder build(){
            //Here we create the actual bank account object, which is always in a fully initialised state when it's returned.
            CityBuilder country = new CityBuilder();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
            country.numJunction = this.numJunction;
            //country.map=this.map;
            //country.vehicleType=this.vehicleType;
            //country.vehicle=this.vehicle;
            
            return country;
        }
    }
    //Fields omitted for brevity.
		private CityBuilder() {
        //Constructor is now private.
		}
		
		public int getNumJunction() {
			return numJunction;
		}
		
		public ArrayList<Vehicle> getVehicles(){
			return this.vehicle;
		}

}
