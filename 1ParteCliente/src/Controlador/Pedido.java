package Controlador;

import BBDD.BBDD_pedido;
import ValorFijo.IDPedidoActual;

public class Pedido {
	
	
	public void enviarPeido(){
		
		
		BBDD_pedido pedido=new BBDD_pedido();
		
		//como numero de pedido autoincrementa por tanto id actula es ultimo id + 1
		IDPedidoActual.id=pedido.buscarultimoID()+1;
		
		pedido.Crear();
	}
	
	
	
}
