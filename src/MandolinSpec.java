
public class MandolinSpec extends Spec {
	
	private Wood topWood;
	private Wood backWood;
	private boolean pickGuard;
	
	public MandolinSpec(Builder builder, Type type, Wood topWood, Wood backWood, boolean pickGuard) {
		super(builder, type);
		this.topWood = topWood;
		this.backWood = backWood;
		this.pickGuard = pickGuard;
	}
	
	public Wood getBackWood() {
		return this.backWood;
	}
	
	public Wood getTopWood() {
		return this.topWood;
	}
	
	public boolean matches(MandolinSpec ms) {
		return false;
	}
	
}
