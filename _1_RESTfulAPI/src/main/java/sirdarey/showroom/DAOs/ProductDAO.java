package sirdarey.showroom.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sirdarey.showroom.model.Brand;
import sirdarey.showroom.model.Product;

public class ProductDAO {
	
	SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Product.class)
								.addAnnotatedClass(Brand.class)
								.buildSessionFactory();

	public List<Product> getProductsByBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		String sql = "FROM products WHERE brandId = "+brandId;
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Product> productsList = session.createQuery(sql).getResultList();
		return productsList;
	}

	public List<Product> getProductsByBrandAndCategory(int brandId, String category) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		String sql = "FROM products WHERE brandId = "+brandId+ " AND category = '"+category+"'";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Product> productsList = session.createQuery(sql).getResultList();
		return productsList;
	}

}
