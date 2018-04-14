package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.PojoObject2;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PojoObject2DAO {

	@Autowired
	HibernateUtil hiberUtil;

	public PojoObject2 save(PojoObject2 pojoObject2) {

		if (get(pojoObject2) == null) {

			Session session = hiberUtil.getSessionFactory().openSession();

			session.getTransaction().begin();
			session.saveOrUpdate(pojoObject2);
			session.getTransaction().commit();

			session.close();

			return get(pojoObject2);
		}

		return null;
	}

	public PojoObject2 get(PojoObject2 pojoObject2) {

		Session session = hiberUtil.getSessionFactory().openSession();

		session.getTransaction().begin();
		PojoObject2 pojoObject2FromDB = session.get(PojoObject2.class, pojoObject2.getId());
		session.getTransaction().commit();

		session.close();

		return pojoObject2FromDB;

	}

	public PojoObject2 update(PojoObject2 pojoObject2) {

		if (get(pojoObject2) != null) {

			Session session = hiberUtil.getSessionFactory().openSession();

			session.getTransaction().begin();
			session.saveOrUpdate(pojoObject2);
			session.getTransaction().commit();

			session.close();

			return get(pojoObject2);
		}

		return null;
	}

	public void delete(PojoObject2 pojoObject2) {

		Session session = hiberUtil.getSessionFactory().openSession();

		session.getTransaction().begin();
		session.delete(pojoObject2);
		session.getTransaction().commit();

		session.close();
	}
}
