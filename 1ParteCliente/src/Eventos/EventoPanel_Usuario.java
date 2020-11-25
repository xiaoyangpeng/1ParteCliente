package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Interfaz.Panel_Entrar;
import Interfaz.Ventana_Usuario;
import ValorFijo.Imagen;

public class EventoPanel_Usuario implements ChangeListener ,ActionListener {



	JTabbedPane usuario;
	
	static  int quepanel;

	public EventoPanel_Usuario(JTabbedPane usuario) {
	
		this.usuario = usuario;
		
	}

		@Override// vertificar que panel ha elegido
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			
			 quepanel  = usuario.getSelectedIndex(); 
			
			 	if(quepanel==0) {
		
			 		
			 	}
			 	else if(quepanel==1) {
			 		
			
			 		
			 	}
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	
}
