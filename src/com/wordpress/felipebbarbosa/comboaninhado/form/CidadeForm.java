package com.wordpress.felipebbarbosa.comboaninhado.form;

import org.apache.struts.action.ActionForm;

public class CidadeForm extends ActionForm {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long paisId;
	private Long estadoId;
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPaisId() {
		return paisId;
	}

	public void setPaisId(Long paisId) {
		this.paisId = paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Long estadoId) {
		this.estadoId = estadoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
