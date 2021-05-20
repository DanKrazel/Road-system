package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import Prototype.ShapeCache;
import components.Map;
import utilities.Timer;
import components.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CyclicBarrier;

public class RoadSystemPanel extends JPanel implements ActionListener {
   private static final long serialVersionUID = 1L;
   private Main frame;
   private JPanel p1;
   private JButton[] b_num;
   private String[] names = {"Create road system","Start","Stop","Resume","Info"};
   private JScrollPane scrollPane;
   private boolean isTableVisible;
   private Driving driving = null;
   private int colorInd = 0;
   private boolean started = false;
	
   
   public RoadSystemPanel(Main f) {
	    frame = f;
	    isTableVisible = false;
	    setBackground(new Color(255,255,255));
	    p1=new JPanel();
		p1.setLayout(new GridLayout(1,7,0,0));
		p1.setBackground(new Color(0,150,255));
		b_num=new JButton[names.length];
		for(int i=0;i<names.length;i++) {
		    b_num[i]=new JButton(names[i]);
		    b_num[i].addActionListener(this);
		    b_num[i].setBackground(Color.lightGray);
		    p1.add(b_num[i]);		
		}

		setLayout(new BorderLayout());
		add("South", p1);
   }	
   
   
   public void createNewRoadSystem(int junc, int cars) {
	    if (driving !=null)
	    	driving.setStop();
		driving = new Driving(junc,cars);
		driving.setPanel(this); 
		started = false;
		//BigBrother b = new BigBrother(null);
		repaint();
   }
   
   
  public void createBuildSystem(int junc, int cars,String name) {
	    if (driving !=null)
	    	driving.setStop();
		driving = new Driving(junc,cars,name);
		driving.setPanel(this); 
		started = false;
		//BigBrother b = new BigBrother(null);
		repaint();
  }
  
  public void CloneCar (){

	  	int choice=0;
	  	JSlider JunctionsSlider;
	  	JPanel Simulator;
	  	Simulator=new JPanel();
		JTextField Index=new JTextField();
		JunctionsSlider = new JSlider(0, 50, 0);
		JunctionsSlider.setMajorTickSpacing(10);
		JunctionsSlider.setMinorTickSpacing(1);
		JunctionsSlider.setPaintTicks(true);
		JunctionsSlider.setPaintLabels(true);
		String []ComboBoxOptions= {"Default","City","Highway"};
		JOptionPane dialogBox =new JOptionPane();
		JDialog dialog = dialogBox.createDialog(Simulator, "Create Road System");
		dialog.setSize(600, 300);
		JLabel txt2 = new JLabel("Id of the Vehicle tou chose to clon :  "+driving.getVehicles().size());
		JLabel txt3=new JLabel("Choose Mode");
		JComboBox CityOrRoad=new JComboBox(ComboBoxOptions);
		dialogBox.setMessage(new Object	[]{txt2,Index});
		dialogBox.setOptionType(JOptionPane.OK_CANCEL_OPTION);
		dialog.setVisible(true);
        if (( dialogBox!=null)&&((Integer) dialogBox.getValue()).intValue() == JOptionPane.YES_OPTION) {
			  choice = Integer.parseInt(Index.getText());
			  ShapeCache.loadCache(driving.getVehicles().get(choice-1));
			  Vehicle Clone = (Vehicle) ShapeCache.getShape(choice);
			  System.out.println(("Vehicle Clon : " + Clone.getID()));
			  Clone.toString();
			  driving.getVehicles().add(Clone);
			  driving.getAllTimedElements().addAll(driving.getVehicles());
			  started=false;
			  start();
		  }
 }
  
   public Driving GetDriving() {
	   return driving;
   }

   public void paintComponent(Graphics g) {
	   	super.paintComponent(g);	
	   	
	   	if (driving==null) return;
	   	int delta = 10;
   
	   	Map map = driving.getMap();
	   		
	   	for(Road road: map.getRoads()) 
	   		road.drawRoads(g,delta);
	   	
	   	for(Road road: map.getRoads()) 
	   		road.drawRoadGreenLight(g,delta);
	   	
	   	for(Junction junc: map.getJunctions())
	   		junc.drawJunction(g,delta);
	   	
	   	for(Vehicle veh: driving.getVehicles()) 
	   		veh.drawVehicle(g, delta, colorInd);
   	
   }
   
   
   
   public void setColorIndex(int ind) {
	   this.colorInd = ind;
	   repaint();
   }
   
   
   public void setBackgr(int num) {
	   switch(num) {
	   case 0:
		   setBackground(new Color(255,255,255));
		   break;
	   case 1:
		   setBackground(new Color(0,150,255));
		   break;

	   }
	   repaint();
   }
   
   
   
   public void add(){
	   CreateRoadSystemlDialog dial = new CreateRoadSystemlDialog(frame,this,"Create road system");
	   dial.setVisible(true);
   }
   

   public void start() {
	   if (driving == null || started) return;
	   started = true;
	   Thread t = new Thread(driving);
	   t.start();
   }
   
	public void resume() {
		if (driving == null) return;
		driving.setResume();
   }

 	public void stop() {
 		if (driving == null) return;
	   driving.setSuspend();
   }

   
   public void info() { 
	   if (driving == null) return;
	   if(isTableVisible == false) {
		 int i=0;
		  String[] columnNames = {"Vehicle #", "Type", "Location","Time on loc","Speed"};
		  ArrayList<Vehicle> vehicles = driving.getVehicles();
	      String [][] data = new String[vehicles.size()][columnNames.length];
	      for(Vehicle v : vehicles) {
	    	  data[i][0] = ""+v.getID();
	    	  data[i][1] = ""+v.getVehicleType();
	    	  RouteParts rp = v.getCurrentRoutePart();
	    	  if (rp instanceof Road) {
	    		  Road r = (Road) rp;
	    		  data[i][2] = "Road "+r.getStartJunction().getJunctionName()+"-"+r.getEndJunction().getJunctionName();
	    		  data[i][4] = ""+Math.min(r.getMaxSpeed(), v.getVehicleType().getAverageSpeed());
	    	  }
	    	  else {
	    		  Junction j = (Junction) rp;
	    		  data[i][2] = "Junction "+j.getJunctionName();
	    		  data[i][4] = "0";
	    	  }
	    	  
	    	  data[i][3] = ""+v.getTimeOnCurrentPart();
	    	  i++;
	      }
	      
	      JTable table = new JTable(data, columnNames);
	      scrollPane = new JScrollPane(table);
	      scrollPane.setSize(450,table.getRowHeight()*(vehicles.size())+24);
	      add( scrollPane, BorderLayout.CENTER );
	      isTableVisible = true;
	   }
	   else
		   isTableVisible = false;
	   
	   scrollPane.setVisible(isTableVisible);
       repaint();
   }

   
   public void destroy(){  	        
      System.exit(0);
   }
   
   
   public void actionPerformed(ActionEvent e) {
	if(e.getSource() == b_num[0]) 
		add();
	else if(e.getSource() == b_num[1]) 
		start();
	else if(e.getSource() == b_num[2])  
		stop();
	else if(e.getSource() == b_num[3])  
		resume(); 
	else if(e.getSource() == b_num[4])  
		info();
   }

}