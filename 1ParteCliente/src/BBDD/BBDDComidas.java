package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ValorFijo.BBDD;
public class BBDDComidas {

	Connection conexion;
	PreparedStatement tabla;
	ResultSet resultado=null;
	public BBDDComidas() {
		// TODO Auto-generated constructor stub
		
		try {
			conexion=DriverManager.getConnection(BBDD.url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ResultSet buscar(String valor) {
		
		String sql="select nombre, precio from comidas where categoria= ?";
		try {
			tabla=conexion.prepareStatement(sql);
			
			tabla.setString(1,valor);
			
			tabla.execute();
			
			resultado=tabla.getResultSet();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public String[] getValorComidas(ResultSet resultado) {
		
		
		String[] valor=new String[2];
		
		
		try {
			valor[0]=resultado.getString("nombre");
			valor[1]=resultado.getString("precio");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return valor;
		
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
