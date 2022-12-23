package sirdarey;

public class Currency {
	private String code, name;

	public Currency(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return "The Currency with Code "+code.toUpperCase()+ " is: "+name;
	}
}
