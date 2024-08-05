package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.StateVO;

@Repository
public class StateDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public  void Insert(StateVO stateVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(stateVO);
			transaction.commit();
			session.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<?> search() {

		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from StateVO");

		List<?> ls = q.list();
		session.close();

		return ls;
	}
	
	
}
