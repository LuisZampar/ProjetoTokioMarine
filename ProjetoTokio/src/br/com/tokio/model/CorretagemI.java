package br.com.tokio.model;

public class CorretagemI {
	
	private String cd_consulta;
	private String nm_empresa_cliente;
	private String ob_tipo_seguimento;
	private float vl_servico;
	private String cd_servico;
	private int id_endereco;
	private int id_cliente;
	
	//Construtor
	public CorretagemI() {
	}
	
	//Getters and Stters
	public String getCd_consulta() {
		return cd_consulta;
	}

	public void setCd_consulta(String cd_consulta) {
		this.cd_consulta = cd_consulta;
	}

	public String getNm_empresa_cliente() {
		return nm_empresa_cliente;
	}

	public void setNm_empresa_cliente(String nm_empresa_cliente) {
		this.nm_empresa_cliente = nm_empresa_cliente;
	}

	public String getOb_tipo_seguimento() {
		return ob_tipo_seguimento;
	}

	public void setOb_tipo_seguimento(String ob_tipo_seguimento) {
		this.ob_tipo_seguimento = ob_tipo_seguimento;
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
