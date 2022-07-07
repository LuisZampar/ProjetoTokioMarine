package br.com.tokio.views;

import javax.swing.*;
import java.lang.reflect.Method;
import java.awt.*;
import java.awt.event.*;

public class InterfaceCliente extends JFrame {
	public JButton close;

	// Painel Lateral
	private JPanel pnMain;
	private JButton btMainServices, btMyServices, btHelpServices, btSeeSite;
	private JLabel lbImgUser, lbImgLogo, lbNameCliente;

	// Painel de comprar serviços
	private JPanel pnMainServices;
	private JButton btResidencial, btFianca, btImobiliario, btAuto, btVida, btAcidente;
	private JLabel lbTitleMainServices, lbTitleBuyServices, lbRecomendadosMainServices, lbMainServicesExplicacao;

	// Painel buy
	private JPanel pnBuy;
	private JLabel lbBuyTitle, lbBuyRural, lbBuyPortaria, lbBuyAlvenaria, lbBuyEndereco, lbBuyValor;
	private ButtonGroup gpRural, gpPortaria,gpAlvenaria;
	private JRadioButton rbBuyRuralSim, rbBuyPortariaSim, rbBuyAlvenariaSim, rbBuyRuralNao, rbBuyPortariaNao,
			rbBuyAlvenariaNao;
	private JTextField txBuyEndereco, txBuyValor;
	private JButton btBuyCancel, btBuyNext;

	// Painel seguro Residencial
	private JPanel pnResidencial;
	private JLabel lbResidencialTitle, lbResidencialTipo, lbResidencialValor;
	private JTextField txResidencialTipo;
	private double valorResidencial = 700;
	private JButton btResidencialVoltar, btResidencialCancel, btResidencialConfirm;

	// Painel seguro fiança
	private JPanel pnFianca;
	private JLabel lbFiancaTitle, lbFiancaTipo, lbFiancaValor;
	private JTextField txFiancaTipo;
	private double valorFianca = 600;
	private JButton btFiancaVoltar, btFiancaCancel, btFiancaConfirm;

	// Painel seguro Imobiliario
	private JPanel pnImobiliario;
	private JLabel lbImobiliarioTitle, lbImobiliarioTipo, lbImobiliarioValor, lbImobiliarioEmpresa;
	private JTextField txImobiliarioTipo, txImobiliarioEmpresa;
	private double valorImobiliario = 1000;
	private JButton btImobiliarioVoltar, btImobiliarioCancel, btImobiliarioConfirm;

	// Painel meus serviços
	private JPanel pnMyServices;
	private JLabel lbMyServicesTitle, lbMyServicesExplicacao;

	// Painel Ajuda
	private JPanel pnHelp;
	private JLabel lbHelpTitle, lbHelpServicos, lbHelpTextArea, lbHelpExplicacao;
	private JTextArea txaHelpMessage;
	private JButton btHelpSend;
	private JComboBox cbHelpServicos;

	public InterfaceCliente() {
		componentes();
		eventos();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setBounds(0, 0, 700, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setIconImage(new ImageIcon("images//icon.png").getImage());
	}

	public void componentes() {
		getContentPane().setLayout(null);

		//////////////////////////////////// PAINEL
		//////////////////////////////////// LATEAL/////////////////////////////////////
		pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBackground(Color.decode("#007256"));
		pnMain.setBounds(0, 0, 175, 600);
		pnMain.setVisible(true);

		btMainServices = new JButton("HOME");
		btMainServices.setBounds(0, 204, 175, 40);
		btMainServices.setFont(new Font("Dialog", Font.PLAIN, 11));
		btMainServices.setBackground(Color.decode("#007256"));
		btMainServices.setForeground(Color.WHITE);
		btMainServices.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btMainServices);

		lbImgUser = new JLabel(new ImageIcon("images//user-branco.png"));
		lbImgUser.setBounds(20, 10, 135, 135);
		pnMain.add(lbImgUser);

		lbImgLogo = new JLabel(new ImageIcon("images//logo-tokio-marine-seguradora-branco.png"));
		lbImgLogo.setBounds(10, 550, 155, 36);
		pnMain.add(lbImgLogo);

		lbNameCliente = new JLabel(
				"<html><body><center>Julio Cesar Lopes Batista <br>Corretor: FREDINHO <center></body></html>"); // Colocar
																												// nome
																												// do
																												// cliente
		lbNameCliente.setBounds(10, 165, 165, 25);
		lbNameCliente.setFont(new Font("Dialog", Font.BOLD, 12));
		lbNameCliente.setForeground(Color.WHITE);
		pnMain.add(lbNameCliente);

		btMyServices = new JButton("Meus Seguros");
		btMyServices.setBounds(0, 244, 175, 40);
		btMyServices.setFont(new Font("Dialog", Font.PLAIN, 11));
		btMyServices.setBackground(Color.decode("#007256"));
		btMyServices.setForeground(Color.WHITE);
		btMyServices.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btMyServices);

		btHelpServices = new JButton("Ajuda");
		btHelpServices.setBounds(0, 284, 175, 40);
		btHelpServices.setFont(new Font("Dialog", Font.PLAIN, 11));
		btHelpServices.setBackground(Color.decode("#007256"));
		btHelpServices.setForeground(Color.WHITE);
		btHelpServices.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btHelpServices);

		btSeeSite = new JButton("Visite o site");
		btSeeSite.setBounds(0, 324, 175, 40);
		btSeeSite.setFont(new Font("Dialog", Font.PLAIN, 11));
		btSeeSite.setBackground(Color.decode("#007256"));
		btSeeSite.setForeground(Color.WHITE);
		btSeeSite.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btSeeSite);

		close = new JButton("Sair");
		close.setForeground(Color.WHITE);
		close.setBounds(0, 364, 175, 40);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		close.setFont(new Font("Dialog", Font.PLAIN, 15));
		close.setBackground(Color.decode("#007256"));
		pnMain.add(close);
		//////////////////////////////////// FIM PAINEL
		//////////////////////////////////// LATEAL/////////////////////////////////////

		///////////////////////////////////////// PAINEL
		///////////////////////////////////////// PRINCIPAL////////////////////////////////////////

		pnMainServices = new JPanel();
		pnMainServices.setLayout(null);
		pnMainServices.setVisible(true);
		pnMainServices.setBounds(177, 0, 525, 600);

		lbTitleMainServices = new JLabel("HOME");
		lbTitleMainServices.setBounds(217, 45, 75, 20);
		lbTitleMainServices.setFont(new Font("Dialog", Font.BOLD, 25));
		pnMainServices.add(lbTitleMainServices);

		lbMainServicesExplicacao = new JLabel(
				"<html><body><center>Bem vindo a área do cliente!!!<br> Aqui você pode adiquirir, ver serviços e muito mais!!!<br><center></body></html>");
		lbMainServicesExplicacao.setBounds(106, 93, 312, 60);
		lbMainServicesExplicacao.setFont(new Font("Dialog", Font.PLAIN, 15));
		pnMainServices.add(lbMainServicesExplicacao);

		lbTitleBuyServices = new JLabel("ADQUIRA UM NOVO SEGURO RESIDENCIAL");
		lbTitleBuyServices.setBounds(48, 185, 430, 20);
		lbTitleBuyServices.setFont(new Font("Dialog", Font.BOLD, 20));
		pnMainServices.add(lbTitleBuyServices);

		//////////////////////////////////////////////////////////// Painel
		//////////////////////////////////////////////////////////// compra//////////////////////////////////////////////////////

		pnBuy = new JPanel();
		pnBuy.setLayout(null);
		pnBuy.setVisible(false);
		pnBuy.setBounds(177, 0, 525, 600);

		lbBuyTitle = new JLabel("Titulo");
		lbBuyTitle.setBounds(189, 45, 208, 65);
		lbBuyTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		pnBuy.add(lbBuyTitle);

		lbBuyEndereco = new JLabel("<html><body>Digite o endereço do imóvel<br> que deseja assegurar: </body></html>");
		lbBuyEndereco.setFont(new Font("Dialog", Font.BOLD, 14));
		lbBuyEndereco.setBounds(89, 125, 208, 35);
		pnBuy.add(lbBuyEndereco);

		lbBuyRural = new JLabel("Sua propriedade é uma propriedade rural?");
		lbBuyRural.setFont(new Font("Dialog", Font.BOLD, 14));
		lbBuyRural.setBounds(89, 210, 300, 15);
		pnBuy.add(lbBuyRural);

		lbBuyPortaria = new JLabel("Sua propriedade possui portaria el\u00E9trica?");
		lbBuyPortaria.setFont(new Font("Dialog", Font.BOLD, 14));
		lbBuyPortaria.setBounds(89, 264, 293, 15);
		pnBuy.add(lbBuyPortaria);

		lbBuyAlvenaria = new JLabel("Sua propriedade possui alvenária?");
		lbBuyAlvenaria.setFont(new Font("Dialog", Font.BOLD, 14));
		lbBuyAlvenaria.setBounds(89, 318, 246, 15);
		pnBuy.add(lbBuyAlvenaria);

		lbBuyValor = new JLabel("Qual o valor da sua propriedade?");
		lbBuyValor.setFont(new Font("Dialog", Font.BOLD, 14));
		lbBuyValor.setBounds(89, 370, 242, 15);
		pnBuy.add(lbBuyValor);

		rbBuyRuralSim = new JRadioButton("Sim");
		rbBuyRuralSim.setSelected(true);
		rbBuyRuralSim.setBounds(100, 230, 50, 20);
		pnBuy.add(rbBuyRuralSim);

		rbBuyRuralNao = new JRadioButton("Não");
		rbBuyRuralNao.setBounds(160, 230, 50, 20);
		pnBuy.add(rbBuyRuralNao);
		
		gpRural = new ButtonGroup();
		gpRural.add(rbBuyRuralSim);
		gpRural.add(rbBuyRuralNao);

		rbBuyPortariaSim = new JRadioButton("Sim");
		rbBuyPortariaSim.setSelected(true);
		rbBuyPortariaSim.setBounds(100, 284, 50, 20);
		pnBuy.add(rbBuyPortariaSim);

		rbBuyPortariaNao = new JRadioButton("Não");
		rbBuyPortariaNao.setBounds(160, 284, 50, 20);
		pnBuy.add(rbBuyPortariaNao);

		gpPortaria = new ButtonGroup();
		gpPortaria.add(rbBuyPortariaSim);
		gpPortaria.add(rbBuyPortariaNao);
		
		rbBuyAlvenariaSim = new JRadioButton("Sim");
		rbBuyAlvenariaSim.setSelected(true);
		rbBuyAlvenariaSim.setBounds(100, 338, 50, 20);
		pnBuy.add(rbBuyAlvenariaSim);

		rbBuyAlvenariaNao = new JRadioButton("Não");
		rbBuyAlvenariaNao.setBounds(160, 338, 50, 20);
		pnBuy.add(rbBuyAlvenariaNao);
		
		gpAlvenaria = new ButtonGroup();
		gpAlvenaria.add(rbBuyAlvenariaSim);
		gpAlvenaria.add(rbBuyAlvenariaNao);

		txBuyEndereco = new JTextField();
		txBuyEndereco.setBounds(89, 170, 359, 25);
		txBuyEndereco.setFont(new Font("Dialog", Font.PLAIN, 15));
		pnBuy.add(txBuyEndereco);

		txBuyValor = new JTextField();
		txBuyValor.setFont(new Font("Dialog", Font.PLAIN, 15));
		txBuyValor.setBounds(89, 396, 145, 25);
		pnBuy.add(txBuyValor);

		btBuyCancel = new JButton("Cancelar");
		btBuyCancel.setBounds(89, 455, 165, 65);
		btBuyCancel.setFont(new Font("", Font.BOLD, 20));
		btBuyCancel.setBackground(Color.decode("#007256"));
		btBuyCancel.setForeground(Color.WHITE);
		btBuyCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnBuy.add(btBuyCancel);

		btBuyNext = new JButton("Próximo");
		btBuyNext.setBounds(283, 455, 165, 65);
		btBuyNext.setFont(new Font("", Font.BOLD, 20));
		btBuyNext.setBackground(Color.decode("#007256"));
		btBuyNext.setForeground(Color.WHITE);
		btBuyNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnBuy.add(btBuyNext);

		//////////////////////////////////////////////////////////// FIM Painel
		//////////////////////////////////////////////////////////// compra//////////////////////////////////////////////////////

		btResidencial = new JButton("Residencial Premiado");
		btResidencial.setBounds(25, 220, 145, 80);
		btResidencial.setFont(new Font("Dialog", Font.PLAIN, 11));
		btResidencial.setBackground(Color.decode("#007256"));
		btResidencial.setForeground(Color.WHITE);
		btResidencial.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMainServices.add(btResidencial);

		//////////////////////////////////////////////////////////// Painel compra
		//////////////////////////////////////////////////////////// Residencial//////////////////////////////////////////////////////
		pnResidencial = new JPanel();
		pnResidencial.setLayout(null);
		pnResidencial.setBounds(176, 0, 525, 600);
		pnResidencial.setVisible(false);

		lbResidencialTitle = new JLabel("<html><body><center>Residencial <br> Premiado</center></body></html>");
		lbResidencialTitle.setBounds(189, 45, 208, 65);
		lbResidencialTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		pnResidencial.add(lbResidencialTitle);

		btResidencialVoltar = new JButton("Voltar");
		btResidencialVoltar.setBounds(51, 53, 60, 30);
		btResidencialVoltar.setFont(new Font("Dialog", Font.PLAIN, 9));
		btResidencialVoltar.setBackground(Color.decode("#007256"));
		btResidencialVoltar.setForeground(Color.WHITE);
		btResidencialVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnResidencial.add(btResidencialVoltar);

		lbResidencialTipo = new JLabel("Qual o tipo da sua residência?");
		lbResidencialTipo.setFont(new Font("Dialog", Font.BOLD, 22));
		lbResidencialTipo.setBounds(111, 179, 307, 37);
		pnResidencial.add(lbResidencialTipo);

		lbResidencialValor = new JLabel("Valor: " + valorResidencial + " R$/MÊS");
		lbResidencialValor.setFont(new Font("Dialog", Font.BOLD, 30));
		lbResidencialValor.setBounds(132, 309, 290, 30);
		pnResidencial.add(lbResidencialValor);

		txResidencialTipo = new JTextField();
		txResidencialTipo.setBounds(89, 227, 359, 37);
		txResidencialTipo.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnResidencial.add(txResidencialTipo);

		btResidencialCancel = new JButton("Cancelar");
		btResidencialCancel.setBounds(89, 400, 165, 65);
		btResidencialCancel.setFont(new Font("", Font.BOLD, 20));
		btResidencialCancel.setBackground(Color.decode("#007256"));
		btResidencialCancel.setForeground(Color.WHITE);
		btResidencialCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnResidencial.add(btResidencialCancel);

		btResidencialConfirm = new JButton("Adquirir");
		btResidencialConfirm.setBounds(283, 400, 165, 65);
		btResidencialConfirm.setFont(new Font("", Font.BOLD, 20));
		btResidencialConfirm.setBackground(Color.decode("#007256"));
		btResidencialConfirm.setForeground(Color.WHITE);
		btResidencialConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnResidencial.add(btResidencialConfirm);
		//////////////////////////////////////////////////////////// FIM Painel compra
		//////////////////////////////////////////////////////////// Residencial//////////////////////////////////////////////////////

		btFianca = new JButton("Fian\u00E7a Locat\u00EDcia - Aluguel");
		btFianca.setBounds(188, 220, 147, 80);
		btFianca.setFont(new Font("Dialog", Font.PLAIN, 9));
		btFianca.setBackground(Color.decode("#007256"));
		btFianca.setForeground(Color.WHITE);
		btFianca.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMainServices.add(btFianca);

		//////////////////////////////////////////////////////////// Painel compra
		//////////////////////////////////////////////////////////// Aluguel//////////////////////////////////////////////////////
		pnFianca = new JPanel();
		pnFianca.setLayout(null);
		pnFianca.setBounds(176, 0, 525, 600);
		pnFianca.setVisible(false);

		lbFiancaTitle = new JLabel("<html><body><center>Fiança Locática <br> Aluguel</center></body></html>");
		lbFiancaTitle.setBounds(189, 45, 208, 65);
		lbFiancaTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		pnFianca.add(lbFiancaTitle);

		btFiancaVoltar = new JButton("Voltar");
		btFiancaVoltar.setBounds(51, 53, 60, 30);
		btFiancaVoltar.setFont(new Font("Dialog", Font.PLAIN, 9));
		btFiancaVoltar.setBackground(Color.decode("#007256"));
		btFiancaVoltar.setForeground(Color.WHITE);
		btFiancaVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnFianca.add(btFiancaVoltar);

		lbFiancaTipo = new JLabel("Qual o tipo da sua residência?");
		lbFiancaTipo.setFont(new Font("Dialog", Font.BOLD, 22));
		lbFiancaTipo.setBounds(111, 179, 307, 37);
		pnFianca.add(lbFiancaTipo);

		lbFiancaValor = new JLabel("Valor: " + valorFianca + " R$/MÊS");
		lbFiancaValor.setFont(new Font("Dialog", Font.BOLD, 30));
		lbFiancaValor.setBounds(132, 309, 290, 30);
		pnFianca.add(lbFiancaValor);

		txFiancaTipo = new JTextField();
		txFiancaTipo.setBounds(89, 227, 359, 37);
		txFiancaTipo.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnFianca.add(txFiancaTipo);

		btFiancaCancel = new JButton("Cancelar");
		btFiancaCancel.setBounds(89, 400, 165, 65);
		btFiancaCancel.setFont(new Font("", Font.BOLD, 20));
		btFiancaCancel.setBackground(Color.decode("#007256"));
		btFiancaCancel.setForeground(Color.WHITE);
		btFiancaCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnFianca.add(btFiancaCancel);

		btFiancaConfirm = new JButton("Adiquirir");
		btFiancaConfirm.setBounds(283, 400, 165, 65);
		btFiancaConfirm.setFont(new Font("", Font.BOLD, 20));
		btFiancaConfirm.setBackground(Color.decode("#007256"));
		btFiancaConfirm.setForeground(Color.WHITE);
		btFiancaConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnFianca.add(btFiancaConfirm);

		//////////////////////////////////////////////////////////// FIM Painel compra
		//////////////////////////////////////////////////////////// Aluguel//////////////////////////////////////////////////////

		btImobiliario = new JButton("Imobili\u00E1rio");
		btImobiliario.setBounds(354, 220, 145, 80);
		btImobiliario.setFont(new Font("Dialog", Font.PLAIN, 11));
		btImobiliario.setBackground(Color.decode("#007256"));
		btImobiliario.setForeground(Color.WHITE);
		btImobiliario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMainServices.add(btImobiliario);

		//////////////////////////////////////////////////////////// Painel compra
		//////////////////////////////////////////////////////////// Imobiliario//////////////////////////////////////////////////////
		pnImobiliario = new JPanel();
		pnImobiliario.setLayout(null);
		pnImobiliario.setBounds(176, 0, 525, 600);
		pnImobiliario.setVisible(false);

		lbImobiliarioTitle = new JLabel("<html><body><center>Imobiliário</center></body></html>");
		lbImobiliarioTitle.setBounds(189, 45, 208, 65);
		lbImobiliarioTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		pnImobiliario.add(lbImobiliarioTitle);

		btImobiliarioVoltar = new JButton("Voltar");
		btImobiliarioVoltar.setBounds(51, 53, 60, 30);
		btImobiliarioVoltar.setFont(new Font("Dialog", Font.PLAIN, 9));
		btImobiliarioVoltar.setBackground(Color.decode("#007256"));
		btImobiliarioVoltar.setForeground(Color.WHITE);
		btImobiliarioVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnImobiliario.add(btImobiliarioVoltar);

		lbImobiliarioTipo = new JLabel("Qual o segmento da sua empresa?");
		lbImobiliarioTipo.setFont(new Font("Dialog", Font.BOLD, 22));
		lbImobiliarioTipo.setBounds(89, 281, 359, 37);
		pnImobiliario.add(lbImobiliarioTipo);

		lbImobiliarioEmpresa = new JLabel("Qual o nome da sua empresa?");
		lbImobiliarioEmpresa.setFont(new Font("Dialog", Font.BOLD, 22));
		lbImobiliarioEmpresa.setBounds(110, 179, 310, 37);
		pnImobiliario.add(lbImobiliarioEmpresa);

		txImobiliarioEmpresa = new JTextField();
		txImobiliarioEmpresa.setBounds(89, 227, 359, 37);
		txImobiliarioEmpresa.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnImobiliario.add(txImobiliarioEmpresa);

		lbImobiliarioValor = new JLabel("Valor: " + valorImobiliario + " R$/MÊS");
		lbImobiliarioValor.setFont(new Font("Dialog", Font.BOLD, 30));
		lbImobiliarioValor.setBounds(110, 397, 405, 30);
		pnImobiliario.add(lbImobiliarioValor);

		txImobiliarioTipo = new JTextField();
		txImobiliarioTipo.setBounds(89, 329, 359, 37);
		txImobiliarioTipo.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnImobiliario.add(txImobiliarioTipo);

		btImobiliarioCancel = new JButton("Cancelar");
		btImobiliarioCancel.setBounds(89, 455, 165, 65);
		btImobiliarioCancel.setFont(new Font("", Font.BOLD, 20));
		btImobiliarioCancel.setBackground(Color.decode("#007256"));
		btImobiliarioCancel.setForeground(Color.WHITE);
		btImobiliarioCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnImobiliario.add(btImobiliarioCancel);

		btImobiliarioConfirm = new JButton("Adiquirir");
		btImobiliarioConfirm.setBounds(283, 455, 165, 65);
		btImobiliarioConfirm.setFont(new Font("", Font.BOLD, 20));
		btImobiliarioConfirm.setBackground(Color.decode("#007256"));
		btImobiliarioConfirm.setForeground(Color.WHITE);
		btImobiliarioConfirm.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnImobiliario.add(btImobiliarioConfirm);
		//////////////////////////////////////////////////////////// FIM Painel compra
		//////////////////////////////////////////////////////////// Imobiliario//////////////////////////////////////////////////////

		lbRecomendadosMainServices = new JLabel("CATEGORIAS RECOMENDADAS");
		lbRecomendadosMainServices.setBounds(113, 390, 309, 20);
		lbRecomendadosMainServices.setFont(new Font("Dialog", Font.BOLD, 20));
		pnMainServices.add(lbRecomendadosMainServices);

		btAuto = new JButton("Automóveis");
		btAuto.setBounds(25, 425, 145, 80);
		btAuto.setFont(new Font("Dialog", Font.PLAIN, 12));
		btAuto.setBackground(Color.decode("#007256"));
		btAuto.setForeground(Color.WHITE);
		btAuto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMainServices.add(btAuto);

		btVida = new JButton("Vida");
		btVida.setBounds(188, 425, 147, 80);
		btVida.setFont(new Font("Dialog", Font.PLAIN, 12));
		btVida.setBackground(Color.decode("#007256"));
		btVida.setForeground(Color.WHITE);
		btVida.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMainServices.add(btVida);

		btAcidente = new JButton("Acidentes Pessoais");
		btAcidente.setBounds(354, 425, 145, 80);
		btAcidente.setFont(new Font("Dialog", Font.PLAIN, 12));
		btAcidente.setBackground(Color.decode("#007256"));
		btAcidente.setForeground(Color.WHITE);
		btAcidente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMainServices.add(btAcidente);

		///////////////////////////////////////// FIM PAINEL
		///////////////////////////////////////// PRINCIPAL////////////////////////////////////////

		/////////////////////////////////////////////////// PN MEUS
		/////////////////////////////////////////////////// SERVICOS///////////////////////////////////////

		pnMyServices = new JPanel();
		pnMyServices.setLayout(null);
		pnMyServices.setBounds(176, 0, 525, 600);
		pnMyServices.setVisible(false);

		lbMyServicesTitle = new JLabel("MEUS SEGUROS");
		lbMyServicesTitle.setBounds(175, 45, 189, 25);
		lbMyServicesTitle.setFont(new Font("Dialog", Font.BOLD, 23));
		pnMyServices.add(lbMyServicesTitle);

		lbMyServicesExplicacao = new JLabel(
				"<html><body><center>Visualize todos os seguros que você contratou.<br>Caso tenha alguma dúvida entre em contato com o seu corretor<center></body></html>");
		lbMyServicesExplicacao.setBounds(106, 93, 312, 60);
		lbMyServicesExplicacao.setFont(new Font("Dialog", Font.PLAIN, 15));
		pnMyServices.add(lbMyServicesExplicacao);

		/////////////////////////////////////////////////// FIM PN MEUS
		/////////////////////////////////////////////////// SERVICOS///////////////////////////////////////

		////////////////////////////////////////////////// PN
		////////////////////////////////////////////////// HELP////////////////////////////////////////
		pnHelp = new JPanel();
		pnHelp.setLayout(null);
		pnHelp.setBounds(176, 0, 525, 600);
		pnHelp.setVisible(false);

		lbHelpTitle = new JLabel("AJUDA");
		lbHelpTitle.setBounds(220, 45, 87, 25);
		lbHelpTitle.setFont(new Font("Dialog", Font.BOLD, 23));
		pnHelp.add(lbHelpTitle);

		lbHelpExplicacao = new JLabel(
				"<html><body><center>Envie suas dúvidas direto para o seu corretor,<br> que retornará assim que possível em seu email.<center></body></html>");
		lbHelpExplicacao.setBounds(106, 93, 312, 43);
		lbHelpExplicacao.setFont(new Font("Dialog", Font.PLAIN, 15));
		pnHelp.add(lbHelpExplicacao);

		lbHelpServicos = new JLabel("<html><body>Selecione o serviço <br> que necessita de ajuda:</body></html>");
		lbHelpServicos.setBounds(36, 165, 208, 43);
		lbHelpServicos.setFont(new Font("Dialog", Font.BOLD, 18));
		pnHelp.add(lbHelpServicos);

		lbHelpTextArea = new JLabel("Escreva abaixo o seu problema/dúvida: ");
		lbHelpTextArea.setBounds(130, 264, 265, 25);
		lbHelpTextArea.setFont(new Font("Dialog", Font.BOLD, 13));
		pnHelp.add(lbHelpTextArea);

		txaHelpMessage = new JTextArea();
		txaHelpMessage.setBounds(36, 291, 449, 143);
		pnHelp.add(txaHelpMessage);

		btHelpSend = new JButton("Enviar");
		btHelpSend.setBounds(161, 464, 208, 70);
		btHelpSend.setFont(new Font("", Font.BOLD, 20));
		btHelpSend.setBackground(Color.decode("#007256"));
		btHelpSend.setForeground(Color.WHITE);
		btHelpSend.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnHelp.add(btHelpSend);

		cbHelpServicos = new JComboBox(); /// colocar os serviços do user
		cbHelpServicos.setFont(new Font("Dialog", Font.PLAIN, 13));
		cbHelpServicos.setForeground(Color.decode("#007256"));
		cbHelpServicos.setBounds(267, 178, 218, 30);
		pnHelp.add(cbHelpServicos);
		//////////////////////////////////////////////// FIM PN
		//////////////////////////////////////////////// HELP////////////////////////////////////////////

		getContentPane().add(pnMainServices);
		this.getContentPane().add(pnMain);
	}

	public void eventos() {
		// EVENTOS DE HOVER
		btMainServices.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btMainServices.setBackground(Color.decode("#00574f"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btMainServices.setBackground(Color.decode("#007256"));
			}

		});
		btMyServices.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btMyServices.setBackground(Color.decode("#00574f"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btMyServices.setBackground(Color.decode("#007256"));
			}

		});

		btHelpServices.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btHelpServices.setBackground(Color.decode("#00574f"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btHelpServices.setBackground(Color.decode("#007256"));
			}

		});
		btSeeSite.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btSeeSite.setBackground(Color.decode("#00574f"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btSeeSite.setBackground(Color.decode("#007256"));
			}

		});
		close.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				close.setBackground(Color.decode("#00574f"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				close.setBackground(Color.decode("#007256"));
			}

		});

		// FIM EVENTOS DE HOVER

		// EVENTOS DE AÃ‡ÃƒO
		btMainServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (pnHelp.isVisible()) {
					pnHelp.setVisible(false);
					pnMainServices.setVisible(true);
					getContentPane().add(pnMainServices);
				} else if (pnMyServices.isVisible()) {
					pnMyServices.setVisible(false);
					pnMainServices.setVisible(true);
					getContentPane().add(pnMainServices);
				}

			}
		});
		btHelpServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (pnMainServices.isVisible()) {
					pnMainServices.setVisible(false);
					pnHelp.setVisible(true);
					getContentPane().add(pnHelp);
				} else if (pnMyServices.isVisible()) {
					pnMyServices.setVisible(false);
					pnHelp.setVisible(true);
					getContentPane().add(pnHelp);
				}

			}
		});
		btMyServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (pnMainServices.isVisible()) {
					pnMainServices.setVisible(false);
					pnMyServices.setVisible(true);
					getContentPane().add(pnMyServices);
				} else if (pnHelp.isVisible()) {
					pnHelp.setVisible(false);
					pnMyServices.setVisible(true);
					getContentPane().add(pnMyServices);
				}

			}
		});

		btImobiliario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				btMyServices.setEnabled(false);
				btHelpServices.setEnabled(false);
				btMainServices.setEnabled(false);

				pnMainServices.setVisible(false);
				pnBuy.setVisible(true);
				getContentPane().add(pnBuy);

				lbBuyTitle.setText("<html><body><center>Imobiliário</center></body></html>");
			}
		});

		btResidencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				btMyServices.setEnabled(false);
				btHelpServices.setEnabled(false);
				btMainServices.setEnabled(false);

				pnMainServices.setVisible(false);
				pnBuy.setVisible(true);
				getContentPane().add(pnBuy);

				lbBuyTitle.setText("<html><body><center>Residencial <br> Premiado</center></body></html>");
			}
		});

		btFianca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				btMyServices.setEnabled(false);
				btHelpServices.setEnabled(false);
				btMainServices.setEnabled(false);

				pnMainServices.setVisible(false);
				pnBuy.setVisible(true);
				getContentPane().add(pnBuy);

				lbBuyTitle.setText("<html><body><center>Fiança Locática <br> Aluguel</center></body></html>");
			}
		});
		rbBuyRuralSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (rbBuyRuralNao.isSelected()) {
					rbBuyRuralNao.setSelected(false);
				} else if (rbBuyRuralSim.isSelected()) {
					rbBuyRuralSim.setSelected(true);

				}
			}
		});
		rbBuyRuralNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (rbBuyRuralSim.isSelected()) {
					rbBuyRuralSim.setSelected(false);
				} else if (rbBuyRuralNao.isSelected()) {
					rbBuyRuralNao.setSelected(true);

				}
			}
		});
		rbBuyPortariaSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (rbBuyPortariaNao.isSelected()) {
					rbBuyPortariaNao.setSelected(false);
				} else if (rbBuyPortariaSim.isSelected()) {
					rbBuyPortariaSim.setSelected(true);

				}
			}
		});
		rbBuyPortariaNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (rbBuyPortariaSim.isSelected()) {
					rbBuyPortariaSim.setSelected(false);
				} else if (rbBuyPortariaNao.isSelected()) {
					rbBuyPortariaNao.setSelected(true);

				}
			}
		});
		rbBuyAlvenariaSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (rbBuyAlvenariaNao.isSelected()) {
					rbBuyAlvenariaNao.setSelected(false);
				} else if (rbBuyPortariaSim.isSelected()) {
					rbBuyAlvenariaSim.setSelected(true);
				}
			}
		});
		rbBuyAlvenariaNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (rbBuyAlvenariaSim.isSelected()) {
					rbBuyAlvenariaSim.setSelected(false);
				} else if (rbBuyPortariaNao.isSelected()) {
					rbBuyAlvenariaNao.setSelected(true);
				}
			}
		});
		btBuyCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txBuyEndereco.setText("");
				txBuyValor.setText("");
				pnBuy.setVisible(false);
				pnMainServices.setVisible(true);
				getContentPane().add(pnMainServices);
				btMyServices.setEnabled(true);
				btHelpServices.setEnabled(true);
				btMainServices.setEnabled(true);

			}
		});
		btBuyNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {

				if (txBuyEndereco.getText().equals("") || txBuyEndereco.getText().length() <= 10) {
					txBuyEndereco.requestFocus();
				} else if (txBuyValor.getText().equals("") || txBuyValor.getText().length() <= 4) {
					txBuyValor.requestFocus();
				} else {
					pnBuy.setVisible(false);

					if (lbBuyTitle.getText()
							.equals("<html><body><center>Fiança Locática <br> Aluguel</center></body></html>")) {
						pnFianca.setVisible(true);
						getContentPane().add(pnFianca);

					} else if (lbBuyTitle.getText()
							.equals("<html><body><center>Residencial <br> Premiado</center></body></html>")) {
						pnResidencial.setVisible(true);
						getContentPane().add(pnResidencial);

					} else if (lbBuyTitle.getText().equals("<html><body><center>Imobiliário</center></body></html>")) {
						pnImobiliario.setVisible(true);
						getContentPane().add(pnImobiliario);
					}
				}
			}
		});

		btResidencialVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				pnResidencial.setVisible(false);
				pnBuy.setVisible(true);
				getContentPane().add(pnBuy);

			}
		});
		btImobiliarioVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				pnImobiliario.setVisible(false);
				pnBuy.setVisible(true);
				getContentPane().add(pnBuy);

			}
		});
		btFiancaVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				pnFianca.setVisible(false);
				pnBuy.setVisible(true);
				getContentPane().add(pnBuy);

			}
		});
		btResidencialCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txBuyEndereco.setText("");
				txBuyValor.setText("");
				txResidencialTipo.setText("");

				pnResidencial.setVisible(false);
				pnMainServices.setVisible(true);
				getContentPane().add(pnMainServices);
				btMyServices.setEnabled(true);
				btHelpServices.setEnabled(true);
				btMainServices.setEnabled(true);

			}
		});
		btImobiliarioCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txBuyEndereco.setText("");
				txBuyValor.setText("");
				txImobiliarioTipo.setText("");
				txImobiliarioEmpresa.setText("");

				pnImobiliario.setVisible(false);
				pnMainServices.setVisible(true);
				getContentPane().add(pnMainServices);
				btMyServices.setEnabled(true);
				btHelpServices.setEnabled(true);
				btMainServices.setEnabled(true);

			}
		});
		btFiancaCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txBuyEndereco.setText("");
				txBuyValor.setText("");
				txFiancaTipo.setText("");

				pnFianca.setVisible(false);
				pnMainServices.setVisible(true);
				getContentPane().add(pnMainServices);
				btMyServices.setEnabled(true);
				btHelpServices.setEnabled(true);
				btMainServices.setEnabled(true);

			}
		});
		btResidencialConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				String[] options = { "Sim", "Não" };
				if (txResidencialTipo.getText().equals("") || txResidencialTipo.getText().length() < 5) {
					txResidencialTipo.requestFocus();
				} else {
					String endereco = txBuyEndereco.getText();
					String tipo = txResidencialTipo.getText();
					double valorImovel = Double.parseDouble(txBuyValor.getText());
					String rural, portaria, alvenaria;

					if (rbBuyRuralSim.isSelected()) {
						rural = rbBuyRuralSim.getText();
					} else {
						rural = rbBuyRuralNao.getText();
					}

					if (rbBuyPortariaSim.isSelected()) {
						portaria = rbBuyPortariaSim.getText();
					} else {
						portaria = rbBuyPortariaNao.getText();
					}
					if (rbBuyAlvenariaSim.isSelected()) {
						alvenaria = rbBuyAlvenariaSim.getText();
					} else {
						alvenaria = rbBuyAlvenariaNao.getText();
					}

					if (JOptionPane.showOptionDialog(null,
							"Confirma essas informações???" + "\n" + "\n Endereço: " + endereco + "\n Tipo do imóvel: "
									+ tipo + "\n Valor do imóvel: " + valorImovel + " R$" + "\n Propriedade rural: "
									+ rural + "\n Portaria elétrica: " + portaria + "\n Alvenaria: " + alvenaria
									+ "\n Valor do serviço: " + valorResidencial,
							"Confirma essas informações?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, options, options[0]) == 0) {

						JOptionPane.showMessageDialog(null, "Serviço contratado com sucesso");
						txBuyEndereco.setText("");
						txBuyValor.setText("");
						txResidencialTipo.setText("");

						pnResidencial.setVisible(false);
						pnMainServices.setVisible(true);

						btMyServices.setEnabled(true);
						btHelpServices.setEnabled(true);
						btMainServices.setEnabled(true);
						getContentPane().add(pnMainServices);

					} else {

					}
				}
			}
		});
		btImobiliarioConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				String[] options = { "Sim", "Não" };
				if (txImobiliarioTipo.getText().equals("") || txImobiliarioTipo.getText().length() < 5) {
					txImobiliarioTipo.requestFocus();
				} else if (txImobiliarioEmpresa.getText().equals("")) {
					txImobiliarioEmpresa.requestFocus();
				}

				else {
					String endereco = txBuyEndereco.getText();
					String tipo = txImobiliarioTipo.getText();
					String nome = txImobiliarioEmpresa.getText();
					double valorImovel = Double.parseDouble(txBuyValor.getText());
					String rural, portaria, alvenaria;

					if (rbBuyRuralSim.isSelected()) {
						rural = rbBuyRuralSim.getText();
					} else {
						rural = rbBuyRuralNao.getText();
					}

					if (rbBuyPortariaSim.isSelected()) {
						portaria = rbBuyPortariaSim.getText();
					} else {
						portaria = rbBuyPortariaNao.getText();
					}
					if (rbBuyAlvenariaSim.isSelected()) {
						alvenaria = rbBuyAlvenariaSim.getText();
					} else {
						alvenaria = rbBuyAlvenariaNao.getText();
					}

					if (JOptionPane.showOptionDialog(null,
							"Confirma essas informações???" + "\n" + "\n Nome da empresa " + nome + "\n Endereço: "
									+ endereco + "\n Segmento da empresa: " + tipo + "\n Valor do imóvel: "
									+ valorImovel + " R$" + "\n Propriedade rural: " + rural + "\n Portaria elétrica: "
									+ portaria + "\n Alvenaria: " + alvenaria + "\n Valor do serviço: "
									+ valorImobiliario,
							"Confirma essas informações?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, options, options[0]) == 0) {

						JOptionPane.showMessageDialog(null, "Serviço contratado com sucesso");
						txBuyEndereco.setText("");
						txBuyValor.setText("");
						txImobiliarioTipo.setText("");
						txImobiliarioEmpresa.setText("");

						pnImobiliario.setVisible(false);
						pnMainServices.setVisible(true);

						btMyServices.setEnabled(true);
						btHelpServices.setEnabled(true);
						btMainServices.setEnabled(true);
						getContentPane().add(pnMainServices);

					} else {

					}
				}
			}
		});
		btFiancaConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				String[] options = { "Sim", "Não" };
				if (txFiancaTipo.getText().equals("") || txFiancaTipo.getText().length() < 5) {
					txFiancaTipo.requestFocus();
				} else {
					String endereco = txBuyEndereco.getText();
					String tipo = txFiancaTipo.getText();
					double valorImovel = Double.parseDouble(txBuyValor.getText());
					String rural, portaria, alvenaria;

					if (rbBuyRuralSim.isSelected()) {
						rural = rbBuyRuralSim.getText();
					} else {
						rural = rbBuyRuralNao.getText();
					}

					if (rbBuyPortariaSim.isSelected()) {
						portaria = rbBuyPortariaSim.getText();
					} else {
						portaria = rbBuyPortariaNao.getText();
					}
					if (rbBuyAlvenariaSim.isSelected()) {
						alvenaria = rbBuyAlvenariaSim.getText();
					} else {
						alvenaria = rbBuyAlvenariaNao.getText();
					}

					if (JOptionPane.showOptionDialog(null,
							"Confirma essas informações???" + "\n" + "\n Endereço: " + endereco + "\n Tipo do imóvel: "
									+ tipo + "\n Valor do imóvel: " + valorImovel + " R$" + "\n Propriedade rural: "
									+ rural + "\n Portaria elétrica: " + portaria + "\n Alvenaria: " + alvenaria
									+ "\n Valor do serviço: " + valorFianca,
							"Confirma essas informações?", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
							null, options, options[0]) == 0) {

						JOptionPane.showMessageDialog(null, "Serviço contratado com sucesso");
						txBuyEndereco.setText("");
						txBuyValor.setText("");
						txFiancaTipo.setText("");

						pnFianca.setVisible(false);
						pnMainServices.setVisible(true);

						btMyServices.setEnabled(true);
						btHelpServices.setEnabled(true);
						btMainServices.setEnabled(true);
						getContentPane().add(pnMainServices);

					} else {

					}
				}
			}
		});

		btSeeSite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				OpenURL.open("https://www.tokiomarine.com.br/");

			}
		});
		btAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				OpenURL.open("https://www.tokiomarine.com.br/seguros-automoveis/");

			}
		});
		btVida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				OpenURL.open("https://www.tokiomarine.com.br/seguros-vida/");

			}
		});
		btAcidente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				OpenURL.open("https://www.tokiomarine.com.br/seguros-acidentes/");

			}
		});

	}

	public void close() {

		this.setVisible(false);
	}
}
