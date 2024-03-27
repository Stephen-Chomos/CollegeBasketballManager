import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Save {
	public Save(Vector<Team> tm, Coach ch) {
		JFrame frame = new JFrame("College Basketball Manager");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 100);
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Please pick save location:\n");
        
        JButton save1 = new JButton("SAVE 1");
        JButton save2 = new JButton("SAVE 2");
        JButton save3 = new JButton("SAVE 3");
        JButton back = new JButton("Go Back");
        JButton end = new JButton("Exit without saving");
        
        panel.add(label);
        panel.add(save1);
        panel.add(save2);
        panel.add(save3);
        panel.add(back);
        panel.add(end);
        
        frame.add(panel);
        frame.setVisible(true);
        save1.addActionListener(new ActionListener() {
            String tempLine = "";
    		PrintWriter writer;
    		Scanner saveReader;
            public void actionPerformed(ActionEvent e) {
            	try {
    				writer = new PrintWriter("save1.txt");
    				tempLine = ch.getFirstname() + "," + ch.getLastname() + "," + ch.getAge() + "," + ch.getTeamID() + "," + ch.getWins() + "," + ch.getAPranks() + "," + ch.getConfregc() + "," + ch.getConftournc() + "," + ch.getNcaaap() + "," + ch.getNcaaff() + "," + ch.getNcaanc() + "," + ch.getPrestige() + "\n";
    				writer.write(tempLine);
    				for(Team tem : tm) {
    			    	writer.write(tem.getId() + "," + tem.getTeamName() + "," + tem.getCity() + "," + tem.getState() + "," + tem.getYearFormed() + "," + tem.getNum_years() + "," + tem.getNum_wins() + "," + tem.getAPranks() + "," + tem.getConfregc() + "," + tem.getConftournc() + "," + tem.getNcaaap() + "," + tem.getNcaaff() + "," + tem.getNcaanc() + "," + tem.getPrestige() + "," + tem.getNumplayers() + "," + tem.getConfrence()  + "," + tem.getSpeed() + "," + tem.getRebagg() + "," + tem.getShotrang() + "," + tem.roster() + "\n");
    		        }
    				writer.close();
    			} catch (FileNotFoundException e3) {
    				e3.printStackTrace();
    			}
                frame.setVisible(false);
                new Runner();
            }
        });
        
        save2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String tempLine = "";
        		PrintWriter writer;
        		Scanner saveReader;
        			try {
        				writer = new PrintWriter("save2.txt");
        				tempLine = ch.getFirstname() + "," + ch.getLastname() + "," + ch.getAge() + "," + ch.getTeamID() + "," + ch.getWins() + "," + ch.getAPranks() + "," + ch.getConfregc() + "," + ch.getConftournc() + "," + ch.getNcaaap() + "," + ch.getNcaaff() + "," + ch.getNcaanc() + "," + ch.getPrestige() + "\n";
        				writer.write(tempLine);
        				for(Team tem : tm) {
        			    	writer.write(tem.getId() + "," + tem.getTeamName() + "," + tem.getCity() + "," + tem.getState() + "," + tem.getYearFormed() + "," + tem.getNum_years() + "," + tem.getNum_wins() + "," + tem.getAPranks() + "," + tem.getConfregc() + "," + tem.getConftournc() + "," + tem.getNcaaap() + "," + tem.getNcaaff() + "," + tem.getNcaanc() + "," + tem.getPrestige() + "\n");
        		        }
        				writer.close();
        			} catch (FileNotFoundException e3) {
        				e3.printStackTrace();
        			}
                frame.setVisible(false);
                new Runner();
            }
        });
        
        save3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String tempLine = "";
        		PrintWriter writer;
        		Scanner saveReader;
        			try {
        				writer = new PrintWriter("save3.txt");
        				tempLine = ch.getFirstname() + "," + ch.getLastname() + "," + ch.getAge() + "," + ch.getTeamID() + "," + ch.getWins() + "," + ch.getAPranks() + "," + ch.getConfregc() + "," + ch.getConftournc() + "," + ch.getNcaaap() + "," + ch.getNcaaff() + "," + ch.getNcaanc() + "," + ch.getPrestige() + "\n";
        				writer.write(tempLine);
        				for(Team tem : tm) {
        			    	writer.write(tem.getId() + "," + tem.getTeamName() + "," + tem.getCity() + "," + tem.getState() + "," + tem.getYearFormed() + "," + tem.getNum_years() + "," + tem.getNum_wins() + "," + tem.getAPranks() + "," + tem.getConfregc() + "," + tem.getConftournc() + "," + tem.getNcaaap() + "," + tem.getNcaaff() + "," + tem.getNcaanc() + "," + tem.getPrestige() + "\n");
        		        }
        				writer.close();
        			} catch (FileNotFoundException e3) {
        				e3.printStackTrace();
        			}
                frame.setVisible(false);
                new Runner();
            }
        });
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MainScreen(tm, ch);
                frame.setVisible(false);
            }
        });
        
        end.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Runner();
            }
        });
        
	}
}
