import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NewGame {
	
	public NewGame() {
			JFrame frame = new JFrame("College Basketball Manager");
		    String[] fnames = new String[120];
		    String[] lnames = new String[120];
		    String work;
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    
		    JPanel panel = new JPanel();
		    
		    JButton begin = new JButton("Begin Career");
		    JLabel flname = new JLabel("First Name");
		    JTextField fname = new JTextField();
		    fname.setPreferredSize(new Dimension(200, 30));
		    JLabel llname = new JLabel("Last Name");
		    JTextField lname = new JTextField();
		    lname.setPreferredSize(new Dimension(200, 30));
		    JLabel lage = new JLabel("Age:");
		    JTextField age = new JTextField();
		    age.setPreferredSize(new Dimension(200, 30));
		    JRadioButton career = new JRadioButton("Check for Career mode:");
		    
		    panel.add(flname);
		    panel.add(fname);
		    panel.add(llname);
		    panel.add(lname);
		    panel.add(lage);
		    panel.add(age);
		    panel.add(career);
		    panel.add(begin);
		    
		    try {
			      File myObj = new File("firstnames.txt");
			      Scanner myReader = new Scanner(myObj);
			      int count = 0;
			      while (myReader.hasNextLine()) {
			    	work = myReader.nextLine();
			        fnames[count] = work;
			        //object.print();
			        work = "";
			        ++count;
			      }
			      myReader.close();
			      myObj = new File("lastnames.txt");
			      myReader = new Scanner(myObj);
			      count = 0;
			      while (myReader.hasNextLine()) {
			    	work = myReader.nextLine();
			        lnames[count] = work;
			        //object.print();
			        work = "";
			        ++count;
			      }
			      myReader.close();
			    } catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
		    
		    begin.addActionListener(new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		            String firstName = fname.getText();
		            String lastName = lname.getText();
		            String Age = age.getText();
		            int ageI = Integer.parseInt(Age);
		            boolean car = career.isSelected();
		            frame.setVisible(false);
		            new PickTeam(firstName, lastName, ageI, car, fnames, lnames);
		        }
		    });
		    
		    frame.add(panel);
		    
		    frame.setSize(1000, 500);
		    
		    frame.setVisible(true);
			}
}
