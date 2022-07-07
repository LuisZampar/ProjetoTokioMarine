package br.com.tokio.model;

public class Cliente {
	
	private long id_cliente;
	private String id_corretor;
	private String nm_cliente;
	private String nr_cpf_cliente;
	private String dt_nasc_cliente;
	private char ob_sexo_cliente;
	private String nr_rg_cliente;
	private String nr_cep_cliente;
	private String nr_tel_cliente;
	private String ob_profissao_cliente;
	private float vl_renda_mensal;
	private String ob_email_cliente;
	private String ds_senha_cliente;
	
	//Construtor
	public Cliente() {
	}

	//Setters and Getters 
	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getId_corretor() {
		return id_corretor;
	}

	public void setId_corretor(String id_corretor) {
		this.id_corretor = id_corretor;
	}

	public String getNm_cliente() {
		return nm_cliente;
	}

	public void setNm_cliente(String nm_cliente) {
		this.nm_cliente = nm_cliente;
	}

	public String getNr_cpf_cliente() {
		return nr_cpf_cliente;
	}

	public void setNr_cpf_cliente(String nr_cpf_cliente) {
		this.nr_cpf_cliente = nr_cpf_cliente;
	}

	public String getDt_nasc_cliente() {
		return dt_nasc_cliente;
	}

	public void setDt_nasc_cliente(String dt_nasc_cliente) {
		this.dt_nasc_cliente = dt_nasc_cliente;
	}

	public char getOb_sexo_cliente() {
		return ob_sexo_cliente;
	}

	public void setOb_sexo_cliente(char ob_sexo_cliente) {
		this.ob_sexo_cliente = ob_sexo_cliente;
	}

	public String getNr_rg_cliente() {
		return nr_rg_cliente;
	}

	public void setNr_rg_cliente(String nr_rg_cliente) {
		this.nr_rg_cliente = nr_rg_cliente;
	}

	public String getNr_cep_cliente() {
		return nr_cep_cliente;
	}

	public void setNr_cep_cliente(String nr_cep_cliente) {
		this.nr_cep_cliente = nr_cep_cliente;
	}

	public String getNr_tel_cliente() {
		return nr_tel_cliente;
	}

	public void setNr_tel_cliente(String nr_tel_cliente) {
		this.nr_tel_cliente = nr_tel_cliente;
	}

	public String getOb_profissao_cliente() {
		return ob_profissao_cliente;
	}

	public void setOb_profissao_cliente(String ob_profissao_cliente) {
		this.ob_profissao_cliente = ob_profissao_cliente;
	}

	public float getVl_renda_mensal() {
		return vl_renda_mensal;
	}

	public void setVl_renda_mensal(float vl_renda_mensal) {
		this.vl_renda_mensal = vl_renda_mensal;
	}

	public String getOb_email_cliente() {
		return ob_email_cliente;
	}

	public void setOb_email_cliente(String ob_email_cliente) {
		this.ob_email_cliente = ob_email_cliente;
	}

	public String getDs_senha_cliente() {
		return ds_senha_cliente;
	}

	public void setDs_senha_cliente(String ds_senha_cliente) {
		this.ds_senha_cliente = ds_senha_cliente;
	}
	
	

}
