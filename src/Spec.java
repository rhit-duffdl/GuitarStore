
public class Spec {
	
	private Builder builder;
	private Type type;
	
	public Spec(Builder builder, Type type) {
		this.builder = builder;
		this.type = type;				
	}
	
	public Builder getBuilder() {
		return this.builder;
	}
	
	public Type getType() {
		return this.type;		
	}
	
	public boolean matches(Spec spec) {
		return false;
	}
}
