
public class GuitarSpec extends Spec{
	
	private Wood topWood;
	private Wood backWood;
	
	public GuitarSpec(Builder builder, Type type, Wood topWood, Wood backWood) {
		super(builder, type);
		this.topWood = topWood;
		this.backWood = backWood;
	}
	
	public Wood getBackWood() {
		return this.backWood;
	}
	
	public Wood getTopWood() {
		return this.topWood;
	}
	
	public boolean matches(GuitarSpec gs) {
		return false;
	}
	
	
}
