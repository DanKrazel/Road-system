package Builder;

import java.util.ArrayList;
import components.Factory;
import components.Junction;
import components.Map;
import components.Vehicle;
import gui.RoadSystemPanel;
import utilities.VehicleType;

public class CountryBuilder {

	public int numJunction;
	public Map map;
	private VehicleType vehicleType;
	private ArrayList<Vehicle>vehicle;
	private RoadSystemPanel panel;
	
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
        
        public Builder createMap(Map map) {
        	this.map=map;
        	return this;
        }
       
        
        /*public Builder chooseVehicleType(VehicleType vehicleType) {
        	if(vehicleType==Factory.getFactory(2).getVehicle("slow") ||
        			vehicleType==Factory.getFactory(10).getVehicle("public"))
        		this.vehicleType=vehicleType;
        	return this;
        }*/
        	
        public Builder createVehicle(ArrayList<Vehicle> vehicle) {
        	for(int i=0;i<this.vehicle.size();i++) {
        		if(vehicle.get(i).getVehicleType()==Factory.getFactory(2).getVehicle("slow") || 
        			vehicle.get(i).getVehicleType()==Factory.getFactory(10).getVehicle("public"))
        			this.vehicle=null;
        	}
        		this.vehicle=vehicle;
        	return this;
        }


        public CountryBuilder build(){
            //Here we create the actual bank account object, which is always in a fully initialised state when it's returned.
            CountryBuilder country = new CountryBuilder();  //Since the builder is in the BankAccount class, we can invoke its private constructor.
            country.numJunction = this.numJunction;
            //country.map=this.map;
            //country.vehicleType=this.vehicleType;
            //country.vehicle=this.vehicle;
            
            return country;
        }
    }

		private CountryBuilder() {
		}
		
		public int getNumJunction() {
			return numJunction;
		}
		
		public ArrayList<Vehicle> getVehicles(){
			return this.vehicle;
		}

}
