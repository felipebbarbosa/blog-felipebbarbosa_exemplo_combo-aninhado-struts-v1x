package com.wordpress.felipebbarbosa.comboaninhado.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.wordpress.felipebbarbosa.comboaninhado.modelo.Cidade;
import com.wordpress.felipebbarbosa.comboaninhado.modelo.Estado;
import com.wordpress.felipebbarbosa.comboaninhado.modelo.Pais;

public class HibernateUtil {

private static SessionFactory factory;
	
	static {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		
		cfg.addAnnotatedClass(Cidade.class);
		cfg.addAnnotatedClass(Estado.class);
		cfg.addAnnotatedClass(Pais.class);
	
				
		factory = cfg.buildSessionFactory();		
	}
	
	public Session getSession() {
		Session session = factory.openSession();
		factory.close();		
		return session;
	}
	
}
