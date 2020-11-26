package Interfaz;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Eventos.EventoModelo_Panel;

public class Modelo_Panel extends JScrollPane{
	
	
	JTable table;
	
	
	public Modelo_Panel(DefaultTableModel modelo,Ventana_Usuario ventana) {
	
	
	table = new JTable() {	// asi tabla no se puede modificar
		
		@Override
		public boolean isCellEditable(int row,int colum) {
		
		return false;
	}
};
	
	table.setModel(modelo);
	
	setViewportView(table);
	
	
	EventoModelo_Panel ranton=new EventoModelo_Panel(table,ventana);
	
	
	table.addMouseListener(ranton);
	
	}

}
