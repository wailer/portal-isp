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
@Component("serveisDao")
public class ServeisDao {


	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Servei> getServeis(String estat) {
		Criteria criteria = session().createCriteria(Servei.class);
		criteria.add(Restrictions.eq("estat",estat));		
		return criteria.list();		
	}

	public void saveOrUpdate(Servei servei) {
		session().saveOrUpdate(servei);		
	}

	public void delete(int id) {
		Query query = session()
				.createQuery("delete from Servei where id=:id");
		query.setLong("id", id);
		query.executeUpdate();		
	}

	@SuppressWarnings("unchecked")
	public List<ServeiDomini> getServeisDomini(String estat) {
		Criteria criteria = session().createCriteria(ServeiDomini.class);
		criteria.add(Restrictions.eq("estat",estat));		
		return criteria.list();			
	}

	public ServeiDomini getServeiDomini(int id) {
		Criteria criteria = session().createCriteria(ServeiDomini.class);		
		criteria.add(Restrictions.eq("id", id));
		return (ServeiDomini) criteria.uniqueResult();			
	}

	public void update(ServeiDomini serveiDomini) {
		session().update(serveiDomini);		
	}

	public ServeiAllotjament getServeiAllotjament(int id) {
		Criteria criteria = session().createCriteria(ServeiAllotjament.class);		
		criteria.add(Restrictions.eq("id", id));
		return (ServeiAllotjament) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<ServeiAllotjament> getServeisAllotjament(String estat) {
		Criteria criteria = session().createCriteria(ServeiAllotjament.class);
		criteria.add(Restrictions.eq("estat",estat));		
		return criteria.list();			
	}
	
	
	

}