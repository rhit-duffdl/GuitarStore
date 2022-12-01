
public class Guitar extends StringInstrument {
	
	private GuitarSpec spec;
	
	public Guitar(String serialNumber, double price, GuitarSpec spec) {
		super(serialNumber, price, spec);
		this.spec = spec;
	}
	
	public String toString() {
		return "$" + super.getPrice() + " " + super.getSpec().getType() + " " + super.getSpec().getBuilder() + ", Top Wood: " + spec.getTopWood() + ", Back Wood: " + spec.getBackWood() + ", SN: " + super.getSerialNumber();
	}


}
