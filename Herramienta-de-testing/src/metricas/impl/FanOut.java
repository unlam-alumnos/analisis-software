package metricas.impl;

import java.util.List;

import ayuda.Cadenas;
import entidades.Clase;
import entidades.Metodo;
import metricas.Metrica;
import metricas.ResultadoMetrica;
import metricas.TipoMetrica;

public class FanOut implements Metrica {

	private List<Clase> proyecto;
	private Integer fanOut;
	
	public FanOut (List<Clase> proyecto){
		this.proyecto = proyecto;
	}
	
	public void calcular(Metodo metodo) {
		this.fanOut = 0;
		for(Clase claseProyecto : this.proyecto){
			for(Metodo metodoClaseProyecto : claseProyecto.getMetodos()){
				this.fanOut += Cadenas.cantidadOcurrenciasMetodo(metodoClaseProyecto.getNombre(), metodo.getCodigo());
			}
		}
	}

	public ResultadoMetrica obtenerResultado() {
		return new ResultadoMetrica( this, this.fanOut.toString() );
	}

	public TipoMetrica getTipo() {
		return TipoMetrica.FanOut;
	}

}