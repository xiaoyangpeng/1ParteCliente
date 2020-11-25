package Controlador;

import BBDD.BBDD_Cliente;

public class Usuario {


	// comprobar si exite el usuario , si existe entra else para
	// buscar si conisite con su contraseña
public	boolean ComprobaUsuarioYContra(String Usuario,String contrasena) {
	
		BBDD_Cliente usuario=new BBDD_Cliente();
		
		if(!usuario.buscarUsuario(Usuario)) {
			usuario.cerrar();
			return false;
		}
		else {
			if(usuario.buscarContrasena().equals(contrasena)) {
				usuario.cerrar();
				return true;
			}
			else {
				usuario.cerrar();
				return false;
			}
			
			
		}
		
	}


	public boolean SiexisteUsuario(String Usuario){
		
		BBDD_Cliente usuario=new BBDD_Cliente();
		
		if(usuario.buscarUsuario(Usuario)) {
			
			usuario.cerrar();
			
			return true;
		}
		
		usuario.cerrar();
		
		return false;
	
	
}
	
public void Modificar(String Usuario,String Contrasena) {
		
		BBDD_Cliente usuario=new BBDD_Cliente();
		usuario.modificar(Integer.parseInt(Usuario), Contrasena);
		usuario.cerrar();
		
	}



	public void crear(String Usuario,String Contrasena) {
		
		BBDD_Cliente usuario=new BBDD_Cliente();
		usuario.Crear(Integer.parseInt(Usuario), Contrasena);
		usuario.cerrar();
		
	}
	


}
