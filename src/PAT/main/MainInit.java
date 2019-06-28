package PAT.main;

import PAT.screens.EmployeeEnter;
import PAT.screens.EmployeeOverview;
import SQLBackend.SQLEmployees;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainInit {
	
	//Static here because I need a constant base throughout the program
	static JFrame base = new JFrame();

	//Simply initializes the JFrame
	public static void main(String[] args) {
		SQLEmployees.initEmployees();
		base.setSize(800, 600);
		base.setTitle("Human Resources: Deluxe");
		base.setVisible(true);
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base.setLocationRelativeTo(null);  
		base.setResizable(true);
		//Adds the main menu panel to the base JFrame
		mainMenu(null);
	}
	
	//I use the following methods to manipulate what appears on screen
	//"source" is the JPanel that needs to close before the next takes its place
	//I use these because I need to hide those panels if I want to open another
	public static void mainMenu(JPanel source) {
		//If there is no panel to hide, we just use null
		if (source != null)
			source.setVisible(false);
		MainMenu menu = new MainMenu();
		base.add(menu, 0);
		base.pack();
	}
	
	public static void employeeOverview(JPanel source) {
		System.out.println("Employee Overview Opening!");
		source.setVisible(false);
		EmployeeOverview empOv = new EmployeeOverview();
		MainInit.base.add(empOv, 0);
		MainInit.base.pack();
	}
	
	public static void employeeEnter(JPanel source, Boolean newEmployee, String name, String ID, String gender, String DoB) {
		System.out.println("Add/Edit Employee Opening!");
		source.setVisible(false);
		EmployeeEnter addEmp = new EmployeeEnter(newEmployee, name, ID, gender, DoB);
		MainInit.base.add(addEmp, 0);
		MainInit.base.pack();
	}
	
}