package principal;


import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidades.Clase;
import entidades.Metodo;
import interfaz.GUI;
import lector.LectorJavaParser;
import metricas.Metrica;
import metricas.ResultadoMetrica;
import metricas.TipoMetrica;
import metricas.impl.CantidadComentarios;
import metricas.impl.CantidadLineas;
import metricas.impl.ComplejidadCiclomatica;
import metricas.impl.FanIn;
import metricas.impl.FanOut;
import metricas.impl.Halstead;

public class HerramientaTesting {

	private List<Clase> proyecto;
	
	public static void main(final String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public HerramientaTesting (File rutaProyecto){
		this.proyecto = new LectorJavaParser().leerProyecto(rutaProyecto);
	}
	
	public Map<TipoMetrica, ResultadoMetrica> calcularMetricas(Metodo metodo){
		Map<TipoMetrica, ResultadoMetrica> resultados = new HashMap<TipoMetrica, ResultadoMetrica>();
		
		List<Metrica> metricas = new ArrayList<Metrica>();
		metricas.add(new ComplejidadCiclomatica());
		metricas.add(new CantidadLineas());
		metricas.add(new CantidadComentarios());
		metricas.add(new Halstead());
		metricas.add(new FanIn(this.proyecto));		
		metricas.add(new FanOut(this.proyecto));
		
		for(Metrica metrica : metricas){
			metrica.calcular(metodo);
			resultados.put(metrica.getTipo(), metrica.obtenerResultado());
		}
		return resultados;
	}

	public List<Clase> getProyecto() {
		return proyecto;
	}
	
}
