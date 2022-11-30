
public class StringInstrument {

	private String serialNumber;
	private double price;
	private Spec spec;
	
	public StringInstrument(String serialNumber, double price, Spec spec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
	}
			
	
	public double getPrice() {
		return this.price;
	}
	
	
	public String getSerialNumber() {
		return this.serialNumber;
	}
	
	
	public Spec getSpec() {
		return this.spec;
	}
	
	
	public void setPrice(float newPrice) {
		this.price = newPrice;
	}
	
	
	
	
	
}
