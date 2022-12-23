package sirdarey.model;

public class Brand {

	private int brandId;
	private String brandName;
	private Links [] links;
	
	public Brand() {}

	public Brand(String brandName) {
		this.brandName = brandName;
	}

	public Brand(int brandId, String brandName) {
		this.brandId = brandId;
		this.brandName = brandName;
	}

	public Brand(int brandId, String brandName, Links[] links) {
		this.brandId = brandId;
		this.brandName = brandName;
		this.links = links;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public Links[] getLinks() {
		return links;
	}

	public void setLinks(Links[] links) {
		this.links = links;
	}
}
