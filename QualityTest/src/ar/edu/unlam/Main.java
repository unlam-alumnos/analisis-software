package ar.edu.unlam;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import ar.edu.unlam.caracteristicas.Caracteristica;
import ar.edu.unlam.caracteristicas.SubCaracteristica;

public class Main {

	private JFrame frmAlgoritmoDeCalidad;
	private JRadioButton rdbtnBuena, rdbtnRegular, rdbtnMala;
	private ButtonGroup buttonGroup;
	private JButton btnSiguiente, btnAtras;
	private JLabel lblSubCaracteristica, lblCaracteristica;
	private JTextPane txtrDescripcion;
	
	private ListIterator<SubCaracteristica> subCaracteristicas;
	private SubCaracteristica subCaractActual;
	private AlgoritmoCalidad algoritmo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmAlgoritmoDeCalidad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		this.algoritmo = new AlgoritmoCalidad();
		this.algoritmo.cargar();
		
		this.subCaracteristicas = this.algoritmo.getSubCatacteristicas().listIterator();
		initialize();
		SubCaracteristica next = this.subCaracteristicas.next();
		mostrarSeccion(next);
	}

	private void saveState() {
		this.subCaractActual.setResult(getRadioButtonSelected());
	}

	private void mostrarSeccion(SubCaracteristica subCaracteristica) {
		
		this.subCaractActual = subCaracteristica;
		
		lblCaracteristica.setText(subCaracteristica.getCaracteristica().getNombre());
		lblSubCaracteristica.setText(subCaracteristica.getNombre());
		txtrDescripcion.setText(
			String.format("%s\n\nCriterio:\n%s\n%s\n%s",
				subCaracteristica.getDescripcion(),
				subCaracteristica.getRespuestas().get(0),
				subCaracteristica.getRespuestas().get(1),
				subCaracteristica.getRespuestas().get(2)
			)
		);
		
		if (subCaracteristica.getResult() == null){
			buttonGroup.clearSelection();
		} else {
			switch (subCaracteristica.getResult()) {
				case 0:
					buttonGroup.setSelected(rdbtnMala.getModel(), true); break;
				case 1:
					buttonGroup.setSelected(rdbtnRegular.getModel(), true); break;
				case 2:
					buttonGroup.setSelected(rdbtnBuena.getModel(), true); break;
				default:
					break;
			}
		}
	}

	public String obtenerResultadoCalidad() {
		double aux = 0;
		List<Caracteristica> caracteristicas = this.algoritmo.getCaracteristicas();
		
		for (Caracteristica caract : caracteristicas){
			aux += caract.getPromedio();
		}
		aux /= caracteristicas.size();
		
		if (aux >= 1.5)
			return "Buena";
		else if (aux >= 1)
			return "Regular";
		else
			return "Mala";
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAlgoritmoDeCalidad = new JFrame();
		frmAlgoritmoDeCalidad.setTitle("Algoritmo de Calidad");
		frmAlgoritmoDeCalidad.setBounds(100, 100, 500, 450);
		frmAlgoritmoDeCalidad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlgoritmoDeCalidad.getContentPane().setLayout(null);

		lblCaracteristica = new JLabel();
		lblCaracteristica.setBounds(100, 10, 300, 40);
		lblCaracteristica.setFont(new Font("Arial", Font.BOLD, 25));
		lblCaracteristica.setHorizontalAlignment(SwingConstants.CENTER);
		frmAlgoritmoDeCalidad.getContentPane().add(lblCaracteristica);

		lblSubCaracteristica = new JLabel();
		lblSubCaracteristica.setBounds(100, 60, 300, 40);
		lblSubCaracteristica.setForeground(Color.DARK_GRAY);
		lblSubCaracteristica.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSubCaracteristica.setHorizontalAlignment(SwingConstants.CENTER);
		frmAlgoritmoDeCalidad.getContentPane().add(lblSubCaracteristica);

		JPanel panel = new JPanel();
		panel.setBounds(50, 110, 400, 250);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		frmAlgoritmoDeCalidad.getContentPane().add(panel);
		
		txtrDescripcion = new JTextPane();
		txtrDescripcion.setEditable(false);
		StyledDocument doc = txtrDescripcion.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 20, 360, 170);
		scrollPane.setViewportView(txtrDescripcion);
		panel.add(scrollPane);

		JLabel lblEvaluación = new JLabel("Evaluación");
		lblEvaluación.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEvaluación.setBounds(10, 200, 100, 20);
		panel.add(lblEvaluación);
		
		buttonGroup = new ButtonGroup();

		rdbtnMala = new JRadioButton("Mala");
		rdbtnMala.setBounds(40, 220, 100, 25);
		rdbtnMala.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveState();
			}
		});
		buttonGroup.add(rdbtnMala);
		panel.add(rdbtnMala);

		rdbtnRegular = new JRadioButton("Regular");
		rdbtnRegular.setBounds(150, 220, 100, 25);
		rdbtnRegular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveState();
			}
		});
		buttonGroup.add(rdbtnRegular);
		panel.add(rdbtnRegular);


		rdbtnBuena = new JRadioButton("Buena");
		rdbtnBuena.setBounds(290, 220, 100, 25);
		rdbtnBuena.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveState();
			}
		});
		buttonGroup.add(rdbtnBuena);
		panel.add(rdbtnBuena);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(275, 400, 175, 25);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getRadioButtonSelected() != null) {
					if (!subCaracteristicas.hasNext()){
						showMessage("El software es de calidad " + obtenerResultadoCalidad());
					} else {
						SubCaracteristica next = subCaracteristicas.next();
						mostrarSeccion(next);
					}
				} else
					showMessage("Por favor seleccione una puntuación antes de continuar.");
			}
		});
		frmAlgoritmoDeCalidad.getContentPane().add(btnSiguiente);

		btnAtras = new JButton("Atras");
		btnAtras.setBounds(50, 400, 175, 25);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( subCaracteristicas.previousIndex()>0 ) { //Está parado en el 2do o más
					subCaracteristicas.previous(); //Vuelve al actual
					SubCaracteristica previous = subCaracteristicas.previous(); //Obtiene al anterior y retrocede
					subCaracteristicas.next(); //Avanza al anterior
					mostrarSeccion(previous);
				}
			}
		});
		frmAlgoritmoDeCalidad.getContentPane().add(btnAtras);
	}

	private void showMessage(String message) {
		JOptionPane.showMessageDialog(frmAlgoritmoDeCalidad, message);
	}

	private Integer getRadioButtonSelected() {
		if (buttonGroup.isSelected(rdbtnMala.getModel()) == true)
			return 0;
		if (buttonGroup.isSelected(rdbtnRegular.getModel()) == true)
			return 1;
		if (buttonGroup.isSelected(rdbtnBuena.getModel()) == true)
			return 2;
		return null;
	}
}
