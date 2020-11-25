package Eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EventoTablaCesta extends MouseAdapter {


	DefaultTableModel modelocesta;
	JTable tabla;
	public EventoTablaCesta(JTable tabla,DefaultTableModel modelocesta) {
		// TODO Auto-generated constructor stub
		this.tabla=tabla;
		this.modelocesta=modelocesta;
				
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println(tabla.getSelectedRow());// fila);
	}
	
}
