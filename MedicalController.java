package MedicalDatabase;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JFrame;

public class MedicalController {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		
		InputandOutput inout = new InputandOutput();
		
		int people = inout.checkLines();
		System.out.println(people);
		
		LList control = new LList();

		for(int i =0 ; i < people; i++)
		{
			inout.loadData(i);
			control.add(inout.getData());
			
		}
		
	
	
		
		GuiManager gui = new GuiManager("Patient Data", control,people);
		gui.setSize(800,500);
		gui.setResizable(true);
		gui.setLocationRelativeTo(null);
		gui.setBackground(Color.white);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);


	}


}
