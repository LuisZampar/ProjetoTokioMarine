package br.com.tokio.connectionFactory;

import java.sql.*;

public class ConnectionFactory {
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
	private String user = "tm_luis_zampar";
	private String senha = "300704";

	public Connection getConnection() {

		try {
			Class.forName(driver);
			System.out.println("Conectado com sucesso");
			return DriverManager.getConnection(url, user, senha);

		} catch (ClassNotFoundException erro) {
			System.out.print("DEU ERRO NO DRIVE, NÃO FOI ENCONTRADO: " + erro.toString());
			throw new RuntimeException(erro);

		} catch (SQLException erro) {
			System.out.print("ERRO NO CAMINHO DO BANCO DE DADOS, ERRO NO ACESSO: " + erro.toString());
			throw new RuntimeException(erro);
		}
	}

}
