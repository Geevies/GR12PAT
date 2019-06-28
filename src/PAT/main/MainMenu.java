package PAT.main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MainMenu extends JPanel {

	public MainMenu() {
		setPreferredSize(new Dimension(800, 600));

		GridBagLayout gbl = new GridBagLayout();
		
		//Credits to Adri Wessels for teaching me these two code blocks
		//There are three columns, 0 is left, 1 is centre, 2 is right
		gbl.columnWidths = new int[]{150, 300, 150};
		double width = 0;
		for(int i : gbl.columnWidths) width += i;
			gbl.columnWeights = new double[gbl.columnWidths.length];
		for(int i = 0; i < gbl.columnWeights.length; i++)
			gbl.columnWeights[i] = gbl.columnWidths[i] / width;
		
		//There are six rows
		gbl.rowHeights = new int[]{150, 100, 100, 100, 100, 100};
		double height = 0;
		for(int i : gbl.rowHeights) height += i;
			gbl.rowWeights = new double[gbl.rowHeights.length];
		for(int i = 0; i < gbl.rowWeights.length; i++)
			gbl. rowWeights[i] = gbl.rowHeights[i] / height;
		
		setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = c.BOTH;
		c.insets = new Insets(10, 10, 10, 10);

		//First row, three columns: Name of program
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		add(headerPanel, c);
		
		Font headerFont = new Font("SansSerif", Font.BOLD, 34);
		JLabel headerLabel = new JLabel("Human Resources: Deluxe");
		headerLabel.setPreferredSize(new Dimension (450, 100));
		headerLabel.setFont(headerFont);
		headerLabel.setHorizontalAlignment(JTextField.CENTER);
		headerPanel.add(headerLabel);
		
		//Second row, middle column: View the roster that you've made
		JPanel rosterPanel = new JPanel();
		rosterPanel.setLayout(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		add(rosterPanel, c);
		
		JButton rosterButton = new JButton("View Roster");
		rosterButton.setPreferredSize(new Dimension (230, 70));
		rosterButton.setHorizontalAlignment(JTextField.CENTER);
		rosterButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("aint shit yet");
			}
		});
		rosterPanel.add(rosterButton);
		
		//Third row, middle column: Make a roster
		JPanel rosterEditPanel = new JPanel();
		rosterEditPanel.setLayout(new GridBagLayout());
		c.gridy = 2;
		add(rosterEditPanel, c);
		
		JButton rosterEditButton = new JButton("Add/Edit Roster");
		rosterEditButton.setPreferredSize(new Dimension (230, 70));
		rosterEditButton.setHorizontalAlignment(JTextField.CENTER);
		rosterEditButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("aint shit yet");
			}
		});
		rosterEditPanel.add(rosterEditButton);
		
		//Fourth row, middle column: View the employees currently in 
		JPanel empOverviewPanel = new JPanel();
		empOverviewPanel.setLayout(new GridBagLayout());
		c.gridy = 3;
		add(empOverviewPanel, c);
		
		JButton empOverviewButton = new JButton("Employee Overview");
		empOverviewButton.setPreferredSize(new Dimension (230, 70));
		empOverviewButton.setHorizontalAlignment(JLabel.CENTER);
		empOverviewButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				MainInit.employeeOverview(MainMenu.this);
			}
		});
		empOverviewPanel.add(empOverviewButton);
		
		//Fifth row, middle column: Add or edit employees
		JPanel empAddPanel = new JPanel();
		empAddPanel.setLayout(new GridBagLayout());
		c.gridy = 4;
		add(empAddPanel, c);
		
		JButton empAddButton = new JButton("Add/Edit Employee");
		empAddButton.setPreferredSize(new Dimension (230, 70));
		empAddButton.setHorizontalAlignment(JTextField.CENTER);
		empAddButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("aint shit yet");
			}
		});
		empAddPanel.add(empAddButton);
		
		//Sixth row, middle column: Close the program
		JPanel exitPanel = new JPanel();
		exitPanel.setLayout(new GridBagLayout());
		c.gridy = 5;
		add(exitPanel, c);
		
		JButton exitButton = new JButton("Exit");
		exitButton.setPreferredSize(new Dimension (230, 70));
		exitButton.setHorizontalAlignment(JTextField.CENTER);
		exitButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		exitPanel.add(exitButton);
		
	}
	
}