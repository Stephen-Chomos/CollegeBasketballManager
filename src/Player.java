import java.util.Random;
import java.util.Scanner;

public class Player {
	private String fname;
	private String lname;
	private int year;
	private int aggression;//
	private int anticipation;//
	private int bravery;//
	private int composure;//
	private int concentration;
	private int leadership;
	private int teamwork;//
	private int vision;//
	private int acceleration;//
	private int agility;//
	private int pace;//
	private int stamina;//
	private int hustle;//
	private int layup;//
	private int shrng;//
	private int midrng;//
	private int lngrng;//
	Random random = new Random();
	int increase;
	
	public Player(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
		year = random.nextInt(3) + 1;
		aggression = random.nextInt(99) + 1;
		anticipation = random.nextInt(99) + 1;
		bravery = random.nextInt(99) + 1;
		composure = random.nextInt(99) + 1;
		concentration = random.nextInt(99) + 1;
		leadership = random.nextInt(99) + 1;
		teamwork = random.nextInt(99) + 1;
		vision = random.nextInt(99) + 1;
		acceleration = random.nextInt(99) + 1;
		agility = random.nextInt(99) + 1;
		pace = random.nextInt(99) + 1;
		stamina = random.nextInt(99) + 1;
		hustle = random.nextInt(99) + 1;
		layup = random.nextInt(99) + 1;
		shrng = random.nextInt(99) + 1;
		midrng = random.nextInt(99) + 1;
		lngrng = random.nextInt(99) + 1;
	}
	
	public Player(String fname, String lname, int year) {
		this.fname = fname;
		this.lname = lname;
		this.year = year;
		aggression = random.nextInt(99) + 1;
		anticipation = random.nextInt(99) + 1;
		bravery = random.nextInt(99) + 1;
		composure = random.nextInt(99) + 1;
		concentration = random.nextInt(99) + 1;
		leadership = random.nextInt(99) + 1;
		teamwork = random.nextInt(99) + 1;
		vision = random.nextInt(99) + 1;
		acceleration = random.nextInt(99) + 1;
		agility = random.nextInt(99) + 1;
		pace = random.nextInt(99) + 1;
		stamina = random.nextInt(99) + 1;
		hustle = random.nextInt(99) + 1;
		layup = random.nextInt(99) + 1;
		shrng = random.nextInt(99) + 1;
		midrng = random.nextInt(99) + 1;
		lngrng = random.nextInt(99) + 1;
	}
	
	public String save() {
		return fname + "," + lname + "," + year +  "," + aggression + "," + anticipation + "," + bravery + "," + composure + "," + concentration + "," + leadership + "," + teamwork + "," + vision + "," + acceleration + "," + agility + "," + pace + "," + stamina + "," + hustle + "," + layup + "," + shrng + "," + midrng + "," + lngrng + "\n";
	}
	
	public String view() {
		return fname + " " + lname + " Year:" + year +  " AGG:" + aggression + " ANT:" + anticipation + " BRV:" + bravery + " COMP:" + composure + " CONC:" + concentration + " LDR:" + leadership + " TMK:" + teamwork + " VIS:" + vision + " ACL:" + acceleration + " AGI:" + agility + " PAC:" + pace + " STA:" + stamina + " HUS:" + hustle + " LAY:" + layup + " SHTRNG:" + shrng + " MDRNG:" + midrng + " LNG:" + lngrng;
	}
	
	public Player(String line) {
		Scanner loadScanner = new Scanner(line); 
		loadScanner.useDelimiter(",");
		fname = loadScanner.next();
		lname = loadScanner.next();
		year = loadScanner.nextInt();
		aggression = loadScanner.nextInt();
		bravery = loadScanner.nextInt();
		composure = loadScanner.nextInt();
		concentration = loadScanner.nextInt();
		leadership = loadScanner.nextInt();
		teamwork = loadScanner.nextInt();
		vision = loadScanner.nextInt();
		acceleration = loadScanner.nextInt();
		agility = loadScanner.nextInt();
		pace = loadScanner.nextInt();
		stamina = loadScanner.nextInt();
		hustle = loadScanner.nextInt();
		layup = loadScanner.nextInt();
		shrng = loadScanner.nextInt();
		midrng = loadScanner.nextInt();
		lngrng = loadScanner.nextInt();
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public int getYear() {
		return year;
	}

	public int getAggression() {
		return aggression;
	}

	public int getAnticipation() {
		return anticipation;
	}

	public int getBravery() {
		return bravery;
	}

	public int getComposure() {
		return composure;
	}

	public int getConcentration() {
		return concentration;
	}

	public int getLeadership() {
		return leadership;
	}

	public int getTeamwork() {
		return teamwork;
	}

	public int getVision() {
		return vision;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public int getAgility() {
		return agility;
	}

	public int getPace() {
		return pace;
	}

	public int getStamina() {
		return stamina;
	}

	public int getHustle() {
		return hustle;
	}

	public int getLayup() {
		return layup;
	}

	public int getShrng() {
		return shrng;
	}

	public int getMidrng() {
		return midrng;
	}

	public int getLngrng() {
		return lngrng;
	}

	public void addYear() {
		++year;
	}
	
	public void trainSpeed() {
		increase = random.nextInt(10) + 1;
		hustle = hustle + increase;
		stamina = stamina + increase;
		pace = pace + increase;
		agility = agility + increase;
		if (hustle > 99) {
			hustle = 99;
		}
		if (stamina > 99) {
			stamina = 99;
		}
		if (pace > 99) {
			pace = 99;
		}
		if (agility > 99) {
			agility = 99; 
		}
	}
	
	public void trainMental() {
		increase = random.nextInt(10) + 1;
		leadership = leadership + increase;
		concentration = concentration + increase;
		composure = composure + increase;
		vision = vision + increase;
		if (leadership > 99) {
			leadership = 99;
		}
		if (concentration > 99) {
			concentration = 99;
		}
		if (composure > 99) {
			composure = 99;
		}
		if (vision > 99) {
			vision = 99; 
		}
	}
	
	public void trainShot() {
		increase = random.nextInt(10) + 1;
		layup = layup + increase;
		shrng = shrng + increase;
		midrng = midrng + increase;
		lngrng = lngrng + increase;
		if (layup > 99) {
			layup = 99;
		}
		if (shrng > 99) {
			shrng = 99;
		}
		if (midrng > 99) {
			midrng = 99;
		}
		if (lngrng > 99) {
			lngrng = 99; 
		}
	}
}
