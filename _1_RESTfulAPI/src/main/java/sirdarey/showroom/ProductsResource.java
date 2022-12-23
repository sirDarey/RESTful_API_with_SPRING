package sirdarey.showroom;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import sirdarey.showroom.model.Product;
import sirdarey.showroom.services.ProductService;

@Path("/showroom/brands")
public class ProductsResource {

	ProductService productService = new ProductService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{brandId}/products")
	public List<Product> getProductsByBrand(@PathParam("brandId") int brandId,
			@QueryParam("category") String category) {
		
		if (category != null)
			return productService.getProductsByBrandAndCategory(brandId, category);
		else
			return productService.getProductsByBrand(brandId);
	}
	
}
