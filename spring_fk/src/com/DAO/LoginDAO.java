package com.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.LoginVO;
import com.VO.RegVO;


@Repository
public class LoginDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void insert(LoginVO loginVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(loginVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	public void delete(LoginVO loginVO) {
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.delete(loginVO);
			transaction.commit();
			session.close();

		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	public List search(int id) {

		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from LoginVO where id="+id);

		List ls = q.list();
		session.close();

		return ls;
	}
}
