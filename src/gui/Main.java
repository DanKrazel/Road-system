package gui;

import javax.swing.*;

import Builder.CityBuilder;
import Builder.CountryBuilder;
import components.Factory;
import components.Map;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class Main extends JFrame implements ActionListener {
   private static final long serialVersionUID = 1L;
   private RoadSystemPanel panel;
   private String[] names = {"Exit","Blue","None","Blue","Magenta","Orange", "Random","Help","City","Country","Clone a car","Reports"};
   private JMenu m1, m2, m3, m4,m5,m6,m7;
   private JMenuItem[] mi;
   private JMenuBar mb;

   
   public static void main(String[]args) {
	   Main fr = new Main();
	   fr.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	   fr.setSize(845,715);
	   fr.setVisible(true);
   }

   
   public Main() {
	    super("Road system");
	    panel = new RoadSystemPanel(this);
	    add(panel);
	    panel.setVisible(true);
		mb = new JMenuBar();
		m1 = new JMenu("File");
		m2 = new JMenu("Background");
		m3 = new JMenu("Vehicles color");
		m4 = new JMenu("Help");
		m5 = new JMenu("Build a map");
		m6 = new JMenu("Clone a car");
		m7 = new JMenu("Reports");
		mi = new JMenuItem[names.length];

		for(int i=0;i<names.length;i++) {
		    mi[i]=new JMenuItem(names[i]);
		    mi[i].addActionListener(this);
		}

		m1.add(mi[0]);

		m2.add(mi[1]);
		m2.addSeparator();
		m2.add(mi[2]);


		m3.add(mi[3]);
		m3.addSeparator();
		m3.add(mi[4]);
		m3.addSeparator();
		m3.add(mi[5]);
		m3.addSeparator();
		m3.add(mi[6]);
		
		m4.add(mi[7]);
		
		m5.add(mi[8]);
		m5.addSeparator();
		m5.add(mi[9]);
		
		m6.add(mi[10]);
		
		m7.add(mi[11]);
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		mb.add(m6);
		mb.add(m7);
		setJMenuBar(mb);
		//System.out.println(Factory.getFactory("2"));
		System.out.println(Factory.getFactory(2).getVehicle("fast"));
		System.out.println(Factory.getFactory(4).getVehicle("private"));
   }
   

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mi[0])
			destroy();
		else if(e.getSource() == mi[1])
			panel.setBackgr(1);
		else if(e.getSource() == mi[2])
			panel.setBackgr(0);
		else if(e.getSource() == mi[3])
			panel.setColorIndex(0);
		else if(e.getSource() == mi[4])
			panel.setColorIndex(1);
		else if(e.getSource() == mi[5])
			panel.setColorIndex(2);
		else if(e.getSource() == mi[6])
			panel.setColorIndex(3);
		else if(e.getSource() == mi[7])
			printHelp();
		else if(e.getSource() == mi[8])
			printCity();
		else if(e.getSource() == mi[9])
			printCountry();
		else if(e.getSource() == mi[10])
			panel.CloneCar();
		else if(e.getSource() == mi[11])
			printReports();
	}
	
	
	public void destroy() {
		File myObj = new File("reports.txt");
		myObj.delete();
		System.exit(0);
	}
	
	public void printHelp() {
		JOptionPane.showMessageDialog(this, "Home Work 3\nGUI @ Threads");
	}
	public void printReports() {
	    JFrame frame = new JFrame();
	    JButton closeButton = new JButton("CLOSE");
	    frame.setTitle("Report of Vehicle");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    closeButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e)
	        {
	        	//panel.GetDriving().setStop();
	        	frame.dispose();
	        }
	    });
	    JTextArea tarea = new JTextArea(100,100);
	        try {
	        	File myObj = new File("reports.txt");
	          BufferedReader input = new BufferedReader(new InputStreamReader(
	              new FileInputStream(myObj)));
	          tarea.read(input, "READING FILE :-)");
	        } catch (Exception e) {
	          e.printStackTrace();
	        }
	    frame.getContentPane().add(tarea, BorderLayout.CENTER);
	    frame.getContentPane().add(closeButton, BorderLayout.PAGE_END);
	    frame.pack();
	    frame.setVisible(true);
	}
	
	public void printCountry() {
		//Map map=new Map(6);
		//int numVeh;
		CountryBuilder country = new CountryBuilder.Builder(6).build();
		panel.createBuildSystem(country.getNumJunction(),10,"Country");
	}
	
	public void printCity() {
		CityBuilder city=new CityBuilder.Builder(12).build();
		panel.createBuildSystem(city.getNumJunction(),10,"City");
	}
}
