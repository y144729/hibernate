package com.bdqn.test;


import hhh.hhhhh;

import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.bdqn.vo.Customer;

public class text1 {
	@Test
	public void a (){
		Configuration configure = new  Configuration().configure();	
	 SessionFactory factory = configure.buildSessionFactory();
	 Session session = factory.getCurrentSession();
	 Transaction transaction = (Transaction) session.beginTransaction();
	 Session session2 = factory.getCurrentSession();
	 System.out.println(session==session2);
	 
	 
	}
	@Test
	public void c(){
     Configuration configure = new Configuration().configure();
	SessionFactory sessionFactory =configure.buildSessionFactory();//获取工场
   Session session =sessionFactory.openSession();
	
	}
	@Test
	public void b(){
		org.hibernate.Session session = hhhhh.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		//添加条件
		criteria.add(Restrictions.like("name", "花%"));
		
		List<Customer> list=criteria.list();
		 for (Customer customer : list ){
			System.out.println(customer); 
			 
		 }
		
		
	}

}
