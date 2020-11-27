package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import ValorFijo.BBDD;
import ValorFijo.IDPedidoActual;

public class QueComida {

	Connection conexion;
	PreparedStatement tabla;
	ResultSet resultado=null;
	DefaultTableModel modelocesta;
	
	public QueComida () {
		// TODO Auto-generated constructor stub
		
		try {
			conexion=DriverManager.getConnection(BBDD.url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void  Crear(DefaultTableModel modelocesta) {
		
		this.modelocesta=modelocesta;
		
		int numeroPedido=IDPedidoActual.id;
		
	
		String sql="Insert into Quecomida values( "+numeroPedido+", ?, ? ,?)";
		
		try {
			
		

			for(int i=0;i<modelocesta.getRowCount();i++) {
				
				tabla=conexion.prepareStatement(sql);
				String nombre=modelocesta.getValueAt(i, 0).toString();
				double precio=Double.parseDouble(modelocesta.getValueAt(i, 1).toString());
				int cantidad=Integer.parseInt(modelocesta.getValueAt(i, 2).toString());
				tabla.setString(1,nombre);
				tabla.setInt(2, cantidad);
				tabla.setDouble(3, precio);
				tabla.execute();
				
				}
		
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	public double SacarDatos() {
		
		
		double total=0;
		
		
		return total;
		}
	

	
	
	
	public void cerrar() {
		//Cerramos las conexiones de la BBDD
		 
		 try {
			 if (resultado != null) { // liberar el ResultSet si lo hemos usado
				 resultado.close();
			 }
			 
			 if (tabla != null) { // liberar los Statement
				 tabla.close();
				 }
			 
			 if (conexion != null) { // liberar la conexi¨®n a la BD
				 conexion.close();
				 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
}
