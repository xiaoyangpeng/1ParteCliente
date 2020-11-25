package Interfaz;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Eventos.EventoBotonRegistrar;
import Eventos.EventoPanel_Usuario;
import Eventos.Evento_BotonEntrar;
import ValorFijo.Imagen;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Panel_Entrar extends JPanel {

	/**
	 * Create the  
	 */
	
	private JTextField Usuario;
	
	private JPasswordField Contrasena;
	
	private  JButton entrar;
	
	private JLabel TipoUsuario;

	public Panel_Entrar() {
		
	

		setLayout(null);
		
		Usuario = new JTextField();
		Usuario.setBounds(135, 85, 145, 21);
		 add(Usuario);
		Usuario.setColumns(10);
		
		Contrasena = new JPasswordField();
		Contrasena.setBounds(133, 128, 147, 21);
		 add(Contrasena);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(29, 88, 58, 15);
		 add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrasena");
		lblNewLabel_1.setBounds(29, 131, 94, 15);
		 add(lblNewLabel_1);
		
		 entrar = new JButton("Entrar");
		 entrar.setBounds(93, 189, 157, 38);
		  add(entrar);
		

		JButton registar = new JButton("Registrar");
		registar.setBounds(260, 204, 97, 23);
		 add(registar);
		
	
		JButton botonOlvidarContrasena = new JButton("Olvida contrasena");
		
		botonOlvidarContrasena.setBounds(91, 263, 207, 23);
		
		 add(botonOlvidarContrasena);
		
		TipoUsuario = new JLabel("Cliente");
		TipoUsuario.setFont(new Font("Traditional Arabic", Font.PLAIN, 28));
		TipoUsuario.setForeground(Color.RED);
		TipoUsuario.setBounds(131, 11, 168, 52);
		 add(TipoUsuario);
		
		
		ImageIcon icon=new ImageIcon(Imagen.usuario);
		JLabel foto= new JLabel(icon);
		foto.setBounds(290, 11, 145, 138);
		 add(foto);
		
		 
		 registar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VentanaRegistrar ventana=new VentanaRegistrar("registrar");
				ventana.registar();
			}
		});
		 
		
	
	}
	
	
	


	public JTextField getUsuario() {
		return Usuario;
	}


	public JPasswordField getContrasena() {
		return Contrasena;
	}


	public JButton getEntrar() {
		return entrar;
	}


	public JLabel getTipoUsuario() {
		return TipoUsuario;
	}
	
	
	
	
	
	
}
