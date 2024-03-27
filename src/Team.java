import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.Collections;

public class Team {

	private String TeamName;
	private String City;
	private String State;
	private int yearFormed;
	private int num_wins;
	private int num_years;
	private int APranks;
	private int confregc;
	private int conftournc;
	private int ncaaap;
	private int ncaaff;
	private int ncaanc;
	private int prestige;
	int count = 0;
	private int id;
	Player[] players = new Player[15];
	int numplayers = 0;
	private String confrence;
	private int speed;
	private int rebagg;
	private int shotrang;
	private int wins;
	private int loss;
	private int confwins;
	private int confloss;
	private int games;
	private int confgames;
	private int numGames;
	Random random = new Random();
	int weekOn = 0;
	
	public int getWeekOn() {
		return weekOn;
	}
	
	public void addWeek() {
		++weekOn;
	}

	Vector<Game> gamesced = new Vector<>();
	
	public Team() {	}
	
	public void randomSced() {
		Collections.shuffle(gamesced);
	}
	
	public void ScoreGame(int homeScore, int awayScore, int week) {
		if(weekOn <= week) {
		gamesced.elementAt(week).ScoreGame(homeScore, awayScore);
		++confgames;
		if(gamesced.elementAt(week).homeID == id && homeScore > awayScore) {
			++confwins;
		}
		if(gamesced.elementAt(week).homeID != id && homeScore > awayScore) {
			++confloss;
		}
		if(gamesced.elementAt(week).homeID == id && homeScore < awayScore) {
			++confloss;
		}
		else {
			++confwins;
		}
		++weekOn;
		}
	}
	
	public void addGame(Team other, int otherID, boolean home, boolean neutral) {
		if(home == true) {
			Game g = new Game(TeamName, other.getTeamName(), neutral, id, other.getId());
			gamesced.add(g);
			++numGames;
		}
		else {
			Game g = new Game(other.getTeamName(), TeamName, neutral, other.getId(), id);
			gamesced.add(g);
			++numGames;
		}
	}
	
	public boolean onSchedule(int ID) {
		for(Game g : gamesced) {
			if (g.awayID == ID || g.homeID == ID) {
				return false;
			}
		}
		return true;
	}
	
	public String printsced() {
		String ret = "";
		for(Game g : gamesced) {
			ret = ret + g.print(id);
		}
		return ret;
	}
	
	public void print() {
		getPrestige();
		System.out.println("ID:" + id + " Team Name: " + TeamName + " Place: " + City + ", " + State + ", Confrence " + confrence + " Year Formed: " + yearFormed + " Num years: " + num_years + " Num wins: " + num_wins);
		System.out.println("Ap rankings: " + APranks + " Confrence reg champs: " + confregc + " Confrence tourn champs: " + conftournc + " NCAA apperances: " + ncaaap + " Final Fours: " +  ncaaff + " NCAA Titles: " + ncaanc);
		System.out.println("Prestige: " + prestige);
	}
	
	public void addWin() {
		++wins;
		++games;
	}
	
	public void addLoss() {
		++wins;
		++games;
	}
	
	public void addConfWin() {
		++wins;
		++confwins;
		++games;
		++confgames;
	}
	
	public void addConfLoss() {
		++loss;
		++confloss;
		++games;
		++confgames;
	}
	
	public int getWins() {
		return wins;
	}
	public int getLoss() {
		return loss;
	}
	public int getConfwins() {
		return confwins;
	}
	public int getConfloss() {
		return confloss;
	}
	public int getGames() {
		return games;
	}
	
	public String roster() {
		String ret = "";
		for (int i = 0; i < numplayers; ++i) {
			ret = ret + players[i].save() + ";";
		}
		return ret;
	}
	
	public String rosterView() {
		String ret = "";
		for (int i = 0; i < numplayers; ++i) {
			ret = ret + players[i].view() + "\n";
		}
		return ret;
	}
	
	public String picker() {
		return "ID: " + id + " " + TeamName + " " + City + "," + State + " Confrence " + confrence + " Prestige: " + prestige + "\n";
	}
	
	public void addPlayer(String firstName, String lastName) {
		Player one = new Player(firstName, lastName);
		if (numplayers < 15) {
			players[numplayers] = one;
			++numplayers;
		}
	}
	
	public Team(String teamName, String city, String state, int yearFormed, int num_wins, int num_years, int aPranks,
			int confregc, int conftournc, int ncaaap, int ncaaff, int ncaanc) {
		super();
		TeamName = teamName;
		City = city;
		State = state;
		this.yearFormed = yearFormed;
		this.num_wins = num_wins;
		this.num_years = num_years;
		APranks = aPranks;
		this.confregc = confregc;
		this.conftournc = conftournc;
		this.ncaaap = ncaaap;
		this.ncaaff = ncaaff;
		this.ncaanc = ncaanc;
		getPrestige();
	}
	
	public Team(String line) {
		String lit;
		Scanner loadScanner = new Scanner(line); 
		loadScanner.useDelimiter(",");
		id = loadScanner.nextInt();
		TeamName = loadScanner.next();
		City = loadScanner.next();
		State = loadScanner.next();
		yearFormed = loadScanner.nextInt();
		num_years = loadScanner.nextInt();
		num_wins = loadScanner.nextInt();
		APranks = loadScanner.nextInt();
		confregc = loadScanner.nextInt();
		conftournc = loadScanner.nextInt();
		ncaaap = loadScanner.nextInt();
		ncaaff = loadScanner.nextInt();
		ncaanc = loadScanner.nextInt();
		prestige = loadScanner.nextInt();
		numplayers = loadScanner.nextInt();
		confrence = loadScanner.next();
		speed = loadScanner.nextInt();
		rebagg = loadScanner.nextInt();
		shotrang = loadScanner.nextInt();
		loadScanner.useDelimiter(";");
		for(int i = 0; i < numplayers - 1; ++i) {
			lit = loadScanner.next();
			players[i] = new Player(lit);
		}
	}
	
	public Team(String line, int count) {
		String panelIn;
		panelIn = line;
		String work;
        int point = panelIn.indexOf("\t");
        TeamName = panelIn.substring(0, point);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf(',');
        City = panelIn.substring(0, point);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf("\t");
        State = panelIn.substring(0, point);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf("\t");
        work = panelIn.substring(0, point);
        yearFormed = Integer.parseInt(work);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf("\t");
        work = panelIn.substring(0, point);
        num_years = Integer.parseInt(work);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf("\t");
        work = panelIn.substring(0, point);
        num_wins = Integer.parseInt(work);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf("\t");
        work = panelIn.substring(0, point);
        APranks = Integer.parseInt(work);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf("\t");
        work = panelIn.substring(0, point);
        confregc = Integer.parseInt(work);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf("\t");
        work = panelIn.substring(0, point);
        conftournc = Integer.parseInt(work);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf("\t");
        work = panelIn.substring(0, point);
        ncaaap = Integer.parseInt(work);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf("\t");
        work = panelIn.substring(0, point);
        ncaaff = Integer.parseInt(work);
        panelIn = panelIn.substring(point + 1);
        point = panelIn.indexOf("\t");
        work = panelIn.substring(0, point);
        ncaanc = Integer.parseInt(work);
        panelIn = panelIn.substring(point + 1);
        id = count;
        confrence = panelIn;
        speed = random.nextInt(3) + 1;
        rebagg = random.nextInt(3) + 1;
        shotrang = random.nextInt(3) + 1;
        System.out.println(count);
	}
	
	public String getTeamName() {
		return TeamName;
	}
	public void setTeamName(String teamName) {
		TeamName = teamName;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getYearFormed() {
		return yearFormed;
	}
	public void setYearFormed(int yearFormed) {
		this.yearFormed = yearFormed;
	}
	public int getNum_wins() {
		return num_wins;
	}
	public void setNum_wins(int num_wins) {
		this.num_wins = num_wins;
	}
	public int getNum_years() {
		return num_years;
	}
	public void setNum_years(int num_years) {
		this.num_years = num_years;
	}
	public int getAPranks() {
		return APranks;
	}
	public void setAPranks(int aPranks) {
		APranks = aPranks;
	}
	public int getConfregc() {
		return confregc;
	}
	public void setConfregc(int confregc) {
		this.confregc = confregc;
	}
	public int getConftournc() {
		return conftournc;
	}
	public void setConftournc(int conftournc) {
		this.conftournc = conftournc;
	}
	public int getNcaaap() {
		return ncaaap;
	}
	public void setNcaaap(int ncaaap) {
		this.ncaaap = ncaaap;
	}
	public int getNcaaff() {
		return ncaaff;
	}
	public void setNcaaff(int ncaaff) {
		this.ncaaff = ncaaff;
	}
	public int getNcaanc() {
		return ncaanc;
	}
	public void setNcaanc(int ncaanc) {
		this.ncaanc = ncaanc;
	}
	
	public int getPrestige() {
		prestige = (num_wins / 100) + APranks + confregc + conftournc + ncaaap + (ncaaff * 2) + (ncaanc * 4);
		return prestige;
	}

	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumplayers() {
		return numplayers;
	}
	public String getConfrence() {
		return confrence;
	}
	public void setConfrence(String confrence) {
		this.confrence = confrence;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getRebagg() {
		return rebagg;
	}
	public void setRebagg(int rebagg) {
		this.rebagg = rebagg;
	}
	public int getShotrang() {
		return shotrang;
	}
	public void setShotrang(int shotrang) {
		this.shotrang = shotrang;
	}
	
	public void addYear() {
		for ( int i = 0; i < numplayers; ++i) {
			if(players[i].getYear() == 4) {
				String[] fnames = new String[120];
				String[] lnames = new String[120];
				String work;
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
				 int f = random.nextInt(120);
				 int l = random.nextInt(120);
				 players[i] = new Player(fnames[f], lnames[l], 1);
			}
			players[i].addYear();
		}
	}
	
	public void trainSpeed() {
		for (int i = 0; i < numplayers; ++i) {
			players[i].trainSpeed();
		}
	}
	
	public void trainMental() {
		for (int i = 0; i < numplayers; ++i) {
			players[i].trainMental();
		}
	}

	public void trainShot() {
		for (int i = 0; i < numplayers; ++i) {
			players[i].trainShot();
		}
	}
	public int getNumGames() {
		return numGames;
	}
	public void setNumGames(int numGames) {
		this.numGames = numGames;
	}

	public int getConfWinPct() {
		return confwins / confgames;
	}
	
	public int calcSpeed1() {
		int ret = 0;
		for (int i = 0; i < 15; ++i) {
			ret = ret + players[i].getComposure();
			ret = ret + players[i].getVision();
			ret = ret + players[i].getLeadership();
		}
		ret = ret / 45;
		return ret;
	}
	
	public int calcSpeed2() {
		int ret = 0;
		for (int i = 0; i < 15; ++i) {
			ret = ret + players[i].getPace();
			ret = ret + players[i].getBravery();
			ret = ret + players[i].getStamina();
		}
		ret = ret / 45;
		return ret;
	}

	public int calcSpeed3() {
		int ret = 0;
		for (int i = 0; i < 15; ++i) {
			ret = ret + players[i].getAgility();
			ret = ret + players[i].getHustle();
			ret = ret + players[i].getAcceleration();
		}
		ret = ret / 45;
		return ret;
	}
	
	public int calcReb1() {
		int ret = 0;
		for (int i =0; i < 15; ++i) {
			ret = ret + players[i].getTeamwork();
		}
		ret = ret /15;
		return ret;
	}

	public int calcReb2() {
		int ret = 0;
		for (int i =0; i < 15; ++i) {
			ret = ret + players[i].getAnticipation();
		}
		ret = ret /15;
		return ret;
	}

	public int calcReb3() {
		int ret = 0;
		for (int i =0; i < 15; ++i) {
			ret = ret + players[i].getAggression();
		}
		ret = ret /15;
		return ret;
	}

	public int calcRange1() {
		int ret = 0;
		for (int i =0; i < 15; ++i) {
			ret = ret + players[i].getLayup();
			ret = ret + players[i].getShrng();
		}
		ret = ret /30;
		return ret;
	}

	public int calcRange2() {
		int ret = 0;
		for (int i =0; i < 15; ++i) {
			ret = ret + players[i].getMidrng();
		}
		ret = ret /15;
		return ret;
	}

	public int calcRange3() {
		int ret = 0;
		for (int i =0; i < 15; ++i) {
			ret = ret + players[i].getLngrng();
			ret = ret + players[i].getConcentration();
		}
		ret = ret /30;
		return ret;
	}
	
	
	public Game getGame(int week) {
		return gamesced.elementAt(week);
	}
	
	
	
}
