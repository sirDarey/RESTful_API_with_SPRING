package sirdarey.showroom.services;

import java.util.List;

import sirdarey.showroom.DAOs.BrandDAO;
import sirdarey.showroom.model.Brand;

public class BrandService {

	BrandDAO brandDAO = new BrandDAO();
	
	public List<Brand> getBrands() {
		List <Brand> brandsList = brandDAO.getBrands();
		return brandsList;
	}

	public void addBrand(Brand newBrand) {
		brandDAO.addBrand(newBrand);
	}

	public void updateBrand(Brand updatedBrand) {
		brandDAO.updateBrand(updatedBrand);
	}

	public void deleteBrand(int brandId) {
		brandDAO.deleteBrand(brandId);
	}

	public Brand getBrand(int brandId) {
		return brandDAO.getBrand(brandId);
	}

}
