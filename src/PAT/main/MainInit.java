package PAT.main;

import javax.swing.JFrame;

public class MainInit {

	public static void main(String[] args) {
		JFrame base = new JFrame();
		base = new JFrame();
		base.setSize(800, 600);
		base.setTitle("Human Resources Tool");
		base.setVisible(true);
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base.setLocationRelativeTo(null);  
		base.setResizable(true);
		MainMenu enter = new MainMenu();
		base.add(enter, 0);
		base.pack();
	}
	
}