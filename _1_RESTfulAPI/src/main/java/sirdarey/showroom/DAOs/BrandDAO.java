package sirdarey.showroom.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sirdarey.showroom.model.Brand;

public class BrandDAO {

	SessionFactory factory = new Configuration()
			.configure("hibernate.cfg.xml")
			.addAnnotatedClass(Brand.class)
			.buildSessionFactory();
	
	public List<Brand> getBrands() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Brand> list = session.createQuery("from brands").getResultList();
		return list;
	}

	@SuppressWarnings("deprecation")
	public void addBrand(Brand newBrand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(newBrand);
		session.getTransaction().commit();
	}

	public void updateBrand(Brand updatedBrand) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Brand brand = session.get(Brand.class, updatedBrand.getBrandId());
		brand.setBrandName(updatedBrand.getBrandName());
		session.getTransaction().commit();
	}

	@SuppressWarnings("deprecation")
	public void deleteBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Brand brand = session.get(Brand.class, brandId);
		session.delete(brand);
		session.getTransaction().commit();
	}

	public Brand getBrand(int brandId) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		return session.get(Brand.class, brandId);
	}

}
