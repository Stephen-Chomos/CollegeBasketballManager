import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class PickTeam {
	
	Vector<Team> teamvect = new Vector<>();
	Team worker;
	JTextArea textArea;
	JLabel label;
	JLabel label2;
	Random random = new Random();
	
	public PickTeam(String fname, String lname, int age, boolean career, String[] fnames, String[] lnames) {
		
		
		String panelIn;
		String work;
		JFrame frame = new JFrame("College Basketball Manager");
		String userHome = System.getProperty("user.home");
		String desktopFilePath = userHome + "/Desktop/teams.txt";
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    
	    String line;
	    
	    if(teamvect.size() == 0) {
	    
		try {
		      File myObj = new File("team.txt");
		      Scanner myReader = new Scanner(myObj);
		      int count = 0;
		      while (myReader.hasNextLine()) {
		    	work = myReader.nextLine();
		        Team object = new Team(work, count);
		        for(int i = 0; i < 15; ++i) {
		        	int f = random.nextInt(120);
		        	int l = random.nextInt(120);
		        	object.addPlayer(fnames[f], lnames[l]);
		        }
		        teamvect.add(object);
		        //object.print();
		        work = "";
		        ++count;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	    
	    }
	    
		if (career == true) {
	    	label = new JLabel("Welcome to your career: " + fname + " " + lname);
	    	label2 = new JLabel("Select your team to start");
	    	textArea = new JTextArea(10, 50); // Rows x Columns
	        textArea.setWrapStyleWord(true);
	        textArea.setLineWrap(true);
	        for (Team tm : teamvect) {
	        	if(tm.getPrestige() <= 20) {
	        		work = tm.picker();
	        		textArea.append(work);
	        	}
	        }
	    	
	    }
	    
	    else {
	    	label = new JLabel("Welcome to your career: " + fname + " " + lname);
	    	label2 = new JLabel("Select your team to start");
	    	textArea = new JTextArea(10, 50); // Rows x Columns
	        textArea.setWrapStyleWord(true);
	        textArea.setLineWrap(true);
	        for (Team tm : teamvect) {
	        	work = tm.picker();
	        	textArea.append(work);
	        }
	        
	        
	        
	    }
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel.add(label);
        panel.add(label2);
        panel.add(scrollPane);
        
        JLabel inputlabel = new JLabel("Enter team ID of desired team");
        JTextArea input = new JTextArea();
        input.setPreferredSize(new Dimension(70, 20));
        JButton begin = new JButton("Press to Begin");
        JButton back = new JButton("Return to Coach Editor");
        
        begin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String teamID = input.getText();
	            int teamIDI = Integer.parseInt(teamID);
	            Coach in = new Coach(fname, lname, age, teamIDI);
	            MainScreen main = new MainScreen(teamvect, in);
                frame.setVisible(false);
            }
        });
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewGame();
                frame.setVisible(false);
            }
        });
	    
        panel.add(inputlabel);
        panel.add(input);
        panel.add(begin);
        panel.add(back);
	    frame.add(panel);
	    
	    frame.setSize(1000, 400);
	    
	    frame.setVisible(true);
	}
}
