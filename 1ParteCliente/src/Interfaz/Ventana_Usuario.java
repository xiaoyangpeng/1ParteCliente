package Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.AndairAtabla;
import Controlador.InicarModeloDeTabla;
import Eventos.EventoPanelTermina;
import Eventos.EventoTablaCesta;
import Eventos.EventoVentanaPrincipal;
import ValorFijo.Imagen;
import ValorFijo.NombreFijo;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class Ventana_Usuario    extends JFrame {
	
	
	JTable tablaCesta;
	DefaultTableModel modelo;
	JLabel Total;
	
	JLabel textoTermina;


	public Ventana_Usuario() {
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		  String st[]=	new String[] {
					
					"Nombre", "precio","Cantidad"
				};
		
		modelo=new DefaultTableModel(st,0);
		
		setBounds(100, 100, 954, 412);
		getContentPane().setLayout(null);
		
		
		


		
		JPanel panelmedia = new JPanel();
		panelmedia.setBounds(344, 10, 142, 355);
		getContentPane().add(panelmedia);
		panelmedia.setLayout(null);
		
		JButton btnPedir = new JButton("Pedir");
		btnPedir.setBounds(21, 69, 97, 23);
		panelmedia.add(btnPedir);
		
		Total = new JLabel("");
		Total.setFont(new Font("宋体", Font.PLAIN, 26));
		Total.setBounds(10, 242, 122, 45);
		panelmedia.add(Total);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("宋体", Font.PLAIN, 24));
		lblTotal.setBounds(32, 194, 74, 38);
		panelmedia.add(lblTotal);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 334, 355);
		getContentPane().add(tabbedPane);
		

		JScrollPane scrollPaneCesta = new JScrollPane();
		scrollPaneCesta.setBounds(493, 49, 437, 316);
		getContentPane().add(scrollPaneCesta);
	
		
		tablaCesta = new JTable() {// para que la tabla no se puede modificar
			
			@Override
			public boolean isCellEditable(int row,int colum) {
				
				return false;
			}
		};
		
		tablaCesta.setModel(modelo);
		
		
		tablaCesta.editCellAt(1,1) ;
		
		scrollPaneCesta.setViewportView(tablaCesta);
		
		
		EventoTablaCesta eventoCesta=new EventoTablaCesta(this);
	
		tablaCesta .addMouseListener(eventoCesta);
		
		
		AndairAtabla tabla=new AndairAtabla();// va devolver DefaultTableModel
		
		
		Modelo_Panel verdura=new Modelo_Panel(tabla.BucarSeguncategoira(NombreFijo.verdura),this);
		tabbedPane.addTab("Verdura",verdura);
		
		Modelo_Panel bebida=new Modelo_Panel(tabla.BucarSeguncategoira(NombreFijo.bebida),this);
		tabbedPane.addTab("Bebida",bebida);
		//que lleva informacion de comidas 
		// y con DefaultTableModel crear tablas en distions panels
		
		// tabbedPan  va añadir estos panles que contiene tablas de comidas 

		Modelo_Panel carne=new Modelo_Panel(tabla.BucarSeguncategoira(NombreFijo.carne),this);
		tabbedPane.addTab("Carne",carne);
		
		
		
		JLabel lblCesta = new JLabel("Cesta");
		lblCesta.setFont(new Font("宋体", Font.PLAIN, 18));
		lblCesta.setBounds(580, 10, 75, 29);
		getContentPane().add(lblCesta);
		
		
	
		JPanel PanelTermina = new JPanel();
		PanelTermina.setBounds(0, 0, 718, 365);
		PanelTermina.setLayout(null);
		getContentPane().add(PanelTermina);
		PanelTermina.setVisible(false);
		
		//EventoPanelTermina terminada=new EventoPanelTermina(tabbedPane, scrollPaneCesta, panelmedia,  PanelTermina );
		
		EventoPanelTermina terminada=new EventoPanelTermina(this,PanelTermina);
		
		
		textoTermina = new JLabel("Esperando respuesta..");
		textoTermina.setBounds(100, 100, 309, 112);
		PanelTermina.add(textoTermina);
		textoTermina.setFont(new Font("宋体", Font.PLAIN, 18));
		textoTermina.setForeground(Color.RED);
		
		
		btnPedir.addActionListener(terminada);
		
		
		setVisible(true);
		
		addWindowListener(new EventoVentanaPrincipal(this));
	}
	
	
	
	
	public JLabel getTextoTermina() {
		return textoTermina;
	}




	public void setTextoTermina(JLabel textoTermina) {
		this.textoTermina = textoTermina;
	}




	public JTable getTablaCesta() {
		return tablaCesta;
	}




	public void setTablaCesta(JTable tablaCesta) {
		this.tablaCesta = tablaCesta;
	}




	public DefaultTableModel getModelo() {
		return modelo;
	}




	public void setModelo(DefaultTableModel modelo) {
		this.modelo = modelo;
	}




	public JLabel getTotal() {
		return Total;
	}


	public void setTotal(JLabel total) {
		Total = total;
	}
}
