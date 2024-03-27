import java.util.Scanner;

public class Coach {

	private String firstname;
	private String lastname;
	private int age;
	private int yearsCoached;
	private int teamID;
	private int wins;
	private int APranks;
	private int confregc;
	private int conftournc;
	private int ncaaap;
	private int ncaaff;
	private int ncaanc;
	private int prestige;
	private int pointinSeason;
	
	
	
	public Coach(String firstname, String lastname, int age, int teamID) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.teamID = teamID;
		wins = 0;
		APranks = 0;
		confregc = 0;
		conftournc = 0;
		ncaaap = 0;
		ncaaff = 0;
		ncaanc = 0;
		prestige = 0;
		pointinSeason = 0;
	}
	
	public void parse(String line) {
		Scanner loadScanner = new Scanner(line); 
		loadScanner.useDelimiter(",");
		firstname = loadScanner.next();
		lastname = loadScanner.next();
		age = loadScanner.nextInt();
		teamID = loadScanner.nextInt();
		wins = loadScanner.nextInt();
		APranks = loadScanner.nextInt();
		confregc = loadScanner.nextInt();
		conftournc = loadScanner.nextInt();
		ncaaap = loadScanner.nextInt();
		ncaaff = loadScanner.nextInt();
		ncaanc = loadScanner.nextInt();
		prestige = loadScanner.nextInt();
		pointinSeason =loadScanner.nextInt();
	}

	public Coach() {
	}

	public void print() {
		getPrestige();
		System.out.println("Name:" + firstname + " " + lastname + " Age: " + age + " Years Coaches: " + yearsCoached + " Num wins: " + wins);
		System.out.println("Ap rankings: " + APranks + " Confrence reg champs: " + confregc + " Confrence tourn champs: " + conftournc + " NCAA apperances: " + ncaaap + " Final Fours: " +  ncaaff + " NCAA Titles: " + ncaanc);
		System.out.println("Prestige: " + prestige);
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getYearsCoached() {
		return yearsCoached;
	}
	public void setYearsCoached(int yearsCoached) {
		this.yearsCoached = yearsCoached;
	}
	public int getTeamID() {
		return teamID;
	}
	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
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
		prestige = (wins / 100) + APranks + confregc + conftournc + ncaaap + (ncaaff * 2) + (ncaanc * 4);
		return prestige;
	}
	public void setPrestige(int prestige) {
		this.prestige = prestige;
	}

	public int getPointinSeason() {
		return pointinSeason;
	}

	public void setPointinSeason(int pointinSeason) {
		this.pointinSeason = pointinSeason;
	}
	
	
	
}
