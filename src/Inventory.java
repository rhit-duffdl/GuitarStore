import java.util.ArrayList;

public class Inventory {
	public ArrayList<Guitar> guitars; 
	private ArrayList<Mandolin> mandolins;
	
	public Inventory() {
		this.guitars = new ArrayList<Guitar>();
		this.mandolins = new ArrayList<Mandolin>();
	}
	
	public Inventory(ArrayList<Guitar> guitars, ArrayList<Mandolin> mandolins) {
		this.guitars = guitars;
		this.mandolins = mandolins;
	}
	
	public void addGuitar(Guitar g) {
		this.guitars.add(g);
	}
	
	public void addMandolin(Mandolin m) {
		this.mandolins.add(m);
	}
	
	public Guitar getGuitar(String modelName) {
		return null;
	}
	
	public Mandolin getMandolin(String modelName) {
		return null;
	}

	
}
