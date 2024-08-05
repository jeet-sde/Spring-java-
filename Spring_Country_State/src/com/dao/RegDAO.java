package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.CountryVO;

@Repository
public class RegDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public  void Insert(CountryVO countryVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(countryVO);
			transaction.commit();
			session.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<?> search() {

		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from CountryVO");

		List<?> ls = q.list();
		session.close();

		return ls;
	}

	public  void  Delete(CountryVO countryVO){
		
		
	}
}
