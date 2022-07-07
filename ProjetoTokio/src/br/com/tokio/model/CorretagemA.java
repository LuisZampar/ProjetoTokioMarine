package br.com.tokio.model;

public class CorretagemA {
	
	private String cd_consulta;
	private char ob_tipo_habitacao;
	private float vl_servico;
	private String cd_servico;
	private int id_endereco;
	private int id_cliente;
	
	//Construtor
	public CorretagemA() {

	}

	//Getters and Setters
	public String getCd_consulta() {
		return cd_consulta;
	}

	public void setCd_consulta(String cd_consulta) {
		this.cd_consulta = cd_consulta;
	}

	public char getOb_tipo_habitacao() {
		return ob_tipo_habitacao;
	}

	public void setOb_tipo_habitacao(char ob_tipo_habitacao) {
		this.ob_tipo_habitacao = ob_tipo_habitacao;
	}

	public float getVl_servico() {
		return vl_servico;
	}

	public void setVl_servico(float vl_servico) {
		this.vl_servico = vl_servico;
	}

	public String getCd_servico() {
		return cd_servico;
	}

	public void setCd_servico(String cd_servico) {
		this.cd_servico = cd_servico;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	

}
