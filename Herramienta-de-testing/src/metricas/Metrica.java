package metricas;

import entidades.Metodo;

public interface Metrica {

	public TipoMetrica getTipo();
	public void calcular(Metodo metodo);
	public ResultadoMetrica obtenerResultado();
	
}
