package com.wordpress.felipebbarbosa.comboaninhado.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;

import com.wordpress.felipebbarbosa.comboaninhado.dao.Dao;
import com.wordpress.felipebbarbosa.comboaninhado.form.CidadeForm;
import com.wordpress.felipebbarbosa.comboaninhado.modelo.Cidade;
import com.wordpress.felipebbarbosa.comboaninhado.modelo.Estado;
import com.wordpress.felipebbarbosa.comboaninhado.util.HibernateUtil;

public class CadastraCidadeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CidadeForm formulario = (CidadeForm) form;
		Long estadoId = formulario.getEstadoId();
		String nome = formulario.getNome();
		
		Session session = new HibernateUtil().getSession();
		Dao dao = new Dao(session);
		
		Estado estado = dao.loadEstado(estadoId);
		
		Cidade cidade = new Cidade();
		cidade.setEstado(estado);
		cidade.setNome(nome);
		
		dao.salvaCidade(cidade);
		session.close();
		
		return mapping.findForward("ok");
		
	}

}
