package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

import Controlador.Pedido;
import Interfaz.Ventana_Usuario;

public class EventoPanelTermina implements ActionListener{

	JTabbedPane tabbePane;
	JScrollPane scroll;
	JPanel panelmedia;
	JPanel panelterminad;
	Ventana_Usuario ventana;
	
	/*public EventoPanelTermina(JTabbedPane tabbePane, JScrollPane scroll,JPanel panelmedia,JPanel panelterminad) {
		this.tabbePane = tabbePane;
		this.scroll = scroll;
		this.panelmedia=panelmedia;
		this.panelterminad=panelterminad;
		
		
	}	*/
	
	public EventoPanelTermina(Ventana_Usuario ventana,JPanel panelterminada) {
	
		this.ventana=ventana;
		this.panelterminad=panelterminada;
		
	}
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		int resultado=JOptionPane.showConfirmDialog(
				ventana,
				
				"Seguro quieres hacer el pedido ?",// mensaje
				
				"Seguro",// Titulo
				
				JOptionPane.YES_NO_OPTION);//YES =0, NO = 1 
		
		if(resultado==0) {
			
			// en caso en cesta esta vacio es decir no 
			// hya ninguna fina salta menaje de aviso error
			if(ventana.getModelo().getRowCount()!=0) {
				
			ventana.getContentPane().setVisible(false);
			panelterminad.setVisible(true);
			ventana.setContentPane(panelterminad);
			
			Pedido pide=new Pedido();
			pide.enviarPeido();
			
			
			
			}else {
				
				JoPanelAviso.aviso("No has pedido nada");
			}
			
		}
		
	
	}
	
	
	
	
	
}
