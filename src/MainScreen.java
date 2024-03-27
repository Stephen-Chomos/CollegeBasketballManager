import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen {
	
	Team yours = new Team();

	public MainScreen(Vector<Team> teams, Coach you) {
		JFrame frame = new JFrame("College Basketball Manager");
	    
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel panel = new JPanel();
	    
	    for (Team t : teams) {
	    	if(t.getId() == you.getTeamID()) {
	    		yours = t;
	    	}
	    }
	    
	    JLabel lab = new JLabel("Welcome Coach " + you.getLastname() + ", Head Coach of the " + yours.getTeamName());
	    
	    int years = you.getYearsCoached() + 1;
	    
	    JLabel lab2 = new JLabel (", Year " + years);
	    
	    panel.add(lab);
	    panel.add(lab2);
	    
	    JButton rost = new JButton("View Roster");
	    
	    JButton strat = new JButton("Edit Strategy");
	    
	    JButton exit = new JButton("EXIT");
	   
	    exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Save(teams, you);
            }
        });
	    
	    rost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new RosterView(teams, you, yours);
            }
        });
	    
	    strat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Strategy(teams, you, yours);
            }
        });
	    
	    //Preseason
	    if(you.getPointinSeason() == 0) {
		    
		    JButton offseason = new JButton("Complete OffSeason Tasks"); 
		    
		    panel.add(offseason);
		    offseason.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frame.setVisible(false);
	                new OffSeasonTasks(teams, you, yours);
	            }
	        });
		    
	    }//end of preseason
	    
	    //Regular Season
	    if (you.getPointinSeason() == 1) {
	    	JButton checkSced = new JButton("Check Scedule"); 
	    	JButton checkStand = new JButton("Check Standings"); 
	    	JButton playNext = new JButton("Play Next");
		    
		    panel.add(checkSced);
		    checkSced.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frame.setVisible(false);
	                new ScheduleLook(teams, you, yours);
	            }
	        });
		    
		    panel.add(playNext);
		    int week = yours.getWeekOn();
		    playNext.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frame.setVisible(false);
	                new WeekGameRunner(teams, you, yours, week);
	            }
	        });
		    
		    panel.add(checkStand);
		    checkStand.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                frame.setVisible(false);
	                new StandingsCheck(teams, you, yours);
	            }
	        });
		    
	    }//End of regular Season
	    
	    //Confrence Tourney
	    if (you.getPointinSeason() == 2) {
	    	
	    }
	    
	    //NCAA Tourney
	    if(you.getPointinSeason() == 3) {
	    	
	    }
	    
	    panel.add(exit);
	    panel.add(strat);
	    panel.add(rost);
	    frame.add(panel);
	    
	    frame.setSize(1000, 500);
	    
	    frame.setVisible(true);
	}
}
