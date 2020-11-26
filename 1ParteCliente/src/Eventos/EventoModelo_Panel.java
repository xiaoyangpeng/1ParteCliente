package Eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Interfaz.Ventana_Usuario;

public class EventoModelo_Panel extends MouseAdapter{

	JTable tabla;
	DefaultTableModel modelocesta;
	Ventana_Usuario  ventana;
	public EventoModelo_Panel(JTable tabla,Ventana_Usuario ventana) {
		// TODO Auto-generated constructor stub
		this.ventana=ventana;
		this.tabla=tabla;
		this.modelocesta=ventana.getModelo();
				
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		
		int count=tabla.getSelectedRow();// fila
		String nombre= tabla.getValueAt(count, 0).toString();//columna
		String precio= tabla.getValueAt(count, 1).toString();//columna
		String cantidad=andirCantidad(nombre);
		
	
		int quefilahay;
	
		if(cantidad!=null) {
			
			quefilahay=buscaSiyaexiste(nombre);// buscar si ya exite en cesta o no
											//en caso de no añadir una fila nueva
			// si existe añadir cantidad de comida a esta fila
			
			if(quefilahay==-1) {
			
				String[] st={nombre,precio,cantidad};
				modelocesta.addRow(st);
				
				// sumar los precio de la cesta
				ventana.getTotal().setText(String.valueOf(sumaTotal()));
				
			}
			else {
				
				int cantidadCesta=Integer.parseInt(modelocesta.getValueAt(quefilahay, 2).toString());
				
				int ca=Integer.parseInt(cantidad);
				
				int suma=ca+cantidadCesta;
				
				modelocesta.setValueAt(suma, quefilahay,2);
				
				// sumar los precio de la cesta
				ventana.getTotal().setText(String.valueOf(sumaTotal()));
				
			}
		
		}
		
	}

	public String andirCantidad(String valor) {
		
		String[] cantidad = {
	            "1",
	            "2",
	            "3",
	            "4"
	        };

	     String res = (String)  JOptionPane.showInputDialog(null,
	    				 "Cuantas "+valor+" vas pedir ?",
	    				 "Cantidad", 
	    				 JOptionPane.DEFAULT_OPTION, 
	    				 null, 
	    				 cantidad,
	    				 cantidad[0]);

		return res;
	}
	
	
	public int buscaSiyaexiste(String nombre) {
		
	

		for(int i=0;i<modelocesta.getRowCount();i++) {
			
			
			if(nombre.equals(modelocesta.getValueAt(i, 0).toString())){
			
				
				return i;
			}
			
		}
		
		return -1;
	}
	
	
	
		
	public double sumaTotal() {
		
		
		double total=0;
		
		for(int i=0;i<modelocesta.getRowCount();i++) {
			
			double precio=Double.parseDouble(modelocesta.getValueAt(i, 1).toString());
			
			int cantidad=Integer.parseInt(modelocesta.getValueAt(i, 2).toString());
			
			total=total+(precio*cantidad);
			}
			
		
		return total;
		}
	
	
}
