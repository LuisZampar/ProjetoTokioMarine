package br.com.tokio.views;

import javax.swing.*;

import br.com.tokio.controller.CorretorController;
import br.com.tokio.model.Corretor;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Method;
import javax.swing.border.LineBorder;

public class InterfaceCorretor extends JFrame {
	Corretor corretor = new Corretor();
	CorretorController controller = new CorretorController();
	public JButton close;

	// Painel Lateral
	private JPanel pnMain;
	private JButton btMainServices, btMyClientes, btOcorrencias, btFinalServices, btRelatorios;
	private JLabel lbImgUser, lbImgLogo, lbNameCorretor;

	// Painel Principal
	private JPanel pnMainServices;
	private JLabel pnMainServicesTitle;

	// Painel MyClientes
	private JPanel pnMyClientes;
	private JLabel lbMyClientesTitle, lbMyClientesNome;
	private JTextField txMyClientesNome;
	private JRadioButton rbMyClientesRenda, rbMyClientesSexo, rbMyClientesAlfabetica, rbMyClientesTodos,
			rbMyClientesNome, rbMyClientesM, rbMyClientesF, rbMyClientesO, rbMyClientesSemOrdem;
	private ButtonGroup gpMyClientesTwo, gpMyClientes, gpMyClientesThree;
	private JButton btMyClientesBuscaNome, btMyClientesBusca;
	private JTable tbMyClientes;
	JScrollPane scrollPane;

	// Painel de ocorrências
	private JPanel pnOcorrencias;
	private JLabel lbOcorrenciasTitle;
	private JButton btOcorrenciasBusca;
	private JTable tbOcorrencias;
	JScrollPane scrollPaneOcorrencias;

	// Painel cancelar serviços
	private JPanel pnCancel;
	private JLabel lbCancelTitle, lbCancelTitleDados, lbCancelApolice, lbCancelName, lbCancelEndereco, lbCancelRural,
			lbCancelPortaria, lbCancelAlvenaria, lbCancelValorServico, lbCancelNomeEmpresa, lbCancelValorImovel,
			lbCancelTipo;
	private JTextField txCancelApolice, txCancelNome, txCancelEndereco, txCancelRural, txCancelPortaria,
			txCancelAlvenaria, txCancelValorServico, txCancelNomeEmpresa, txCancelValorImovel, txCancelTipo;
	private ButtonGroup gpCancel;
	private JRadioButton rbCancelImobiliario, rbCancelResidencial, rbCancelFianca;
	private JButton btCancelarApolice, btCancelarDelete, btCancelCancelar;

	// Painel Relatorios
	private JPanel pnRelatorios;
	private JLabel lbRelatoriosTitle;

	public InterfaceCorretor(Corretor corretor) {
		this.corretor.setId_corretor(corretor.getId_corretor());
		this.corretor.setNm_corretor(corretor.getNm_corretor());
		this.corretor.setOb_email_corretor(corretor.getOb_email_corretor());
		this.corretor.setOb_senha_corretor(corretor.getOb_senha_corretor());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setBounds(0, 0, 700, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setIconImage(new ImageIcon("images//icon.png").getImage());
		componentes();
		eventos();

	}

	public void componentes() {
		getContentPane().setLayout(null);

		pnMain = new JPanel();
		pnMain.setLayout(null);
		pnMain.setBackground(Color.decode("#007256"));
		pnMain.setBounds(0, 0, 175, 600);
		pnMain.setVisible(true);

		lbImgUser = new JLabel(new ImageIcon("images//user-branco.png"));
		lbImgUser.setBounds(20, 10, 135, 135);
		pnMain.add(lbImgUser);

		lbImgLogo = new JLabel(new ImageIcon("images//logo-tokio-marine-seguradora-branco.png"));
		lbImgLogo.setBounds(10, 550, 155, 36);
		pnMain.add(lbImgLogo);

		lbNameCorretor = new JLabel("<html><body><center>" + this.corretor.getNm_corretor() + "</body></html>"); // Colocar
																													// nome
																													// do
		// corretor
		lbNameCorretor.setBounds(10, 171, 165, 25);
		lbNameCorretor.setFont(new Font("Dialog", Font.BOLD, 12));
		lbNameCorretor.setForeground(Color.WHITE);
		pnMain.add(lbNameCorretor);

		btMainServices = new JButton("HOME");
		btMainServices.setBounds(0, 204, 175, 40);
		btMainServices.setFont(new Font("Dialog", Font.PLAIN, 11));
		btMainServices.setBackground(Color.decode("#007256"));
		btMainServices.setForeground(Color.WHITE);
		btMainServices.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btMainServices);

		btMyClientes = new JButton("Meus Clientes");
		btMyClientes.setBounds(0, 244, 175, 40);
		btMyClientes.setFont(new Font("Dialog", Font.PLAIN, 11));
		btMyClientes.setBackground(Color.decode("#007256"));
		btMyClientes.setForeground(Color.WHITE);
		btMyClientes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btMyClientes);

		btOcorrencias = new JButton("Ocorrências");
		btOcorrencias.setBounds(0, 284, 175, 40);
		btOcorrencias.setFont(new Font("Dialog", Font.PLAIN, 11));
		btOcorrencias.setBackground(Color.decode("#007256"));
		btOcorrencias.setForeground(Color.WHITE);
		btOcorrencias.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btOcorrencias);

		btFinalServices = new JButton("Finalizar Seguros");
		btFinalServices.setBounds(0, 324, 175, 40);
		btFinalServices.setFont(new Font("Dialog", Font.PLAIN, 11));
		btFinalServices.setBackground(Color.decode("#007256"));
		btFinalServices.setForeground(Color.WHITE);
		btFinalServices.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btFinalServices);

		btRelatorios = new JButton("Relatórios");
		btRelatorios.setBounds(0, 364, 175, 40);
		btRelatorios.setFont(new Font("Dialog", Font.PLAIN, 11));
		btRelatorios.setBackground(Color.decode("#007256"));
		btRelatorios.setForeground(Color.WHITE);
		btRelatorios.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMain.add(btRelatorios);

		close = new JButton("Sair");
		close.setForeground(Color.WHITE);
		close.setBounds(0, 404, 175, 40);
		close.setCursor(new Cursor(Cursor.HAND_CURSOR));
		close.setFont(new Font("Dialog", Font.PLAIN, 15));
		close.setBackground(Color.decode("#007256"));
		pnMain.add(close);

		///////////////////////////////////////////////// PAINEL
		///////////////////////////////////////////////// HOME//////////////////////////////////////////////////
		pnMainServices = new JPanel();
		pnMainServices.setLayout(null);
		pnMainServices.setVisible(true);
		pnMainServices.setBounds(177, 0, 525, 600);

		pnMainServicesTitle = new JLabel("HOME");
		pnMainServicesTitle.setBounds(217, 45, 75, 20);
		pnMainServicesTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		pnMainServices.add(pnMainServicesTitle);

		///////////////////////////////////////////////// FIM PAINEL
		///////////////////////////////////////////////// HOME//////////////////////////////////////////////////

		///////////////////////////////////////////////// PAINEL
		///////////////////////////////////////////////// MYCLIENTES//////////////////////////////////////////////////
		pnMyClientes = new JPanel();
		pnMyClientes.setLayout(null);
		pnMyClientes.setVisible(false);
		pnMyClientes.setBounds(177, 0, 525, 600);

		lbMyClientesTitle = new JLabel("Meus Clientes");
		lbMyClientesTitle.setBounds(170, 45, 175, 20);
		lbMyClientesTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		pnMyClientes.add(lbMyClientesTitle);

		rbMyClientesNome = new JRadioButton("Buscar por nome");
		rbMyClientesNome.setBounds(325, 85, 145, 18);
		pnMyClientes.add(rbMyClientesNome);

		rbMyClientesTodos = new JRadioButton("Buscar todos");
		rbMyClientesTodos.setSelected(true);
		rbMyClientesTodos.setBounds(60, 85, 110, 18);
		pnMyClientes.add(rbMyClientesTodos);

		rbMyClientesSexo = new JRadioButton("Buscar pelo sexo ");
		rbMyClientesSexo.setBounds(180, 85, 135, 18);
		pnMyClientes.add(rbMyClientesSexo);

		gpMyClientes = new ButtonGroup();
		gpMyClientes.add(rbMyClientesNome);
		gpMyClientes.add(rbMyClientesTodos);
		gpMyClientes.add(rbMyClientesSexo);

		rbMyClientesM = new JRadioButton("Masculino");
		rbMyClientesM.setVisible(false);
		rbMyClientesM.setSelected(true);
		rbMyClientesM.setBounds(100, 110, 100, 18);
		pnMyClientes.add(rbMyClientesM);

		rbMyClientesF = new JRadioButton("Feminino");
		rbMyClientesF.setVisible(false);
		rbMyClientesF.setBounds(220, 110, 100, 18);
		pnMyClientes.add(rbMyClientesF);

		rbMyClientesO = new JRadioButton("Outro");
		rbMyClientesO.setVisible(false);
		rbMyClientesO.setBounds(320, 110, 100, 18);
		pnMyClientes.add(rbMyClientesO);

		gpMyClientesThree = new ButtonGroup();
		gpMyClientesThree.add(rbMyClientesM);
		gpMyClientesThree.add(rbMyClientesF);
		gpMyClientesThree.add(rbMyClientesO);

		rbMyClientesSemOrdem = new JRadioButton("Não ordenar");
		rbMyClientesSemOrdem.setBounds(25, 137, 100, 18);
		rbMyClientesSemOrdem.setSelected(true);
		pnMyClientes.add(rbMyClientesSemOrdem);

		rbMyClientesAlfabetica = new JRadioButton("Ordenar por ordem alfabét.");
		rbMyClientesAlfabetica.setBounds(135, 137, 185, 18);
		pnMyClientes.add(rbMyClientesAlfabetica);

		rbMyClientesRenda = new JRadioButton("Ordenar por val .da renda");
		rbMyClientesRenda.setBounds(325, 137, 185, 18);
		pnMyClientes.add(rbMyClientesRenda);

		gpMyClientesTwo = new ButtonGroup();
		gpMyClientesTwo.add(rbMyClientesAlfabetica);
		gpMyClientesTwo.add(rbMyClientesRenda);
		gpMyClientesTwo.add(rbMyClientesSemOrdem);
		lbMyClientesNome = new JLabel("<html> <body> <center>Busque o cliente pelo <br> nome </center> </body></html>");
		lbMyClientesNome.setFont(new Font("Dialog", Font.BOLD, 13));
		lbMyClientesNome.setBounds(50, 174, 158, 36);
		lbMyClientesNome.setVisible(false);
		pnMyClientes.add(lbMyClientesNome);

		txMyClientesNome = new JTextField();
		txMyClientesNome.setBounds(210, 180, 152, 30);
		txMyClientesNome.setFont(new Font("Dialog", Font.PLAIN, 20));
		txMyClientesNome.setVisible(false);
		pnMyClientes.add(txMyClientesNome);

		btMyClientesBuscaNome = new JButton("Buscar");
		btMyClientesBuscaNome.setBounds(372, 180, 90, 30);
		btMyClientesBuscaNome.setVisible(false);
		btMyClientesBuscaNome.setFont(new Font("Dialog", Font.BOLD, 15));
		btMyClientesBuscaNome.setBackground(Color.decode("#007256"));
		btMyClientesBuscaNome.setForeground(Color.WHITE);
		btMyClientesBuscaNome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMyClientes.add(btMyClientesBuscaNome);

		btMyClientesBusca = new JButton("Buscar");
		btMyClientesBusca.setBounds(200, 180, 90, 30);
		btMyClientesBusca.setFont(new Font("Dialog", Font.BOLD, 15));
		btMyClientesBusca.setBackground(Color.decode("#007256"));
		btMyClientesBusca.setForeground(Color.WHITE);
		btMyClientesBusca.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnMyClientes.add(btMyClientesBusca);

		tbMyClientes = new JTable();
		tbMyClientes.setBorder(new LineBorder(Color.BLACK));
		tbMyClientes.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbMyClientes.setPreferredScrollableViewportSize(new Dimension(300, 100));// barra de rolagem
		// tbMyClientes.setFillsViewportHeight(true);

		scrollPane = new JScrollPane(tbMyClientes);
		scrollPane.setBounds(0, 230, 520, 350);
		pnMyClientes.add(scrollPane);
		// adicionando a tabela em uma barra de rolagem, ficará envolta , pela mesma

		///////////////////////////////////////////////// FIM PAINEL
		///////////////////////////////////////////////// MYCLIENTES//////////////////////////////////////////////////

		///////////////////////////////////////////////// PAINEL
		///////////////////////////////////////////////// OCORRENCIAS//////////////////////////////////////////////////
		pnOcorrencias = new JPanel();
		pnOcorrencias.setLayout(null);
		pnOcorrencias.setVisible(true);
		pnOcorrencias.setBounds(177, 0, 525, 600);

		lbOcorrenciasTitle = new JLabel("Ocorrências");
		lbOcorrenciasTitle.setBounds(170, 45, 175, 20);
		lbOcorrenciasTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		pnOcorrencias.add(lbOcorrenciasTitle);

		btOcorrenciasBusca = new JButton("Buscar");
		btOcorrenciasBusca.setBounds(200, 100, 90, 30);
		btOcorrenciasBusca.setFont(new Font("Dialog", Font.BOLD, 15));
		btOcorrenciasBusca.setBackground(Color.decode("#007256"));
		btOcorrenciasBusca.setForeground(Color.WHITE);
		btOcorrenciasBusca.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnOcorrencias.add(btOcorrenciasBusca);

		tbOcorrencias = new JTable();
		tbOcorrencias.setBorder(new LineBorder(Color.BLACK));
		tbOcorrencias.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tbOcorrencias.setPreferredScrollableViewportSize(new Dimension(300, 100));// barra de rolagem
		// tbMyClientes.setFillsViewportHeight(true);

		scrollPaneOcorrencias = new JScrollPane(tbOcorrencias);
		scrollPaneOcorrencias.setBounds(0, 170, 520, 400);
		pnOcorrencias.add(scrollPaneOcorrencias);

		///////////////////////////////////////////////// FIM PAINEL
		///////////////////////////////////////////////// OCORRENCIAS//////////////////////////////////////////////////

/////////////////////////////////////////////////PAINEL RELATORIOS//////////////////////////////////////////////////
		pnRelatorios = new JPanel();
		pnRelatorios.setLayout(null);
		pnRelatorios.setVisible(false);
		pnRelatorios.setBounds(177, 0, 525, 600);

		lbRelatoriosTitle = new JLabel("Relatórios");
		lbRelatoriosTitle.setBounds(170, 45, 175, 20);
		lbRelatoriosTitle.setFont(new Font("Dialog", Font.BOLD, 25));
		pnRelatorios.add(lbRelatoriosTitle);

/////////////////////////////////////////////////FIM PAINEL RELATORIOS//////////////////////////////////////////////////

		///////////////////////////////////////////////// PAINEL CANCELAR
		///////////////////////////////////////////////// SERVIÇOS////////////////////////////////////
		pnCancel = new JPanel();
		pnCancel.setLayout(null);
		pnCancel.setBounds(177, 0, 525, 600);
		pnCancel.setVisible(false);

		lbCancelTitle = new JLabel("Cancelar Serviços");
		lbCancelTitle.setBounds(165, 45, 208, 25);
		lbCancelTitle.setFont(new Font("Dialog", Font.BOLD, 23));
		pnCancel.add(lbCancelTitle);

		rbCancelResidencial = new JRadioButton("Residencial Premiado");
		rbCancelResidencial.setSelected(true);
		rbCancelResidencial.setBounds(50, 87, 150, 18);
		pnCancel.add(rbCancelResidencial);

		rbCancelFianca = new JRadioButton("Fiança Locatícia - Aluguel");
		rbCancelFianca.setBounds(200, 87, 175, 18);
		pnCancel.add(rbCancelFianca);

		rbCancelImobiliario = new JRadioButton("Imobiliario");
		rbCancelImobiliario.setBounds(375, 87, 90, 18);
		pnCancel.add(rbCancelImobiliario);

		gpCancel = new ButtonGroup();
		gpCancel.add(rbCancelResidencial);
		gpCancel.add(rbCancelFianca);
		gpCancel.add(rbCancelImobiliario);

		lbCancelApolice = new JLabel(
				"<html> <body> <center>Busque o serviço pela <br> apólice </center> </body></html>");
		lbCancelApolice.setFont(new Font("Dialog", Font.BOLD, 13));
		lbCancelApolice.setBounds(40, 121, 158, 36);
		pnCancel.add(lbCancelApolice);

		txCancelApolice = new JTextField();
		txCancelApolice.setBounds(200, 127, 152, 30);
		txCancelApolice.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnCancel.add(txCancelApolice);

		lbCancelTitleDados = new JLabel("Dados do serviço");
		lbCancelTitleDados.setBounds(165, 178, 193, 25);
		lbCancelTitleDados.setFont(new Font("Dialog", Font.BOLD, 23));
		pnCancel.add(lbCancelTitleDados);

		lbCancelName = new JLabel("Nome");
		lbCancelName.setFont(new Font("Dialog", Font.BOLD, 13));
		lbCancelName.setBounds(55, 224, 37, 18);
		pnCancel.add(lbCancelName);

		txCancelNome = new JTextField();
		txCancelNome.setBounds(100, 224, 352, 20);
		txCancelNome.setEnabled(false);
		txCancelNome.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnCancel.add(txCancelNome);

		lbCancelEndereco = new JLabel("Endereco");
		lbCancelEndereco.setFont(new Font("Dialog", Font.BOLD, 13));
		lbCancelEndereco.setBounds(32, 260, 60, 18);
		pnCancel.add(lbCancelEndereco);

		txCancelEndereco = new JTextField();
		txCancelEndereco.setBounds(100, 260, 352, 20);
		txCancelEndereco.setEnabled(false);
		txCancelEndereco.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnCancel.add(txCancelEndereco);

		lbCancelPortaria = new JLabel("Portaria elétrica");
		lbCancelPortaria.setFont(new Font("Dialog", Font.BOLD, 13));
		lbCancelPortaria.setBounds(32, 295, 103, 18);
		pnCancel.add(lbCancelPortaria);

		txCancelPortaria = new JTextField();
		txCancelPortaria.setBounds(145, 295, 40, 20);
		txCancelPortaria.setEnabled(false);
		txCancelPortaria.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnCancel.add(txCancelPortaria);

		lbCancelAlvenaria = new JLabel("Alvenaria");
		lbCancelAlvenaria.setFont(new Font("Dialog", Font.BOLD, 13));
		lbCancelAlvenaria.setBounds(200, 295, 61, 18);
		pnCancel.add(lbCancelAlvenaria);

		txCancelAlvenaria = new JTextField();
		txCancelAlvenaria.setBounds(270, 295, 40, 20);
		txCancelAlvenaria.setEnabled(false);
		txCancelAlvenaria.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnCancel.add(txCancelAlvenaria);

		lbCancelRural = new JLabel("Moradia rural");
		lbCancelRural.setFont(new Font("Dialog", Font.BOLD, 13));
		lbCancelRural.setBounds(320, 295, 90, 18);
		pnCancel.add(lbCancelRural);

		txCancelRural = new JTextField();
		txCancelRural.setBounds(415, 295, 40, 20);
		txCancelRural.setEnabled(false);
		txCancelRural.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnCancel.add(txCancelRural);

		lbCancelValorImovel = new JLabel("Valor do imóvel");
		lbCancelValorImovel.setFont(new Font("Dialog", Font.BOLD, 13));
		lbCancelValorImovel.setBounds(30, 330, 103, 18);
		pnCancel.add(lbCancelValorImovel);

		txCancelValorImovel = new JTextField();
		txCancelValorImovel.setBounds(140, 330, 111, 20);
		txCancelValorImovel.setEnabled(false);
		txCancelValorImovel.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnCancel.add(txCancelValorImovel);

		lbCancelTipo = new JLabel("Tipo");
		lbCancelTipo.setFont(new Font("Dialog", Font.BOLD, 13));
		lbCancelTipo.setBounds(270, 330, 37, 18);
		pnCancel.add(lbCancelTipo);

		txCancelTipo = new JTextField();
		txCancelTipo.setBounds(310, 330, 139, 20);
		txCancelTipo.setEnabled(false);
		txCancelTipo.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnCancel.add(txCancelTipo);

		lbCancelNomeEmpresa = new JLabel("Nome da empresa");
		lbCancelNomeEmpresa.setFont(new Font("Dialog", Font.BOLD, 13));
		lbCancelNomeEmpresa.setVisible(false);
		lbCancelNomeEmpresa.setBounds(30, 365, 125, 18);
		pnCancel.add(lbCancelNomeEmpresa);

		txCancelNomeEmpresa = new JTextField();
		txCancelNomeEmpresa.setBounds(160, 365, 292, 20);
		txCancelNomeEmpresa.setVisible(false);
		txCancelNomeEmpresa.setEnabled(false);
		txCancelNomeEmpresa.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnCancel.add(txCancelNomeEmpresa);

		lbCancelValorServico = new JLabel("Valor do serviço");
		lbCancelValorServico.setFont(new Font("Dialog", Font.BOLD, 13));
		lbCancelValorServico.setBounds(140, 405, 111, 18);
		pnCancel.add(lbCancelValorServico);

		txCancelValorServico = new JTextField();
		txCancelValorServico.setBounds(255, 405, 97, 20);
		txCancelValorServico.setEnabled(false);
		txCancelValorServico.setFont(new Font("Dialog", Font.PLAIN, 18));
		pnCancel.add(txCancelValorServico);

		btCancelarApolice = new JButton("Buscar");
		btCancelarApolice.setBounds(362, 127, 90, 30);
		btCancelarApolice.setFont(new Font("Dialog", Font.BOLD, 15));
		btCancelarApolice.setBackground(Color.decode("#007256"));
		btCancelarApolice.setForeground(Color.WHITE);
		btCancelarApolice.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnCancel.add(btCancelarApolice);

		btCancelarDelete = new JButton("Finalizar");
		btCancelarDelete.setBounds(283, 455, 165, 65);
		btCancelarDelete.setFont(new Font("", Font.BOLD, 20));
		btCancelarDelete.setBackground(Color.decode("#007256"));
		btCancelarDelete.setForeground(Color.WHITE);
		btCancelarDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btCancelarDelete.setEnabled(false);
		pnCancel.add(btCancelarDelete);

		btCancelCancelar = new JButton("Cancelar");
		btCancelCancelar.setBounds(89, 455, 165, 65);
		btCancelCancelar.setFont(new Font("", Font.BOLD, 20));
		btCancelCancelar.setBackground(Color.decode("#007256"));
		btCancelCancelar.setForeground(Color.WHITE);
		btCancelCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		pnCancel.add(btCancelCancelar);

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
		btMyClientes.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btMyClientes.setBackground(Color.decode("#00574f"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btMyClientes.setBackground(Color.decode("#007256"));
			}

		});

		btOcorrencias.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btOcorrencias.setBackground(Color.decode("#00574f"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btOcorrencias.setBackground(Color.decode("#007256"));
			}

		});
		btFinalServices.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btFinalServices.setBackground(Color.decode("#00574f"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btFinalServices.setBackground(Color.decode("#007256"));
			}

		});
		btRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btRelatorios.setBackground(Color.decode("#00574f"));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btRelatorios.setBackground(Color.decode("#007256"));
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

		//////////////////////////////// COMANDOS DE
		//////////////////////////////// AÇÕES/////////////////////////////////////
		btMainServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (pnCancel.isVisible()) {
					pnCancel.setVisible(false);

					pnMainServices.setVisible(true);
					getContentPane().add(pnMainServices);
				} else if (pnMyClientes.isVisible()) {
					pnMyClientes.setVisible(false);

					pnMainServices.setVisible(true);
					getContentPane().add(pnMainServices);
				} else if (pnOcorrencias.isVisible()) {
					pnOcorrencias.setVisible(false);

					pnMainServices.setVisible(true);
					getContentPane().add(pnMainServices);
				} else if (pnRelatorios.isVisible()) {
					pnRelatorios.setVisible(false);

					pnMainServices.setVisible(true);
					getContentPane().add(pnMainServices);
				}

			}
		});
		btMyClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (pnCancel.isVisible()) {
					pnCancel.setVisible(false);

					pnMyClientes.setVisible(true);
					getContentPane().add(pnMyClientes);
				} else if (pnMainServices.isVisible()) {
					pnMainServices.setVisible(false);

					pnMyClientes.setVisible(true);
					getContentPane().add(pnMyClientes);
				} else if (pnOcorrencias.isVisible()) {
					pnOcorrencias.setVisible(false);

					pnMyClientes.setVisible(true);
					getContentPane().add(pnMyClientes);
				} else if (pnRelatorios.isVisible()) {
					pnRelatorios.setVisible(false);

					pnMyClientes.setVisible(true);
					getContentPane().add(pnMyClientes);
				}
			}
		});
		btOcorrencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (pnCancel.isVisible()) {
					pnCancel.setVisible(false);

					pnOcorrencias.setVisible(true);
					getContentPane().add(pnOcorrencias);
				} else if (pnMainServices.isVisible()) {
					pnMainServices.setVisible(false);

					pnOcorrencias.setVisible(true);
					getContentPane().add(pnOcorrencias);
				} else if (pnMyClientes.isVisible()) {
					pnMyClientes.setVisible(false);

					pnOcorrencias.setVisible(true);
					getContentPane().add(pnOcorrencias);
				} else if (pnRelatorios.isVisible()) {
					pnRelatorios.setVisible(false);

					pnOcorrencias.setVisible(true);
					getContentPane().add(pnOcorrencias);
				}
			}
		});
		btRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (pnCancel.isVisible()) {
					pnCancel.setVisible(false);

					pnRelatorios.setVisible(true);
					getContentPane().add(pnRelatorios);
				} else if (pnMyClientes.isVisible()) {
					pnMyClientes.setVisible(false);

					pnRelatorios.setVisible(true);
					getContentPane().add(pnRelatorios);
				} else if (pnMainServices.isVisible()) {
					pnMainServices.setVisible(false);

					pnRelatorios.setVisible(true);
					getContentPane().add(pnRelatorios);
				} else if (pnOcorrencias.isVisible()) {
					pnOcorrencias.setVisible(false);

					pnRelatorios.setVisible(true);
					getContentPane().add(pnRelatorios);
				}

			}
		});
		btFinalServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (pnMainServices.isVisible()) {
					pnMainServices.setVisible(false);

					pnCancel.setVisible(true);
					getContentPane().add(pnCancel);
				} else if (pnMyClientes.isVisible()) {
					pnMyClientes.setVisible(false);

					pnCancel.setVisible(true);
					getContentPane().add(pnCancel);
				} else if (pnOcorrencias.isVisible()) {
					pnOcorrencias.setVisible(false);

					pnCancel.setVisible(true);
					getContentPane().add(pnCancel);
				} else if (pnRelatorios.isVisible()) {
					pnRelatorios.setVisible(false);

					pnCancel.setVisible(true);
					getContentPane().add(pnCancel);
				}

			}
		});

		btOcorrenciasBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {

				/*
				 * tbOcorrencias.setModel(controller.selectClientes(corretor.getId_corretor(),
				 * "SELECT * FROM tb_tok_ajuda_cliente WHERE id_corretor=?"));
				 */
			}
		});

		rbMyClientesNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txMyClientesNome.setVisible(true);
				txMyClientesNome.setText("");
				lbMyClientesNome.setVisible(true);
				btMyClientesBusca.setVisible(false);

				btMyClientesBuscaNome.setVisible(true);

				rbMyClientesM.setVisible(false);
				rbMyClientesF.setVisible(false);
				rbMyClientesO.setVisible(false);

			}
		});
		rbMyClientesTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txMyClientesNome.setVisible(false);
				lbMyClientesNome.setVisible(false);
				btMyClientesBusca.setVisible(true);
				btMyClientesBuscaNome.setVisible(false);

				rbMyClientesM.setVisible(false);
				rbMyClientesF.setVisible(false);
				rbMyClientesO.setVisible(false);

				// tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),"SELECT
				// * FROM tb_tok_cliente WHERE id_corretor=?"));

			}
		});
		rbMyClientesSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txMyClientesNome.setVisible(false);
				lbMyClientesNome.setVisible(false);
				btMyClientesBusca.setVisible(true);
				btMyClientesBuscaNome.setVisible(false);

				rbMyClientesM.setVisible(true);
				rbMyClientesF.setVisible(true);
				rbMyClientesO.setVisible(true);

				// tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),"SELECT
				// * FROM tb_tok_cliente WHERE id_corretor=? AND ob_sexo_cliente="));

			}
		});
		btMyClientesBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (rbMyClientesTodos.isSelected() && rbMyClientesSemOrdem.isSelected()) {
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=?"));

				} else if (rbMyClientesTodos.isSelected() && rbMyClientesAlfabetica.isSelected()) {
					// todos e ordem alfabética
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? ORDER BY nm_cliente ASC"));

				} else if (rbMyClientesTodos.isSelected() && rbMyClientesRenda.isSelected()) {
					// todos e ordem de renda
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? ORDER BY vl_renda_mensal DESC"));

				} else if (rbMyClientesSexo.isSelected() && rbMyClientesM.isSelected()
						&& rbMyClientesSemOrdem.isSelected()) {
					// Masculino sem ordem
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? AND ob_sexo_cliente='M'"));

				} else if (rbMyClientesSexo.isSelected() && rbMyClientesM.isSelected()
						&& rbMyClientesAlfabetica.isSelected()) {
					// Masculino e ordem alfabética
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? AND ob_sexo_cliente='M' ORDER BY nm_cliente ASC"));

				} else if (rbMyClientesSexo.isSelected() && rbMyClientesM.isSelected()
						&& rbMyClientesRenda.isSelected()) {
					// masculino e ordem de renda
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? AND ob_sexo_cliente='M' ORDER BY vl_renda_mensal DESC"));

				}

				else if (rbMyClientesSexo.isSelected() && rbMyClientesF.isSelected()
						&& rbMyClientesSemOrdem.isSelected()) {
					// Feminino sem ordem
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? AND ob_sexo_cliente='F' "));

				} else if (rbMyClientesSexo.isSelected() && rbMyClientesF.isSelected()
						&& rbMyClientesAlfabetica.isSelected()) {
					// Feminino e ordem alfabética
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? AND ob_sexo_cliente='F' ORDER BY nm_cliente ASC"));

				} else if (rbMyClientesSexo.isSelected() && rbMyClientesF.isSelected()
						&& rbMyClientesRenda.isSelected()) {
					// Feminino e ordem de renda
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? AND ob_sexo_cliente='F' ORDER BY vl_renda_mensal DESC"));

				} else if (rbMyClientesSexo.isSelected() && rbMyClientesO.isSelected()
						&& rbMyClientesSemOrdem.isSelected()) {
					// Feminino sem ordem
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? AND ob_sexo_cliente='O' "));

				} else if (rbMyClientesSexo.isSelected() && rbMyClientesO.isSelected()
						&& rbMyClientesAlfabetica.isSelected()) {
					// Feminino e ordem alfabética
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? AND ob_sexo_cliente='O' ORDER BY nm_cliente ASC"));

				} else if (rbMyClientesSexo.isSelected() && rbMyClientesO.isSelected()
						&& rbMyClientesRenda.isSelected()) {
					// Feminino e ordem de renda
					tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
							"SELECT * FROM tb_tok_cliente WHERE id_corretor=? AND ob_sexo_cliente='O' ORDER BY vl_renda_mensal DESC"));

				}

			}
		});
		btMyClientesBuscaNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {

				if (txMyClientesNome.getText().equals("")) {
					txMyClientesNome.requestFocus();
				} else {
					if (rbMyClientesSemOrdem.isSelected()) {
						tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
								"SELECT * FROM tb_tok_cliente WHERE id_corretor=? AND  nm_cliente LIKE '"
										+ txMyClientesNome.getText() + "%'"));

					} else if (rbMyClientesAlfabetica.isSelected()) {
						// nome e com ordem alfabetica
						tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
								"SELECT * FROM tb_tok_cliente WHERE id_corretor=?AND  nm_cliente LIKE '"
										+ txMyClientesNome.getText() + "%' ORDER BY nm_cliente ASC"));
					} else if (rbMyClientesRenda.isSelected()) {
						// nome e com ordem por renda
						tbMyClientes.setModel(controller.selectClientes(corretor.getId_corretor(),
								"SELECT * FROM tb_tok_cliente WHERE id_corretor=?AND  nm_cliente LIKE '"
										+ txMyClientesNome.getText() + "%' ORDER BY vl_renda_mensal DESC"));

					}
				}
			}
		});

		rbCancelImobiliario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txCancelNomeEmpresa.setVisible(true);
				lbCancelNomeEmpresa.setVisible(true);

				btCancelarDelete.setEnabled(false);
				txCancelApolice.setText("");
				txCancelNome.setText("");
				txCancelEndereco.setText("");
				txCancelRural.setText("");
				txCancelPortaria.setText("");
				txCancelAlvenaria.setText("");
				txCancelValorServico.setText("");
				txCancelNomeEmpresa.setText("");
				txCancelValorImovel.setText("");
				txCancelTipo.setText("");

			}
		});
		rbCancelFianca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txCancelNomeEmpresa.setVisible(false);
				lbCancelNomeEmpresa.setVisible(false);

				btCancelarDelete.setEnabled(false);
				txCancelApolice.setText("");
				txCancelNome.setText("");
				txCancelEndereco.setText("");
				txCancelRural.setText("");
				txCancelPortaria.setText("");
				txCancelAlvenaria.setText("");
				txCancelValorServico.setText("");
				txCancelNomeEmpresa.setText("");
				txCancelValorImovel.setText("");
				txCancelTipo.setText("");
			}
		});
		rbCancelResidencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				txCancelNomeEmpresa.setVisible(false);
				lbCancelNomeEmpresa.setVisible(false);

				btCancelarDelete.setEnabled(false);
				txCancelApolice.setText("");
				txCancelNome.setText("");
				txCancelEndereco.setText("");
				txCancelRural.setText("");
				txCancelPortaria.setText("");
				txCancelAlvenaria.setText("");
				txCancelValorServico.setText("");
				txCancelNomeEmpresa.setText("");
				txCancelValorImovel.setText("");
				txCancelTipo.setText("");
			}
		});

		btCancelarApolice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				if (txCancelApolice.getText().equals("")) {
					txCancelApolice.requestFocus();
				} else {
					// verificar se tem um serviço com essa apolice
					// Se sim buscar e colocar nos textfields

					btCancelarDelete.setEnabled(true);
					if (rbCancelResidencial.isSelected()) {

						/// Fazer a busca na tabela residencial e colocar nos textfields
						String sql = "select cli.nm_cliente, ecli.ob_endereco, ecli.ob_local_rural, ecli.ob_portaria_eletr, ecli.ob_habitacao_alvenaria, ecli.vl_imovel, crp.ob_tipo_habitacao, crp.vl_servico from tb_tok_endereco_cliente ecli left join tb_tok_cliente cli on (ecli.id_cliente  = cli.id_cliente) inner join tb_tok_corretagem_rp crp on (ecli.id_endereco = crp.id_endereco) inner join tb_tok_servicos ser on crp.cd_servico = ser.cd_servico where cd_consulta=?";
						System.out.print("aq funciona");
						Object[] objeto = controller.selectServicos(txCancelApolice.getText(), sql);

						txCancelNome.setText((String) objeto[0]);
						txCancelEndereco.setText((String) objeto[1]);
						txCancelRural.setText((String) objeto[2]);
						txCancelPortaria.setText((String) objeto[3]);
						txCancelAlvenaria.setText((String) objeto[4]);
						txCancelValorServico.setText((String) objeto[5]);
						txCancelValorImovel.setText((String) objeto[6]);
						txCancelTipo.setText((String) objeto[7]);

					} else if (rbCancelImobiliario.isSelected()) {

						/// Fazer a busca na tabela imobliario e colocar nos textfields
						txCancelNome.setText("Guedes");
						txCancelEndereco.setText("ONDE JUDAS PERDEU AS BOTAS");
						txCancelRural.setText("Nao");
						txCancelPortaria.setText("Nao");
						txCancelAlvenaria.setText("Nao");
						txCancelValorServico.setText("2000");
						txCancelNomeEmpresa.setText("SLA");
						txCancelValorImovel.setText("1000000");
						txCancelTipo.setText("SAL");

						btCancelarDelete.setEnabled(true);

					} else {
						/// Fazer a busca na tabela Fianca aluguel e colocar nos textfields
						txCancelNome.setText("LUIzao");
						txCancelEndereco.setText("RUAona");
						txCancelRural.setText("Sim");
						txCancelPortaria.setText("Sim");
						txCancelAlvenaria.setText("Sim");
						txCancelValorServico.setText("1000");
						txCancelValorImovel.setText("750000");
						txCancelTipo.setText("apartamentao");

						btCancelarDelete.setEnabled(true);

					}
				}

			}
		});
		btCancelarDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				String sql = "";
				if (rbCancelResidencial.isSelected()) {
					sql = "DELETE from tb_tok_corretagem_rp where cd_consulta=?";
					if(controller.delete(txCancelApolice.getText(), sql)) {
						JOptionPane.showMessageDialog(null, "Deletado com sucesso");
						btCancelarDelete.setEnabled(false);
						txCancelApolice.setText("");
						txCancelNome.setText("");
						txCancelEndereco.setText("");
						txCancelRural.setText("");
						txCancelPortaria.setText("");
						txCancelAlvenaria.setText("");
						txCancelValorServico.setText("");
						txCancelNomeEmpresa.setText("");
						txCancelValorImovel.setText("");
						txCancelTipo.setText("");
						
					}else {
						JOptionPane.showMessageDialog(null, "Erro ao deletar");
						btCancelarDelete.setEnabled(false);
						txCancelApolice.setText("");
						txCancelNome.setText("");
						txCancelEndereco.setText("");
						txCancelRural.setText("");
						txCancelPortaria.setText("");
						txCancelAlvenaria.setText("");
						txCancelValorServico.setText("");
						txCancelNomeEmpresa.setText("");
						txCancelValorImovel.setText("");
						txCancelTipo.setText("");
					}

				} else if (rbCancelImobiliario.isSelected()) {

				} else {

					
				}
			}
		});
		btCancelCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argse) {
				btCancelarDelete.setEnabled(false);
				txCancelApolice.setText("");
				txCancelNome.setText("");
				txCancelEndereco.setText("");
				txCancelRural.setText("");
				txCancelPortaria.setText("");
				txCancelAlvenaria.setText("");
				txCancelValorServico.setText("");
				txCancelNomeEmpresa.setText("");
				txCancelValorImovel.setText("");
				txCancelTipo.setText("");

				pnCancel.setVisible(false);
				pnMainServices.setVisible(true);
				getContentPane().add(pnMainServices);

			}
		});

	}

	public void close() {
		this.setVisible(false);
	}
}
