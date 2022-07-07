package br.com.tokio.views;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import br.com.tokio.connectionFactory.ConnectionFactory;
import br.com.tokio.controller.CorretorController;
import br.com.tokio.model.Corretor;
import br.com.tokio.repository.CorretorDAO;

import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.*;

public class Login extends JFrame {
	
	// panel principal
	private JButton btCliente, btCorretor;
	private JLabel lbHello, lbHelloTwo, imgLogoMain;

	// panel cliente
	private String passworld, login;
	private JTextField txLogin, txPassworld;
	private JLabel lbLogin, lbPassworld, lbHelloCliente, imgLogo;
	private JButton btSend, btRegister, btBackCliente;
	private JPanel pnLoginCliente, pnRegister, pnMain, pnLoginCorretor;

	// panel register
	private JTextField txName, txCpf, txDtNasc, txCep, txRg, txEmail, txJob, txRenda, txTel, txPassworldRegister,
			txPassworldConfirm;
	private JLabel lbTitleRegister, lbName, lbCpf, lbDtNasc, lbCep, lbRg, lbSexo, lbEmail, lbJob, lbRenda, lbTel,
			lbPassworldRegister, lbPassworldConfirm;
	private JComboBox cbSexo;
	private String[] vetCbSexo = { "Masculino", "Feminino", "Outro" };
	private JButton btRegisterDone, btBackRegister;

	// panel corretor
	private JTextField txLoginCorretor, txPassworldCorretor;
	private JLabel lbLoginCorretor, lbPassworldCorretor, lbHelloCorretor, imgLogoCorretor;
	private JButton btSendCorretor, btBackCorretor;

	public Login() {
		componentes();
		eventos();
	}

	public void componentes() {

		pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setVisible(true);

		imgLogoMain = new JLabel(new ImageIcon("images//tokio-marine-sem-fundo190x168.png"));
		imgLogoMain.setBounds(130, 30, 190, 168);
		pnMain.add(imgLogoMain);

		lbHello = new JLabel("Seja bem vindo!!!");
		lbHello.setBounds(100, 230, 300, 30);
		lbHello.setFont(new Font("Dialog", Font.BOLD, 30));
		lbHello.setForeground(Color.decode("#007256"));
		pnMain.add(lbHello);

		lbHelloTwo = new JLabel("Qual área você deseja entrar???");
		lbHelloTwo.setBounds(40, 270, 370, 30);
		lbHelloTwo.setFont(new Font("Dialog", Font.BOLD, 23));
		lbHelloTwo.setForeground(Color.decode("#007256"));
		pnMain.add(lbHelloTwo);

		btCliente = new JButton(new ImageIcon("images//logoCliente.jpg"));
		btCliente.setBounds(50, 340, 150, 150);
		btCliente.setFont(new Font("Dialog", Font.BOLD, 13));

		btCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btCliente);

		btCorretor = new JButton(new ImageIcon("images//logoCorretor.jpg"));
		btCorretor.setBounds(240, 340, 150, 150);
		btCorretor.setFont(new Font("Dialog", Font.BOLD, 13));
		btCorretor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btCorretor);

		//////////////////////////////////////////////////// PN
		//////////////////////////////////////////////////// CORRETOR////////////////////////////////////////////
		pnLoginCorretor = new JPanel();
		pnLoginCorretor.setLayout(null);
		pnLoginCorretor.setVisible(false);

		imgLogoCorretor = new JLabel(new ImageIcon("images//tokio-marine-sem-fundo190x168.png"));
		imgLogoCorretor.setBounds(130, 30, 190, 168);
		pnLoginCorretor.add(imgLogoCorretor);

		btBackCorretor = new JButton("Voltar");
		btBackCorretor.setBounds(10, 10, 60, 30);
		btBackCorretor.setFont(new Font("Dialog", Font.PLAIN, 9));
		btBackCorretor.setBackground(Color.decode("#007256"));
		btBackCorretor.setForeground(Color.WHITE);
		btBackCorretor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnLoginCorretor.add(btBackCorretor);

		pnLoginCorretor.add(imgLogoCorretor);

		lbHelloCorretor = new JLabel("Olá, Corretor");
		lbHelloCorretor.setFont(new Font("", Font.BOLD, 25));
		lbHelloCorretor.setBounds(150, 230, 240, 30);
		pnLoginCorretor.add(lbHelloCorretor);

		lbLoginCorretor = new JLabel("Email:");
		lbLoginCorretor.setFont(new Font("", Font.BOLD, 27));
		lbLoginCorretor.setBounds(50, 285, 100, 35);
		pnLoginCorretor.add(lbLoginCorretor);

		lbPassworldCorretor = new JLabel("Senha:");
		lbPassworldCorretor.setFont(new Font("", Font.BOLD, 27));
		lbPassworldCorretor.setBounds(50, 340, 100, 35);
		pnLoginCorretor.add(lbPassworldCorretor);

		txLoginCorretor = new JTextField();
		txPassworldCorretor = new JPasswordField();

		txLoginCorretor.setBounds(150, 280, 240, 45);
		txLoginCorretor.setFont(new Font("", Font.BOLD, 20));
		pnLoginCorretor.add(txLoginCorretor);

		txPassworldCorretor.setBounds(150, 335, 240, 45);
		txPassworldCorretor.setFont(new Font("", Font.BOLD, 20));
		pnLoginCorretor.add(txPassworldCorretor);

		btSendCorretor = new JButton("Logar");
		btSendCorretor.setBounds(150, 400, 165, 50);
		btSendCorretor.setFont(new Font("", Font.BOLD, 20));
		btSendCorretor.setBackground(Color.decode("#007256"));
		btSendCorretor.setForeground(Color.WHITE);
		btSendCorretor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnLoginCorretor.add(btSendCorretor);

		//////////////////////////////////////////////// PN
		//////////////////////////////////////////////// CLIENTE//////////////////////////////////////////

		pnLoginCliente = new JPanel();
		pnLoginCliente.setLayout(null);
		pnLoginCliente.setVisible(false);

		imgLogo = new JLabel(new ImageIcon("images//tokio-marine-sem-fundo190x168.png"));
		imgLogo.setBounds(130, 30, 190, 168);
		pnLoginCliente.add(imgLogo);

		btBackCliente = new JButton("Voltar");
		btBackCliente.setBounds(10, 10, 60, 30);
		btBackCliente.setFont(new Font("Dialog", Font.PLAIN, 9));
		btBackCliente.setBackground(Color.decode("#007256"));
		btBackCliente.setForeground(Color.WHITE);
		btBackCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnLoginCliente.add(btBackCliente);

		lbHelloCliente = new JLabel("Olá, Cliente");
		lbHelloCliente.setFont(new Font("", Font.BOLD, 25));
		lbHelloCliente.setBounds(150, 230, 240, 30);
		pnLoginCliente.add(lbHelloCliente);

		lbLogin = new JLabel("CPF:");
		lbLogin.setFont(new Font("", Font.BOLD, 27));
		lbLogin.setBounds(50, 285, 100, 35);
		pnLoginCliente.add(lbLogin);

		lbPassworld = new JLabel("Senha:");
		lbPassworld.setFont(new Font("", Font.BOLD, 27));
		lbPassworld.setBounds(50, 340, 100, 35);
		pnLoginCliente.add(lbPassworld);

		try {
			txLogin = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		txPassworld = new JPasswordField();

		txLogin.setBounds(150, 280, 240, 45);
		txLogin.setFont(new Font("", Font.BOLD, 20));
		pnLoginCliente.add(txLogin);

		txPassworld.setBounds(150, 335, 240, 45);
		txPassworld.setFont(new Font("", Font.BOLD, 20));
		pnLoginCliente.add(txPassworld);

		btSend = new JButton("Logar");
		btSend.setBounds(50, 400, 165, 50);
		btSend.setFont(new Font("", Font.BOLD, 20));
		btSend.setBackground(Color.decode("#007256"));
		btSend.setForeground(Color.WHITE);
		btSend.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnLoginCliente.add(btSend);

		btRegister = new JButton("Registrar");
		btRegister.setBounds(225, 400, 165, 50);
		btRegister.setFont(new Font("", Font.BOLD, 20));
		btRegister.setBackground(Color.decode("#007256"));
		btRegister.setForeground(Color.WHITE);
		btRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnLoginCliente.add(btRegister);

		////////////////////////////////////////////////////// PAINEL DE
		////////////////////////////////////////////////////// REGISTRO///////////////////////////////////////////////////////
		pnRegister = new JPanel();
		pnRegister.setLayout(null);
		pnRegister.setVisible(false);

		lbTitleRegister = new JLabel("NOVO CLIENTE");
		lbTitleRegister.setForeground(Color.decode("#007256"));
		lbTitleRegister.setFont(new Font("", Font.BOLD, 26));
		lbTitleRegister.setBounds(121, 57, 200, 27);
		pnRegister.add(lbTitleRegister);

		btBackRegister = new JButton("Voltar");
		btBackRegister.setBounds(10, 10, 60, 30);
		btBackRegister.setFont(new Font("Dialog", Font.PLAIN, 9));
		btBackRegister.setBackground(Color.decode("#007256"));
		btBackRegister.setForeground(Color.WHITE);
		btBackRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnRegister.add(btBackRegister);

		txName = new JTextField();
		txName.setBounds(100, 110, 320, 30);
		pnRegister.add(txName);

		try {
			txDtNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txDtNasc.setBounds(160, 155, 100, 30);
		pnRegister.add(txDtNasc);

		try {
			txCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		txCpf.setBounds(100, 203, 160, 30);
		pnRegister.add(txCpf);

		try {
			txCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txCep.setBounds(60, 250, 151, 30);
		pnRegister.add(txCep);

		try {
			txRg = new JFormattedTextField(new MaskFormatter("##.###.###-#"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txRg.setBounds(309, 203, 111, 30);
		pnRegister.add(txRg);

		// Combobox
		cbSexo = new JComboBox(vetCbSexo);
		cbSexo.setBounds(320, 155, 100, 30);
		cbSexo.setForeground(Color.decode("#007256"));
		pnRegister.add(cbSexo);

		txEmail = new JTextField();
		txEmail.setBounds(70, 385, 350, 30);
		pnRegister.add(txEmail);

		txJob = new JTextField();
		txJob.setBounds(100, 296, 320, 30);
		pnRegister.add(txJob);

		txRenda = new JTextField();
		txRenda.setBounds(221, 341, 121, 30);
		pnRegister.add(txRenda);

		try {
			txTel = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txTel.setBounds(296, 250, 124, 30);
		pnRegister.add(txTel);

		txPassworldRegister = new JPasswordField();
		txPassworldRegister.setBounds(75, 427, 125, 30);
		txPassworldRegister.setFont(new Font("", Font.BOLD, 20));
		pnRegister.add(txPassworldRegister);

		txPassworldConfirm = new JPasswordField();
		txPassworldConfirm.setBounds(296, 427, 125, 30);
		txPassworldConfirm.setFont(new Font("", Font.BOLD, 20));
		pnRegister.add(txPassworldConfirm);

		lbName = new JLabel("Nome: ");
		lbName.setFont(new Font("", Font.BOLD, 22));
		lbName.setForeground(Color.decode("#007256"));
		lbName.setBounds(20, 110, 73, 23);
		pnRegister.add(lbName);

		lbDtNasc = new JLabel("Data de nascimento: ");
		lbDtNasc.setFont(new Font("", Font.BOLD, 13));
		lbDtNasc.setForeground(Color.decode("#007256"));
		lbDtNasc.setBounds(20, 158, 134, 23);
		pnRegister.add(lbDtNasc);

		lbSexo = new JLabel("Sexo: ");
		lbSexo.setBounds(272, 158, 49, 23);
		lbSexo.setFont(new Font("", Font.BOLD, 14));
		lbSexo.setForeground(Color.decode("#007256"));
		pnRegister.add(lbSexo);

		lbCpf = new JLabel("CPF: ");
		lbCpf.setFont(new Font("", Font.BOLD, 14));
		lbCpf.setForeground(Color.decode("#007256"));
		lbCpf.setBounds(20, 205, 77, 23);
		pnRegister.add(lbCpf);

		lbRg = new JLabel("RG: ");
		lbRg.setBounds(272, 205, 29, 23);
		lbRg.setFont(new Font("", Font.BOLD, 14));
		lbRg.setForeground(Color.decode("#007256"));
		pnRegister.add(lbRg);

		lbCep = new JLabel("CEP: ");
		lbCep.setBounds(20, 252, 36, 23);
		lbCep.setFont(new Font("", Font.BOLD, 14));
		lbCep.setForeground(Color.decode("#007256"));
		pnRegister.add(lbCep);

		lbEmail = new JLabel("Email: ");
		lbEmail.setBounds(20, 388, 49, 23);
		lbEmail.setFont(new Font("", Font.BOLD, 14));
		lbEmail.setForeground(Color.decode("#007256"));
		pnRegister.add(lbEmail);

		lbJob = new JLabel("Profissão: ");
		lbJob.setBounds(20, 298, 77, 23);
		lbJob.setFont(new Font("", Font.BOLD, 14));
		lbJob.setForeground(Color.decode("#007256"));
		pnRegister.add(lbJob);

		lbRenda = new JLabel("Renda Mensal: ");
		lbRenda.setBounds(110, 343, 111, 23);
		lbRenda.setFont(new Font("", Font.BOLD, 14));
		lbRenda.setForeground(Color.decode("#007256"));
		pnRegister.add(lbRenda);

		lbPassworldRegister = new JLabel("Senha: ");
		lbPassworldRegister.setBounds(20, 430, 52, 23);
		lbPassworldRegister.setFont(new Font("", Font.BOLD, 14));
		lbPassworldRegister.setForeground(Color.decode("#007256"));
		pnRegister.add(lbPassworldRegister);

		lbPassworldConfirm = new JLabel("Confirmar: ");
		lbPassworldConfirm.setBounds(217, 430, 77, 23);
		lbPassworldConfirm.setFont(new Font("", Font.BOLD, 14));
		lbPassworldConfirm.setForeground(Color.decode("#007256"));
		pnRegister.add(lbPassworldConfirm);

		lbTel = new JLabel("Tel: ");
		lbTel.setBounds(261, 252, 29, 23);
		lbTel.setFont(new Font("", Font.BOLD, 14));
		lbTel.setForeground(Color.decode("#007256"));
		pnRegister.add(lbTel);

		btRegisterDone = new JButton("Registrar");
		btRegisterDone.setFont(new Font("", Font.BOLD, 20));
		btRegisterDone.setBackground(Color.decode("#007256"));
		btRegisterDone.setForeground(Color.WHITE);
		btRegisterDone.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btRegisterDone.setBounds(134, 468, 175, 60);
		pnRegister.add(btRegisterDone);

		this.getContentPane().add(pnMain);
	}

	public void eventos() {

		btCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				pnMain.setVisible(false);
				pnLoginCliente.setVisible(true);
				getContentPane().add(pnLoginCliente);

			}
		});

		btCorretor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				pnMain.setVisible(false);
				pnLoginCorretor.setVisible(true);
				getContentPane().add(pnLoginCorretor);

			}
		});

		btRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				pnLoginCliente.setVisible(false);
				pnRegister.setVisible(true);
				getContentPane().add(pnRegister);

			}
		});
		btBackRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txLogin.setText("");
				txPassworld.setText("");

				pnRegister.setVisible(false);
				pnLoginCliente.setVisible(true);
				getContentPane().add(pnLoginCliente);

				txName.setText("");
				txDtNasc.setText("");
				txCpf.setText("");
				txRg.setText("");
				txCep.setText("");
				txTel.setText("");
				txJob.setText("");
				txRenda.setText("");
				txEmail.setText("");
				txPassworldRegister.setText("");
				txPassworldConfirm.setText("");

			}
		});
		btBackCorretor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				pnLoginCorretor.setVisible(false);
				pnMain.setVisible(true);
				getContentPane().add(pnMain);

			}
		});
		btBackCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txLogin.setText("");
				txPassworld.setText("");

				pnLoginCliente.setVisible(false);
				pnMain.setVisible(true);
				getContentPane().add(pnMain);

			}
		});
		btRegisterDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {

				if (txName.getText().equals("")) {
					txName.requestFocus();
				} else if (txDtNasc.getText().equals("  /  /    ")) {
					txDtNasc.requestFocus();
				} else if (txCpf.getText().equals("   .   .   -  ")) {
					txCpf.requestFocus();
				} else if (txRg.getText().equals("  .   .   - ")) {
					txRg.requestFocus();
				} else if (txCep.getText().equals("     -   ")) {
					txCep.requestFocus();
				} else if (txTel.getText().equals("(  )      -    ")) {
					txTel.requestFocus();
				} else if (txJob.getText().equals("")) {
					txJob.requestFocus();
				} else if (txRenda.getText().equals("")) {
					txRenda.requestFocus();
				} else if (txEmail.getText().equals("")) {
					txEmail.requestFocus();
				} else if (txPassworldRegister.getText().equals("")) {
					txPassworldRegister.requestFocus();
				} else if (txPassworldConfirm.getText().equals("")) {
					txPassworldConfirm.requestFocus();
				} else {
					if (txPassworldRegister.getText().equals(txPassworldConfirm.getText())) {

						String name = txName.getText();
						String dtNasc = txDtNasc.getText();
						String cpf = txCpf.getText();
						String rg = txRg.getText();
						String cep = txCep.getText();
						String tel = txTel.getText();
						String job = txJob.getText();
						String renda = txRenda.getText();
						String email = txEmail.getText();
						String sexo = (String) cbSexo.getSelectedItem();
						String senha = txPassworldRegister.getText();
						;

						// Validar dados (Tamanhos)

						String[] options = { "Sim", "Não" };
						if (JOptionPane.showOptionDialog(null,
								"Confirma essas informações???" + "\n" + "\n Nome: " + name + "\n Data de nascimento: "
										+ dtNasc + "\n Sexo: " + sexo + "\n CPF: " + cpf + "\n RG: " + rg + "\n CEP: "
										+ cep + "\n TEL: " + tel + "\n Profissão: " + job + "\n Renda mensal: " + renda
										+ "\n Email: " + email + "\n Senha: " + senha,
								"Confirma essas informações?", JOptionPane.DEFAULT_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, options, options[0]) == 0) {

							if (cpf.equals("451.161.738-44")) { // verificar se não existe ninguém cadastrado

								// cadastrar no banco de dados

								JOptionPane.showMessageDialog(null,
										"Parabéns, " + name + "! \nVocê foi cadastrado com sucesso ",
										"Cadastrad0 com sucesso!!!!", JOptionPane.INFORMATION_MESSAGE);
								txName.setText("");
								txDtNasc.setText("");
								txCpf.setText("");
								txRg.setText("");
								txCep.setText("");
								txTel.setText("");
								txJob.setText("");
								txRenda.setText("");
								txEmail.setText("");
								txPassworldRegister.setText("");
								txPassworldConfirm.setText("");

								txLogin.setText("");
								txPassworld.setText("");

								pnRegister.setVisible(false);
								pnLoginCliente.setVisible(true);
								getContentPane().add(pnLoginCliente);

							} else {
								JOptionPane.showMessageDialog(null, "Já existe alguém cadastrado com esse CPF",
										"Inválido", JOptionPane.ERROR_MESSAGE);
							}

						} else {

						}

					} else {
						JOptionPane.showMessageDialog(null, "As senhas digitadas não são iguais", "Inválido",
								JOptionPane.ERROR_MESSAGE);
						txPassworldConfirm.setText("");
					}
				}
			}
		});
		btSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {

				if (txLogin.getText().equals("   .   .   -  ")) {
					txLogin.requestFocus();

				} else if (txPassworld.getText().equals("")) {
					txPassworld.requestFocus();

				} else {

					login = txLogin.getText();
					passworld = txPassworld.getText();

					if (login.equals("451.161.738-44") && passworld.equals("senha")) { // fazer busca no banco de dados

						disabled();
						InterfaceCliente cliente = new InterfaceCliente();
						cliente.setEnabled(true);

						cliente.close.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent argse) {
								cliente.close();
								enabled();
							}
						});

					} else {
						JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos", "Inválido",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		btSendCorretor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (txLoginCorretor.getText().equals("")) {
					txLoginCorretor.requestFocus();

				} else if (txPassworldCorretor.getText().equals("")) {
					txPassworldCorretor.requestFocus();

				} else {

					login = txLoginCorretor.getText();
					passworld = txPassworldCorretor.getText();
					
					
					CorretorController corretor = new CorretorController(); 
					
					Corretor corret = corretor.login(login,passworld);
						
					if (corret==null) { // fazer busca no
																									// banco de dados
						JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos", "Inválido",
								JOptionPane.ERROR_MESSAGE);

					} else {
						disabled();
						InterfaceCorretor corretos = new InterfaceCorretor(corret);
						corretos.setEnabled(true);

						corretos.close.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent argse) {
								corretos.close();
								enabled();
						

							}
						});
						
					}

				}

			}
		});

	}

	public void close() {
		System.exit(DISPOSE_ON_CLOSE);

	}

	public void disabled() {
		this.setEnabled(false);
	}

	public void enabled() {
		this.setEnabled(true);
	}

	public static void main(String Args[]) {
		Login frame = new Login();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Login");
		// frame.setUndecorated(true);
		frame.setBounds(0, 0, 450, 600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setIconImage(new ImageIcon("images//icon.png").getImage());
	}

}
