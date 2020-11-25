package BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ValorFijo.BBDD;
public class BBDD_Cliente {

	
	Connection conexion;
	PreparedStatement tabla = null;
	ResultSet resultado=null;
	String usuario;
	

	public BBDD_Cliente() {
		
		try {
			// Asociamos el driver de SQLite
			Class.forName("org.sqlite.JDBC");
			conexion=DriverManager.getConnection(BBDD.url,"","");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
			
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	

	public boolean buscarUsuario(String Usuario){
		
		try {
			
			String sql="SELECT  * FROM Usuario where ID = ?";
			
			tabla=conexion.prepareStatement(sql);
			
			tabla.setInt(1, Integer.parseInt(Usuario));
			
			tabla.execute();
			
			resultado=tabla.getResultSet();
	
			if(resultado.next()) {
				
			usuario=resultado.getString("ID");
			
			return true;
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}
		return false;
		
	}
	
	
	public String buscarContrasena(){
		
		
		String contasena = null;
		try {
			
		String sql="SELECT Contrasena FROM Usuario where ID ="+usuario;
			
		
		tabla=conexion.prepareStatement(sql);
		
		tabla.execute();
		
		resultado=tabla.getResultSet();
		
	
		 contasena=resultado.getString("Contrasena");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return contasena;
		
	}
	
	public void modificar(int Usuario,String Contrasena) {
		
		String sql="UPDATE Usuario "
				+ "set Contrasena= ? "
				+ "where ID =?";
		try {
			
			
			tabla=conexion.prepareStatement(sql);
			
			tabla.setString(1, Contrasena);
			tabla.setInt(2, Usuario);
			tabla.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public String Crear(int Usuario,String Contrasena){
		
		
		String contasena = null;
		try {
			
		String sql=	sql=" Insert into Usuario Values ( ?,?)";
			
		
		tabla=conexion.prepareStatement(sql);
		
		tabla.setInt(1, Usuario);
		tabla.setString(2, Contrasena);
		
		tabla.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return contasena;
		
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
