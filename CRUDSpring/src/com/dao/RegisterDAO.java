package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.RegisterVO;

@Repository
public class RegisterDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void insert(RegisterVO regVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(regVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
			
		}
	
	public  List<?> search() {

		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from RegisterVO");

		List<?> ls = q.list();
		session.close();

		return ls;
	}
	
	public void delete(RegisterVO regVO){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(regVO);
		transaction.commit();
		session.close();		
	}
	
	public List<?> edit(RegisterVO regVO) {

		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from RegisterVO where id=" + regVO.getId());
		List<?> ls = q.list();
		session.close();

		return ls;
	
	
	}

}
