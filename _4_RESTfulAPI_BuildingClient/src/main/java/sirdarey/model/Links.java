package sirdarey.model;

public class Links {
	private String link, rel;
	
	public Links() {}

	public Links(String link, String rel) {
		this.link = link;
		this.rel = rel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}
}
