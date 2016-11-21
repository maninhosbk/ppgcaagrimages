package mvc_util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory SESSION_FACTORY;
	private static Logger log = Logger.getLogger(HibernateUtil.class);

	static {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			SESSION_FACTORY = new Configuration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			log.error("Initial SessionFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return SESSION_FACTORY.openSession();
	}
}
