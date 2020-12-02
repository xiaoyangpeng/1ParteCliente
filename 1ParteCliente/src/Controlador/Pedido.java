package Controlador;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import BBDD.BBDD_pedido;
import BBDD.QueComida;
import ValorFijo.IDPedidoActual;

public class Pedido {
	
	
	
	
	public void enviarPeido(String direccion){
		
		
		BBDD_pedido pedido;
		try {
			
			
			pedido = new BBDD_pedido();
			
			
			//como numero de pedido autoincrementa por tanto id actula es ultimo id + 1
			IDPedidoActual.id=pedido.buscarultimoID()+1;
			
			pedido.Crear(direccion);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
			// TODO Auto-generated constructor stub
			
		
	
	}
	
	
	public void enviarComida(DefaultTableModel modelocesta) {
		
		
		QueComida enviaComida=new QueComida();
	
		enviaComida.Crear(modelocesta);
		
		enviaComida.cerrar();
	}
	
	
	
}
