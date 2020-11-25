package Eventos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EventoVentanaPrincipal  extends WindowAdapter{
	
	
	
	JFrame ventana;
	
	public EventoVentanaPrincipal(JFrame ventana) {
		// TODO Auto-generated constructor stub
		this.ventana=ventana;
	
	}
	
	public void windowClosing(WindowEvent e) {
	
		int resultado=JOptionPane.showConfirmDialog(ventana,
				
				"Seguro quieres salir ?",// mensaje
				
				"SALIR",// Titulo
				
				JOptionPane.YES_NO_OPTION);//YES =0, NO = 1 
		
		if(resultado==0) {
			
			System.exit(-1);// cerrar programa
			
		}
		
		
	}

}
