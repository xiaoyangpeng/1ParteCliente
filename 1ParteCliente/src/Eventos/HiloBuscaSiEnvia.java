package Eventos;

import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JTable;

import BBDD.BBDD_pedido;
import ValorFijo.IDPedidoActual;

public class HiloBuscaSiEnvia  extends Thread{
	
	
	JLabel mensajeTemina;

	public HiloBuscaSiEnvia(JLabel mensajeTemina) {
		this.mensajeTemina = mensajeTemina;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	while(true) {
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(pertificarEnviado()) {
				break;
			}
		
		}
	
	}
	
		
	boolean pertificarEnviado() {
		
		BBDD_pedido pedido;
		
		try {
			pedido = new BBDD_pedido();
			
			if(pedido.buscarSienviado(IDPedidoActual.id)) {
				
				mensajeTemina.setText("El restaurante ya te ha enviado ");
				
				return true;
			}
		
			pedido.cerrar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			pertificarEnviado();
			
		}
		
		return false;
		
	}

}
