package sirdarey.showroom.services;

import java.util.List;

import sirdarey.showroom.DAOs.ProductDAO;
import sirdarey.showroom.model.Product;

public class ProductService {
	
	ProductDAO productDAO = new ProductDAO(); 

	public List<Product> getProductsByBrand(int brandId) {
		List <Product> productsList = productDAO.getProductsByBrand(brandId);
		return productsList;
	}

	public List<Product> getProductsByBrandAndCategory(int brandId, String category) {
		List <Product> productsList = productDAO.getProductsByBrandAndCategory(brandId, category);
		return productsList;
	}

}
