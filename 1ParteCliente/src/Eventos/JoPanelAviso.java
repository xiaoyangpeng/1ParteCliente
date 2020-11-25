package Eventos;

import javax.swing.JOptionPane;

public class JoPanelAviso {

	
	static public void aviso(String valor) {
		
		
		JOptionPane.showMessageDialog(null, valor, 
				"Error",
				JOptionPane. ERROR_MESSAGE);
		
	}
}
