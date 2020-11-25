package Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.AndairAtabla;
import Controlador.InicarModeloDeTabla;
import Eventos.EventoTablaCesta;
import Eventos.EventoVentanaPrincipal;
import ValorFijo.NombreFijo;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Ventana_Usuario  extends JFrame {
	
	
	JTable tablaCesta;
	DefaultTableModel modelo;
	JLabel Total;
	
	
	public Ventana_Usuario() {
		
		
		  String st[]=	new String[] {
					
					"Nombre", "precio","Cantidad"
				};
		
		modelo=new DefaultTableModel(st,0);
		
		setBounds(100, 100, 742, 412);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(344, 10, 142, 355);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnPedir = new JButton("Pedir");
		btnPedir.setBounds(21, 69, 97, 23);
		panel.add(btnPedir);
		
		Total = new JLabel("New label");
		Total.setBounds(41, 193, 58, 15);
		panel.add(Total);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 334, 355);
		getContentPane().add(tabbedPane);
		

		JScrollPane scrollPaneCesta = new JScrollPane();
		scrollPaneCesta.setBounds(493, 49, 225, 316);
		getContentPane().add(scrollPaneCesta);
	
		
		tablaCesta = new JTable() {
			
			@Override
			public boolean isCellEditable(int row,int colum) {
				
				return false;
			}
		};
		
		tablaCesta.setModel(modelo);
		
	//	tablaCesta.setEnabled(false);
		
		tablaCesta.editCellAt(1,1) ;
		
		scrollPaneCesta.setViewportView(tablaCesta);
		
		
		EventoTablaCesta eventoCesta=new EventoTablaCesta(tablaCesta, modelo);
	
		tablaCesta .addMouseListener(eventoCesta);
		
		
		AndairAtabla tabla=new AndairAtabla();// va devolver DefaultTableModel
		//que lleva informacion de comidas 
		// y con DefaultTableModel crear tablas en distions panels
		
		// tabbedPan  va añadir estos panles que contiene tablas de comidas 
		
		Modelo_Panel carne=new Modelo_Panel(tabla.BucarSeguncategoira(NombreFijo.carne),modelo);
		tabbedPane.addTab("Carne",carne);
		
		
		Modelo_Panel verdura=new Modelo_Panel(tabla.BucarSeguncategoira(NombreFijo.verdura),modelo);
		tabbedPane.addTab("Verdura",verdura);
		
		Modelo_Panel bebida=new Modelo_Panel(tabla.BucarSeguncategoira(NombreFijo.verdura),modelo);
		tabbedPane.addTab("Bebida",bebida);
		
		
		
		JLabel lblCesta = new JLabel("Cesta");
		lblCesta.setFont(new Font("宋体", Font.PLAIN, 18));
		lblCesta.setBounds(580, 10, 75, 29);
		getContentPane().add(lblCesta);
		
		

		
		setVisible(true);
		
		addWindowListener(new EventoVentanaPrincipal(this));
	}
}
