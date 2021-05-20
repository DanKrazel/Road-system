package gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import components.Vehicle;

public class Moked {
	
	private volatile static Moked single=null;
	
	public void SendReport(Vehicle vehicle) {
		try {
		      File myObj = new File("reports.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		try
		{
		 String filename = "reports.txt";
		 String text = "ID of Vehicle: " +Integer.toString(vehicle.getID())+" Speed of Vehicle :" +Integer.toString(vehicle.getSpeed())+" Max Speed of the road: "
		 +Integer.toString(vehicle.getLastRoad().getMaxSpeed())+" Time infraction : "+Integer.toString(vehicle.getTimeOnCurrentPart());
		 FileWriter fw = new FileWriter(filename,true);
		 BufferedWriter bufWriter = new BufferedWriter(fw);
		 //fw.write(vehicle.getSpeed());
		 bufWriter.newLine();
		 bufWriter.write(text);
         bufWriter.close();
		}
		catch(IOException ioe)
		{
		 //System.err.println(IOException: + ioe.getMessage());
		}
	}
	
	  public static Moked getInstance(){
		    if(single == null){
		      synchronized(Moked.class){
		        if(single == null) {
		        	System.out.println("MOKED");
		          single = new Moked();
		        }
		      }
		    }      
		    return single;
		  }
		  
}
