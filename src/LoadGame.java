import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class LoadGame {

	public LoadGame() {
		Vector<Team> teamvect = new Vector<>();
		Team worker;
		Coach obj = new Coach();
		JFrame frame = new JFrame("College Basketball Manager");
        
		frame.setSize(1000, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Please pick save location:\n");
        
        JButton save1 = new JButton("SAVE 1");
        JButton save2 = new JButton("SAVE 2");
        JButton save3 = new JButton("SAVE 3");
        JButton back = new JButton("Go Back");
        
        panel.add(label);
        panel.add(save1);
        panel.add(save2);
        panel.add(save3);
        panel.add(back);
        
        save1.addActionListener(new ActionListener() {
            String tempLine = "";
    		PrintWriter writer;
    		Scanner saveReader;
            public void actionPerformed(ActionEvent e) {
            	try {
            		File myObj = new File("save1.txt");
   			     	Scanner myReader = new Scanner(myObj);
   			     	int count = 0;
   			     	tempLine = myReader.nextLine();
   			     	obj.parse(tempLine);
   			     	while (myReader.hasNextLine()) {
   			     		tempLine = myReader.nextLine();  
   			     		Team object = new Team(tempLine);
   			     		teamvect.add(object);
   			     	}
    			} catch (FileNotFoundException e3) {
    				e3.printStackTrace();
    			}
            	MainScreen main = new MainScreen(teamvect, obj);
                frame.setVisible(false);
            }
        });
        
        save2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String tempLine = "";
        		PrintWriter writer;
        		Scanner saveReader;
        			try {
        				File myObj = new File("save2.txt");
       			     	Scanner myReader = new Scanner(myObj);
       			     	int count = 0;
       			     	tempLine = myReader.nextLine();
       			     	obj.parse(tempLine);
       			     	while (myReader.hasNextLine()) {
       			     		tempLine = myReader.nextLine();  
       			     		Team object = new Team(tempLine);
       			     		teamvect.add(object);
       			     	}
        			} catch (FileNotFoundException e3) {
        				e3.printStackTrace();
        			}
        		MainScreen main = new MainScreen(teamvect, obj);
                frame.setVisible(false);
            }
        });
        
        save3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String tempLine = "";
        		PrintWriter writer;
        		Scanner saveReader;
        			try {
        				 File myObj = new File("save3.txt");
        			     Scanner myReader = new Scanner(myObj);
        			     int count = 0;
        			     tempLine = myReader.nextLine();
        			     obj.parse(tempLine);
        			     while (myReader.hasNextLine()) {
        			    	 tempLine = myReader.nextLine();  
        			    	 Team object = new Team(tempLine);
        			    	 teamvect.add(object);
        			     }
        			} catch (FileNotFoundException e3) {
        				e3.printStackTrace();
        			}
        		
        		MainScreen main = new MainScreen(teamvect, obj);	
                frame.setVisible(false);
            }
        });
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Runner();
                frame.setVisible(false);
            }
        });
        
        frame.add(panel);
        frame.setVisible(true);
	}
}
