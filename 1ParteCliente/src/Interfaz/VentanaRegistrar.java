package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Eventos.EventoBotonRegistrar;

import java.awt.Color;

public class VentanaRegistrar extends JFrame {

	private JPanel contentPane;
	private JPasswordField repitecontrasena;
	private JLabel Aviso_registrar;
	private JTextField Usuaio;
	private JPasswordField Contrasena;
	private JButton ButtonRegistrar;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public VentanaRegistrar(String que) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Usuaio = new JTextField();
		Usuaio.setBounds(166, 85, 145, 21);
		getContentPane().add(Usuaio);
		Usuaio.setColumns(10);
		
		Contrasena = new JPasswordField();
		Contrasena.setBounds(166, 128, 147, 21);
		getContentPane().add(Contrasena);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(29, 88, 58, 15);
		getContentPane().add(lblNewLabel);
		
		repitecontrasena = new JPasswordField();
		repitecontrasena.setBounds(166, 169, 147, 21);
		contentPane.add(repitecontrasena);
		
		JLabel lblContresena = new JLabel("Contresena");
		lblContresena.setBounds(29, 131, 80, 15);
		contentPane.add(lblContresena);
		
		JLabel lblReptiteContresena = new JLabel("Repite Contaseña");
		lblReptiteContresena.setBounds(10, 172, 146, 15);
		contentPane.add(lblReptiteContresena);
		
		ButtonRegistrar = new JButton(que);
		ButtonRegistrar.setBounds(175, 231, 97, 23);
		contentPane.add(ButtonRegistrar);
		
		Aviso_registrar= new JLabel("");
		
		Aviso_registrar.setForeground(Color.RED);
		Aviso_registrar.setBounds(82, 271, 346, 27);
		contentPane.add(Aviso_registrar);
	

		setVisible(true);
	}

	
	public	void registar(){
		
		EventoBotonRegistrar registrar=new EventoBotonRegistrar(this);
		ButtonRegistrar.addActionListener(registrar);
		
	}
	
	public void cambiaContrasena(String idUsuario){
		
		Usuaio.setText(idUsuario);
		Usuaio.setEnabled(false);
		EventoBotonRegistrar registrar=new EventoBotonRegistrar(this,true);
		ButtonRegistrar.addActionListener(registrar);
		
	}
	
	
	public JPasswordField getRepitecontrasena() {
		return repitecontrasena;
	}

	public JLabel getAviso_registrar() {
		return Aviso_registrar;
	}

	public JTextField getUsuaio() {
		return Usuaio;
	}

	public JPasswordField getContrasena() {
		return Contrasena;
	}

	public JButton getButtonRegistrar() {
		return ButtonRegistrar;
	}
	
	
	
}



