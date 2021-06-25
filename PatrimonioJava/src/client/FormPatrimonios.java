package client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class FormPatrimonios extends JFrame {
	private static final long serialVersionUID = 1L;

	// JGui
	private JButton salvar, adicionar, atualizar, delete;
	private JLabel jlbNome;

	// Bordas
	private TitledBorder bordaOpcoes;
	private Border emptyBorder;

	// Cores
	private String SpaceCadetColor = "#272640";
	private String CelesteColor = "#C0FDFF";
	private String SlateBlueColor = "#5E60CE";

	void AreaTrabalho() {
		//this.setTitle("Contador de Patrimonio");
		this.setLayout(null);
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.WHITE);

		jlbNome = new JLabel("PAINEL DE OBJETOS DA EMPRESA");
		jlbNome.setFont(new Font("Nunito", Font.BOLD, 20));
		jlbNome.setBounds(465, 10, 335, 17);
		this.add(jlbNome);
	}

	private JPanel Painelprincipal;

	void PainelOpcoes() {

		this.Painelprincipal = new JPanel();
		this.Painelprincipal.setLayout(null);
		this.Painelprincipal.setBounds(25, 170, 100, 300);
		this.Painelprincipal.setBackground(Color.WHITE);

		bordaOpcoes = BorderFactory.createTitledBorder("Opções");
		bordaOpcoes.setTitleJustification(TitledBorder.CENTER);
		bordaOpcoes.setTitleColor(Color.decode(SpaceCadetColor));
		this.Painelprincipal.setBorder(bordaOpcoes);

		botoes();
		Painelprincipal.add(adicionar);
		Painelprincipal.add(delete);
		Painelprincipal.add(salvar);
		Painelprincipal.add(atualizar);

	}

	// Items
	void botoes() {

		// add button
		adicionar = new JButton("Adicionar");
		adicionar.setBounds(10, 20, 80, 50);
		adicionar.setBorder(emptyBorder);
		adicionar.setBorderPainted(false);
		adicionar.setFocusable(false);
		adicionar.setBackground(Color.decode(SlateBlueColor));
		adicionar.setForeground(Color.WHITE);
		adicionar.setFont(new Font("Nunito", Font.BOLD, 14));
		// adicionar.addActionListener(this);

		// delete button
		delete = new JButton("Deletar");
		delete.setBounds(10, 90, 80, 50);
		delete.setBorder(emptyBorder);
		delete.setBorderPainted(false);
		delete.setFocusable(false);
		delete.setBackground(Color.decode(SlateBlueColor));
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Nunito", Font.BOLD, 14));
		// excluir.addActionListener(this);

		// save button
		salvar = new JButton("Salvar");
		salvar.setBounds(10, 160, 80, 50);
		salvar.setBorder(emptyBorder);
		salvar.setBorderPainted(false);
		salvar.setFocusable(false);
		salvar.setBackground(Color.decode(SlateBlueColor));
		salvar.setForeground(Color.WHITE);
		salvar.setFont(new Font("Nunito", Font.BOLD, 14));
		// salvar.addActionListener(this);

		// update button
		atualizar = new JButton("Atualizar");
		atualizar.setBounds(10, 230, 80, 50);
		atualizar.setBorder(emptyBorder);
		atualizar.setBorderPainted(false);
		atualizar.setFocusable(false);
		atualizar.setBackground(Color.decode(SlateBlueColor));
		atualizar.setForeground(Color.WHITE);
		atualizar.setFont(new Font("Nunito", Font.BOLD, 14));
		// atualizar.addActionListener(this);

	}

	FormPatrimonios() {
		this.AreaTrabalho();
		this.PainelOpcoes();
		this.add(Painelprincipal);
	}

	// Runner
	public static void main(String[] args) {
		new FormPatrimonios().setVisible(true);
	}

}
