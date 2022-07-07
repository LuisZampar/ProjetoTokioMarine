package br.com.tokio.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import br.com.tokio.connectionFactory.ConnectionFactory;
import br.com.tokio.model.*;
import br.com.tokio.repository.CorretorDAO;

public class CorretorController {

	private CorretorDAO corretor;
	private Connection conexao = new ConnectionFactory().getConnection();

	public CorretorController() {
		this.corretor = new CorretorDAO(conexao);
	}
	public Corretor login(String email, String senha) {
		try {
			return corretor.login(email, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public DefaultTableModel selectClientes(String idCorretor, String sql) {
		List<Cliente> lista = null;
		try {
			lista = corretor.selectClientes(idCorretor,sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Nome");
		modelo.addColumn("CPF");
		modelo.addColumn("Data Nasc.");
		modelo.addColumn("Sexo");
		modelo.addColumn("RG");
		modelo.addColumn("CEP");
		modelo.addColumn("TEL");
		modelo.addColumn("Profissao");
		modelo.addColumn("Renda");
		modelo.addColumn("Email");

		if (lista == null) {
			return null;
		} else {
			for (Cliente cliente : lista) {

				modelo.addRow(new Object[] { cliente.getNm_cliente(), cliente.getNr_cpf_cliente(),
						cliente.getDt_nasc_cliente(), cliente.getOb_sexo_cliente(),
						cliente.getNr_rg_cliente(), cliente.getNr_cep_cliente(), cliente.getNr_tel_cliente(),
						cliente.getOb_profissao_cliente(), cliente.getVl_renda_mensal(),
						cliente.getOb_email_cliente() });
			}
			return modelo;
		}
	}
	public Object[] selectServicos(String apolice,String sql) {
		try {
			return corretor.selectServicos(apolice,sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public boolean delete(String apolice, String sql) {
		try {
			return corretor.delete(apolice,sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
}
