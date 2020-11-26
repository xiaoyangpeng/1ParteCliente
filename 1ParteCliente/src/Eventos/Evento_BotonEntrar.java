package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.undo.CannotUndoException;

import Controlador.Usuario;
import Interfaz.Panel_Entrar;
import Interfaz.Ventana_Usuario;
import ValorFijo.cuentaUsuario;


public class Evento_BotonEntrar implements ActionListener{

	Panel_Entrar panelentraentra;
	
     JFrame frame;
     String usuario;
     String contrasena;
     
	public Evento_BotonEntrar( JFrame frame,Panel_Entrar panelEntrar) {
	
		this.panelentraentra=panelEntrar;
		
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {// hace invisible panel de entrar 
		                                      // y hace visible panel de rellena datos
		// TODO Auto-generated method stub
	
		
		if(buscaUsuario()) {// solo en caso si existe cuenta de usuario y es correcto su contraseña 
	
			frame.setVisible(false);
			
			cuentaUsuario.cuenta=usuario;
			Ventana_Usuario ventan=new Ventana_Usuario();
			
		}
		
		
	}

	
	boolean buscaUsuario(){
		
		usuario=panelentraentra.getUsuario().getText();
		
		
		contrasena=new String(panelentraentra.getContrasena().getPassword());
		
		
		
		if(comprobarVacio(usuario)&&comprobarVacio(contrasena)) {
	
		Usuario busca=new Usuario();
		
		
			if(busca.ComprobaUsuarioYContra(usuario, contrasena)) {
					
				return true;
				
			}
			else {
				
				//panelentraentra.setAviso_Entrar("Usuario o contraseña incorrecto");
				
				JoPanelAviso.aviso("Usuario o contraseña incorrecto");
				
				return false;
			}
		
		}
		else {
		
		
		//	panelentraentra.setAviso_Entrar("vacio");
			
			JoPanelAviso.aviso("Usuario vacio");
			
			return false;
		}
		
		
	}
	
	boolean comprobarVacio(String valor) {
		
		if(!valor.equals("")) {
			return true;
		}
		
		return false;
	}
	
	
}
