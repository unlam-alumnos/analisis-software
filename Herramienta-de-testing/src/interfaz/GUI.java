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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import ayuda.TextAreaUpdater;
import entidades.Clase;
import entidades.Metodo;
import metricas.ResultadoMetrica;
import metricas.TipoMetrica;
import metricas.impl.Halstead;
import principal.HerramientaTesting;
import java.awt.Font;
import java.awt.SystemColor;

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
	private JLabel datoComplejidad;
	private JLabel datoLineas;
	private JLabel datoComentarios;
	private JLabel datoPorcentajeComentarios;
	private JLabel datoLongitud;
	private JLabel datoVolumen;
	private JLabel datoFanIn;		
 	private JLabel datoFanOut;

	public GUI() {
		
		setResizable(false);
		setTitle("Testing Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 600);
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
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setBounds(10, 97, 89, 20);
		contentPane.add(lblCodigo);
		
		JLabel lblComplejidad = new JLabel("Complejidad Ciclomática");
		lblComplejidad.setForeground(Color.DARK_GRAY);
		lblComplejidad.setBounds(20, 450, 190, 20);
		contentPane.add(lblComplejidad);
		
		datoComplejidad = new JLabel("");
		datoComplejidad.setBounds(20, 470, 190, 20);
		contentPane.add(datoComplejidad);
		
		JLabel lblLineas = new JLabel("Líneas de Código");
		lblLineas.setForeground(Color.DARK_GRAY);
		lblLineas.setBounds(20, 490, 190, 20);
		contentPane.add(lblLineas);
		
		datoLineas = new JLabel("");
		datoLineas.setBounds(20, 510, 190, 20);
		contentPane.add(datoLineas);
		
		JLabel lblComentarios = new JLabel("Líneas de Comentarios");
		lblComentarios.setForeground(Color.DARK_GRAY);
		lblComentarios.setBounds(210, 450, 190, 20);
		contentPane.add(lblComentarios);
		
		datoComentarios = new JLabel("");
		datoComentarios.setBounds(210, 470, 190, 20);
		contentPane.add(datoComentarios);
		
		JLabel lblPorcentajeComentarios = new JLabel("% de Comentarios");
		lblPorcentajeComentarios.setForeground(Color.DARK_GRAY);
		lblPorcentajeComentarios.setBounds(210, 490, 190, 20);
		contentPane.add(lblPorcentajeComentarios);
		
		datoPorcentajeComentarios = new JLabel("");
		datoPorcentajeComentarios.setBounds(210, 510, 190, 20);
		contentPane.add(datoPorcentajeComentarios);
		
		JLabel lblFanIn = new JLabel("Fan-In");		
 		lblFanIn.setForeground(Color.DARK_GRAY);		
 		lblFanIn.setBounds(400, 450, 170, 20);		
 		contentPane.add(lblFanIn);		
 				
 		datoFanIn = new JLabel("");		
 		datoFanIn.setBounds(400, 470, 170, 20);		
 		contentPane.add(datoFanIn);		
 				
 		JLabel lblFanOut = new JLabel("Fan-Out");		
 		lblFanOut.setForeground(Color.DARK_GRAY);		
 		lblFanOut.setBounds(400, 490, 170, 20);		
 		contentPane.add(lblFanOut);		
 				
 		datoFanOut = new JLabel("");		
 		datoFanOut.setBounds(400, 510, 170, 20);		
 		contentPane.add(datoFanOut);
		
 		JLabel lblLongitud = new JLabel("Longitud");
 		lblLongitud.setForeground(Color.DARK_GRAY);
 		lblLongitud.setBounds(570, 450, 170, 20);
 		contentPane.add(lblLongitud);
 		
 		datoLongitud = new JLabel("");
 		datoLongitud.setBounds(570, 470, 170, 20);
 		contentPane.add(datoLongitud);
 		
 		JLabel lblVolumen = new JLabel("Volumen");
 		lblVolumen.setForeground(Color.DARK_GRAY);
 		lblVolumen.setBounds(570, 490, 170, 20);
 		contentPane.add(lblVolumen);
 		
 		datoVolumen = new JLabel("");
 		datoVolumen.setBounds(570, 510, 170, 20);
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
		
		JLabel lblAnalisis = new JLabel("Análisis:");
		lblAnalisis.setBounds(10, 420, 89, 20);
		contentPane.add(lblAnalisis);
		
		JButton btnHalstead = new JButton("Info Halstead");
		btnHalstead.setBackground(SystemColor.control);
		btnHalstead.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		btnHalstead.setForeground(Color.DARK_GRAY);
		btnHalstead.setBounds(570, 540, 150, 20);
		btnHalstead.addActionListener(mostrarOperadoresHalstead);
		contentPane.add(btnHalstead);
		
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
            datoComplejidad.setText(complejidadCiclomatica.toString());
            
            if( complejidadCiclomatica > 10){		 
            	datoComplejidad.setForeground(Color.RED);		
            	datoComplejidad.setToolTipText("La complejidad ciclom\u00E1tica supera 10, es recomendable modularizar el m\u00E9todo.");		
            }else{		
            	datoComplejidad.setForeground(Color.DARK_GRAY);		
            	datoComplejidad.setToolTipText(null);		
            }  
			
			/**
			 * Lineas de codigo, comentarios y porcentaje de comentarios
			 */
			datoLineas.setText(resultados.get(TipoMetrica.CantidadLineas).getResultado());

			datoComentarios.setText(resultados.get(TipoMetrica.CantidadComentarios).getResultado());
			Double porcentajeComentarios = Integer.parseInt(datoComentarios.getText()) * 100.0 / Integer.parseInt(datoLineas.getText());
			datoPorcentajeComentarios.setText(String.format("%.2f", porcentajeComentarios) + "%");
			
			if( porcentajeComentarios < 15){		
				datoPorcentajeComentarios.setForeground(Color.RED);		
				datoPorcentajeComentarios.setToolTipText("El porcentaje de comentarios recomendable es del 15%. Agregue m\u00E1s comentarios al m\u00E9todo.");		
			}else{		
			 	datoPorcentajeComentarios.setForeground(Color.DARK_GRAY);		
			 	datoPorcentajeComentarios.setToolTipText(null);		
			}
			
			/**
			 * Fan In/Out
			 */
			datoFanIn.setText(resultados.get(TipoMetrica.FanIn).getResultado());		
			datoFanOut.setText(resultados.get(TipoMetrica.FanOut).getResultado());
			
			/**
			 * Halstead
			 */
			halstead = resultados.get(TipoMetrica.Halstead).getResultado().split(" ");
			datoLongitud.setText(halstead[1]);
			datoVolumen.setText(halstead[3]);

		}
	};
	
	private ActionListener mostrarOperadoresHalstead = new ActionListener() {		
 		
 		public void actionPerformed(ActionEvent e) {		
 			String msg = "Operadores considerados:\n";		
 			for (String operador : Halstead.operadores) {		
 				msg += operador + ", ";		
 			}		
 			JOptionPane.showMessageDialog(new JFrame(), msg, "Informacion - Halstead", JOptionPane.INFORMATION_MESSAGE);		
  		}		  		
  	};
}

