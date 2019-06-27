package PAT.main;

import javax.swing.JFrame;

public class MainInit {
	
	static JFrame base = new JFrame();

	public static void main(String[] args) {
		base.setSize(800, 600);
		base.setTitle("Human Resources: Deluxe");
		base.setVisible(true);
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base.setLocationRelativeTo(null);  
		base.setResizable(true);
		MainMenu menu = new MainMenu();
		base.add(menu, 0);
		base.pack();
	}
	
	public static void mainMenu() {
		MainMenu menu = new MainMenu();
		base.add(menu, 0);
		base.pack();
	}
	
}