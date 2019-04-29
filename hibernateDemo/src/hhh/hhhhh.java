package hhh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class hhhhh {
	private static SessionFactory sf;
	static{
		Configuration configuration = new Configuration().configure();
    sf=configuration.buildSessionFactory();	
	}
	public static Session openSession(){
		return sf.openSession();
	}
	public static Session createGreenSession(){
		return sf.getCurrentSession();
	}
	


}
