package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.undo.CannotUndoException;

import ValorFijo.BBDD;
import ValorFijo.NombreFijo;
import ValorFijo.cuentaUsuario;

public class BBDD_pedido {

	
	Connection conexion;
	PreparedStatement tabla;
	ResultSet resultado=null;
	String usuario;
	
	public  BBDD_pedido() {
		// TODO Auto-generated constructor stub
		
		try {
			conexion=DriverManager.getConnection(BBDD.url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
public int buscarultimoID() {
		
		String sql="select seq from sqlite_sequence where name='Pedido'";
		
		int ultimo=0;
		
		try {
			tabla=conexion.prepareStatement(sql);
			
	
			tabla.execute();
			
			resultado=tabla.getResultSet();
			
			while(resultado.next()) {
				
			ultimo=resultado.getInt("seq");
			
		
			
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ultimo;
	}
	
public boolean buscarSienviado(int valor) {
		
		String sql="select enviado from pedido where numero= ?";
		try {
			tabla=conexion.prepareStatement(sql);
			
			tabla.setInt(1,valor);
			
			tabla.execute();
			
			resultado=tabla.getResultSet();
			
			while(resultado.next()) {
				
			
				if(resultado.getBoolean("enviado")) {
					return true;
				}
			
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

	public void Crear(){
		

		try {
			
		String sql=	" Insert into pedido(usuario,enviado) Values ( ?,false)";
			
		
		tabla=conexion.prepareStatement(sql);
		
		tabla.setString(1, cuentaUsuario.cuenta);
		
		
		tabla.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
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
