package gui;

import java.util.ArrayList;

import components.Vehicle;

public class BigBrother {

	private volatile static BigBrother single=null;
	private String name ="";
	private Moked mok;
	public static void main(final String[] args) {  
		
    }  
	public void TestBigBrother(Vehicle vehicle){
		if(vehicle.getSpeed()>vehicle.getLastRoad().getMaxSpeed()) {
			mok=Moked.getInstance();
			mok.SendReport(vehicle);
		}
	  }
	   
	  public static BigBrother getInstance(){
	    if(single == null){
	      synchronized(BigBrother.class){
	        if(single == null)
	          single = new BigBrother();
	      }
	    }      
	    return single;
	  }
	  
	  public String getName(){
	    return this.name;
	  }
}
