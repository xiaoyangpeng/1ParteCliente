package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import BBDD.BBDDComidas;


public class AndairAtabla {

	InicarModeloDeTabla modelo;
	BBDDComidas base;
	ResultSet resultado;
		
public DefaultTableModel BucarSeguncategoira(String valor) {
		
		modelo=new InicarModeloDeTabla();
		
		base=new BBDDComidas();
		
		resultado=base.buscar(valor);
	
		pasaSiguitesFilas();
		
		base.cerrar();
		
		return modelo.getModelo();
	}
	
	private void pasaSiguitesFilas() {

		try {
			
			while(resultado.next()) {// recorrer el ResultSet
				
				String[] valores=base.getValorComidas(resultado);
																
				modelo.addRow(valores);// añadir fila
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
