package Eventos;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Interfaz.Ventana_Usuario;
import ValorFijo.NombreFijo;

public class EventoTablaCesta extends MouseAdapter {


	DefaultTableModel modelocesta;
	JTable tabla;
	Ventana_Usuario  ventana;
	public EventoTablaCesta(	Ventana_Usuario  ventana) {
		// TODO Auto-generated constructor stub
		this.ventana=ventana;
		this.tabla=ventana.getTablaCesta();
		this.modelocesta=ventana.getModelo();
				
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		int count=tabla.getSelectedRow();// fila

		String nombre= tabla.getValueAt(count, 0).toString();//columna
	
		
		
		
		if(oepracion().equals(NombreFijo.Eliminar)) {
			
			//eliminar fila
			modelocesta.removeRow(count);
			
			// sumar los precio de la cesta
			ventana.getTotal().setText(String.valueOf(sumaTotal()));
		}else {
			
			
			String cantidad=ModificarCantidad(nombre);
			// modificar cantidad en tabla
			modelocesta.setValueAt(cantidad, count,2);
			
			// sumar los precio de la cesta
			ventana.getTotal().setText(String.valueOf(sumaTotal()));
			
		}
		
		
	}
			
		public String oepracion() {
				
				String[] operacion = {
						NombreFijo.Eliminar,
						NombreFijo.Modificar_Cantidad
			        };
		
			     String res = (String)  JOptionPane.showInputDialog(null,
			    				 "Que operacion quiseras hacer ?",
			    				 "Operacion", 
			    				 JOptionPane.DEFAULT_OPTION, 
			    				 null, 
			    				 operacion,
			    				 operacion[0]);
		
				return res;
			}
		
		
		public String ModificarCantidad(String valor) {
			
			String[] cantidad = {
		            "1",
		            "2",
		            "3",
		            "4",
		            "5",
		            "6",
		            "7",
		            "8"
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
