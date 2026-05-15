package org.jsp.MerchantProductApp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import org.jsp.MerchantProductApp.dto.Merchant;
import org.jsp.MerchantProductApp.dto.Product;

public class ProductDao {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	public Product addProduct(int mid, Product p) {
		EntityTransaction etran=em.getTransaction();
		etran.begin();
		Merchant mdb=em.find(Merchant.class,mid);
		if(mdb!=null) {
			p.setM(mdb);
			mdb.getProds().add(p);
			etran.commit();
			return p;
		}else {
			return null;
		}
	}
	public Product updateProduct(Product p) {
		EntityTransaction tran = em.getTransaction();
		tran.begin();
		Product pdb=em.find(Product.class, p.getId());
		if(pdb!=null) {
			pdb.setName(p.getName());
			pdb.setBrand(p.getBrand());
			pdb.setCategory(p.getCategory());
			pdb.setCost(p.getCost());
			tran.commit();
			return pdb;
		}
		else {
			return null;
		}
		
	}
	public java.util.List<Product> findProductById(int mid) {
		Query q = em.createQuery("select p from Product p where p.id=?1");
		q.setParameter(1,mid);
		java.util.List<Product> lpList=q.getResultList();
		return lpList;
		}
	public List<Product> findProductByBrandAndCategory(String br, String cat) {
		Query q = em.createQuery("select p from Product p where p.brand=?1 and p.category=?2");
		q.setParameter(1, br);
		q.setParameter(2, cat);
		List<Product> lpList=q.getResultList();
		return lpList;
	}
	
	public List<Product> findProductByMerchantId(int mid) {
		Query q = em.createQuery("select m.prods from Merchant m where m.id=?1");
		q.setParameter(1, mid);
		List<Product> lp=q.getResultList();
		return lp;
	}
}
