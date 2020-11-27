package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Eventos.EventoVentanaPrincipal;
import Eventos.Evento_BotonEntrar;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 510, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		setResizable(false);
		
		addWindowListener(new EventoVentanaPrincipal(this));
		
		//añadir panel entra a ventana principal
		Panel_Entrar panelentra=new Panel_Entrar();
		add(panelentra);
		
		// añadir evento a boton entrara
		// cuadndo el usuario pone bien su nuemero de cuenta y contraseña
		// esta ventan deja de ser visible 
		//y activar ventan de usuario
		Evento_BotonEntrar eventoentra=new Evento_BotonEntrar(this,panelentra);
		 
		panelentra.getEntrar().addActionListener(eventoentra);
		
	}

}
