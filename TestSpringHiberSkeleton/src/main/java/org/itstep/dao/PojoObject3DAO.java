package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.PojoObject3;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PojoObject3DAO {

	@Autowired
	HibernateUtil hiberUtil;

	public PojoObject3 save(PojoObject3 pojoObject3) {

		if (get(pojoObject3) == null) {

			Session session = hiberUtil.getSessionFactory().openSession();

			session.getTransaction().begin();
			session.saveOrUpdate(pojoObject3);
			session.getTransaction().commit();

			session.close();

			return get(pojoObject3);
		}

		return null;
	}

	public PojoObject3 get(PojoObject3 pojoObject3) {

		Session session = hiberUtil.getSessionFactory().openSession();

		session.getTransaction().begin();
		PojoObject3 pojoObject3FromDB = session.get(PojoObject3.class, pojoObject3.getId());
		session.getTransaction().commit();

		session.close();

		return pojoObject3FromDB;

	}

	public PojoObject3 update(PojoObject3 pojoObject3) {

		if (get(pojoObject3) != null) {

			Session session = hiberUtil.getSessionFactory().openSession();

			session.getTransaction().begin();
			session.saveOrUpdate(pojoObject3);
			session.getTransaction().commit();

			session.close();

			return get(pojoObject3);
		}

		return null;
	}

	public void delete(PojoObject3 pojoObject3) {

		Session session = hiberUtil.getSessionFactory().openSession();

		session.getTransaction().begin();
		session.delete(pojoObject3);
		session.getTransaction().commit();

		session.close();
	}
}
