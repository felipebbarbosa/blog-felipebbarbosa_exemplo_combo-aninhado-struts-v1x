package com.wordpress.felipebbarbosa.comboaninhado.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.wordpress.felipebbarbosa.comboaninhado.modelo.Cidade;
import com.wordpress.felipebbarbosa.comboaninhado.modelo.Estado;
import com.wordpress.felipebbarbosa.comboaninhado.modelo.Pais;

public class Dao {

	private Session session;
	
	public Dao(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Pais> listaPaises() {
		return this.session.createCriteria(Pais.class)
				.addOrder(Order.asc("nome")).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Estado> listaEstados(Pais pais) {
		return this.session.createCriteria(Estado.class)
				.add(Restrictions.eq("pais", pais))
				.addOrder(Order.asc("nome")).list();
	}
	
	public void salvaCidade(Cidade cidade) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(cidade);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public Pais loadPais(Long id) {		
		return (Pais) this.session.load(Pais.class, id);
	}

	public Estado loadEstado(Long id) {
		return (Estado) this.session.load(Estado.class, id);
	}
	
}
