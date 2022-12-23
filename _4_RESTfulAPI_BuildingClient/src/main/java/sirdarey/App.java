package sirdarey;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sirdarey.model.Brand;
import sirdarey.model.Links;

@Path("/")
public class App {

	static Client client = ClientBuilder.newClient();
	static WebTarget baseBrandURL = client.target("http://localhost:9090/RESTfulAPI/showroom/brands");
	static WebTarget brandURL = baseBrandURL.path("{brandId}");
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String homePage() {
//		String response = brandURL
//							.resolveTemplate("brandId", "2")
//							.request(MediaType.APPLICATION_JSON)
//							.get(String.class);
//		return response;
//	}
	
	
	public static void main(String[] args) {
		
		//1. /********    GET    *********/
		
		System.out.println("\n\n/******  GET A Specific Brand as a STRING Entity   *********/");
		//GET where Response is received in a STRING Object
		String getStringResponse = brandURL     //Specific Brand
				.resolveTemplate("brandId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(String.class);
		System.out.println(getStringResponse);
		
		
		System.out.println("\n\n/******  GET ALL Brands as Brands Entities   *********/");
		//GET where Response is received in a MODEL Object
		// **The MODEL must be accurate to match the incoming response
		Brand[] getModelResponse = baseBrandURL   //All Brands
				.request(MediaType.APPLICATION_JSON)
				.get(Brand[].class);  
		
		for (Brand brand : getModelResponse)
			System.out.println("Brand ID: "+brand.getBrandId() +"\t Brand Name: "+brand.getBrandName());
		
			
		System.out.println("\n\n/******  GET A Specific Brand with HATEOUS Links as a Brand Entity   *********/");
		//GET HATEOUS Response which is also received in a MODEL Object		
		Brand getHATEOUSResponse_specificBrand = brandURL   //Specific Brand
				.resolveTemplate("brandId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Brand.class);  
		
		System.out.println("Brand ID: "+getHATEOUSResponse_specificBrand.getBrandId() 
							+"\t Brand Name: "+getHATEOUSResponse_specificBrand.getBrandName()
							+"\n LINKS");
		Links [] links = getHATEOUSResponse_specificBrand.getLinks();
		for (Links link : links)
			System.out.println("\t Link: "+link.getLink() +"\t Rel: "+link.getRel());	
		
		
		
		System.out.println("\n\n\n/******  GET All Brands with HATEOUS Links as Brand Entities   *********/\n");	
		
		Brand[] getHATEOUSResponse_allBrands = baseBrandURL   //All Brands
				.request(MediaType.APPLICATION_JSON)
				.get(Brand[].class);  
		
		Links [] specificlinks;
		
		for (Brand brand : getHATEOUSResponse_allBrands) {
			System.out.println("Brand ID: "+brand.getBrandId() 
			+"\t Brand Name: "+brand.getBrandName()
			+"\n LINKS");
			
			specificlinks = brand.getLinks();
			for (Links link : specificlinks)
				System.out.println("\t Link: "+link.getLink() +"\t Rel: "+link.getRel());
		}
		
		 	
		
		
		
		
//		//2. /********    POST    *********/
//		Response postResponse = baseBrandURL
//									.request(MediaType.APPLICATION_JSON)
//									.post(Entity.json(new Brand("New Brand 16")));
//		System.out.println(postResponse);
//		System.out.println(postResponse.readEntity(String.class)); //to read the json POJO
		
		
		
		
//		//3. /********    PUT    *********/
//		System.out.println("\n\n\n/******  Updating Brand with Id 15   *********/\n");	
//		
//		Response putResponse = brandURL
//				.resolveTemplate("brandId", "15")
//				.request(MediaType.APPLICATION_JSON)
//				.put(Entity.json(new Brand("New Brand 15 Updated")));
//		System.out.println("Status Code of Operation: "+putResponse.getStatus());
//		
//		
//		
//		//4. /********    DELETE    *********/
//		System.out.println("\n\n\n/******  Deleting Brand with Id 16   *********/\n");	
//		
//		Response deleteResponse = brandURL
//				.resolveTemplate("brandId", "16")
//				.request()
//				.delete();
//		System.out.println("Status Code of Operation: "+deleteResponse.getStatus());
	}
}
