
public class Mandolin extends StringInstrument {
	
	private MandolinSpec spec;
	
	public Mandolin(String serialNumber, double price, MandolinSpec spec) {
		super(serialNumber, price, spec);
		this.spec = spec;
	}
	
	public String toString() {
		return "$" + super.getPrice() + " " + super.getSpec().getType() + " " + super.getSpec().getBuilder() + ", Top Wood: " + spec.getTopWood() + ", Back Wood: " + spec.getBackWood() + ", Pick Guard? " + spec.hasPickGuard() + ", SN: " + super.getSerialNumber();
	}
	
	public MandolinSpec getSpec() {
		return this.spec;
	}
	
}
