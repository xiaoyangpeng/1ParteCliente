package Controlador;

import javax.swing.table.DefaultTableModel;

public class InicarModeloDeTabla {
	
	final  String st[]=	new String[] {
			
			"Nombre", "Precio"
		};
	
	
	public DefaultTableModel modelo;
	

	public InicarModeloDeTabla() {
		
		modelo=new DefaultTableModel(st,0);
		
	}


	public DefaultTableModel getModelo() {
		
		return modelo;
	}


	public void addRow(String[] valores) {
		// TODO Auto-generated method stub
		
		modelo.addRow(valores);
		
	}
}
