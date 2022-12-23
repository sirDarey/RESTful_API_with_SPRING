package sirdarey.showroom;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import sirdarey.showroom.model.Brand;
import sirdarey.showroom.model.Links;
import sirdarey.showroom.services.BrandService;

@Path("/showroom/brands")
public class BrandsResource {
	
	BrandService brandService = new BrandService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Brand> getBrands(@Context UriInfo uriInfo) {
		
		List<Brand> brandsList = brandService.getBrands();
		
		brandsList.forEach(brand-> {
			List <Links> links = new ArrayList<>();
			
			links.add(new Links(uriInfo.getAbsolutePathBuilder()
									.path(String.valueOf(brand.getBrandId()))
									.build()
									.toString(), "self"));
			links.add(new Links(uriInfo.getAbsolutePathBuilder()
									.path(String.valueOf(brand.getBrandId()))
									.path("products")
									.build()
									.toString(), "products"));
			brand.setLink(links);
		});
		
		return brandsList;
	}
	
	@GET
	@Path("/{brandId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Brand getBrand(@PathParam("brandId") int brandId, @Context UriInfo uriInfo) {
		
		List <Links> links = new ArrayList<>();
		
		links.add(new Links(uriInfo.getAbsolutePath().toString(), "self")); // Self link is not a problem
		
		//For product link, this is used when we can easily access the ABSOLUTE PATH
//		links.add(new Links(uriInfo.getAbsolutePathBuilder()
//								.path("products")
//								.build()
//								.toString(), "products"));
		
		//******  Start of 2nd Method for adding productLink
		//Now, what  if we want to build the link from a sub-resource such as products
		String productUri = uriInfo.getBaseUriBuilder()
								.path(ProductsResource.class) //adds the class level path, "/showroom/brands"
								.path(ProductsResource.class, "getProductsByBrand") //adds the method level path, "/{brandId}/products"
								.resolveTemplate("brandId", brandId) //Resolves the brandId in the path as a variable
								.toString();
		Links productLink = new Links(productUri, "products");  //adding the productUri to a link
		links.add(productLink);   //Finally, adding the productLink to the Links list;
		
		//******** End of 2nd Method
		
		Brand brand = brandService.getBrand(brandId);
		brand.setLink(links);
		return brand;
	}
	
	//When Nothing is returned
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void addBrand(BrandEntity newBrand) {
//		brandService.addBrand(newBrand);
//	}
	
	//Now, when we want to return a response or even change the status code, we do it like this
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBrand(Brand newBrand, @Context UriInfo uriInfo) {
		brandService.addBrand(newBrand);
		
		// Now, when we want to return the location of this newly add resource with the response
		URI location = uriInfo.getAbsolutePathBuilder()
								.path(String.valueOf(newBrand.getBrandId()))
								.build();
		
		return Response.created(location).entity(newBrand).build();
	}
	
	@PUT
	@Path("/{brandId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBrand(@PathParam("brandId") int brandId,Brand updatedBrand) {
		updatedBrand.setBrandId(brandId);
		brandService.updateBrand(updatedBrand);
	}
	
	@DELETE
	@Path("/{brandId}")
	public void deleteBrand(@PathParam("brandId") int brandId) {
		brandService.deleteBrand(brandId);
	}
}
