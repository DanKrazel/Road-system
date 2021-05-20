package Prototype;

import java.util.Hashtable;

import components.Vehicle;

public class ShapeCache {
	
   private static Hashtable<String, Vehicle> shapeMap  = new Hashtable<String, Vehicle>();

   public static Vehicle getShape(int shapeId) {
      Vehicle cachedShape = shapeMap.get(Integer.toString(shapeId));
      return (Vehicle) cachedShape.clone();
   }

   public static void loadCache(Vehicle vehi) {
     Vehicle vehicle = new Vehicle();
     vehicle.setId(vehi.getID());
     shapeMap.put(Integer.toString(vehi.getID()),vehi);
   }
}