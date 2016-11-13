package ar.edu.unlam.interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ar.edu.unlam.n2t;

public class Ventana {

	private n2t conversor;
	private Map<String, String> credenciales;
	private final String USUARIO_DEFAULT = "admin";
	private final String PASSWORD_DEFAULT = "123456";
	
	private JFrame frm;
	private JLabel lblTitulo;
	
	private JLabel lblMensaje;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnValidar;
	
	private JTextField txtNumero;
	private JLabel lblNumeroTexto;
	private JButton btnConvertir;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Ventana().getFrm().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ventana() {
		super();
		
		this.conversor = new n2t();
		this.credenciales = new HashMap<String, String>();
		this.credenciales.put(this.USUARIO_DEFAULT, this.PASSWORD_DEFAULT);
		
		this.frm = new JFrame();
		this.frm.setTitle("Number 2 Text");
		this.frm.setBounds(100, 100, 500, 300);
		this.frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frm.setLocationRelativeTo(null);
		this.frm.getContentPane().setLayout(null);
		
		this.lblTitulo = new JLabel();
		this.lblTitulo.setBounds(0, 20, 500, 40);
		this.lblTitulo.setFont(new Font("Arial", Font.BOLD, 25));
		this.lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblTitulo.setText("Conversor de número a texto");
		
		this.lblMensaje = new JLabel("");
		this.lblMensaje.setBounds(0, 90, 500, 40);
		this.lblMensaje.setForeground(Color.DARK_GRAY);
		this.lblMensaje.setFont(new Font("Arial", Font.ITALIC, 20));
		this.lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.frm.getContentPane().add(this.lblTitulo);
		this.frm.getContentPane().add(this.lblMensaje);
		
		this.cargarLogin();
	}

	private void cargarLogin() {
		
		this.lblMensaje.setText("Ingrese usuario y password válidos");
		
		this.lblUsuario = new JLabel();
		this.lblUsuario.setBounds(150, 160, 100, 20);
		this.lblUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		this.lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblUsuario.setText("Usuario");
		
		this.lblPassword = new JLabel();
		this.lblPassword.setBounds(150, 190, 100, 20);
		this.lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		this.lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblPassword.setText("Password");
		
		this.txtUsuario = new JTextField();
		this.txtUsuario.setFont(new Font("Arial", Font.PLAIN, 15));
		this.txtUsuario.setBounds(250, 160, 100, 20);
		this.txtUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarIngreso();
			}
		});
		
		this.txtPassword = new JPasswordField();
		this.txtPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		this.txtPassword.setBounds(250, 190, 100, 20);
		this.txtPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarIngreso();
			}
		});
		
		this.btnValidar = new JButton("Validar");
		this.btnValidar.setBounds(300, 240, 100, 20);
		this.btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validarIngreso();
			}
		});

		this.frm.getContentPane().add(this.lblUsuario);
		this.frm.getContentPane().add(this.lblPassword);
		this.frm.getContentPane().add(this.txtUsuario);
		this.frm.getContentPane().add(this.txtPassword);
		this.frm.getContentPane().add(this.btnValidar);
	}

	protected void validarIngreso() {
		if( this.txtUsuario.getText().isEmpty() ||
			this.txtPassword.getPassword().length==0 ){
			
			JOptionPane.showMessageDialog(
				null,
				"Debe ingresar usuario y password",
				this.lblTitulo.getText(),
				JOptionPane.WARNING_MESSAGE
			);
		} else if ( this.credenciales.containsKey(this.txtUsuario.getText()) 
				&& this.credenciales.get(this.txtUsuario.getText()).equals(new String(this.txtPassword.getPassword()))){
			this.cargarPrincipal();
			
		} else {
			JOptionPane.showMessageDialog(
				null,
				"Usuario o password inválidos",
				this.lblTitulo.getText(),
				JOptionPane.ERROR_MESSAGE
			);
		}
	}

	private void cargarPrincipal() {
		
		this.lblUsuario.setVisible(false);
		this.lblPassword.setVisible(false);
		this.txtUsuario.setVisible(false);
		this.txtPassword.setVisible(false);
		this.btnValidar.setVisible(false);
		
		this.lblMensaje.setText("Ingrese número a convertir");
		
		this.txtNumero = new JTextField();
		this.txtNumero.setFont(new Font("Arial", Font.PLAIN, 15));
		this.txtNumero.setBounds(200, 140, 100, 20);
		this.txtNumero.setHorizontalAlignment(SwingConstants.CENTER);
		this.txtNumero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				convertir();
			}
		});
		
		this.btnConvertir = new JButton("Convertir");
		this.btnConvertir.setBounds(200, 170, 100, 20);
		this.btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				convertir();
			}
		});
		
		this.lblNumeroTexto = new JLabel("");
		this.lblNumeroTexto.setFont(new Font("Arial", Font.BOLD, 15));
		this.lblNumeroTexto.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblNumeroTexto.setVerticalAlignment(SwingConstants.CENTER);
		this.lblNumeroTexto.setBounds(100, 200, 300, 80);
		
		this.frm.getContentPane().add(this.txtNumero);
		this.frm.getContentPane().add(this.btnConvertir);
		this.frm.getContentPane().add(this.lblNumeroTexto);
	}

	protected void convertir() {
		
		String strNumero = this.txtNumero.getText();
		
		if( strNumero.matches("\\d+") && strNumero.length()<=8 ) {
		
			this.lblNumeroTexto.setText(
				"<html><center>"+
				this.conversor.convertirLetras( Integer.valueOf(strNumero) )+
				"<center></html>"
			);
			
		} else {
			JOptionPane.showMessageDialog(
				null,
				"Sólo puede ingresar valores enteros entre 0 y 99.999.999",
				this.lblTitulo.getText(),
				JOptionPane.ERROR_MESSAGE
			);
		}
	}

	public JFrame getFrm() {
		return frm;
	}
	
}
