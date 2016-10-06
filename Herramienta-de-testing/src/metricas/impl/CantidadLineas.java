package metricas.impl;

import java.util.List;

import entidades.Metodo;
import metricas.Metrica;
import metricas.ResultadoMetrica;
import metricas.TipoMetrica;

public class CantidadLineas implements Metrica {
	
	private Integer cantidadLineas;
	
	public void calcular(Metodo metodo) {
		List<String> codigo = metodo.getCodigo();
		this.cantidadLineas = codigo.size();
	}

	public ResultadoMetrica obtenerResultado() {
		return new ResultadoMetrica( this, this.cantidadLineas.toString() );
	}
	
	public TipoMetrica getTipo() {
		return TipoMetrica.CantidadLineas;
	}
}
