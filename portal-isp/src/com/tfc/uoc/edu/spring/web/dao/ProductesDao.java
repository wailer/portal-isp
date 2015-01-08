package com.tfc.uoc.edu.spring.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("productesDao")
public class ProductesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Producte> getProductes(boolean inactius) {
		if(inactius) {
			return session().createQuery("from Producte").list();
		}
		else {
		Criteria criteria = session().createCriteria(Producte.class);
		criteria.add(Restrictions.eq("actiu",true));		
		return criteria.list();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Domini> getDominis(boolean inactius) {
		if(inactius) {
			return session().createQuery("from Domini").list();
		}
		else {
		Criteria criteria = session().createCriteria(Domini.class);
		criteria.add(Restrictions.eq("actiu",true));		
		return criteria.list();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Allotjament> getAllotjaments(boolean inactius) {
		if(inactius) {
			return session().createQuery("from Allotjament").list();
		}
		else {
		Criteria criteria = session().createCriteria(Allotjament.class);
		criteria.add(Restrictions.eq("actiu",true));		
		return criteria.list();
		}
	}

	public void saveOrUpdate(Producte producte) {
		session().saveOrUpdate(producte);
	}

	public boolean delete(int id) {
		Query query = session()
				.createQuery("delete from Producte where id=:id");
		query.setLong("id", id);
		return query.executeUpdate() == 1;
	}

	public Producte getProducte(String codi) {
		Criteria criteria = session().createCriteria(Producte.class);		
		criteria.add(Restrictions.eq("codi", codi));
		return (Producte) criteria.uniqueResult();		
	}

	public void delete(String codi) {
		Query query = session().createQuery("delete from Producte where codi=:codi");
		query.setString("codi", codi);
		query.executeUpdate();		
	}

	public Domini getDomini(String codi) {
		Criteria criteria = session().createCriteria(Domini.class);
		criteria.add(Restrictions.eq("codi", codi));
		Domini domini  = (Domini)criteria.uniqueResult();
		return domini;		
	}

	public void update(Domini domini) {
		session().update(domini);
		
	}

	public Allotjament getAllotjament(String codi) {
		Criteria criteria = session().createCriteria(Allotjament.class);
		criteria.add(Restrictions.eq("codi", codi));
		Allotjament allotjament  = (Allotjament)criteria.uniqueResult();
		return allotjament;
	}




}
