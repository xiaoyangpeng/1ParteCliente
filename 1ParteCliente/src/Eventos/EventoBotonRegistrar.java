package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlador.Usuario;
import Interfaz.VentanaRegistrar;

public class EventoBotonRegistrar implements ActionListener{


	
	
	String usuario;
	String contrasena;
	String Repitecontrasena;
	
	JTextField textusuario;
	 JPasswordField textcontrasena;
	 JPasswordField textRepitecontrasena;
	 
	 JButton registar;
	 
	 JLabel Aviso_registrar;
	 
	 boolean  cambiaContrasena=false;
	 
	 public EventoBotonRegistrar(VentanaRegistrar ventana,boolean cambiaContrasena) {

		this.textusuario = ventana.getUsuaio();
		this.textcontrasena = ventana.getContrasena();
		this.textRepitecontrasena = ventana.getRepitecontrasena();
		this.registar=ventana.getButtonRegistrar();
		this.Aviso_registrar=ventana.getAviso_registrar();
		this.cambiaContrasena=cambiaContrasena;
		
	}
	 public EventoBotonRegistrar(VentanaRegistrar ventana) {

			this.textusuario = ventana.getUsuaio();
			this.textcontrasena = ventana.getContrasena();
			this.textRepitecontrasena = ventana.getRepitecontrasena();
			this.registar=ventana.getButtonRegistrar();
			this.Aviso_registrar=ventana.getAviso_registrar();
			
		}
	

	
	void asignar() {
		
		this.usuario=textusuario.getText();
		
		this.contrasena=new String(textcontrasena.getPassword());
		
		this.Repitecontrasena=new String(textRepitecontrasena.getPassword());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		asignar();
		
		if(comprobar_vacio()&&comproba_numero()&&comprobar_consistir_contrasena()) {
		
			if(!cambiaContrasena) {
				
				crearUsuario();
			}
			else {
				
				cambiarContrasena();
				
			}
			
		}
		
		
	}
	
	void cambiarContrasena() {
		
		Usuario cambia=new Usuario();
		
		cambia.Modificar(usuario, contrasena);
		
		registar.setEnabled(false);
		
		Aviso_registrar.setText("ya esta Modificado");
		
	}
	
	
	void crearUsuario() {
		
		Usuario existe=new Usuario();
		
		if(!existe.SiexisteUsuario(usuario)){
		
		Usuario crear=new Usuario();
		
		crear.crear(usuario, contrasena);
		
		Aviso_registrar.setText("ya esta registrado");
		
		registar.setEnabled(false);
		}
		else {
			
			JoPanelAviso .aviso("Ya existe este usuario");
		}
	}
	
	
	
	
	
	boolean comprobar_vacio(){
		
		
		if(usuario.equals("")||contrasena.equals("")||Repitecontrasena.equals("")) {
			
			JoPanelAviso .aviso("Hay campo esta vacio");
		
			return false;
			
		}
		else {
			
			return true;
		}
		
	}
	
	boolean comproba_numero() {
		
		System.out.println(usuario);
		
		try {
			
			int numeor=Integer.parseInt(usuario);
			
		}catch(Exception e) {
			
			JoPanelAviso .aviso("Usuario debe ser numerico");
		
			return false;
		}
		
		return true;
	}
	
	boolean comprobar_consistir_contrasena() {
		
		
		if(!contrasena.equals(Repitecontrasena)) {
			
			JoPanelAviso .aviso("Contraseña no son iguales");
			
			return false;
		}
		
		return true;
	}
	
	


}
