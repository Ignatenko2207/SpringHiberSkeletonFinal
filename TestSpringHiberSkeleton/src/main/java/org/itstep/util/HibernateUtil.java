package org.itstep.util;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.itstep.model.PojoObject1;
import org.itstep.model.PojoObject2;
import org.itstep.model.PojoObject3;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HibernateUtil {

	private final SessionFactory sessionFactory = configureSessionFactory();

	/**
	 * Create SessionFactory
	 * 
	 * @return {@link SessionFactory}
	 * @throws HibernateException
	 */
	private SessionFactory configureSessionFactory() throws HibernateException {

		Configuration configuration = new Configuration();
		
		configuration.addAnnotatedClass(PojoObject1.class);
		configuration.addAnnotatedClass(PojoObject2.class);
		configuration.addAnnotatedClass(PojoObject3.class);

		return configuration.buildSessionFactory();

	}

	/**
	 * Get SessionFactory
	 * 
	 * @return {@link SessionFactory}
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}