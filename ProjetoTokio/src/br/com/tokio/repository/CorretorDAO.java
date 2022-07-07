package br.com.tokio.repository;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;

import br.com.tokio.connectionFactory.*;
import br.com.tokio.model.*;

public class CorretorDAO {
	private Connection conexao;

	public CorretorDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public Corretor login(String email, String senha) throws SQLException {
		String sql = "SELECT * FROM tb_tok_corretor WHERE ob_email_corretor=? AND ob_senha_corretor=?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			if (rs.getRow() == 0) {
				System.out.println("não achou");
				rs.close();
				stmt.close();
				return null;
			} else {
				System.out.println("achou");
				Corretor corretor = new Corretor();
				corretor.setId_corretor(rs.getString("id_corretor"));
				corretor.setNm_corretor(rs.getString("nm_corretor"));
				corretor.setOb_email_corretor(rs.getString("ob_email_corretor"));
				corretor.setOb_senha_corretor(rs.getString("ob_senha_corretor"));
				
				rs.close();
				stmt.close();
				return corretor;
			}
		}
		return null;

	}

	public List<Cliente> selectClientes(String idCorretor, String sql) throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, idCorretor);
		ResultSet rs = stmt.executeQuery();
		List<Cliente> clientes = new ArrayList<Cliente>();
		while (rs.next()) {
			if (rs.getRow() == 0) {
				System.out.println(rs.getRow());
				System.out.println("não achou");
				rs.close();
				stmt.close();
				return null;
			} else {
				System.out.println(rs.getRow());
				System.out.println("achou");
				Cliente cliente = new Cliente();
				cliente.setId_cliente(rs.getLong("id_cliente"));
				cliente.setNm_cliente(rs.getString("nm_cliente"));
				cliente.setNr_cpf_cliente(rs.getString("nr_cpf_cliente"));
				cliente.setDt_nasc_cliente(rs.getString("dt_nasc_cliente"));
				cliente.setOb_sexo_cliente(rs.getString("ob_sexo_cliente").charAt(0));
				cliente.setNr_rg_cliente(rs.getString("nr_rg_cliente"));
				cliente.setNr_cep_cliente(rs.getString("nr_cep_cliente"));
				cliente.setNr_tel_cliente(rs.getString("nr_tel_cliente"));
				cliente.setOb_profissao_cliente(rs.getString("ob_profissao_cliente"));
				cliente.setVl_renda_mensal(rs.getFloat("vl_renda_mensal"));
				cliente.setOb_email_cliente(rs.getString("ob_email_cliente"));

				clientes.add(cliente);
				
			}
		}
		rs.close();
		stmt.close();
		return clientes;

	}
	public Object[] selectServicos(String apolice,String sql) throws SQLException {
		System.out.println("Funfa");
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, apolice);
		System.out.println("Funcionouuuuuuuuuu");
		ResultSet rs = stmt.executeQuery();
		
		System.out.println("Funcionou");
		Object[] objeto= new Object[10];
		
		while (rs.next()) {
			if (rs.getRow() == 0) {
				System.out.println(rs.getRow());
				System.out.println("não achou");
				rs.close();
				stmt.close();
				return null;
			} else {
				System.out.println(rs.getRow());
				System.out.println("achou");
				
		
				//valorservico,nomeempresa

				
				objeto[0]=rs.getString("nm_cliente"); //////cliente
				objeto[1]=rs.getString("ob_endereco");
				objeto[2]=rs.getString("ob_local_rural");
				objeto[3]=rs.getString("ob_portaria_eletr");
				objeto[4]=rs.getString("ob_habitacao_alvenaria");
				objeto[5]=rs.getString("vl_imovel");
				objeto[6]=rs.getString("ob_tipo_habitacao");////servico 
				objeto[7]=rs.getString("vl_servico");  /////////servico

				//clientes.add(cliente);
				
			}
		}
		rs.close();
		stmt.close();
		return objeto;
		
	}
	public boolean delete(String apolice, String sql)throws SQLException {
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, apolice);
		stmt.execute();
		stmt.close();
		return true;
		
		
		
	}

	
}
