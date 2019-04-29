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
		//加载配置文件
		Configuration con=new Configuration().configure();
		//创建工厂
		SessionFactory factory = con.buildSessionFactory();
		//打开session
		Session session = factory.openSession();
		//打开事务
		Transaction transaction = session.beginTransaction();
		Customer c=new Customer();
		c.setAge(20);
		c.setCity("北京");
		c.setName("马腾飞");
		//使用session的save方法添加
		session.save(c);
		transaction.commit();
	}
	@Test
	public void b(){
		        //加载配置文件
				Configuration con=new Configuration().configure();
				//创建工厂
				SessionFactory factory = con.buildSessionFactory();
				//打开session
				Session session = factory.openSession();
				//打开事务
				Transaction transaction = session.beginTransaction();
				//根据ID查询get/load
				Customer c = (Customer) session.get(Customer.class, 1);
				System.out.println(c);
				Customer c1=(Customer) session.load(Customer.class, 1);
				System.out.println(c1);
	}
	@Test
	public void c(){
		//加载配置文件
		Configuration con=new Configuration().configure();
		//创建工厂
		SessionFactory factory = con.buildSessionFactory();
		//打开session
		Session session = factory.openSession();
		//打开事务
		Transaction transaction = session.beginTransaction();
	    Customer c=new Customer();
	    c.setId(3);
	    session.delete(c);
	    transaction.commit();
	}
	@Test
public void d(){
		//加载配置文件
				Configuration con=new Configuration().configure();
				//创建工厂
				SessionFactory factory = con.buildSessionFactory();
				//打开session
				Session session = factory.openSession();
				//打开事务
				Transaction transaction = session.beginTransaction();
				Customer c=new Customer();
				c.setAge(17);
				c.setId(4);
				c.setName("马腾飞");
				c.setCity("河北");
				session.update(c);
				transaction.commit();
}
	@Test
	public void e(){
		//加载配置文件
		Configuration con=new Configuration().configure();
		//创建工厂
		SessionFactory factory = con.buildSessionFactory();
		//打开session
		Session session = factory.openSession();
		//打开事务
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	@Test
	public void f(){
		//加载配置文件
				Configuration con=new Configuration().configure();
				//创建工厂
				SessionFactory factory = con.buildSessionFactory();
				//打开session
				Session session = factory.openSession();
				//打开事务
				Transaction transaction = session.beginTransaction();
				SQLQuery q = session.createSQLQuery("select * from customer");
				SQLQuery q1=q.addEntity(Customer.class);
				List<Customer> list = q1.list();
				for (Customer customer : list) {
					System.out.println(customer);
				}
	}
}
