package com.wordpress.felipebbarbosa.comboaninhado.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.wordpress.felipebbarbosa.comboaninhado.dao.Dao;
import com.wordpress.felipebbarbosa.comboaninhado.modelo.Pais;
import com.wordpress.felipebbarbosa.comboaninhado.util.HibernateUtil;

public class AbreCadastroCidadeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Session session = new HibernateUtil().getSession();
		List<Pais> paises = new Dao(session).listaPaises();
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("paises", paises);
		
		session.close();
		
		return mapping.findForward("ok");
		
	}
	
}
