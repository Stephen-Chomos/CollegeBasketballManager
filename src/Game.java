import java.util.Scanner;
import java.util.Vector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	String home;
	String away;
	boolean neutralsite;
	int homeID;
	int awayID;
	int homePoints = 0;
	int awayPoints = 0;
	
	public Game(String h, String a, boolean n, int hi, int ai) {
		home = h;
		away = a;
		neutralsite = n;
		homeID = hi;
		awayID = ai;
	}
	
	public void ScoreGame(int home, int away) {
		homePoints = home;
		awayPoints = away;
	}
	
	public String print(int ID) {
		if(homeID == ID && neutralsite == false && homePoints == 0) {
			return "vs " + away + "\n";
		}
		else if(homeID == ID && neutralsite == true && homePoints == 0) {
			return "vs(neutral) " + away + "\n";
		}
		else if(awayID == ID && neutralsite == false && homePoints == 0) {
			return "at " + home + "\n";
		}
		else if(awayID == ID && neutralsite == true && homePoints == 0){
			return "at(neutral) " + home + "\n";
		}
		else if(homeID == ID && neutralsite == false && homePoints != 0) {
			return "vs " + away + " Final: " + homePoints + "-" + awayPoints +"\n";
		}
		else if(homeID == ID && neutralsite == true && homePoints != 0) {
			return "vs(neutral) " + away + " Final: " + homePoints + "-" + awayPoints +"\n";
		}
		else if(awayID == ID && neutralsite == false && homePoints != 0) {
			return "at " + home + " Final: " + awayPoints + "-" + homePoints +"\n";
		}
		else {
			return "at(neutral) " + home + " Final: " + awayPoints + "-" + homePoints + "\n";
		}
	}
	
	public String save() {
		if(neutralsite == false) {
			return home + "," + away + "," + Integer.toString(homeID) + "," + Integer.toString(awayID) + ",No\n";
		}
		else {
			return home + "," + away + "," + Integer.toString(homeID) + "," + Integer.toString(awayID) + ",Yes\n";
		}
	}
	
	public void load(String lo) {
		String lit;
		Scanner loadScanner = new Scanner(lo); 
		loadScanner.useDelimiter(",");
		home = loadScanner.next();
		away = loadScanner.next();
		homeID = loadScanner.nextInt();
		awayID = loadScanner.nextInt();
		lit = loadScanner.next();
		if(lit == "No") {
			neutralsite = false;
		}
		else {
			neutralsite = true;
		}
	}

	public String getHome() {
		return home;
	}


	public String getAway() {
		return away;
	}

	public boolean isNeutralsite() {
		return neutralsite;
	}

	public void setNeutralsite(boolean neutralsite) {
		this.neutralsite = neutralsite;
	}

	public int getHomeID() {
		return homeID;
	}

	public void setHomeID(int homeID) {
		this.homeID = homeID;
	}

	public int getAwayID() {
		return awayID;
	}

	public void setAwayID(int awayID) {
		this.awayID = awayID;
	}
	
	
	
	
	
}
