package org.itstep.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.model.PojoObject1;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;

@Repository
public class PojoObject1DAO {

	@Autowired
	HibernateUtil hiberUtil;

	public PojoObject1 save(PojoObject1 pojoObject1) {

		if (get(pojoObject1) == null) {

			Session session = hiberUtil.getSessionFactory().openSession();

			session.getTransaction().begin();
			session.saveOrUpdate(pojoObject1);
			session.getTransaction().commit();

			session.close();

			return get(pojoObject1);
		}

		return null;
	}

	public PojoObject1 get(PojoObject1 pojoObject1) {

		Session session = hiberUtil.getSessionFactory().openSession();

		session.getTransaction().begin();
		PojoObject1 pojoObject1FromDB = session.get(PojoObject1.class, pojoObject1.getId());
		session.getTransaction().commit();

		session.close();

		return pojoObject1FromDB;

	}

	public PojoObject1 update(PojoObject1 pojoObject1) {

		if (get(pojoObject1) != null) {

			Session session = hiberUtil.getSessionFactory().openSession();

			session.getTransaction().begin();
			session.saveOrUpdate(pojoObject1);
			session.getTransaction().commit();

			session.close();

			return get(pojoObject1);
		}

		return null;
	}

	public void delete(PojoObject1 pojoObject1) {

		Session session = hiberUtil.getSessionFactory().openSession();

		session.getTransaction().begin();
		session.delete(pojoObject1);
		session.getTransaction().commit();

		session.close();
	}
}
