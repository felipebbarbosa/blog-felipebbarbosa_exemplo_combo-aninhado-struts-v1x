package com.wordpress.felipebbarbosa.comboaninhado.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import com.wordpress.felipebbarbosa.comboaninhado.dao.Dao;
import com.wordpress.felipebbarbosa.comboaninhado.modelo.Estado;
import com.wordpress.felipebbarbosa.comboaninhado.modelo.Pais;
import com.wordpress.felipebbarbosa.comboaninhado.util.HibernateUtil;

public class CarregaEstadosAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String idPais = request.getParameter("pais");
		
		Session session = new HibernateUtil().getSession();
		Dao dao = new Dao(session);
		
		Pais pais = dao.loadPais(Long.parseLong(idPais));
		
		List<Estado> estados = dao.listaEstados(pais);
		
		JSONArray array = new JSONArray();
		for (Estado estado : estados) {
			JSONObject object = new JSONObject();
			
			object.put("id", estado.getId());
			object.put("nome", estado.getNome());
			
			array.put(object);
		}
		
		String jsonResult = array.toString();
		
		response.setContentType("text/javascript; charset=utf-8");
		response.getWriter().write(jsonResult);
		
		return null;
		
	}
	
}
