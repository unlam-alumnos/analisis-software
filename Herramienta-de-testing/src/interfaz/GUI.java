package interfaz;

import java.awt.Color;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import ayuda.TextAreaUpdater;
import entidades.Clase;
import entidades.Metodo;
import metricas.ResultadoMetrica;
import metricas.TipoMetrica;
import principal.HerramientaTesting;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfRuta;
	private JComboBox<String> cbClases;
	private JComboBox<String> cbMetodos;
	private HerramientaTesting herramienta;
	private String halstead[];
	private List<Clase> clasesProyecto;
	private List<Metodo> metodosClaseElegida;
	private TextArea txtAreaCodigo;
	private JLabel datoComplejidadCiclomatica;
	private JLabel datoLineasCodigo;
	private JLabel datoLineasComentarios;
	private JLabel datoPorcentajeComentarios;
	private JLabel datoLongitud;
	private JLabel datoVolumen;

	public GUI() {
		
		setResizable(false);
		setTitle("Testing Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 738, 560);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarpeta = new JLabel("Carpeta: ");
		lblCarpeta.setBounds(10, 11, 79, 14);
		contentPane.add(lblCarpeta);
		
		tfRuta = new JTextField();
		tfRuta.setBackground(Color.WHITE);
		tfRuta.setEditable(false);
		tfRuta.setBounds(89, 8, 523, 20);
		contentPane.add(tfRuta);
		tfRuta.setColumns(10);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setBounds(630, 7, 89, 23);
		btnAbrir.addActionListener(abrirDirectorio);
		contentPane.add(btnAbrir);
		
		cbClases = new JComboBox<String>();
		cbClases.setBounds(89, 54, 190, 20);
		cbClases.addActionListener(cargarMetodos);
		contentPane.add(cbClases);
		
		JLabel lblClass = new JLabel("Clase:");
		lblClass.setBounds(10, 57, 61, 14);
		contentPane.add(lblClass);
		
		JLabel lblMetodos = new JLabel("Método:");
		lblMetodos.setBounds(308, 55, 68, 18);
		contentPane.add(lblMetodos);
		
		cbMetodos = new JComboBox<String>();
		cbMetodos.setBounds(375, 54, 237, 20);
		cbMetodos.addActionListener(cargarMetricasCodigo);
		contentPane.add(cbMetodos);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(10, 97, 89, 20);
		contentPane.add(lblCodigo);
		
		JLabel label = new JLabel("Complejidad Ciclom\u00E1tica");
		label.setForeground(Color.DARK_GRAY);
		label.setBounds(39, 457, 200, 20);
		contentPane.add(label);
		
		datoComplejidadCiclomatica = new JLabel("");
		datoComplejidadCiclomatica.setBounds(39, 479, 200, 20);
		contentPane.add(datoComplejidadCiclomatica);
		
		JLabel label_1 = new JLabel("L\u00EDneas de C\u00F3digo");
		label_1.setForeground(Color.DARK_GRAY);
		label_1.setBounds(39, 511, 200, 20);
		contentPane.add(label_1);
		
		datoLineasCodigo = new JLabel("");
		datoLineasCodigo.setBounds(39, 528, 200, 20);
		contentPane.add(datoLineasCodigo);
		
		JLabel label_2 = new JLabel("L\u00EDneas de Comentarios");
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setBounds(277, 457, 200, 20);
		contentPane.add(label_2);
		
		datoLineasComentarios = new JLabel("");
		datoLineasComentarios.setBounds(277, 477, 200, 20);
		contentPane.add(datoLineasComentarios);
		
		JLabel lblPorcentajeDeComentarios = new JLabel("Porcentaje de Comentarios");
		lblPorcentajeDeComentarios.setForeground(Color.DARK_GRAY);
		lblPorcentajeDeComentarios.setBounds(277, 511, 200, 20);
		contentPane.add(lblPorcentajeDeComentarios);
		
		datoPorcentajeComentarios = new JLabel("");
		datoPorcentajeComentarios.setBounds(277, 528, 200, 20);
		contentPane.add(datoPorcentajeComentarios);
		
		JLabel label_3 = new JLabel("Longitud");
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setBounds(538, 457, 111, 20);
		contentPane.add(label_3);
		
		datoLongitud = new JLabel("");
		datoLongitud.setBounds(538, 477, 156, 20);
		contentPane.add(datoLongitud);
		
		JLabel label_4 = new JLabel("Volumen");
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setBounds(538, 511, 200, 20);
		contentPane.add(label_4);
		
		datoVolumen = new JLabel("");
		datoVolumen.setBounds(538, 528, 200, 20);
		contentPane.add(datoVolumen);
		
		txtAreaCodigo = new TextArea();
		txtAreaCodigo.setBackground(Color.WHITE);
		txtAreaCodigo.setEditable(false);
		txtAreaCodigo.setBounds(10,123,708,281);
		contentPane.add(txtAreaCodigo);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 39, 709, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 86, 709, 2);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 410, 709, 2);
		contentPane.add(separator_2);
		
		JLabel lblAnlisis = new JLabel("Análisis:");
		lblAnlisis.setBounds(10, 422, 89, 23);
		contentPane.add(lblAnlisis);
		
	}
	
	ActionListener abrirDirectorio = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			//Creamos el objeto JFileChooser
			JFileChooser fc=new JFileChooser();
			 
			//Indicamos lo que podemos seleccionar
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			 
			//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
			int seleccion = fc.showOpenDialog(contentPane);
			 
			//Si el usuario, pincha en aceptar
			if(seleccion == JFileChooser.APPROVE_OPTION){
			    //Seleccionamos el fichero
			    File fichero = fc.getSelectedFile();
			 
			    //Ecribe la ruta del fichero seleccionado en el campo de texto
			    tfRuta.setText(fichero.getAbsolutePath());
			    
			    //Elimina las clases y metodos cargados en el combobox
			    cbClases.removeAllItems();
			    cbMetodos.removeAllItems();
			    
			    herramienta = new HerramientaTesting(new File(fichero.getAbsolutePath()));
			    clasesProyecto = herramienta.getProyecto();	
			    
			    //Cargo el comboBox de clases
			    for(int indice = 0; indice < clasesProyecto.size(); indice++){
					cbClases.addItem(clasesProyecto.get(indice).getNombre());			
				}
			}
		}
	};
	
	ActionListener cargarMetodos = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			//Elimino los metodos cargados en el comboBox
			cbMetodos.removeAllItems();
			
			JComboBox<?> comboBox = (JComboBox<?>) e.getSource();
			
			if(null==comboBox.getSelectedItem())
			       return ;
			
            Integer claseSeleccionada = comboBox.getSelectedIndex();
			Clase claseElegida = clasesProyecto.get(claseSeleccionada);
			metodosClaseElegida = claseElegida.getMetodos();
			
			//Cargo el comboBox de metodos
		    for(int indice = 0; indice < metodosClaseElegida.size(); indice++){
				cbMetodos.addItem(metodosClaseElegida.get(indice).getNombre());			
			}
		}
	};
	
	ActionListener cargarMetricasCodigo = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			JComboBox<?> comboBox = (JComboBox<?>) e.getSource();

            Integer metodoSeleccionado = comboBox.getSelectedIndex();
            if (metodoSeleccionado == -1) {
				return;
			}
            Metodo metodoElegido = metodosClaseElegida.get(metodoSeleccionado);
            
            Map<TipoMetrica, ResultadoMetrica> resultados = herramienta.calcularMetricas(metodoElegido);
			
            new Thread(
            		new TextAreaUpdater(txtAreaCodigo, metodoElegido.getCodigo())
        		).start();
            
            /**
             * Complejidad Ciclomatica
             */
            Integer complejidadCiclomatica = Integer.parseInt(resultados.get(TipoMetrica.ComplejidadCiclomatica).getResultado());            
        	datoComplejidadCiclomatica.setForeground(Color.DARK_GRAY);
			datoComplejidadCiclomatica.setText(complejidadCiclomatica.toString());
			
			
			/**
			 * Lineas de codigo, comentarios y porcentaje de comentarios
			 */
			datoLineasCodigo.setText(resultados.get(TipoMetrica.CantidadLineas).getResultado());

			datoLineasComentarios.setText(resultados.get(TipoMetrica.CantidadComentarios).getResultado());
			Double porcentajeComentarios = Integer.parseInt(datoLineasComentarios.getText()) * 100.0 / Integer.parseInt(datoLineasCodigo.getText());
        	datoPorcentajeComentarios.setForeground(Color.DARK_GRAY);
			datoPorcentajeComentarios.setText(String.format("%.2f", porcentajeComentarios) + "%");
			
			/**
			 * Halstead
			 */
			halstead = resultados.get(TipoMetrica.Halstead).getResultado().split(" ");
			datoLongitud.setText(halstead[1]);
			datoVolumen.setText(halstead[3]);
			
		}
	};
}

