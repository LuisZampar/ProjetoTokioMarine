package br.com.tokio.model;

import java.util.List;

public class Corretor {
	
	private List<Cliente> listaDeClientes;
	private String id_corretor;
	private String nm_corretor;
	private String ob_email_corretor;
	private String ob_senha_corretor;
	
	//Construtor
	public Corretor() {
	}

	//Getters and Setters 
	public String getId_corretor() {
		return id_corretor;
	}

	public void setId_corretor(String id_corretor) {
		this.id_corretor = id_corretor;
	}

	public String getNm_corretor() {
		return nm_corretor;
	}

	public void setNm_corretor(String nm_corretor) {
		this.nm_corretor = nm_corretor;
	}

	public String getOb_email_corretor() {
		return ob_email_corretor;
	}

	public void setOb_email_corretor(String ob_email_corretor) {
		this.ob_email_corretor = ob_email_corretor;
	}

	public String getOb_senha_corretor() {
		return ob_senha_corretor;
	}

	public void setOb_senha_corretor(String ob_senha_corretor) {
		this.ob_senha_corretor = ob_senha_corretor;
	}

	public List<Cliente> getListaDeClientes() {
		return listaDeClientes;
	}

	public void setListaDeClientes(List<Cliente> listaDeClientes) {
		this.listaDeClientes = listaDeClientes;
	}
	
	

}
