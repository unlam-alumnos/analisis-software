import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class Main {

	private JFrame frmAlgoritmoDeCalidad;
	private JRadioButton rdbtnBuena, rdbtnRegular, rdbtnMala;
	private ButtonGroup buttonGroup;
	private List<Seccion> secciones;
	private int posicionActual, maxPosicion;
	private JButton btnSiguiente, btnAtras;
	private JLabel lblSubSeccion, lblSeccion;
	private JTextArea txtrDescripcion;

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
		posicionActual = 0;
		Pair<List<Seccion>, Integer> p = Seccion.cargarSecciones();
		secciones = p.getV1();
		maxPosicion = p.getV2();
		initialize();
		mostrarSeccion(obtenerSeccion());
	}

	private Pair<Seccion, SubSeccion> obtenerSeccion() {
		Seccion seccion = null;
		SubSeccion subSeccion = null;
		for (Seccion seccion1 : secciones) {
			for (SubSeccion subSeccion1 : seccion1.getSubSecciones()) {
				if (subSeccion1.getPosicion() == posicionActual) {
					subSeccion = subSeccion1;
					break;
				}
			}
			if (subSeccion != null) {
				seccion = seccion1;
				break;
			}
		}
		return new Pair<Seccion, SubSeccion>(seccion, subSeccion);
	}

	private void saveState() {
		SubSeccion subSeccion = null;
		for (Seccion seccion1 : secciones) {
			for (SubSeccion subSeccion1 : seccion1.getSubSecciones()) {
				if (subSeccion1.getPosicion() == posicionActual) {
					subSeccion = subSeccion1;
					break;
				}
			}
			if (subSeccion != null) {
				break;
			}
		}
		subSeccion.setResult(getRadioButtonSelected());
	}

	private void mostrarSeccion(Pair<Seccion, SubSeccion> pair) {
		Seccion seccion = pair.getV1();
		SubSeccion subSeccion = pair.getV2();
		lblSeccion.setText(seccion.getNombre());
		lblSubSeccion.setText(subSeccion.getNombre());
		txtrDescripcion.setText(subSeccion.getDescripcion());
		List<String> respuestas = subSeccion.getRespuestas();
		rdbtnMala.setToolTipText(respuestas.get(0));
		rdbtnRegular.setToolTipText(respuestas.get(1));
		rdbtnBuena.setToolTipText(respuestas.get(2));
		if (subSeccion.getResult() == null)
			buttonGroup.clearSelection();
		else
			switch (subSeccion.getResult()) {
			case 0:
				buttonGroup.setSelected(rdbtnMala.getModel(), true);
				break;
			case 1:
				buttonGroup.setSelected(rdbtnRegular.getModel(), true);
				break;
			case 2:
				buttonGroup.setSelected(rdbtnBuena.getModel(), true);
				break;
			default:
				break;
			}
	}

	public String obtenerResultadoCalidad() {
		double aux;
		for (Seccion seccion : secciones) {
			aux = 0;
			for (SubSeccion subSeccion : seccion.getSubSecciones())
				aux += subSeccion.getResult() * 5;
			seccion.setPromedioSubSecciones(aux / (seccion.getSubSecciones().size()));
		}
		aux = 0;
		for (Seccion seccion : secciones)
			aux += seccion.getPromedioSubSecciones();
		aux /= secciones.size();
		if (aux >= 9)
			return "supera las expectativas";
		else if (aux >= 6)
			return "cumple con las expectativas";
		else
			return "no pasa la prueba de calidad";

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlgoritmoDeCalidad = new JFrame();
		frmAlgoritmoDeCalidad.setTitle("Algoritmo de Calidad");
		frmAlgoritmoDeCalidad.setBounds(100, 100, 450, 285);
		frmAlgoritmoDeCalidad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlgoritmoDeCalidad.getContentPane().setLayout(null);

		lblSeccion = new JLabel("<dynamic> - <dynamic>");
		lblSeccion.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblSeccion.setBounds(10, 11, 414, 35);
		frmAlgoritmoDeCalidad.getContentPane().add(lblSeccion);

		lblSubSeccion = new JLabel("Nombre Seccion");
		lblSubSeccion.setForeground(Color.GRAY);
		lblSubSeccion.setFont(new Font("Tahoma", Font.ITALIC, 19));
		lblSubSeccion.setBounds(10, 43, 414, 35);
		frmAlgoritmoDeCalidad.getContentPane().add(lblSubSeccion);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 84, 414, 118);
		frmAlgoritmoDeCalidad.getContentPane().add(panel);
		panel.setLayout(null);

		buttonGroup = new ButtonGroup();

		rdbtnMala = new JRadioButton("Mala");
		rdbtnMala.setBounds(6, 36, 109, 23);
		rdbtnMala.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveState();
			}
		});
		buttonGroup.add(rdbtnMala);
		panel.add(rdbtnMala);

		rdbtnRegular = new JRadioButton("Regular");
		rdbtnRegular.setBounds(6, 62, 109, 23);
		rdbtnRegular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveState();
			}
		});
		buttonGroup.add(rdbtnRegular);
		panel.add(rdbtnRegular);

		JLabel lblEvaluacin = new JLabel("Evaluaci\u00F3n");
		lblEvaluacin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEvaluacin.setBounds(6, 11, 87, 18);
		panel.add(lblEvaluacin);

		rdbtnBuena = new JRadioButton("Buena");
		rdbtnBuena.setBounds(6, 88, 109, 23);
		rdbtnBuena.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveState();
			}
		});
		buttonGroup.add(rdbtnBuena);
		panel.add(rdbtnBuena);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(121, 11, 283, 100);
		panel.add(scrollPane);

		txtrDescripcion = new JTextArea();
		txtrDescripcion.setLineWrap(true);
		txtrDescripcion.setWrapStyleWord(true);
		txtrDescripcion.setEditable(false);
		scrollPane.setViewportView(txtrDescripcion);
		txtrDescripcion.setText("Descripcion de la Seccion");
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getRadioButtonSelected() != null) {
					if (posicionActual == maxPosicion)
						showMessage("El producto software " + obtenerResultadoCalidad());
					else {
						posicionActual++;
						buttonGroup.clearSelection();
						mostrarSeccion(obtenerSeccion());
					}
				} else
					showMessage("Por favor seleccione una puntuación antes de continuar.");
			}
		});
		btnSiguiente.setBounds(335, 213, 89, 23);
		frmAlgoritmoDeCalidad.getContentPane().add(btnSiguiente);

		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (posicionActual != 0) {
					posicionActual--;
					mostrarSeccion(obtenerSeccion());
				}
			}
		});
		btnAtras.setBounds(236, 213, 89, 23);
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
