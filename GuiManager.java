package MedicalDatabase;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.management.modelmbean.ModelMBean;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;;

public class GuiManager extends JFrame implements  ActionListener, WindowListener{

	//JPanels--------------------------------------------------
	private JPanel mainMenu;
	private JPanel DIsplayAllInfo;
	private JPanel DataInputs;
	private JPanel controller;
	private JPanel searchPanel;
	private JPanel youngestPatientPanel;
	
	//JButtons---------------------------------------------------
	private JButton addNew;
	private JButton displayAll;
	private JButton displayOne;
	private JButton averageAge;
	private JButton youngestPatient;
	private JButton deleteInfo;
	private JButton notification;
	private JButton Back;
	private JButton Back2;
	private JButton Back3;
	private JButton Back4;

	private JButton AddEnter;
	private JButton OneEnter;
	
	//JTable----------------------------------------------------------------------------------------------------------
	private JTable Datashowed;
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane scroll;
	
	//JTextPanel----------------------------------------------------------
	private JTextField inputID;
	private JTextArea OneData;
	private JTextField name;
	private JTextField ID;
	private JTextField Address;
	private JTextField Height;
	private JTextField Weight;
	private JTextField DOB;
	private JTextField LastVisit;
	private JTextField InitialVisit;

	//JLabel-----------------------------------------------------------------------------------
	JTextArea ypatient;
	//Other Initialized--------------------------------------------------------------------------
	private LList InitialPatients;
	private String delorsearch;
	private int ipeople;
	private CardLayout clayout= new CardLayout();
	
	public GuiManager(String title, LList InitialPatients, int people)
	{
		super(title);
		this.InitialPatients = InitialPatients;
		ipeople = people;
		this.addWindowListener(this);
		CreateContent();
	}
	
	public void CreateContent()
	{
		
		//Instantiate All JPanels-----------------------------------------------------------------------------
		mainMenu = new JPanel();
		DIsplayAllInfo = new JPanel();
		DataInputs = new JPanel();
		searchPanel = new JPanel();
		youngestPatientPanel = new JPanel();
		//-----------------------------------------------------------------------------------------------------
		
		mainMenu.setBackground(Color.orange);
		
		
		
		//Instantiate all Buttons------------------------------------------------------------------------------
		addNew = new JButton("Add Patient");
		addNew.addActionListener(this);
		//addNew.setSize(100, 50);
		
		displayAll = new JButton("Show All Patients");
		displayAll.addActionListener(this);
		displayAll.setSize(100, 100);
		
		
		displayOne = new JButton("Find Patient");
		displayOne.addActionListener(this);
		displayOne.setSize(100, 100);
		
		averageAge = new JButton("Average Age");
		averageAge.addActionListener(this);
		averageAge.setSize(100, 100);
		
		youngestPatient = new JButton("Yongest Patient");
		youngestPatient.addActionListener(this);
		youngestPatient.setSize(100, 100);
		
		deleteInfo = new JButton("Delete Info");
		deleteInfo.addActionListener(this);
		deleteInfo.setSize(100, 100);
		
		notification = new JButton("Notification List");
		notification.addActionListener(this);
		notification.setSize(100,100);
		
		Back = new JButton("Back");
		Back.addActionListener(this);
		
		Back2 = new JButton("Back");
		Back2.addActionListener(this);
		
		Back4 = new JButton("Back");
		Back4.addActionListener(this);
		
		AddEnter = new JButton("Enter");
		AddEnter.addActionListener(this);
		
		//User Inputs Components------------------------------------------------------------------------------------------------
	
		name = new JTextField();
		name.setFont(new Font("Ariel", Font.PLAIN, 18));
		ID = new JTextField(7);	
		ID.setFont(new Font("Ariel", Font.PLAIN, 18));
		Address = new JTextField();	
		Address.setFont(new Font("Ariel", Font.PLAIN, 18));
		Height = new JTextField();	
		Height.setFont(new Font("Ariel", Font.PLAIN, 18));
		Weight = new JTextField();
		Weight.setFont(new Font("Ariel", Font.PLAIN, 18));
		DOB = new JTextField();	
		DOB.setFont(new Font("Ariel", Font.PLAIN, 18));
		InitialVisit = new JTextField();	
		InitialVisit.setFont(new Font("Ariel", Font.PLAIN, 18));
		LastVisit = new JTextField();	
		LastVisit.setFont(new Font("Ariel", Font.PLAIN, 18));
		//Main Menu Component-------------------------------------------------------------------------------
		
		JPanel ButtonPanel = new JPanel();
		JLabel greetings = new JLabel("Patient Information");
		greetings.setFont(new Font("Ariel", Font.PLAIN,20 ));
		ButtonPanel.setBackground(Color.orange);
		ButtonPanel.setLayout(new BoxLayout(ButtonPanel, BoxLayout.Y_AXIS));
		
		ButtonPanel.add(greetings);
		ButtonPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		ButtonPanel.add(addNew);
		ButtonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ButtonPanel.add(deleteInfo);
		ButtonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ButtonPanel.add(displayAll);
		ButtonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ButtonPanel.add(displayOne);
		ButtonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ButtonPanel.add(youngestPatient);
		ButtonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ButtonPanel.add(averageAge);
		ButtonPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		ButtonPanel.add(notification);
		
		mainMenu.setLayout(new BorderLayout());
		mainMenu.add(ButtonPanel, BorderLayout.WEST);
		
		//Display Info Components-----------------------------------------------------------------------------
		
		
		Datashowed = new JTable(model);
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("ID");
		model.addColumn("Height");
		model.addColumn("Weight");
		model.addColumn("Date Of Birth");
		model.addColumn("Intial Visit");
		model.addColumn("Latest Visit");
	
		Datashowed.setPreferredScrollableViewportSize(new Dimension(600, 300));
		Datashowed.setFillsViewportHeight(true);
		Datashowed.setEnabled(false);
		scroll = new JScrollPane(Datashowed);
		scroll.setVisible(true);
	
		
		//DataInputs Components-------------------------------------------------------------------------------------------
		
		DataInputs.setLayout(new GridLayout(10,2));
		DataInputs.setBackground(Color.GREEN);
		
		JLabel sName = new JLabel("Name");
		sName.setFont(new Font("Ariel", Font.PLAIN, 18));
		JLabel sID = new JLabel("ID:");
		sID.setFont(new Font("Ariel", Font.PLAIN, 18));
		JLabel sAddress = new JLabel("Address");
		sAddress.setFont(new Font("Ariel", Font.PLAIN, 18));
		JLabel sHeight= new JLabel("Height");
		sHeight.setFont(new Font("Ariel", Font.PLAIN, 18));
		JLabel sWeight = new JLabel("Weight");
		sWeight.setFont(new Font("Ariel", Font.PLAIN, 18));
		JLabel sDOB = new JLabel("DOB (mm/dd/yyyy)");
		sDOB.setFont(new Font("Ariel", Font.PLAIN, 18));
		JLabel sIvisit = new JLabel("First Visit (mm/dd/yyyy)");
		sIvisit.setFont(new Font("Ariel", Font.PLAIN, 18));
		JLabel sLvisit = new JLabel("Last Visit (mm/dd/yyyy)");
		sLvisit.setFont(new Font("Ariel", Font.PLAIN, 18));
	
		DataInputs.add(sName);
		DataInputs.add(name);
		
		DataInputs.add(sID);
		DataInputs.add(ID);
		
		DataInputs.add(sAddress);
		DataInputs.add(Address);
		
		DataInputs.add(sHeight);
		DataInputs.add(Height);
		
		DataInputs.add(sWeight);
		DataInputs.add(Weight);
		
		DataInputs.add(sDOB);
		DataInputs.add(DOB);
		
		DataInputs.add(sIvisit);
		DataInputs.add(InitialVisit);
		
		DataInputs.add(sLvisit);
		DataInputs.add(LastVisit);
		
		DataInputs.add(Back);
		DataInputs.add(AddEnter);
		
		
		
		
		//DIsplayAllInfo------------------------------------------------------------------------------------------
		DIsplayAllInfo.setLayout(new BorderLayout());
		DIsplayAllInfo.setBackground(Color.orange);
		DIsplayAllInfo.add(scroll, BorderLayout.CENTER);
		DIsplayAllInfo.add(Back2, BorderLayout.PAGE_END);
		
		
		
		
		
		//Search Pane--------------------------------------------------------------------------------------------------
		//this panel will seach for one patient and either delete patient or DIsplayAllInfo
		OneData = new JTextArea();
		OneData.setEditable(false);
		OneData.setFont(new Font("Ariel", Font.PLAIN, 20));
		//OneData.setBounds(0, 100, 450, 450);;
		
		inputID = new JTextField();
		inputID.setFont(new Font("Ariel",Font.PLAIN,18));
		inputID.setPreferredSize(new Dimension(250, 50));;
		
		Back3 = new JButton("Back");
		Back3.addActionListener(this);
		
		OneEnter = new JButton();
		OneEnter.addActionListener(this);
		
		JLabel idlabel = new JLabel("ID # ");
		idlabel.setFont(new Font("Ariel",Font.PLAIN,18));
		JPanel InputPane= new JPanel();
		InputPane.setBackground(Color.gray);
		InputPane.add(idlabel);
		InputPane.add(inputID);
		
		JPanel OutputPane= new JPanel();
		OutputPane.setBackground(Color.gray);
		OutputPane.add(OneEnter);
		OutputPane.add(Back3);
		
		searchPanel.setLayout(new BorderLayout());
		searchPanel.setBackground(Color.RED);
		searchPanel.add(InputPane,BorderLayout.NORTH);
		//searchPanel.add(OneEnter);
		searchPanel.add(OneData);
		searchPanel.add(OutputPane,BorderLayout.SOUTH);

		//searchPanel.add(Back3);
		
		
		
		//Panel to Display Youngest Patients--------------------------------------------------------------------
		
		ypatient = new JTextArea();
		ypatient.setFont(new Font("Ariel", Font.PLAIN,20));
		youngestPatientPanel.setLayout(new BorderLayout());
		youngestPatientPanel.add(ypatient, BorderLayout.CENTER);
		youngestPatientPanel.add(Back4, BorderLayout.SOUTH);

		//Controls Scenes--------------------------------------------------------------------------------------
		controller = new JPanel();
		controller.setLayout(clayout);
		
		controller.add(mainMenu,"Menu");
		controller.add(DIsplayAllInfo,"Information");
		controller.add(DataInputs, "UsrInfo");
		controller.add(searchPanel, "Search");
		controller.add(youngestPatientPanel, "Youngest Patient");
		
		
		this.setContentPane(controller);
		clayout.show(controller, "mainMenu");

		//-------------------------------------------------------------------------------------------------------
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton click = (JButton)e.getSource();
		
		//go to add new menu
		if(click.equals(addNew))
		{
			System.out.println("click");
			clayout.show(controller, "UsrInfo");
		}
		//Go to find menu
		if(click.equals(displayOne))
		{
			System.out.println("click");
			delorsearch = "Search";
			OneEnter.setText("Search");
			clayout.show(controller, "Search");
		}
		
		//Go to delete menu
		if(click.equals(deleteInfo))
		{
			System.out.println("click");
			delorsearch = "Delete";
			OneEnter.setText("Delete");
			clayout.show(controller, "Search");
		}
		
		//go to display all menu
		if(click.equals(displayAll))
		{
//			LList fillrows = InitialPatients;
			model.setRowCount(0);
			
			/*while(fillrows.curr != null)
			{	System.out.println(fillrows.curr.getData().ToStringL());
				fillrows.curr = fillrows.curr.next;
				
			}*/
			InitialPatients.curr = InitialPatients.head;
			
			while(InitialPatients.curr != null)
			{	
					System.out.println("Got It");
					model.addRow(InitialPatients.curr.getData().ToStringA());
					
					InitialPatients.curr = InitialPatients.curr.next;
				
			}
			clayout.show(controller, "Information");
		
		}
		
		//Gives info on the youngest patient
		if(click.equals(youngestPatient))
		{
			InitialPatients.curr = InitialPatients.head;
			int age= 200;
			LNode youngest = InitialPatients.head;
			
			while(InitialPatients.curr != null)
			{
				if(age>InitialPatients.curr.getData().GetAge())
				{
					age=InitialPatients.curr.getData().GetAge();
					youngest= InitialPatients.curr;
				}
				InitialPatients.curr = InitialPatients.curr.next;
			}
			
			ypatient.setText(youngest.getData().ToStringS());
			clayout.show(controller, "Youngest Patient");
			
			
		}
		//Will return the average age of all patients
		if(click.equals(averageAge))
		{
			
			int ages = 0;
			int count=1;
			int total;
			InitialPatients.curr = InitialPatients.head;
			
			while( InitialPatients.curr != null)
			{
				ages += InitialPatients.curr.getData().GetAge();
				System.out.println("ages " +InitialPatients.curr.getData().GetAge());
				System.out.println("Count " +count);

				count++;
				InitialPatients.curr= InitialPatients.curr.next;
			}
			
			JOptionPane.showMessageDialog(mainMenu, "The average age of the patients is: " + (ages/count));
			
		}
		
		//go to notification list
		
		if(click.equals(notification))
		{
			LList checker = InitialPatients;
			model.setRowCount(0);

			checker.curr = checker.head;
			while(checker.curr != null)
			{
				if(checker.curr.getData().GetTimeSinceLastVist() > 3)
				{
					model.addRow(checker.curr.getData().ToStringA());
				}
				checker.curr = checker.curr.next;

			}
			
			clayout.show(controller, "Information");
			
		}
		
		//Back Buttons to return to main menu and clear fields---------------------------------------------
		if(click.equals(Back) )
		{
			System.out.println("Back click");
			clayout.show(controller, "Menu");
			name.setText("");
			ID.setText("");
			Address.setText("");
			Height.setText("");
			Weight.setText("");
			DOB.setText("");
			InitialVisit.setText("");
			LastVisit.setText("");

		}
		if(click.equals(Back2) || click.equals(Back4) )
		{
			System.out.println("Back2 click");
			
			clayout.show(controller, "Menu");
		}
		if(click.equals(Back3))
		{
			inputID.setText("");
			OneData.setText("");
			System.out.println("Back3 click");
			clayout.show(controller, "Menu");
		}
		
		//-----------------------------------------------------------------------------------------------------
		
		//Confirmation for adding new patients
		if(click.equals(AddEnter))
		{
			String name = this.name.getText();
			String ID = this.ID.getText();
			String address = this.Address.getText();
			int height = Integer.parseInt(this.Height.getText());
			float weight = Float.parseFloat(this.Weight.getText());
			String DOB = this.DOB.getText();
			String iVisit = this.InitialVisit.getText();
			String lVisit = this.LastVisit.getText();
			
			if(ID.length() <7 || ID.length() >7)
			{	
				JOptionPane.showMessageDialog(DataInputs, "Your ID is the incorret Length");
				
			}
			else
			{
				LNode key = InitialPatients.find(ID);
				
				if(key == null)
				{	
					InitialPatients.add(new Patient(name,ID,address,height,weight,DOB,iVisit,lVisit));
					
				}
				else
				{
					JOptionPane errormsg = new JOptionPane();
					errormsg.showMessageDialog(DataInputs, "That ID is already in use");
				}
				clayout.show(controller, "Menu");
			}
		}
		
		//Confirmation to find one patient/delete on patient
		if(click.equals(OneEnter))
		{
			if(OneEnter.getText().equals("Search"))
			{
				
				LNode output = InitialPatients.find(inputID.getText());
				
				if(output != null)
				{
					OneData.setText(output.p.ToStringS());
				}
				else
					System.out.println("Does not exist");
			}
			else if(OneEnter.getText().equals("Delete"))
			{
				
				System.out.println("Deleted");
				InitialPatients.delete(inputID.getText());
				OneData.setText("Patient Information Deleted");
			}
		}
	}


	//WindowListener Methods---------------------------------------------------------------------------------------
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

		InputandOutput timetosave = new InputandOutput();
		timetosave.clearFile();
		timetosave.saveData(InitialPatients);
		JOptionPane.showMessageDialog(DataInputs, "Data Saved");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	
}

