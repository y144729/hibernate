package com.bdqn.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import com.bdqn.vo.Customer;


public class DemoTest {
	@Test
	public void a(){
		//���������ļ�
		Configuration con=new Configuration().configure();
		//��������
		SessionFactory factory = con.buildSessionFactory();
		//��session
		Session session = factory.openSession();
		//������
		Transaction transaction = session.beginTransaction();
		Customer c=new Customer();
		c.setAge(20);
		c.setCity("����");
		c.setName("���ڷ�");
		//ʹ��session��save�������
		session.save(c);
		transaction.commit();
	}
	@Test
	public void b(){
		        //���������ļ�
				Configuration con=new Configuration().configure();
				//��������
				SessionFactory factory = con.buildSessionFactory();
				//��session
				Session session = factory.openSession();
				//������
				Transaction transaction = session.beginTransaction();
				//����ID��ѯget/load
				Customer c = (Customer) session.get(Customer.class, 1);
				System.out.println(c);
				Customer c1=(Customer) session.load(Customer.class, 1);
				System.out.println(c1);
	}
	@Test
	public void c(){
		//���������ļ�
		Configuration con=new Configuration().configure();
		//��������
		SessionFactory factory = con.buildSessionFactory();
		//��session
		Session session = factory.openSession();
		//������
		Transaction transaction = session.beginTransaction();
	    Customer c=new Customer();
	    c.setId(3);
	    session.delete(c);
	    transaction.commit();
	}
	@Test
public void d(){
		//���������ļ�
				Configuration con=new Configuration().configure();
				//��������
				SessionFactory factory = con.buildSessionFactory();
				//��session
				Session session = factory.openSession();
				//������
				Transaction transaction = session.beginTransaction();
				Customer c=new Customer();
				c.setAge(17);
				c.setId(4);
				c.setName("���ڷ�");
				c.setCity("�ӱ�");
				session.update(c);
				transaction.commit();
}
	@Test
	public void e(){
		//���������ļ�
		Configuration con=new Configuration().configure();
		//��������
		SessionFactory factory = con.buildSessionFactory();
		//��session
		Session session = factory.openSession();
		//������
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	@Test
	public void f(){
		//���������ļ�
				Configuration con=new Configuration().configure();
				//��������
				SessionFactory factory = con.buildSessionFactory();
				//��session
				Session session = factory.openSession();
				//������
				Transaction transaction = session.beginTransaction();
				SQLQuery q = session.createSQLQuery("select * from customer");
				SQLQuery q1=q.addEntity(Customer.class);
				List<Customer> list = q1.list();
				for (Customer customer : list) {
					System.out.println(customer);
				}
	}
}
