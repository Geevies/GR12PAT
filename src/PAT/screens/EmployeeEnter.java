package PAT.screens;

import PAT.main.MainInit;
import SQLBackend.SQLEmployees;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeEnter extends JPanel {

	//TODO, PayRate
	public EmployeeEnter(Boolean newEmployee, String name, String ID, String gender, String DoB) {
		setPreferredSize(new Dimension(800, 600));
		//setBackground(Color.red);

		GridBagLayout gbl = new GridBagLayout();
		
		//Credits to Adri Wessels for teaching me these two code blocks
		gbl.columnWidths = new int[]{100, 150, 200, 250, 50};
		double width = 0;
		for(int i : gbl.columnWidths) width += i;
			gbl.columnWeights = new double[gbl.columnWidths.length];
		for(int i = 0; i < gbl.columnWeights.length; i++)
			gbl.columnWeights[i] = gbl.columnWidths[i] / width;
		
		gbl.rowHeights = new int[]{200, 100, 100, 100, 100, 100};
		double height = 0;
		for(int i : gbl.rowHeights) height += i;
			gbl.rowWeights = new double[gbl.rowHeights.length];
		for(int i = 0; i < gbl.rowWeights.length; i++)
			gbl. rowWeights[i] = gbl.rowHeights[i] / height;
		
		setLayout(gbl);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = c.BOTH;
		c.insets = new Insets(10, 10, 10, 10);

		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 5;
		//headerPanel.setBackground(Color.cyan);
		add(headerPanel, c);
		
		Font headerFont = new Font("SansSerif", Font.BOLD, 26);
		JLabel headerLabel = new JLabel("Employee Data Form");
		headerLabel.setPreferredSize(new Dimension (260, 60));
		headerLabel.setFont(headerFont);
		headerLabel.setHorizontalAlignment(JTextField.CENTER);
		headerPanel.add(headerLabel);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth = 1;
		//namePanel.setBackground(Color.cyan);
		add(namePanel, c);
		

		JTextField nameField = new JTextField("Name and Surname:");
		nameField.setPreferredSize(new Dimension (130, 30));
		nameField.setEditable(false);
		nameField.setHorizontalAlignment(JTextField.CENTER);
		namePanel.add(nameField);
		
		JPanel nEntryPanel = new JPanel();
		nEntryPanel.setLayout(new GridBagLayout());
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 1;
		//nEntryPanel.setBackground(Color.cyan);
		add(nEntryPanel, c);
		
		if (name == null) {
			name = "John Smith";
		}		
		JTextField nEntryField = new JTextField(name);
		nEntryField.setPreferredSize(new Dimension (180, 30));
		nEntryField.setHorizontalAlignment(JTextField.CENTER);
		nEntryField.addFocusListener(new FocusAdapter() {
		boolean removedExampleName = false;
		public void focusGained(FocusEvent e) {
			if (removedExampleName == false) {
			JTextField source = (JTextField)e.getComponent();
			source.setText("");
			source.removeFocusListener(this);
			removedExampleName = true;
			}
		}
		});
		nEntryPanel.add(nEntryField);
		
		JPanel nResultPanel = new JPanel();
		nResultPanel.setLayout(new GridBagLayout());
		c.gridx = 3;
		c.gridy = 1;
		//nResultPanel.setBackground(Color.cyan);
		add(nResultPanel, c);
		
		JLabel nResultLabel = new JLabel("");
		nResultLabel.setPreferredSize(new Dimension (230, 50));
		nResultLabel.setHorizontalAlignment(JLabel.CENTER);
		nResultPanel.add(nResultLabel);
		
		JPanel IDPanel = new JPanel();
		IDPanel.setLayout(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 2;
		//IDPanel.setBackground(Color.cyan);
		add(IDPanel, c);
		
		JTextField idNumber = new JTextField("ID Number:");
		idNumber.setPreferredSize(new Dimension (130, 30));
		idNumber.setEditable(false);
		idNumber.setHorizontalAlignment(JTextField.CENTER);
		IDPanel.add(idNumber);
		
		JPanel idEntryPanel = new JPanel();
		idEntryPanel.setLayout(new GridBagLayout());
		c.gridx = 2;
		c.gridy = 2;
		//idEntryPanel.setBackground(Color.cyan);
		add(idEntryPanel, c);
		
		//The following codeblock creates and displays a fully accurate example ID
		//(Checksum accuracy not included)
		//The example ID disappears once the field is highlighted to begin input
		//TODO: Put all this garbage in a method.
		
		if (ID == null) {
		Calendar exampleIDDate = Calendar.getInstance();
		exampleIDDate.add(Calendar.YEAR, -16);
		String exampleMonth = String.valueOf(exampleIDDate.get(Calendar.MONTH) + 1);
		if (exampleMonth.length() < 2) exampleMonth = "0" + exampleMonth;
		String exampleDay = String.valueOf(exampleIDDate.get(Calendar.DATE));
		if (exampleDay.length() < 2) exampleDay = "0" + exampleDay;
		String exampleGenderedNumber = String.valueOf((int)(Math.random()*1000));
		if (exampleGenderedNumber.length() == 1) exampleGenderedNumber = exampleGenderedNumber + (int)(Math.random()*10-1) + (int)(Math.random()*10-1) + (int)(Math.random()*10-1);
		if (exampleGenderedNumber.length() == 2) exampleGenderedNumber = exampleGenderedNumber + (int)(Math.random()*10-1) + (int)(Math.random()*10-1);
		if (exampleGenderedNumber.length() == 3) exampleGenderedNumber = exampleGenderedNumber + (int)(Math.random()*10-1);
		String exampleID = String.valueOf(exampleIDDate.get(Calendar.YEAR)).substring(2) 
				+ exampleMonth
				+ exampleDay
				+ exampleGenderedNumber
				+ String.valueOf((int)(Math.random()))
				+ String.valueOf((int)(Math.random()*10-1));
		
		ID = exampleID;
		}
		JTextField idEntryField = new JTextField(ID);
		idEntryField.setPreferredSize(new Dimension (180, 30));
		idEntryField.setHorizontalAlignment(JTextField.CENTER);
		idEntryField.addFocusListener(new FocusAdapter() {
		boolean removedExampleID = false;
		public void focusGained(FocusEvent e) {
			if (removedExampleID == false) {
			JTextField source = (JTextField)e.getComponent();
			source.setText("");
			source.removeFocusListener(this);
			removedExampleID = true;
			}
		}
		});
		idEntryPanel.add(idEntryField);

		JPanel idResultPanel = new JPanel();
		idResultPanel.setLayout(new GridBagLayout());
		c.gridx = 3;
		c.gridy = 2;
		//idResultPanel.setBackground(Color.cyan);
		add(idResultPanel, c);
		
		JLabel idResultLabel = new JLabel("");
		idResultLabel.setPreferredSize(new Dimension (230, 50));
		idResultLabel.setHorizontalAlignment(JLabel.CENTER);
		idResultPanel.add(idResultLabel);
		
		JPanel genderPanel = new JPanel();
		genderPanel.setLayout(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 3;
		//genderPanel.setBackground(Color.cyan);
		add(genderPanel, c);
		
		JTextField genderField = new JTextField("Gender:");
		genderField.setPreferredSize(new Dimension (130, 30));
		genderField.setEditable(false);
		genderField.setHorizontalAlignment(JTextField.CENTER);
		genderPanel.add(genderField);

		JPanel gEntryPanel = new JPanel();
		gEntryPanel.setLayout(new GridBagLayout());
		c.gridx = 2;
		c.gridy = 3;
		//gEntryPanel.setBackground(Color.cyan);
		add(gEntryPanel, c);
		
		JRadioButton rbM = new JRadioButton("Male");
		JRadioButton rbF = new JRadioButton("Female");
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rbM);
		bgroup.add(rbF);
		gEntryPanel.add(rbM);
		if (gender != null) {
			if (gender.equalsIgnoreCase("M")) rbM.setSelected(true);
			else rbF.setSelected(true);
		}
		else rbM.setSelected(true);
		gEntryPanel.add(rbF);
		
		JPanel gResultPanel = new JPanel();
		gResultPanel.setLayout(new GridBagLayout());
		c.gridx = 3;
		c.gridy = 3;
		//genderResultPanel.setBackground(Color.cyan);
		add(gResultPanel, c);
		
		JLabel gResultLabel = new JLabel("");
		gResultLabel.setPreferredSize(new Dimension (230, 50));
		gResultLabel.setHorizontalAlignment(JLabel.CENTER);
		gResultPanel.add(gResultLabel);

		JPanel dobPanel = new JPanel();
		dobPanel.setLayout(new GridBagLayout());
		c.gridx = 1;
		c.gridy = 4;
		//dobPanel.setBackground(Color.cyan);
		add(dobPanel, c);
		
		JTextField dobField = new JTextField("Date of Birth:");
		dobField.setPreferredSize(new Dimension (130, 30));
		dobField.setEditable(false);
		dobField.setHorizontalAlignment(JTextField.CENTER);
		dobPanel.add(dobField);
		
		JPanel dobEntryPanel = new JPanel();
		dobEntryPanel.setLayout(new GridBagLayout());
		c.gridx = 2;
		c.gridy = 4;
		//dobEntryPanel.setBackground(Color.cyan);
		add(dobEntryPanel, c);
		
		//An imported library is used here to create a Datepicker component
		JCalendar dobPicker = new JCalendar(new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis((long) (365.25 * 16))));
		dobPicker.setMaxSelectableDate(new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis((long) (365.25 * 16))));
		dobPicker.setMinSelectableDate(new Date(System.currentTimeMillis() - TimeUnit.DAYS.toMillis((long) (365.25 * 65))));
		if (DoB != null) {
			//Old and deprecated type, but JCalendar needs it.
			Date date = new Date();
			//Get correct times from DoB string
			Integer year = Integer.parseInt(DoB.substring(0, 4));
			Integer month = Integer.parseInt(DoB.substring(5, 7));
			Integer day = Integer.parseInt(DoB.substring(8, 10));
			//Initialize time correctly
			Calendar temp = Calendar.getInstance();
			temp.clear();
			//Component is weird. I don't know why I have to subtract a month,
			//but it works, though. That's what counts.
			temp.set(year, month - 1, day);
			//Put the correct time into the date
			date = temp.getTime();
			//Tell the picker to use this date
			dobPicker.setDate(date);
		}
		dobEntryPanel.add(dobPicker);
		
		JPanel dobResultPanel = new JPanel();
		dobResultPanel.setLayout(new GridBagLayout());
		c.gridx = 3;
		c.gridy = 4;
		add(dobResultPanel, c);
		
		JLabel dobResultLabel = new JLabel("");
		dobResultLabel.setPreferredSize(new Dimension (230, 50));
		dobResultLabel.setHorizontalAlignment(JLabel.CENTER);
		dobResultPanel.add(dobResultLabel);
		
		JPanel vPanel = new JPanel();
		vPanel.setLayout(new GridBagLayout());
		c.gridx = 2;
		c.gridy = 5;
		add(vPanel, c);
		
		JButton vButton = new JButton("Finalize");
		vButton.setPreferredSize(new Dimension (100, 30));
		vButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//Reset the error message after every press of the button
				nResultLabel.setText("");
				idResultLabel.setText("");
				gResultLabel.setText("");
				dobResultLabel.setText("");
				
				//Overarching check handles final message
				Boolean validData = true;
				
				//Validate all the name data
				Boolean nameOnlyLetters = nEntryField.getText().matches(("[a-zA-Z ]+"));
				if (nameOnlyLetters == false)
				{ 
					validData = false;
					nResultLabel.setText("<html>Your name may only use regular keyboard characters!<html>");
				}
				if (nEntryField.getText().isEmpty())
				{
					validData = false;
					nResultLabel.setText("<html>The name field cannot be empty!<html>");
				}
				
				//Cross-reference entered DoB data and Gender data with ID data
				if (idEntryField.getText().length() < 12)
				{
					validData = false;
					idResultLabel.setText("<html>The entered ID is too short!<html>");
				}
				if (idEntryField.getText().length() == 12) 
				{
					if (String.valueOf(dobPicker.getYearChooser().getYear()).substring(2, 4).equals(idEntryField.getText().substring(0, 2)) == false)
					{
						validData = false;
						idResultLabel.setText("<html>The year of birth does not match with the ID!<html>");
						dobResultLabel.setText("<html>The year of birth does not match with the ID!<html>");
					}
					String dobMonth = String.valueOf(dobPicker.getMonthChooser().getMonth() + 1);
					if (dobMonth.length() == 1) dobMonth = "0" + dobMonth;
					if (dobMonth.equals(idEntryField.getText().substring(2, 4)) == false)
					{
						validData = false;
						idResultLabel.setText("<html>The month of birth does not match with the ID!<html>");
						dobResultLabel.setText("<html>The month of birth does not match with the ID!<html>");
					}
					String dobDay = String.valueOf(dobPicker.getDate().getDate());
					if (dobDay.length() == 1) dobDay = "0" + dobDay;
					if (dobDay.equals(idEntryField.getText().substring(4, 6)) == false)
					{
						validData = false;
						idResultLabel.setText("<html>The day of birth does not match with the ID!<html>");
						dobResultLabel.setText("<html>The day of birth does not match with the ID!<html>");
					}
					
					Boolean isMale = false;
					Boolean isFemale = false;
					if (rbM.isSelected()) isMale = true;
					if (rbF.isSelected()) isFemale = true;
					if (isMale == true)
					{
						if (Integer.parseInt(idEntryField.getText().substring(6, 10)) < 5000)
						{
							validData = false;
							idResultLabel.setText("<html>The ID does not match with the gender input!<html>");
						}
					}
					if (isFemale == true)
					{
						if (Integer.parseInt(idEntryField.getText().substring(6, 10)) > 4999)
						{
							validData = false;
							idResultLabel.setText("<html>The ID does not match with the gender input!<html>");
						}
					}
				}
				if (idEntryField.getText().length() > 12)
				{
					validData = false;
					idResultLabel.setText("<html>The entered ID is too long!<html>");
				}
				if (idEntryField.getText().length() == 0) 
				{
					validData = false;
					idResultLabel.setText("<html>There must be an ID number entered!<html>");
				}

				//Only gets displayed if all the data entered is valid
				if (validData == true) {
					Integer choice = JOptionPane.showConfirmDialog(null, "Do you wish to commit this to your database?");
					System.out.println(choice); //TODO: Remove this line
					if (choice == 0 && newEmployee == true)
					{
						System.out.println("Adding Employee!");
						
						//Split full name into first name and surname
						String tempName = nEntryField.getText();
						String[] tempSplit = tempName.split(" ", 2);
						String fName = tempSplit[0];
						String sName = tempSplit[1];
						
						//Get gender
						String g = "M"; //Default gender is Male
						if (rbM.isSelected()) {
							g = "M";
						}
						if (rbF.isSelected()) {
							g = "F";
						}
						
						//Now we use this formatter to trim the date so that
						//it doesn't include hours, minutes and seconds anymore
						SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
						Date tempDate = dobPicker.getDate();
						try {
							tempDate = formatter.parse(formatter.format(dobPicker.getDate()));
						} catch (ParseException ex) {
							ex.printStackTrace();
						}
						
						//Get DoB from parser 
						//(Needs to be converted to SQL date)
						java.sql.Date sqlDate = new java.sql.Date(tempDate.getTime());
	
						//Make new employee
						SQLEmployees.newEmployee(idEntryField.getText(), fName, sName, sqlDate, 30, g);
						//Make sure to update list with new employee
						SQLEmployees.initEmployees();
						
						//Put us back in the employee overview screen
						MainInit.employeeOverview(EmployeeEnter.this);
					}
				}
					
			}
		});
		vPanel.add(vButton);
		
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new GridBagLayout());
		c.gridx = 3;
		c.gridy = 5;
		add(backPanel, c);
		
		JButton backButton = new JButton("Back");
		backButton.setPreferredSize(new Dimension (230, 70));
		backButton.setHorizontalAlignment(JLabel.CENTER);
		backButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				MainInit.employeeOverview(EmployeeEnter.this);
			}
		});
		backPanel.add(backButton);
	}
	
}